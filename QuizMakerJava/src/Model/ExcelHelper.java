package Model;




import java.io.*;
import java.lang.reflect.*;
import java.text.DateFormat;
import java.util.*;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;

import net.sf.jasperreports.engine.export.ooxml.XlsxZip;

public class ExcelHelper {
    
    private List<String> alanAdi =new ArrayList<String>();
    private Workbook workbook=null;
    private String workbookName="";

    public List<String> getAlanAdi() {
        return alanAdi;
    }

    public void setAlanAdi(List<String> alanAdi) {
        this.alanAdi = alanAdi;
    }

    public Workbook getWorkbook() {
        return workbook;
    }

    public void setWorkbook(Workbook workbook) {
        this.workbook = workbook;
    }

    public String getWorkbookName() {
        return workbookName;
    }

    public void setWorkbookName(String workbookName) {
        this.workbookName = workbookName;
    }
    
            

       public ExcelHelper(String workbookName) {
        this.workbookName=workbookName;
        initialize();
        
    }

       private void initialize(){
           setWorkbook(new HSSFWorkbook());
                   
       }
       
       public void closeWorksheet(){
        FileOutputStream fos;
           try {
               fos= new FileOutputStream(getWorkbookName());
               getWorkbook().write(fos);
               fos.close();
               
           }
           catch (FileNotFoundException e) {
               e.printStackTrace();
           }
           catch (Exception e) {
               e.printStackTrace();
           }
       }
      
       private boolean setupFieldsForClass (Class<?> clasz ) throws Exception{
           Field[] fields = clasz.getDeclaredFields();
           for (int i = 0; i < fields.length; i++) {
               alanAdi.add(fields[i].getName());
                       
           }
           return true;
       }
       
       
       private Sheet getSheetWithName (String adi){
           Sheet sheet =null;
           for (int i = 0; i < workbook.getNumberOfSheets(); i++) {
               if(adi.compareTo(workbook.getSheetName(i))==0){
                   sheet=workbook.getSheetAt(i);
                   break;        
               }
               
           }
           return sheet;
       }
       
       private void initializeForRead() throws InvalidFormatException, IOException{
           InputStream inp = new FileInputStream(getWorkbookName());
           workbook=WorkbookFactory.create(inp);
       }
       
     //  @SuppressWarnings({"unchecked", "rawtypes"})
       public <T> List<T> readData(String classname) throws Exception {
           initializeForRead();

           Sheet sheet = getSheetWithName(classname);

           Class clasz =Class.forName(workbook.getSheetName(0));
           
           setupFieldsForClass(clasz);
           List <T> result = new ArrayList<T>();
           Row row;
          for(int rowCount =1; rowCount<4; rowCount++){
               T one = (T) clasz.newInstance();
               row=sheet.getRow(rowCount);
               int colCount=0;
               result.add(one);
               for(Cell cell : row){
                   CellType type = cell.getCellType();
                   String fieldName =alanAdi.get(colCount++);
                   Method method = constructMethod(clasz, fieldName);
                   if (type == cell.getCellType().STRING) {
                       String value =cell.getStringCellValue();
                       Object[] values = new Object[1];
                       values[0]=value;
                       method.invoke(one, values);
                       
                               
                   }
                   else if(type ==cell.getCellType().NUMERIC){
                       Double num= cell.getNumericCellValue();
                       Class<?> returnType = getGetterReturnClass(clasz,fieldName);
                       if (returnType == int.class || returnType == Integer.class) {
                           method.invoke(one, num.intValue());}
                       
                           else if (returnType == double.class || returnType == Double.class) {
                           method.invoke(one, num);
                       }   
                           else if (returnType == float.class || returnType == Float.class) {
                           method.invoke(one, num.floatValue());
                           
                       }  
                       else if (returnType == long.class || returnType == Long.class) {
                           method.invoke(one, num.longValue());
                           
                       }  
                    else if (returnType == Date.class ) {
                        Date date = HSSFDateUtil.getJavaDate(cell.getNumericCellValue());
                           method.invoke(one, date);
                           
                       }         
                       
                       
                   }
                   else if (type == cell.getCellType().BOOLEAN) {
                       boolean num = cell.getBooleanCellValue();
                       Object[] values = new Object[1];
                       values[0]=num;
                       method.invoke(one, values);
                           
                       }  
                   
                   
                   
               }
           }
           return result;
       }
       
