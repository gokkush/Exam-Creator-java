/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presenter;

import Model.DbAbstraction;
import Model.DbRefinedAbstraction;
import Model.Derslik;
import Model.Kullanici;
import Model.SqlLiteImplementor;
import Model.VeriGuncelleyebilme;
import Model.VeriSecebilme;
import Model.VeriSilebilme;
import Model.VeriYenileyebilme;
import View.Ana_Form;
import View.Derslik_Guncelle_Form;
import View.IViewDerslikGuncelle;
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
public class DerslikGuncellePresenter implements VeriGuncelleyebilme, VeriSecebilme,VeriSilebilme,VeriYenileyebilme{
    private IViewDerslikGuncelle view;  
    private Connection baglanti;
    private DbAbstraction abs = new DbRefinedAbstraction(new SqlLiteImplementor());
    private ResultSet res;
    private Statement st=null;
    private String secilenKayit;
    private String id;

    private Derslik_Guncelle_Form form = Derslik_Guncelle_Form.yeniFormOlustur();
    
    public DerslikGuncellePresenter(IViewDerslikGuncelle view) {
        this.view = view;
        baglanti = abs.getImplementor().OpenCon(" Derslik Guncelle Presenter");
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
    if((form.getTxt_Bina_Adi().getText().equals(""))||(form.getTxt_Salon_Kodu().getText().equals(""))||(form.getTxt_Salon_No().getText().equals(""))||(form.getTxt_Salon_Kapasitesi().getText().equals(""))){
JOptionPane.showConfirmDialog(null, "Bilgiler boş olamaz.","Kayıt işlemleri",JOptionPane.PLAIN_MESSAGE);
        }else {
        try {
             st=baglanti.createStatement();

                      
st.executeUpdate("insert into Derslik (Bina_Adi,Salon_No,Salon_Kodu,Salon_Kapasitesi,Save_Date,Save_User) values ('" + form.getTxt_Bina_Adi().getText()+"','" + form.getTxt_Salon_No().getText()+"','" + form.getTxt_Salon_Kodu().getText()+"','" + form.getTxt_Salon_Kapasitesi().getText()+"','"+sqlDate+ "','"+ Kullanici.getId()+"')");
            
        JOptionPane.showConfirmDialog(null, "Salon Başarıyla Eklendi","Derslik İşlemleri",JOptionPane.PLAIN_MESSAGE);
        form.getTxt_Bina_Adi().setText(null);
            
        } catch (Exception e) {
            Logger.getLogger(Ana_Form.class.getName()).log(Level.SEVERE, null, e);
        }
    }
                
            }
            else{
                if((form.getTxt_Bina_Adi().getText().equals(""))){
JOptionPane.showConfirmDialog(null, "Güncellenecek veri bulunamadı!","Derslik İşlemleri",JOptionPane.PLAIN_MESSAGE);
        } else {  
        try {           
           //String [] id={String.valueOf(tablo.getValueAt(tablo.getSelectedRow(), 0))};
           st=(Statement) baglanti.createStatement();
        st.executeUpdate("update Derslik set id='"+form.getLbl_Secilen().getText()+"', Bina_Adi='"+form.getTxt_Bina_Adi().getText()+"',Salon_No='"+form.getTxt_Salon_No().getText() +"',Salon_Kodu='"+form.getTxt_Salon_Kodu().getText() +"',Salon_Kapasitesi='"+form.getTxt_Salon_Kapasitesi().getText() +"', Edit_Date='"+sqlDate +"', Edit_User='"+ Kullanici.getId()+"' where id='"+form.getLbl_Secilen().getText()+"'");
        JOptionPane.showConfirmDialog(null, "Kayıt Başarıyla Güncellendi...","Salon İşlemleri",JOptionPane.PLAIN_MESSAGE); 
        
    } 
          
         catch (SQLException ex) {
            Logger.getLogger(Derslik_Guncelle_Form.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
            }
                
        
    }

    @Override
    public void tablodanVeriSecme() {
       secilenKayit=form.getTablo_Derslik().getValueAt(form.getTablo_Derslik().getSelectedRow(), 0).toString();
     
        id=(String.valueOf(form.getTablo_Derslik().getValueAt(form.getTablo_Derslik().getSelectedRow(), 0))); 
        
        ResultSet rs=null;
        try {
           Statement stKayitgetir=(Statement) baglanti.createStatement();
           //JOptionPane.showConfirmDialog(null, idSecilen.getId());
           rs=stKayitgetir.executeQuery("select * from Derslik where id='"+id+"'");
           while(rs.next()){
               form.getLbl_Secilen().setText(rs.getString("id"));
               form.getTxt_Bina_Adi().setText(rs.getString("Bina_Adi"));
               form.getTxt_Salon_No().setText(rs.getString("Salon_No"));
               form.getTxt_Salon_Kodu().setText(rs.getString("Salon_Kodu"));
               form.getTxt_Salon_Kapasitesi().setText(rs.getString("Salon_Kapasitesi"));
               
               
               
           }           
          
        } catch (Exception ex) {
            Logger.getLogger(Derslik_Guncelle_Form.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(Derslik_Guncelle_Form.class.getName()).log(Level.SEVERE, null, ex);
        }
        tabloYenile();
} else {
              
                  form.getLbl_Secilen().setText(null);
        form.getTxt_Bina_Adi().setText(null);
        
}
              }
    
    }

    @Override
    public void tabloYenile() {
           form.getTxt_Bina_Adi().setText(null);
            form.getTxt_Salon_Kapasitesi().setText(null);
            form.getTxt_Salon_Kodu().setText(null);
            form.getTxt_Salon_No().setText(null);
            
    ArrayList<Derslik> derslikler=new ArrayList<Derslik>();
        try {form.getLbl_Secilen().setText(null);
            Statement st=(Statement) baglanti.createStatement();
            if (form.getTxt_Arama().getText()==null){
                res=st.executeQuery("select * from Derslik order by id");
                
            }
            else {
                res=st.executeQuery("select * from Derslik where Bina_Adi LIKE '%"
                        + form.getTxt_Arama().getText() + "%' OR Salon_No LIKE '%"
                        + form.getTxt_Arama().getText() + "%' OR Salon_Kodu LIKE '%"
                        + form.getTxt_Arama().getText() + "%' OR Salon_Kapasitesi LIKE '%"
                        + form.getTxt_Arama().getText() + "%'");
    
                
            }
            
            
            while(res.next()){
                Derslik derslik=new Derslik();
                derslik.setId(res.getInt("id"));
                derslik.setBina_Adi(res.getString("Bina_Adi"));
                derslik.setSalon_No(res.getString("Salon_No"));
                derslik.setSalon_Kodu(res.getString("Salon_Kodu"));
                derslik.setSalon_Kapasitesi(res.getInt("Salon_Kapasitesi"));
                                
                derslikler.add(derslik);
                
            }

        
        } catch (Exception ex) {
            Logger.getLogger(Ana_Form.class.getName()).log(Level.SEVERE, null, ex);
        }

       
        
      
        DefaultTableModel tModel = (DefaultTableModel)form.getTablo_Derslik().getModel();
        tModel.setRowCount(0);
        Object [] satir = new Object[5];
            for (int i=0; i<derslikler.size();i++) {
                satir[0]=derslikler.get(i).getId();
                satir[1]=derslikler.get(i).getBina_Adi();
                satir[2]=derslikler.get(i).getSalon_No();
                satir[3]=derslikler.get(i).getSalon_Kodu();
                satir[4]=derslikler.get(i).getSalon_Kapasitesi();
                
                tModel.addRow(satir);
            }
form.getTablo_Derslik().setModel(tModel);
    
    
    }
  
  
}
