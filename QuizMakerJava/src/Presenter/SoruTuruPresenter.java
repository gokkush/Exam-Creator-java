/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presenter;

import Model.DbAbstraction;
import Model.DbRefinedAbstraction;
import Model.Kullanici;
import Model.SoruTurleri;
import Model.Soru_Turu;
import Model.SqlLiteImplementor;
import Model.VeriGuncelleyebilme;
import Model.VeriSecebilme;
import Model.VeriSilebilme;
import Model.VeriYenileyebilme;
import View.Ana_Form;
import View.IViewSoruTuru;
import View.Soru_Turu_Form;
import com.sun.org.apache.bcel.internal.generic.AALOAD;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author User
 */
public class SoruTuruPresenter extends SoruTurleri implements VeriGuncelleyebilme, VeriSecebilme,VeriSilebilme,VeriYenileyebilme {
    private Connection baglanti;
    private Statement st=null;
    private ResultSet res;
    private DbAbstraction abs = new DbRefinedAbstraction(new SqlLiteImplementor());
    private IViewSoruTuru view;
    private Soru_Turu_Form form = Soru_Turu_Form.yeniFormOlustur();
    private  Vector<Soru_Turu> ls_S_Turu;
    
    public SoruTuruPresenter(IViewSoruTuru view) {
        this.view = view;
         baglanti = abs.getImplementor().OpenCon(" Soru Türleri Presenter");
         ls_S_Turu= new Vector<Soru_Turu>();
    }

