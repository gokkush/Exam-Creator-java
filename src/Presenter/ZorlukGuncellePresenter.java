/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presenter;

import Model.DbAbstraction;
import Model.DbRefinedAbstraction;
import Model.Kullanici;
import Model.SqlLiteImplementor;
import Model.VeriGuncelleyebilme;
import Model.VeriSecebilme;
import Model.VeriSilebilme;
import Model.VeriYenileyebilme;
import Model.Zorluklar;
import View.Ana_Form;
import View.IViewZorlukGuncelle;
import View.Zorluk_Guncelle_Form;
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
public class ZorlukGuncellePresenter extends Zorluklar implements VeriGuncelleyebilme, VeriSecebilme,VeriSilebilme,VeriYenileyebilme {
    private Connection baglanti;
    private Statement st=null;
    private ResultSet res;
    private DbAbstraction abs = new DbRefinedAbstraction(new SqlLiteImplementor());
    private Zorluk_Guncelle_Form form=Zorluk_Guncelle_Form.yeniFormOlustur();
    private   ArrayList<Zorluklar> zorluk;
    private IViewZorlukGuncelle view;

    public ZorlukGuncellePresenter(IViewZorlukGuncelle view) {
        this.view = view;
         baglanti = abs.getImplementor().OpenCon(" Zorluk Guncelle Presenter");
        zorluk=new ArrayList<Zorluklar>();
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
    if((form.getTxt_Zorluk_derecesi().getText().equals(""))){
JOptionPane.showConfirmDialog(null, "Zorluk derecesi boş olamaz.","Kayıt işlemleri",JOptionPane.PLAIN_MESSAGE);
        }else {
        try {
             st=baglanti.createStatement();

                      
st.executeUpdate("insert into Zorluk (zorluk_derecesi,save_date,save_user) values ('" + form.getTxt_Zorluk_derecesi().getText()+"','"+sqlDate+ "','"+ Kullanici.getId()+"')");
            
        JOptionPane.showConfirmDialog(null, "Zorluk Derecesi Başarıyla Eklendi","Zorluk İşlemleri",JOptionPane.PLAIN_MESSAGE);
        form.getTxt_Zorluk_derecesi().setText(null);
            
        } catch (Exception e) {
            Logger.getLogger(Ana_Form.class.getName()).log(Level.SEVERE, null, e);
        }
    }
                
            }
            else{
                if((form.getTxt_Zorluk_derecesi().getText().equals(""))){
JOptionPane.showConfirmDialog(null, "Güncellenecek veri bulunamadı!","Zorluk İşlemleri",JOptionPane.PLAIN_MESSAGE);
        } else {  
        try {           
           //String [] id={String.valueOf(tablo.getValueAt(tablo.getSelectedRow(), 0))};
           st=(Statement) baglanti.createStatement();
        st.executeUpdate("update Zorluk set id='"+form.getLbl_Secilen().getText()+"', zorluk_derecesi='"+form.getTxt_Zorluk_derecesi().getText() +"', edit_date='"+sqlDate +"', edit_user='"+ Kullanici.getId()+"' where id='"+form.getLbl_Secilen().getText()+"'");
        JOptionPane.showConfirmDialog(null, "Kayıt Başarıyla Güncellendi...","Zorluk İşlemleri",JOptionPane.PLAIN_MESSAGE); 
        
    } 
          
         catch (SQLException ex) {
            Logger.getLogger(Zorluk_Guncelle_Form.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
            }
                
    
    
    }

    @Override
    public void tablodanVeriSecme() {
          secilenKayit=form.getTablo_Zorluk().getValueAt(form.getTablo_Zorluk().getSelectedRow(), 0).toString();
        
       setIdDegeri(String.valueOf(form.getTablo_Zorluk().getValueAt(form.getTablo_Zorluk().getSelectedRow(), 0))); 
        
        ResultSet rs=null;
        try {
           Statement stKayitgetir=(Statement) baglanti.createStatement();
           //JOptionPane.showConfirmDialog(null, idSecilen.getId());
           rs=stKayitgetir.executeQuery("select * from Zorluk where id='"+getIdDegeri()+"'");
           while(rs.next()){
               form.getLbl_Secilen().setText(rs.getString("id"));
               form.getTxt_Zorluk_derecesi().setText(rs.getString("zorluk_derecesi"));
               
               
           }           
          
        } catch (Exception ex) {
            Logger.getLogger(Zorluk_Guncelle_Form.class.getName()).log(Level.SEVERE, null, ex);
        }
        form.getLbl_Secilen().setVisible(false);
    
    
    }

    @Override
    public void tablodanVeriSilme() {
          
            if(form.getLbl_Secilen().getText()==null){
    JOptionPane.showConfirmDialog(null, "Tablodan ders seçmediniz!","Zorluk İşlemleri", JOptionPane.PLAIN_MESSAGE);
        }else {
                
                if (JOptionPane.showConfirmDialog(null, "Zorluk Derecesini silmek istediğinize emin misiniz!?", "UYARI",
        JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
    try {
            Statement stSil=(Statement) baglanti.createStatement();
            stSil.executeUpdate("delete from Zorluk where id='"+form.getLbl_Secilen().getText()+"'");
            JOptionPane.showConfirmDialog(null, "Zorluk derecesi silinmiştir.!","SİLİNDİ",JOptionPane.PLAIN_MESSAGE);
        } catch (Exception ex) {
            Logger.getLogger(Zorluk_Guncelle_Form.class.getName()).log(Level.SEVERE, null, ex);
        }
        tabloYenile();
} else {
              
                  form.getLbl_Secilen().setText(null);
         form.getTxt_Zorluk_derecesi().setText(null);
        
}
              }
    
    
    }

    @Override
    public void tabloYenile() {
       
        ArrayList<Zorluklar> zorluk=new ArrayList<Zorluklar>();
        try {form.getLbl_Secilen().setText(null);
            Statement st=(Statement) baglanti.createStatement();
            if (form.getTxt_Arama().getText()==null){
                res=st.executeQuery("select * from Zorluk order by zorluk_derecesi");
                
            }
            else {
                res=st.executeQuery("select * from Zorluk where zorluk_derecesi LIKE '%"+
                form.getTxt_Arama().getText()+"%'");
                
            }
            
            
            while(res.next()){
                Zorluklar zor=new Zorluklar();
                zor.setId(res.getInt("id"));
                zor.setZorluk(res.getString("zorluk_derecesi"));
                                
                zorluk.add(zor);
                
            }
                    form.getTxt_Zorluk_derecesi().setText(null);
        form.getTxt_Zorluk_derecesi().setText(null);
        
        } catch (Exception ex) {
            Logger.getLogger(Ana_Form.class.getName()).log(Level.SEVERE, null, ex);
        }

       
        
      
        DefaultTableModel tModel = (DefaultTableModel)form.getTablo_Zorluk().getModel();
        tModel.setRowCount(0);
        Object [] satir = new Object[2];
            for (int i=0; i<zorluk.size();i++) {
                satir[0]=zorluk.get(i).getId();
                satir[1]=zorluk.get(i).getZorluk();
                
                tModel.addRow(satir);
            }
form.getTablo_Zorluk().setModel(tModel);
    
    }
    
    
}
