/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presenter;

import Model.DbAbstraction;
import Model.DbRefinedAbstraction;
import Model.Ogrenci;
import Model.SqlLiteImplementor;
import View.Ana_Form;
import View.IViewSalonAtama;
import View.Salon_Atama_Form;
import View.Soru_Guncelle_Form;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFileChooser;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 *
 * @author User
 */
public class SalonAtamaPresenter {
    private IViewSalonAtama view;
    private String secilenKayit;
    private static String id;
    private String cevap;
    private String dogruCevap;
    private int cevapSayisi;
    private String dersSecimi;
    private String soruTurSecimi;
    private String zorlukSecimi;
    private ArrayList<Ogrenci> ogrenciler;
    private static int ogrenci_Adedi;
    private String bina;
    private String salon;
    private int kapasite;

     private ResultSet res;
    private Statement st=null;
    private Connection baglanti;
   private DbAbstraction abs = new DbRefinedAbstraction(new SqlLiteImplementor());


    private Salon_Atama_Form form = Salon_Atama_Form.yeniFormOlustur();

    public SalonAtamaPresenter(IViewSalonAtama view) {
        this.view = view;
         baglanti = abs.getImplementor().OpenCon(" Salon Atama Presenter");
    }


        public void tablo_Sil(){
         try {
                    PreparedStatement st = baglanti.prepareStatement("DELETE FROM Sinav_Yeri");
        st.executeUpdate();

                } catch (Exception e) {
                    Logger.getLogger(Ana_Form.class.getName()).log(Level.SEVERE, null, e);
                }
    }
    public void cm_Gozetmen_Doldurma() {
        form.getCm_Gozetmen().removeAllItems();
        try {
            String sql = "select * from Gozetmen order by id";
            Statement st = (Statement) baglanti.createStatement();
            res = st.executeQuery(sql);

            while (res.next()) {
                String gozetmen_Adi = res.getString("Adi_Soyadi");
                form.getCm_Gozetmen().addItem(gozetmen_Adi);
            }
            res.close();
            st.close();

        } catch (Exception ex) {
            Logger.getLogger(Ana_Form.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void cm_Bina_Doldurma() {
        form.getCm_Bina().removeAllItems();
        try {
            String sql = "select DISTINCT Bina_Adi from Derslik";
            Statement st = (Statement) baglanti.createStatement();
            res = st.executeQuery(sql);

            while (res.next()) {
                String bina_Adi = res.getString("Bina_Adi");
                form.getCm_Bina().addItem(bina_Adi);
            }
            res.close();
            st.close();

        } catch (Exception ex) {
            Logger.getLogger(Ana_Form.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

     public void cm_Ders_Doldurma() {
        form.getCm_Ders().removeAllItems();
        try {
            String sql = "select * from Dersler order by id";
            Statement st = (Statement) baglanti.createStatement();
            res = st.executeQuery(sql);

            while (res.next()) {
                String ders_Adi = res.getString("ders_adi");


                form.getCm_Ders().addItem(ders_Adi);
            }
            res.close();
            st.close();

        } catch (Exception ex) {
            Logger.getLogger(Ana_Form.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void cm_Salon_Doldurma() {
        form.getCm_Salon().removeAllItems();
        try {
            String sql = "select * from Derslik where Bina_Adi='"+bina+"'";
            Statement st = (Statement) baglanti.createStatement();
            res = st.executeQuery(sql);

            while (res.next()) {

                String salon_No = res.getString("Salon_No");
                form.getCm_Salon().addItem(salon_No);
            }
            res.close();
            st.close();

        } catch (Exception ex) {
            Logger.getLogger(Ana_Form.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void kapasite_Al() {

        try {
            salon=form.getCm_Salon().getSelectedItem().toString();

            String sql = "select * from Derslik where Salon_No='"+salon+"'";
            Statement st = (Statement) baglanti.createStatement();
            res = st.executeQuery(sql);

            while (res.next()) {
                kapasite = res.getInt("Salon_Kapasitesi");

            }
            form.getLbKapasite().setText(String.valueOf(kapasite));
            res.close();
            st.close();

        } catch (Exception ex) {
            Logger.getLogger(Ana_Form.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void yenile(){
        form.getjPanel1().setVisible(false);
        form.getjPanel2().setVisible(false);
        form.getTablo_Sinif().setVisible(false);
        form.getLbOgrenci_Adedi().setVisible(false);
        form.getLbText().setVisible(false);

       }

    public void goster(){
        if(ogrenciler!=null){

        form.getTablo_Sinif().setVisible(true);
        form.getjPanel1().setVisible(true);

        form.getLbOgrenci_Adedi().setVisible(true);
        form.getLbText().setVisible(true);
        }
       }

    public void rastgeleAta(){
        DefaultTableModel model = (DefaultTableModel) form.getTablo_Sinif().getModel();
       int sayac=0;
       form.getCm_Atanan_Salon().addItem(form.getCm_Salon().getSelectedItem().toString());
       if(((DefaultComboBoxModel)form.getCm_Atanan_Bina().getModel()).getIndexOf(form.getCm_Bina().getSelectedItem().toString()) == -1)
      {
           form.getCm_Atanan_Bina().addItem(form.getCm_Bina().getSelectedItem().toString());
       }
        for (int i = 0; i < kapasite; i++) {

                 if(ogrenciler.size()>0){

            Random rnd = new Random ();
            int secilen=rnd.nextInt(ogrenciler.size());
            String kod=null;
            sayac++;
            try {
            String sql = "select * from Derslik where Salon_No="+"\""+form.getCm_Salon().getSelectedItem().toString()+"\"";
            Statement st = (Statement) baglanti.createStatement();
            res = st.executeQuery(sql);

            while (res.next()) {

                kod = res.getString("Salon_Kodu");

            }
            } catch (Exception e) {
                    Logger.getLogger(Ana_Form.class.getName()).log(Level.SEVERE, null, e);
                }
            try {
                    st = baglanti.createStatement();

                    st.executeUpdate("insert into Sinav_Yeri (Ders,Bina,Salon,Gozetmen,Sira,Ogrenci_Numarasi,Ogrenci_Adi,Ogrenci_Soyadi,Kod) values ( '" + form.getCm_Ders().getSelectedItem().toString() + "',"
                            + "'" + form.getCm_Bina().getSelectedItem().toString()+ "','" + form.getCm_Salon().getSelectedItem().toString()+ "','" + form.getCm_Gozetmen().getSelectedItem().toString() + "','" + sayac+ "'"
                                    + ","+ "'" + ogrenciler.get(secilen).getOgrenci_No() + "','" + ogrenciler.get(secilen).getOgrenci_Adi()+ "','" + ogrenciler.get(secilen).getOgrenci_Soyadi() + "','" + kod+ "')");



                } catch (Exception e) {
                    Logger.getLogger(Ana_Form.class.getName()).log(Level.SEVERE, null, e);
                }

            ogrenciler.remove(secilen);
//            System.out.println(ogrenciler.get(secilen).getOgrenci_No());

            model.removeRow(secilen);
            ogrenci_Adedi--;

            }

                 if (sayac==kapasite){

                     form.getCm_Salon().removeItem(salon);
                 }


        }

        if(form.getCm_Gozetmen().getSelectedItem()!=null){
        form.getCm_Gozetmen().removeItemAt(form.getCm_Gozetmen().getSelectedIndex());
        }

        form.getTablo_Sinif().setModel(model);
        form.getLbOgrenci_Adedi().setText(String.valueOf(ogrenci_Adedi));
        kapasite_Al();

    }



    public void rapor_Sinav_Hazirla() {




        try {


            InputStream ips = new FileInputStream(new File(System.getProperty("user.dir")+"\\src\\Rapor\\"+ "Sinav_Listesi.jrxml"));
            JasperDesign jd= JRXmlLoader.load(ips);
            String sql="Select * from Sinav_Yeri order by Ogrenci_Numarasi";
            JRDesignQuery query = new JRDesignQuery();
            query.setText(sql);
            jd.setQuery(query);
            JasperReport jr= JasperCompileManager.compileReport(jd);
            HashMap hm=new HashMap();
            JasperPrint jp= JasperFillManager.fillReport(jr, hm, baglanti);
            JasperViewer.viewReport(jp,false);
            OutputStream os= new FileOutputStream(new File(System.getProperty("user.dir")+"\\ciktilar\\"+bina+"-"+"-Sinav_Listesi"+".pdf"));
            JasperExportManager.exportReportToPdfStream(jp,os);









            Statement stKayitgetir = (Statement) baglanti.createStatement();



        } catch (Exception ex) {
            Logger.getLogger(Soru_Guncelle_Form.class.getName()).log(Level.SEVERE, null, ex);
        }
        form.getLbl_Secilen().setVisible(false);


}

    public void raporHazirla2(){
            MessageFormat baslik = new MessageFormat("Öğrenci Listesi");
            MessageFormat alt = new MessageFormat("Sayfa-{0,number,integer}");
            try {
                form.getTablo_Sinif().print(JTable.PrintMode.NORMAL, baslik,alt);
            } catch (Exception e) {
            }


        }

     public void rapor_Salon_Hazirla() {




        try {


            InputStream ips = new FileInputStream(new File(System.getProperty("user.dir")+"\\src\\Rapor\\"+ "Salon_Listesi.jrxml"));
            JasperDesign jd= JRXmlLoader.load(ips);
            String sql="Select * From Sinav_Yeri where Salon="+"\""+form.getCm_Atanan_Salon().getSelectedItem().toString() +"\""+" order by Sira";
            JRDesignQuery query = new JRDesignQuery();
            query.setText(sql);
            jd.setQuery(query);
            JasperReport jr= JasperCompileManager.compileReport(jd);
            HashMap hm=new HashMap();
            JasperPrint jp= JasperFillManager.fillReport(jr, hm, baglanti);
            JasperViewer.viewReport(jp,false);
            OutputStream os= new FileOutputStream(new File(System.getProperty("user.dir")+"\\ciktilar\\"+bina+"-"+form.getCm_Atanan_Salon().getSelectedItem().toString()+"-Salon_Listesi"+".pdf"));
            JasperExportManager.exportReportToPdfStream(jp,os);









            Statement stKayitgetir = (Statement) baglanti.createStatement();



        } catch (Exception ex) {
            Logger.getLogger(Soru_Guncelle_Form.class.getName()).log(Level.SEVERE, null, ex);
        }
        form.getLbl_Secilen().setVisible(false);


}

      public void rapor_Yoklama_Hazirla() {




        try {


            InputStream ips = new FileInputStream(new File(System.getProperty("user.dir")+"\\src\\Rapor\\"+ "Sinav_Yoklama.jrxml"));
            JasperDesign jd= JRXmlLoader.load(ips);
            String sql="Select * From Sinav_Yeri where Salon="+"\""+form.getCm_Atanan_Salon().getSelectedItem().toString() +"\""+" order by Sira";
            JRDesignQuery query = new JRDesignQuery();
            query.setText(sql);
            jd.setQuery(query);
            JasperReport jr= JasperCompileManager.compileReport(jd);
            HashMap hm=new HashMap();
            JasperPrint jp= JasperFillManager.fillReport(jr, hm, baglanti);
            JasperViewer.viewReport(jp,false);
            OutputStream os= new FileOutputStream(new File(System.getProperty("user.dir")+"\\ciktilar\\"+bina+"-"+form.getCm_Atanan_Salon().getSelectedItem().toString()+"-Yoklama_Listesi"+".pdf"));
            JasperExportManager.exportReportToPdfStream(jp,os);









            Statement stKayitgetir = (Statement) baglanti.createStatement();



        } catch (Exception ex) {
            Logger.getLogger(Soru_Guncelle_Form.class.getName()).log(Level.SEVERE, null, ex);
        }
        form.getLbl_Secilen().setVisible(false);


}

    public void dosyaAl(){

        JFileChooser jf = new JFileChooser();
       int sonuc = jf.showOpenDialog(null);
       jf.setDialogTitle("Lütfen Öğrenci Listesi Seçiniz");
       if(sonuc==JFileChooser.APPROVE_OPTION){
           String yol=jf.getSelectedFile().getAbsolutePath();

           if(yol==null){
              ogrenciler=null;
           }
           else{


           DefaultTableModel model = (DefaultTableModel) form.getTablo_Sinif().getModel();
           model.setColumnCount(0);
           model.setRowCount(0);
model.addColumn("Öğrenci Numarası");
model.addColumn("Öğrenci Adı");
model.addColumn("Öğrenci Soyadı");



           try {


InputStream inStr = new FileInputStream(yol);
Workbook wBook = WorkbookFactory.create(inStr);
Sheet sheet = wBook.getSheetAt(0);

ogrenciler = new ArrayList<Ogrenci>();
ogrenciler.clear();

for (int i = 0; i <= sheet.getLastRowNum(); i++)
{
    Ogrenci ogr = new Ogrenci();
    Row row = sheet.getRow(i);
    if(row.getCell(0)!=null ){




	Cell ogr_No = row.getCell(0);
	Cell ogr_Adi = row.getCell(1);
	Cell ogr_Soyadi = row.getCell(2);


        ogr_No.setCellType(ogr_Adi.getCellType());

        String ogr_Numara = ogr_No.getStringCellValue();
  	String ogr_Adi1 = ogr_Adi.getStringCellValue();
  	String ogr_Soyadi1 = ogr_Soyadi.getStringCellValue();
        ogr.setOgrenci_No(ogr_Numara);
        ogr.setOgrenci_Adi(ogr_Adi1);
        ogr.setOgrenci_Soyadi(ogr_Soyadi1);
        ogrenciler.add(ogr);

        model.addRow(new Object[]{ ogr_Numara, ogr_Adi1, ogr_Soyadi1});
        ogrenci_Adedi++;
        }
    }
form.getTablo_Sinif().setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
    form.getTablo_Sinif().setModel(model);

                    } catch (Exception e) {
           }

/*           for (int i = 0; i < ogrenciler.size(); i++) {
           System.out.println(ogrenciler.get(i).getOgrenci_No() + " "+ ogrenciler.get(i).getOgrenci_Adi()+ " " + ogrenciler.get(i).getOgrenci_Soyadi() );
           }*/


       }
        form.getLbOgrenci_Adedi().setText(String.valueOf(ogrenci_Adedi));
        form.getLbOgrenci_Adedi().setVisible(true);
        
        form.getLbText().setVisible(true);

       }
    }

    public String getBina() {
        return bina;
    }

    public void setBina(String bina) {
        this.bina = bina;
    }

    public int getKapasite() {
        return kapasite;
    }

    public void setKapasite(int kapasite) {
        this.kapasite = kapasite;
    }

    public String getDersSecimi() {
        return dersSecimi;
    }

    public void setDersSecimi(String dersSecimi) {
        this.dersSecimi = dersSecimi;
    }

    public String getSoruTurSecimi() {
        return soruTurSecimi;
    }

    public void setSoruTurSecimi(String soruTurSecimi) {
        this.soruTurSecimi = soruTurSecimi;
    }

    public String getZorlukSecimi() {
        return zorlukSecimi;
    }

    public void setZorlukSecimi(String zorlukSecimi) {
        this.zorlukSecimi = zorlukSecimi;
    }

    public static int getOgrenci_Adedi() {
        return ogrenci_Adedi;
    }

    public static void setOgrenci_Adedi(int ogrenci_Adedi) {
        SalonAtamaPresenter.ogrenci_Adedi = ogrenci_Adedi;
    }

    public String getSalon() {
        return salon;
    }

    public void setSalon(String salon) {
        this.salon = salon;
    }

    
    
}