       private Class<?> getGetterReturnClass(Class<?> clasz, String fieldName ){
           String methodName= "get" + capitalize(fieldName);
           String methodIsName = "is" + capitalize(fieldName);
           Class<?> returnType = null;
           for (Method method : clasz.getMethods()) {
               if (method.getName().equals(methodName)||method.getName().equals(methodIsName)) {
                   returnType= method.getReturnType();
                   break;
                   
               }
           }
           return returnType;
       }
       
       @SuppressWarnings({"uncehcked", "rawtypes"})
       private Method constructMethod(Class clasz,String fieldName) throws SecurityException, IOException, NoSuchMethodException{
           Class<?> fieldClass = getGetterReturnClass(clasz, fieldName);
           return clasz.getMethod("set"+capitalize(fieldName) , fieldClass);
           
       }
       
       public <T> void writeData(List <T> data ) throws Exception {
           try {
               Sheet sheet = getWorkbook().createSheet(data.get(0).getClass().getName());
               setupFieldsForClass(data.get(0).getClass());
               int rowCount=0;
               int columnCount=0;
               Row row = sheet.createRow(rowCount++);
               for(String fieldName : alanAdi){
                   Cell cell = row.createCell(columnCount++);
                   cell.setCellValue(fieldName);
               }
               Class<? extends Object> clasz= data.get(0).getClass();
               for(T t:data ){
                   row= sheet.createRow(columnCount);
                   columnCount=0;
                   for(String fieldName : alanAdi){
                       Cell cel = row.createCell(rowCount);
                       Method method= hasMethod(clasz,fieldName)
                               ? clasz.getMethod("get"+ capitalize(fieldName))
                               : clasz.getMethod("is"+ capitalize(fieldName));
                       Object value = method.invoke(t, (Object []) null );
                       if (value!=null) {
                           if (value instanceof String ) {
                               cel.setCellValue((String) value);
                           }
                            else if (value instanceof Long ) {
                               cel.setCellValue((Long) value);
                           }
                           else if (value instanceof Integer ) {
                               cel.setCellValue((Integer) value);
                           }
                           else if (value instanceof Double ) {
                               cel.setCellValue((Double) value);
                           }
                           else if (value instanceof Date ) {
                               cel.setCellValue((Date) value);
                               CellStyle styleDate = workbook.createCellStyle();
                               DataFormat dataFormatDate = workbook.createDataFormat();
                               styleDate.setDataFormat(dataFormatDate.getFormat("dd/mm/yyyy"));
                               cel.setCellStyle(styleDate);
                           }
                           else if (value instanceof Boolean ) {
                               cel.setCellValue((Boolean) value);
                           }
                       }
                       columnCount++;
                   }
                   
               }
               for (int i = 0; i < alanAdi.size(); i++) {
                   sheet.autoSizeColumn(i);
                   FileOutputStream out = new FileOutputStream(new File (workbookName));
                   workbook.write(out);
                   out.close();
                   workbook.close();
                   
               }
           } catch (Exception e) {
           }
           
           
       }     
       
       @SuppressWarnings({"unchecked", "rawtypes"})
       private boolean hasMethod(Class clasz, String fieldName ){
           try {
               clasz.getMethod("get"+capitalize(fieldName));
               return true;
               
           } catch (Exception e) {
               return false;
           }
       }
       
       public String capitalize(String string){
           String capital = string.substring(0,1).toUpperCase();
           return capital + string.substring(1);
       }


       

       
}
