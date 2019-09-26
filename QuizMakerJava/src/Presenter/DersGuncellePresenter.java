/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presenter;

import Model.*;
import View.Ana_Form;

import View.Ders_Guncelle_Form;
import View.IViewDersGuncelle;
import View.IViewOtomasyonaGiris;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author User
 */
public class DersGuncellePresenter implements VeriGuncelleyebilme, VeriSecebilme,VeriSilebilme,VeriYenileyebilme{
     
   private IViewDersGuncelle view;
   private Ders_Guncelle_Form form = Ders_Guncelle_Form.yeniFormOlustur();
   
   private Connection baglanti;
   private DbAbstraction abs = new DbRefinedAbstraction(new SqlLiteImplementor());
   
   private Kullanici kullanici;
    private DersBilgileri bilgiler;
    private Statement st=null;
    private ResultSet res;
    
    
    public DersGuncellePresenter(IViewDersGuncelle view) {
        
        this.view = view;
        kullanici    = new Kullanici();
       bilgiler = new DersBilgileri();
       baglanti = abs.getImplementor().OpenCon(" Ders Guncelle Presenter");
       
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
               
    if((form.getTxt_Ders_Adi().getText().equals(""))){
JOptionPane.showConfirmDialog(null, "Ders adı boş olamaz.","Kayıt işlemleri",JOptionPane.PLAIN_MESSAGE);
        }else {
        try {
             st=baglanti.createStatement();

                      
st.executeUpdate("insert into Dersler (ders_adi,save_date,save_user) values ('" + form.getTxt_Ders_Adi().getText()+"','"+sqlDate+ "','"+ kullanici.getId()+"')");
            
        JOptionPane.showConfirmDialog(null, "Ders Başarıyla Eklendi","Ders İşlemleri",JOptionPane.PLAIN_MESSAGE);
        form.getTxt_Ders_Adi().setText(null);
            
        } catch (Exception e) {
            Logger.getLogger(Ana_Form.class.getName()).log(Level.SEVERE, null, e);
        }
    }
                
            }
            else{
                if((form.getTxt_Ders_Adi().getText().equals(""))){
JOptionPane.showConfirmDialog(null, "Güncellenecek veri bulunamadı!","Ders işlemleri",JOptionPane.PLAIN_MESSAGE);
        } else {  
        try {           
           //String [] id={String.valueOf(tablo.getValueAt(tablo.getSelectedRow(), 0))};
           st= baglanti.createStatement();
        st.executeUpdate("update Dersler set id='"+form.getLbl_Secilen().getText()+"', ders_adi='"+form.getTxt_Ders_Adi().getText() +"', edit_date='"+sqlDate +"', edit_user='"+ kullanici.getId()+"' where id='"+form.getLbl_Secilen().getText()+"'");
        JOptionPane.showConfirmDialog(null, "Kayıt Başarıyla Güncellendi...","Ders İşlemleri",JOptionPane.PLAIN_MESSAGE); 
        
    } 
          
         catch (SQLException ex) {
            Logger.getLogger(Ders_Guncelle_Form.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
            }
                
        
    }

    @Override
    public void tablodanVeriSecme() {
         bilgiler.setSecilenKayit(form.getTablo_Ders().getValueAt(form.getTablo_Ders().getSelectedRow(), 0).toString());
       
        bilgiler.setId(String.valueOf(form.getTablo_Ders().getValueAt(form.getTablo_Ders().getSelectedRow(), 0))); 
        
        ResultSet rs=null;
        
        try {
           Statement stKayitgetir=(Statement) baglanti.createStatement();
           //JOptionPane.showConfirmDialog(null, idSecilen.getId());
           rs=stKayitgetir.executeQuery("select * from Dersler where id='"+bilgiler.getId()+"'");
           while(rs.next()){
               form.getLbl_Secilen().setText(rs.getString("id"));
               form.getTxt_Ders_Adi().setText(rs.getString("ders_adi"));
               
               
           }           
          
        } catch (Exception ex) {
            Logger.getLogger(Ders_Guncelle_Form.class.getName()).log(Level.SEVERE, null, ex);
        }
         form.getLbl_Secilen().setVisible(false);
      
    
    }

    @Override
    public void tablodanVeriSilme() {
       
     
            if(form.getLbl_Secilen().getText()==null){
   JOptionPane.showConfirmDialog(null, "Tablodan ders seçmediniz!","Ders işlemleri", JOptionPane.PLAIN_MESSAGE);
        }else {
                
                if (JOptionPane.showConfirmDialog(null, "Dersi silmek istediğinize emin misiniz!?", "UYARI",
        JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
    try {
            Statement stSil=(Statement) baglanti.createStatement();
            stSil.executeUpdate("delete from Dersler where id='"+form.getLbl_Secilen().getText()+"'");
            JOptionPane.showConfirmDialog(null, "Ders silinmiştir.!","SİLİNDİ",JOptionPane.PLAIN_MESSAGE);
        } catch (Exception ex) {
            Logger.getLogger(Ders_Guncelle_Form.class.getName()).log(Level.SEVERE, null, ex);
        }
        tabloYenile(); 
} else {
              
                  form.getLbl_Secilen().setText(null);
        form.getTxt_Ders_Adi().setText(null);
        
}
              }
            
    }

    @Override
    public void tabloYenile() {
       ArrayList<Dersler> dersler=new ArrayList<Dersler>();
        try {
            
            form.getLbl_Secilen().setText(null);
            Statement st=(Statement) baglanti.createStatement();
            
            if (form.getTxt_Arama().getText()==null){
                res=st.executeQuery("select * from Dersler order by ders_adi");
                
            }
            else {
                res=st.executeQuery("select * from Dersler where ders_adi LIKE '%"+
                form.getTxt_Arama().getText()+"%'");
                
            }
            
            
            while(res.next()){
              Dersler ders = new Dersler();
                ders.setId(res.getInt("id"));
                ders.setDers_adi(res.getString("ders_adi"));
             
                dersler.add(ders);
                
            }
        form.getTxt_Ders_Adi().setText(null);
        
        
        } catch (Exception ex) {
            Logger.getLogger(Ana_Form.class.getName()).log(Level.SEVERE, null, ex);
        }

       
        
      
        DefaultTableModel tModel = (DefaultTableModel)form.getTablo_Ders().getModel();
        tModel.setRowCount(0);
        Object [] sutun = new Object[2];
            for (int i=0; i<dersler.size();i++) {
                sutun[0]=dersler.get(i).getId();
                sutun[1]=dersler.get(i).getDers_adi();
                
                tModel.addRow(sutun);
            }
            
form.getTablo_Ders().setModel(tModel);
            
     
    
    }
    
    
    
    
    
}
