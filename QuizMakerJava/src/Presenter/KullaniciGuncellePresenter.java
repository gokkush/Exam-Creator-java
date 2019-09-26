/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presenter;

import Model.DbAbstraction;
import Model.DbRefinedAbstraction;
import Model.KullaniciModeli;
import Model.SqlLiteImplementor;
import Model.VeriGuncelleyebilme;
import Model.VeriSecebilme;
import Model.VeriSilebilme;
import Model.VeriYenileyebilme;
import View.Ana_Form;
import View.IViewKullaniciGuncelle;
import View.Kullanici_Guncelle_Form;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author User
 */
public class KullaniciGuncellePresenter implements VeriGuncelleyebilme, VeriSecebilme,VeriSilebilme,VeriYenileyebilme{
    private Connection baglanti;
    private Statement st=null;
    private ResultSet res;
    private DbAbstraction abs = new DbRefinedAbstraction(new SqlLiteImplementor());
    private IViewKullaniciGuncelle view ;
    private Vector<KullaniciModeli> kullanicilar;
    private static String secilenKayit;
    private static String id; 
    private Kullanici_Guncelle_Form form = Kullanici_Guncelle_Form.yeniFormOlustur();
    

    public KullaniciGuncellePresenter(IViewKullaniciGuncelle view) {
        this.view = view;
        baglanti = abs.getImplementor().OpenCon(" Kullanici Guncelle Presenter");
    }