    @Override
    public void tablodanVeriGuncelle() {
       java.util.Calendar cal = Calendar.getInstance();
java.util.Date utilDate = new java.util.Date(); 
cal.setTime(utilDate);
cal.set(Calendar.HOUR_OF_DAY, 0);
cal.set(Calendar.MINUTE, 0);
cal.set(Calendar.SECOND, 0);
cal.set(Calendar.MILLISECOND, 0); 
java.sql.Date sqlDate = new java.sql.Date(cal.getTime().getTime());
            
            if(form.getLbl_Secilen().getText()==null){
             Statement st=null;
        ResultSet res;  
    if((form.getTxt_s_turu().getText().equals(""))){
JOptionPane.showConfirmDialog(null, "Soru Türü boş olamaz.","Kayıt işlemleri",JOptionPane.PLAIN_MESSAGE);
        }else {
        try {
             st=baglanti.createStatement();

                      
st.executeUpdate("insert into Soru_Turu (Soru_Turu,save_date,save_user) values ('" + form.getTxt_s_turu().getText()+"','"+sqlDate+ "','"+ Kullanici.getId()+"')");
            
        JOptionPane.showConfirmDialog(null, "Soru Türü Başarıyla Eklendi","Soru Türü İşlemleri",JOptionPane.PLAIN_MESSAGE);
        form.getTxt_s_turu().setText(null);
            
        } catch (Exception e) {
            Logger.getLogger(Ana_Form.class.getName()).log(Level.SEVERE, null, e);
        }
    }
                
            }
            else{
                if((form.getTxt_s_turu().getText().equals(""))){
JOptionPane.showConfirmDialog(null, "Güncellenecek veri bulunamadı!","Soru Türü İşlemleri",JOptionPane.PLAIN_MESSAGE);
        } else {  
        try {           
           //String [] id={String.valueOf(tablo.getValueAt(tablo.getSelectedRow(), 0))};
           st=(Statement) baglanti.createStatement();
        st.executeUpdate("update Soru_Turu set id='"+form.getLbl_Secilen().getText()+"', Soru_Turu='"+form.getTxt_s_turu().getText() +"', edit_date='"+sqlDate +"', edit_user='"+ Kullanici.getId()+"' where id='"+form.getLbl_Secilen().getText()+"'");
        JOptionPane.showConfirmDialog(null, "Kayıt Başarıyla Güncellendi...","Soru_Turu İşlemleri",JOptionPane.PLAIN_MESSAGE); 
        
    } 
          
         catch (SQLException ex) {
            Logger.getLogger(Soru_Turu_Form.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
            }
    
    }

    @Override
    public void tablodanVeriSecme() {
     
             setSecilenKayit(form.getTablo_Soru_Turu().getValueAt(form.getTablo_Soru_Turu().getSelectedRow(), 0).toString());
       // Soru_Turu_Form idSecilen=new Soru_Turu_Form();
        setId(String.valueOf(form.getTablo_Soru_Turu().getValueAt(form.getTablo_Soru_Turu().getSelectedRow(), 0))); 
        
   
        try {
           Statement stKayitgetir=(Statement) baglanti.createStatement();
           //JOptionPane.showConfirmDialog(null, idSecilen.getId());
           res=stKayitgetir.executeQuery("select * from Soru_Turu where id='"+getId()+"'");
           while(res.next()){
               form.getLbl_Secilen().setText(res.getString("id"));
               form.getTxt_s_turu().setText(res.getString("Soru_Turu"));
               
               
           }           
          
        } catch (Exception ex) {
            Logger.getLogger(Soru_Turu_Form.class.getName()).log(Level.SEVERE, null, ex);
        }
        form.getLbl_Secilen().setVisible(false);
    
    }

    @Override
    public void tablodanVeriSilme() {
       if(form.getLbl_Secilen().getText()==null){
    JOptionPane.showConfirmDialog(null, "Tablodan Soru Türü Seçmediniz!","Soru Türü İşlemleri", JOptionPane.PLAIN_MESSAGE);
        }else {
                
                if (JOptionPane.showConfirmDialog(null, "Soru Türünü silmek istediğinize emin misiniz!?", "UYARI",
        JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
    try {
            Statement stSil=(Statement) baglanti.createStatement();
            stSil.executeUpdate("delete from Soru_Turu where id='"+form.getLbl_Secilen().getText()+"'");
            JOptionPane.showConfirmDialog(null, "Soru Türü silinmiştir.!","SİLİNDİ",JOptionPane.PLAIN_MESSAGE);
        } catch (Exception ex) {
            Logger.getLogger(Soru_Turu_Form.class.getName()).log(Level.SEVERE, null, ex);
        }
        tabloYenile();
} else {
              
                  form.getLbl_Secilen().setText(null);
        form.getTxt_s_turu().setText(null);
        
}
              }  
    
    
    }

    @Override
    public void tabloYenile() {
         
        try {form.getLbl_Secilen().setText(null);
            Statement st=(Statement) baglanti.createStatement();
            if (form.getTxt_Arama().getText()==null){
                res=st.executeQuery("select * from Soru_Turu order by Soru_Turu");
                
            }
            else {
                res=st.executeQuery("select * from Soru_Turu where Soru_Turu LIKE '%"+
    form.getTxt_Arama().getText()+"%'");
                
            }
            
            
            while(res.next()){
                Soru_Turu s_Turu=new Soru_Turu();
                s_Turu.setId(res.getInt("id"));
                s_Turu.setSoru_turu(res.getString("Soru_Turu"));
                                
                ls_S_Turu.add(s_Turu);
                
            }
                    form.getTxt_s_turu().setText(null);
        
        
        } catch (Exception ex) {
            Logger.getLogger(Ana_Form.class.getName()).log(Level.SEVERE, null, ex);
        }

       
        
      
        DefaultTableModel tModel = (DefaultTableModel)form.getTablo_Soru_Turu().getModel();
        tModel.setRowCount(0);
        Object [] satir = new Object[2];
            for (int i=0; i<ls_S_Turu.size();i++) {
                satir[0]= ls_S_Turu.get(i).getId();
                satir[1]= ls_S_Turu.get(i).getSoru_turu();
                
                tModel.addRow(satir);
            }
form.getTablo_Soru_Turu().setModel(tModel);
    
    
    }
    
    
}
