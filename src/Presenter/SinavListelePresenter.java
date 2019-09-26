/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presenter;



import Model.DbAbstraction;
import Model.DbRefinedAbstraction;
import Model.SinavIslemleri;
import Model.Sinav_Olustur;
import Model.SqlLiteImplementor;
import Model.VeriSecebilme;
import Model.VeriYenileyebilme;
import View.Ana_Form;
import View.IViewSinavListele;
import View.Sinav_Listele_Form;
import View.Soru_Guncelle_Form;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
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

/**
 *
 * @author User
 */
public class SinavListelePresenter extends SinavIslemleri implements VeriYenileyebilme, VeriSecebilme {
    private Connection baglanti;
    private Statement st=null;
    private ResultSet res;
     private String secilenKayit;
    private DbAbstraction abs = new DbRefinedAbstraction(new SqlLiteImplementor());
    private IViewSinavListele view;
    private Sinav_Listele_Form form = Sinav_Listele_Form.yeniFormOlustur();
    private ArrayList<Sinav_Olustur> sinavlar= new ArrayList<Sinav_Olustur>(); 
      private static String id;
    public SinavListelePresenter(IViewSinavListele view) {
        this.view = view;
         baglanti = abs.getImplementor().OpenCon(" Sinav Listele Presenter");
        
    }

    @Override
    public void tabloYenile() {
     
    
        ArrayList<Sinav_Olustur> sinavlar= new ArrayList<Sinav_Olustur>();
        try {

            Statement st = (Statement) baglanti.createStatement();
            if (form.getTxt_Arama().getText().equals("")) {

                if ((form.getChb_Ders().isSelected()==false)) {

                    res = st.executeQuery("select * from Sinav ");

                
                } else {

                    res = st.executeQuery("select * from Sinav where ders LIKE '%"
                            + form.getCm_Ders().getSelectedItem() + "%'");

                }

            } else {
                res = st.executeQuery("select * from Sinav where gozetmen_Adi LIKE '%"
                        + form.getTxt_Arama().getText() + "%' OR sinav_Tarihi LIKE '%"
                        + form.getTxt_Arama().getText() + "%' OR sinav_Yeri LIKE '%"
                        + form.getTxt_Arama().getText() + "%' OR ders LIKE '%"
                        + form.getTxt_Arama().getText() + "%'");
               

            }

            while (res.next()) {
                Sinav_Olustur sinav = new Sinav_Olustur();
                sinav.setId(res.getInt("id"));
                sinav.setDers(res.getString("ders"));
                sinav.setGozetmen_Adi(res.getString("gozetmen_Adi"));
                sinav.setSinav_Tarihi(res.getString("sinav_Tarihi"));
                sinav.setSinav_Yeri(res.getString("sinav_Yeri"));
                

                sinavlar.add(sinav);

            }

            
            res.close();
            st.close();

        } catch (Exception ex) {
            Logger.getLogger(Ana_Form.class.getName()).log(Level.SEVERE, null, ex);
        }

        DefaultTableModel tModel = (DefaultTableModel) form.getTablo_Sinav().getModel();
        tModel.setRowCount(0);
        Object[] satir = new Object[5];
        for (int i = 0; i < sinavlar.size(); i++) {
            satir[0] = sinavlar.get(i).getId();
            satir[1] = sinavlar.get(i).getDers();
            satir[2] = sinavlar.get(i).getGozetmen_Adi();
            satir[3] = sinavlar.get(i).getSinav_Tarihi();
             satir[4] = sinavlar.get(i).getSinav_Yeri();
            

            tModel.addRow(satir);
        }
        form.getTablo_Sinav().setModel(tModel);
    
    }

    @Override
    public void tablodanVeriSecme() {
   
      secilenKayit = form.getTablo_Sinav().getValueAt(form.getTablo_Sinav().getSelectedRow(), 0).toString();
        
        
        id=String.valueOf(form.getTablo_Sinav().getValueAt(form.getTablo_Sinav().getSelectedRow(), 0));
    
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
  
     
     
        public void raporHazirla() {
            
    String ders=null,gozetmen=null,tarih=null;
        if(id==null){
            JOptionPane.showMessageDialog(null, "Tablodan Sınav Seçmediniz.");
        }
        else
        {
            
            for (int i = 0; i < sinavlar.size(); i++) {
                if(sinavlar.get(i).getId()==Integer.parseInt(id)){
                    ders=sinavlar.get(i).getDers();
                    gozetmen=sinavlar.get(i).getGozetmen_Adi();
                    tarih=sinavlar.get(i).getSinav_Tarihi();
                }
                
            }
    
        
        
        try {

          
            InputStream ips = new FileInputStream(new File(System.getProperty("user.dir")+"\\src\\Rapor\\"+ "Soru_Hazirla.jrxml"));
            JasperDesign jd= JRXmlLoader.load(ips);
            String sql="SELECT*  FROM Sinav Ssinav INNER JOIN Sinav_Sorulari Soru ON Ssinav.id=Soru.sinav_id where Ssinav.id="+id;
            JRDesignQuery query = new JRDesignQuery();
            query.setText(sql);
            jd.setQuery(query);
            JasperReport jr= JasperCompileManager.compileReport(jd);
            HashMap hm=new HashMap();
            JasperPrint jp= JasperFillManager.fillReport(jr, hm, baglanti);
            JasperViewer.viewReport(jp,false);
            OutputStream os= new FileOutputStream(new File(System.getProperty("user.dir")+"\\ciktilar\\"+ders+"-"+gozetmen+"-"+id+".pdf"));
            JasperExportManager.exportReportToPdfStream(jp,os);
            
            
            


            
            
            
            
            Statement stKayitgetir = (Statement) baglanti.createStatement();
            


        } catch (Exception ex) {
            Logger.getLogger(Soru_Guncelle_Form.class.getName()).log(Level.SEVERE, null, ex);
        }
        form.getLbl_Secilen().setVisible(false);

    }
}
    
    
}