    @Override
    public void tablodanVeriGuncelle() {
        
    if(form.getLbl_Secilen().getText()==null){
             Statement st=null;
             ResultSet res;  
             
    if((form.getTxt_Adi().getText().equals(""))||(form.getTxt_Soyadi().getText().equals(""))||(form.getTxt_Kul_Adi().getText().equals(""))){
JOptionPane.showConfirmDialog(null, "Lütfen boş veri bırakmayınız.","Kayıt işlemleri",JOptionPane.PLAIN_MESSAGE);
        }else {
        try {
             st=baglanti.createStatement();
                                                                       
st.executeUpdate("insert into Kullanici (k_adi,sifre,Adi,Soyadi,k_turu) values ('" + form.getTxt_Kul_Adi().getText()+"','"+"12345"+ "','" + form.getTxt_Adi().getText() + "','"+form.getTxt_Soyadi().getText()+"','"+ form.getCmb_Tur().getSelectedItem()+"')");
            
        JOptionPane.showConfirmDialog(null, "Kullanıcı Başarıyla Eklendi","Kullanıcı İşlemleri",JOptionPane.PLAIN_MESSAGE);
        form.getTxt_Kul_Adi().setText(null);
        form.getTxt_Adi().setText(null);
        form.getTxt_Soyadi().setText(null);
        form.getCmb_Tur().setSelectedIndex(0);
            
        } catch (Exception e) {
            Logger.getLogger(Ana_Form.class.getName()).log(Level.SEVERE, null, e);
        }
    }
                
            }
            else{
                if((form.getTxt_Kul_Adi().getText().equals(""))||(form.getTxt_Adi().getText().equals(""))||(form.getTxt_Soyadi().getText().equals(""))){
JOptionPane.showConfirmDialog(null, "Güncellenecek veri bulunamadı!","Kullanıcı işlemleri",JOptionPane.PLAIN_MESSAGE);
        } else {  
        try {           
           //String [] id={String.valueOf(tablo.getValueAt(tablo.getSelectedRow(), 0))};
           st=(Statement) baglanti.createStatement();
        st.executeUpdate("update Kullanici set id='"+form.getLbl_Secilen().getText()+"', k_adi='"+
        form.getTxt_Kul_Adi().getText() +"' ,sifre='"+"12345"+"',Adi='"+form.getTxt_Adi().getText() +"', Soyadi='"+form.getTxt_Soyadi().getText() +"', k_turu='"+form.getCmb_Tur().getSelectedItem() +"' where id='"+form.getLbl_Secilen().getText()+"'");
        JOptionPane.showConfirmDialog(null, "Kayıt Başarıyla Güncellendi...","Kullanıcı İşlemleri",JOptionPane.PLAIN_MESSAGE); 
        
    } 
          
         catch (SQLException ex) {
            Logger.getLogger(Kullanici_Guncelle_Form.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
            }
    
    
    }

    @Override
    public void tablodanVeriSecme() {
            secilenKayit=form.getTablo_kullanici().getValueAt(form.getTablo_kullanici().getSelectedRow(), 0).toString();
        Kullanici_Guncelle_Form idSecilen=form.yeniFormOlustur();
        setId(String.valueOf(form.getTablo_kullanici().getValueAt(form.getTablo_kullanici().getSelectedRow(), 0))); 
        
        ResultSet rs=null;
        try {
           Statement stKayitgetir=(Statement) baglanti.createStatement();
           //JOptionPane.showConfirmDialog(null, idSecilen.getId());
           rs=stKayitgetir.executeQuery("select * from kullanici where id='"+getId()+"'");
           while(rs.next()){
               form.getLbl_Secilen().setText(rs.getString("id"));
               form.getTxt_Kul_Adi().setText(rs.getString("k_adi"));
                form.getTxt_Adi().setText(rs.getString("Adi"));
               form.getTxt_Soyadi().setText(rs.getString("Soyadi"));
               
           }           
          
        } catch (Exception ex) {
            JOptionPane.showConfirmDialog(null, "hata");
            Logger.getLogger(Kullanici_Guncelle_Form.class.getName()).log(Level.SEVERE, null, ex);
        }
        form.getLbl_Secilen().setVisible(false);
                
                }

    @Override
    public void tablodanVeriSilme() {
        
     if(form.getLbl_Secilen().getText()==null){
    JOptionPane.showConfirmDialog(null, "Tablodan kullanıcı seçmediniz!","Kullanıcı işlemleri", JOptionPane.PLAIN_MESSAGE);
        }else {
                
                if (JOptionPane.showConfirmDialog(null, "Kullanıcıyı silmek istediğinize emin misiniz!?", "UYARI",
        JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
    try {
            Statement stSil=(Statement) baglanti.createStatement();
            stSil.executeUpdate("delete from Kullanici where id='"+form.getLbl_Secilen().getText()+"'");
            JOptionPane.showConfirmDialog(null, "Kullanıcı silinmiştir.!","SİLİNDİ",JOptionPane.PLAIN_MESSAGE);
        } catch (Exception ex) {
            Logger.getLogger(Kullanici_Guncelle_Form.class.getName()).log(Level.SEVERE, null, ex);
        }
      tabloYenile();
} else {
              
                  form.getLbl_Secilen().setText(null);
       form.getTxt_Kul_Adi().setText(null);
        form.getTxt_Adi().setText(null);
        form.getTxt_Soyadi().setText(null);
      form.getCmb_Tur().setSelectedIndex(0);
}
              }
    }

    @Override
    public void tabloYenile() {
      
        
         kullanicilar=new Vector<KullaniciModeli>();
        try {form.getLbl_Secilen().setText(null);
            Statement st=(Statement) baglanti.createStatement();
            if (form.getTxt_Arama().getText()==null){
                res=st.executeQuery("select * from Kullanici order by Adi");
                
            }
            else {
                res=st.executeQuery("select * from Kullanici where k_adi LIKE '%"+
    form.getTxt_Arama().getText()+"%' OR Adi LIKE '%"+ 
    form.getTxt_Arama().getText()+"%' OR Soyadi LIKE '%"+ 
    form.getTxt_Arama().getText()+"%' OR k_turu LIKE '%"+ 
    form.getTxt_Arama().getText()+"%'");
                
            }
            
            
            while(res.next()){
            KullaniciModeli kullaniciModeli = new KullaniciModeli();
                
                kullaniciModeli.setId(res.getInt("id"));
                kullaniciModeli.setkAdi(res.getString("k_adi"));
                
                //user.setSifre(res.getString("sifre"));
                kullaniciModeli.setAdi(res.getString("Adi"));
                kullaniciModeli.setSoyadi(res.getString("Soyadi"));
                kullaniciModeli.setkTuru(res.getString("k_turu"));
                
               
                kullanicilar.add(kullaniciModeli);
              
               
            }
        form.getTxt_Kul_Adi().setText(null);
        form.getTxt_Adi().setText(null);
        form.getTxt_Soyadi().setText(null);
        form.getCmb_Tur().setSelectedIndex(0);
        
        } catch (Exception ex) {
            Logger.getLogger(Ana_Form.class.getName()).log(Level.SEVERE, null, ex);
        }

      
      
        DefaultTableModel tModel = (DefaultTableModel)form.getTablo_kullanici().getModel();
        tModel.setRowCount(0);
        Object [] satir = new Object[5];
            for (int i=0; i<kullanicilar.size();i++) {
             
                satir[0]=kullanicilar.get(i).getId();
               
                satir[1]=kullanicilar.get(i).getkAdi();
                satir[2]=kullanicilar.get(i).getAdi();
                satir[3]=kullanicilar.get(i).getSoyadi();
                satir[4]=kullanicilar.get(i).getkTuru();
                 
               tModel.addRow(satir);
            }
form.getTablo_kullanici().setModel(tModel);
            
    
    }

    
    
    
    
    public static String getSecilenKayit() {
        return secilenKayit;
    }

    public static void setSecilenKayit(String secilenKayit) {
        KullaniciGuncellePresenter.secilenKayit = secilenKayit;
    }

    public static String getId() {
        return id;
    }

    public static void setId(String id) {
        KullaniciGuncellePresenter.id = id;
    }
    
    
    
    

}
