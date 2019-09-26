/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presenter;

import Model.DbAbstraction;
import Model.DbRefinedAbstraction;
import Model.Gozetmen;
import Model.Kullanici;
import Model.SqlLiteImplementor;
import Model.VeriGuncelleyebilme;
import Model.VeriSecebilme;
import Model.VeriSilebilme;
import Model.VeriYenileyebilme;
import View.Ana_Form;
import View.Gozetmen_Guncelle_Form;
import View.IViewGozetmenGuncelle;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author User
 */
public class GozetmenGuncellePresenter implements VeriGuncelleyebilme, VeriSecebilme,VeriSilebilme,VeriYenileyebilme{
   private IViewGozetmenGuncelle view;
   private Gozetmen_Guncelle_Form form=Gozetmen_Guncelle_Form.yeniFormOlustur();
   private Connection baglanti;
   private DbAbstraction abs = new DbRefinedAbstraction(new SqlLiteImplementor());
private ResultSet res;
    private Statement st=null;
    private String secilenKayit;
    private String id;
    DefaultListModel listModel2 = new DefaultListModel();
    public GozetmenGuncellePresenter(IViewGozetmenGuncelle view) {
        this.view = view;
         baglanti = abs.getImplementor().OpenCon(" Gözetmen Guncelle Presenter");
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
            String dersler =""; 
            for (int i = 0; i < form.getLs_Gorevlendirilen_Ders().getModel().getSize(); i++) {
    dersler = dersler+form.getLs_Gorevlendirilen_Ders().getModel().getElementAt(i)+" ";
}
            if(form.getLbl_Secilen().getText()==null){
             Statement st=null;
        ResultSet res;  
    if((form.getTxt_Adi_Soyadi().getText().equals(""))){
JOptionPane.showConfirmDialog(null, "Gözetmen adı boş olamaz.","Kayıt işlemleri",JOptionPane.PLAIN_MESSAGE);
        }else {
        try {
             st=baglanti.createStatement();

                      
st.executeUpdate("insert into Gozetmen (Adi_Soyadi,Gorevi,Ders,save_date,save_user) values ('" + form.getTxt_Adi_Soyadi().getText()+"','" + form.getCm_Gorev().getSelectedItem()+"','" + dersler+"','"+sqlDate+ "','"+ Kullanici.getId()+"')");
            
        JOptionPane.showConfirmDialog(null, "Gözetmen Başarıyla Eklendi","Zorluk İşlemleri",JOptionPane.PLAIN_MESSAGE);
        form.getTxt_Adi_Soyadi().setText(null);
            
        } catch (Exception e) {
            Logger.getLogger(Ana_Form.class.getName()).log(Level.SEVERE, null, e);
        }
    }
                
            }
            else{
                if((form.getTxt_Adi_Soyadi().getText().equals(""))){
JOptionPane.showConfirmDialog(null, "Güncellenecek veri bulunamadı!","Zorluk İşlemleri",JOptionPane.PLAIN_MESSAGE);
        } else {  
        try {           
           //String [] id={String.valueOf(tablo.getValueAt(tablo.getSelectedRow(), 0))};
           st=(Statement) baglanti.createStatement();
        st.executeUpdate("update Gozetmen set id='"+form.getLbl_Secilen().getText()+"', Adi_Soyadi='"+form.getTxt_Adi_Soyadi().getText() +"', Gorevi='"+form.getCm_Gorev().getSelectedItem() +"', edit_date='"+sqlDate +"', edit_user='"+ Kullanici.getId()+"' where id='"+form.getLbl_Secilen().getText()+"'");
        JOptionPane.showConfirmDialog(null, "Kayıt Başarıyla Güncellendi...","Gözetmen İşlemleri",JOptionPane.PLAIN_MESSAGE); 
        
    } 
          
         catch (SQLException ex) {
            Logger.getLogger(Gozetmen_Guncelle_Form.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
            }
                
    }

    @Override
    public void tablodanVeriSecme() {
            secilenKayit=form.getTablo_Gozetmen().getValueAt(form.getTablo_Gozetmen().getSelectedRow(), 0).toString();
        
        id=String.valueOf(form.getTablo_Gozetmen().getValueAt(form.getTablo_Gozetmen().getSelectedRow(), 0)); 
        
        ResultSet rs=null;
        try {
           Statement stKayitgetir=(Statement) baglanti.createStatement();
           //JOptionPane.showConfirmDialog(null, idSecilen.getId());
           rs=stKayitgetir.executeQuery("select * from Gozetmen where id='"+id+"'");
           while(rs.next()){
               form.getLbl_Secilen().setText(rs.getString("id"));
               form.getTxt_Adi_Soyadi().setText(rs.getString("Adi_Soyadi"));
               
               
           }           
          
        } catch (Exception ex) {
            Logger.getLogger(Gozetmen_Guncelle_Form.class.getName()).log(Level.SEVERE, null, ex);
        }
        form.getLbl_Secilen().setVisible(false);
    
    }

    @Override
    public void tablodanVeriSilme() {
         
            if(form.getLbl_Secilen().getText()==null){
    JOptionPane.showConfirmDialog(null, "Tablodan Gözetmen seçmediniz!","Gozetmen İşlemleri", JOptionPane.PLAIN_MESSAGE);
        }else {
                
                if (JOptionPane.showConfirmDialog(null, "Görevliyi silmek istediğinize emin misiniz!?", "UYARI",
        JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
    try {
            Statement stSil=(Statement) baglanti.createStatement();
            stSil.executeUpdate("delete from Gozetmen where id='"+form.getLbl_Secilen().getText()+"'");
            JOptionPane.showConfirmDialog(null, "Görevli silinmiştir.!","SİLİNDİ",JOptionPane.PLAIN_MESSAGE);
        } catch (Exception ex) {
            Logger.getLogger(Gozetmen_Guncelle_Form.class.getName()).log(Level.SEVERE, null, ex);
        }
        tabloYenile();
} else {
              
                  form.getLbl_Secilen().setText(null);
        form.getTxt_Adi_Soyadi().setText(null);
        form.getCm_Gorev().setSelectedIndex(0);
        
}
              }
    
    }

    @Override
    public void tabloYenile() {
       
     ls_Ders_Doldurma();
    ArrayList<Gozetmen> goz=new ArrayList<Gozetmen>();
        try {form.getLbl_Secilen().setText(null);
            Statement st=(Statement) baglanti.createStatement();
            if (form.getTxt_Arama().getText()==null){
                res=st.executeQuery("select * from Gozetmen order by Adi_Soyadi");
                
            }
            else {
                res=st.executeQuery("select * from Gozetmen where Adi_Soyadi LIKE '%"+
    form.getTxt_Arama().getText()+"%'");
                
            }
            
            
            while(res.next()){
                Gozetmen gozetmen=new Gozetmen();
                gozetmen.setId(res.getInt("id"));
                gozetmen.setAdi_Soyadi(res.getString("Adi_Soyadi"));
                gozetmen.setGorevi(res.getString("Gorevi"));
                gozetmen.setDers(res.getString("Ders"));
                
                                
                goz.add(gozetmen);
                
            }
                    form.getTxt_Adi_Soyadi().setText(null);
        form.getLs_Gorevlendirilen_Ders().removeAll();
        form.getCm_Gorev().setSelectedIndex(0);
                form.getLb_Ders_Liste().setVisible(false);
        form.getLb_Gorevlendirilen_Dersler().setVisible(false);
        form.getLs_Dersler().setVisible(false);
        form.getLs_Gorevlendirilen_Ders().setVisible(false);
        form.getBtn_Ekle().setVisible(false);
        form.getBtn_Cikar().setVisible(false);
        
        
        } catch (Exception ex) {
            Logger.getLogger(Ana_Form.class.getName()).log(Level.SEVERE, null, ex);
        }

       
        
      
        DefaultTableModel tModel = (DefaultTableModel)form.getTablo_Gozetmen().getModel();
        tModel.setRowCount(0);
        Object [] satir = new Object[4];
            for (int i=0; i<goz.size();i++) {
                satir[0]=goz.get(i).getId();
                satir[1]=goz.get(i).getAdi_Soyadi();
                satir[2]=goz.get(i).getGorevi();
                satir[3]=goz.get(i).getDers();
                
                tModel.addRow(satir);
            }
form.getTablo_Gozetmen().setModel(tModel);
    
    }
   
     public void ls_Ders_Doldurma() {
        form.getLbl_Secilen().removeAll();
        try {
            String sql = "select * from Dersler order by id";
            Statement st = (Statement) baglanti.createStatement();
            res = st.executeQuery(sql);
DefaultListModel listModel = new DefaultListModel();
            while (res.next()) {
                String ders_Adi = res.getString("ders_adi");
                    
    
    listModel.addElement(ders_Adi);
    
    
              
            }
            form.getLs_Dersler().setModel(listModel);
            res.close();
            st.close();
            
        } catch (Exception ex) {
            Logger.getLogger(Ana_Form.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
     
     public void btnEkle(){
           listModel2.addElement(form.getLs_Dersler().getSelectedValue());
    
            form.getLs_Gorevlendirilen_Ders().setModel(listModel2);
     }
     
     public void btnCikar(){
          listModel2.removeElement(form.getLs_Gorevlendirilen_Ders().getSelectedValue());
    
    form.getLs_Gorevlendirilen_Ders().setModel(listModel2);
     }
     
     public void gorevMenu(){
           if(form.getCm_Gorev().getSelectedIndex()==1){
                   form.getLb_Ders_Liste().setVisible(true);
        form.getLb_Gorevlendirilen_Dersler().setVisible(true);
        form.getLs_Dersler().setVisible(true);
        form.getLs_Gorevlendirilen_Ders().setVisible(true); 
        form.getBtn_Ekle().setVisible(true);
        form.getBtn_Cikar().setVisible(true);
        }
        else{
                    form.getLb_Ders_Liste().setVisible(false);
        form.getLb_Gorevlendirilen_Dersler().setVisible(false);
        form.getLs_Dersler().setVisible(false);
        form.getLs_Gorevlendirilen_Ders().setVisible(false);
        form.getBtn_Ekle().setVisible(false);
        form.getBtn_Cikar().setVisible(false);
        }
     }
}
