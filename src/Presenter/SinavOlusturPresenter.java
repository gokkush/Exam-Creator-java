/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presenter;


import Model.DbAbstraction;
import Model.DbRefinedAbstraction;
import Model.Kullanici;
import Model.SinavIslemleri;
import Model.SinavOlusturabilme;
import Model.Sinav_Sorulari;
import Model.SoruDetaylari;
import Model.Sorular;
import Model.SqlLiteImplementor;
import Model.VeriGuncelleyebilme;
import Model.VeriSecebilme;
import Model.VeriYenileyebilme;
import Model.Z_KolaySoru;
import Model.Z_OrtaSoru;
import Model.Z_ZorSoru;
import Model.ZorlukHazirla;
import View.Ana_Form;
import View.IViewSinavOlustur;
import View.Sinav_Olustur_Form;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import static javax.swing.UIManager.get;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author User
 */
public class SinavOlusturPresenter extends SinavIslemleri implements VeriYenileyebilme, VeriSecebilme,SinavOlusturabilme {
    private Connection baglanti;
    private Statement st=null;
    private ResultSet res;
    private DbAbstraction abs ;
    private Sinav_Olustur_Form form ;
    private IViewSinavOlustur view;
    private ArrayList<Sinav_Sorulari> soru_id;
    private ArrayList<Sorular> sorular;
    private ZorlukHazirla zorlukHazirla;
 
   
   
      
    private SoruDetaylari detay;
    public SinavOlusturPresenter(IViewSinavOlustur view) {
        this.view = view;
         abs = new DbRefinedAbstraction(new SqlLiteImplementor());
         baglanti = abs.getImplementor().OpenCon(" Soru Güncelle Presenter");
         form = Sinav_Olustur_Form.yeniFormOlustur();
         soru_id = new ArrayList<Sinav_Sorulari>();
         sorular = new ArrayList<Sorular>();
         
         detay = new SoruDetaylari();
         zorlukHazirla = new ZorlukHazirla();
    }

    //region tablo
    @Override
    public void tabloYenile() {
       
    dersSec();
          zorlukSec();
          ArrayList<Sorular> sorular = new ArrayList<Sorular>();
        try {
            form.getLbl_Secilen().setText(null);
            Statement st = (Statement) baglanti.createStatement();
            if ((form.getTxt_Arama().getText()==null)||(dersSecimi==null)) {
                
               
                res = st.executeQuery("select * from Sorular ");
                
            } else {
                res=st.executeQuery("select * from Sorular where ders_id LIKE '%"
                        +dersSecimi.trim()+"%' AND (Soru LIKE '%"+
                        form.getTxt_Arama().getText()+"%' OR cevaplar LIKE '%"+ 
                        form.getTxt_Arama().getText()+"%' OR dogru_cevap LIKE '%"+ 
                        form.getTxt_Arama().getText()+"%')");
                
            }

            while (res.next()) {
                Sinav_Sorulari sinav = new Sinav_Sorulari();
                Sorular soru = new Sorular();
                soru.setId(res.getInt("id"));
                soru.setSoru(res.getString("Soru"));
                soru.setCevap(res.getString("cevaplar"));
                soru.setCevap_sayisi(res.getInt("cevap_sayisi"));
                soru.setDogru_cevap(res.getString("dogru_cevap"));
                soru.setSoru_puan(res.getFloat("soru_puan"));
                soru.setSoru_tur_id(res.getInt("Soru_tur_id"));
                soru.setDers_id(res.getInt("ders_id"));
                soru.setZorluk_id(res.getInt("zorluk_id"));

                sorular.add(soru);
                
                sinav.setSoru_id(res.getInt("id"));
                soru_id.add(sinav);

            }

            cevap = null;
            dogruCevap = null;
            cevapSayisi=0;
            res.close();
            st.close();

        } catch (Exception ex) {
            Logger.getLogger(Ana_Form.class.getName()).log(Level.SEVERE, null, ex);
        }

        DefaultTableModel tModel = (DefaultTableModel) form.getTablo_Soru().getModel();
        tModel.setRowCount(0);
        Object[] satir = new Object[4];
        for (int i = 0; i < sorular.size(); i++) {
            satir[0] = sorular.get(i).getId();
            satir[1] = sorular.get(i).getSoru();
            satir[2] = sorular.get(i).getCevap();
            satir[3] = sorular.get(i).getDogru_cevap();

            tModel.addRow(satir);
        }
        form.getTablo_Soru().setModel(tModel);

    }
    //endregion
    
    
    @Override
    public void tablodanVeriSecme() {
     secilenKayit = form.getTablo_Soru().getValueAt(form.getTablo_Soru().getSelectedRow(), 0).toString();
       
        setId(String.valueOf(form.getTablo_Soru().getValueAt(form.getTablo_Soru().getSelectedRow(), 0)));

        ResultSet rs = null;
        try {
            Statement stKayitgetir = (Statement) baglanti.createStatement();
            //JOptionPane.showConfirmDialog(null, idSecilen.getId());
            rs = stKayitgetir.executeQuery("select * from Sorular where id='" + getId() + "'");
            while (rs.next()) {
                form.getLbl_Secilen().setText(rs.getString("id"));
                

            }

        } catch (Exception ex) {
            Logger.getLogger(Sinav_Olustur_Form.class.getName()).log(Level.SEVERE, null, ex);
        }
        form.getLbl_Secilen().setVisible(false);
    
    }

    public void stratejiIleRandomSoruAta(){
       if(form.getCm_Zorluk_Tip().getSelectedItem().equals("KOLAY")){
                zorlukHazirla.setDeger(new Z_KolaySoru());
            }
       else if(form.getCm_Zorluk_Tip().getSelectedItem().equals("ORTA")){
                zorlukHazirla.setDeger(new Z_OrtaSoru());
            }
        if(form.getCm_Zorluk_Tip().getSelectedItem().equals("ZOR")){
                zorlukHazirla.setDeger(new Z_ZorSoru());
            }
   
        
    }
    
    @Override
    public void sinav_Olustur() {
       
       

        java.util.Calendar cal = Calendar.getInstance();
        java.util.Date utilDate = new java.util.Date();
        cal.setTime(utilDate);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        java.sql.Date sqlDate = new java.sql.Date(cal.getTime().getTime());


            if ((form.getTxt_gozetmen().equals("")) || (form.getTxt_Tarih().equals("")) || (form.getTxt_Sinav_Yeri().equals("")) ||(form.getTablo_Random_Soru().getRowCount()==0)) {
               
                JOptionPane.showConfirmDialog(null, "Boş girişleri giriniz!.", "Kayıt işlemleri", JOptionPane.DEFAULT_OPTION);
           
            } else {
                try {
                    st = baglanti.createStatement();

                    st.executeUpdate("insert into Sinav (gozetmen_Adi,sinav_Tarihi,sinav_Yeri,ders,save_date,save_user) values ( '" + form.getTxt_gozetmen().getText() + "','" + form.getTxt_Tarih().getText()+ "','" + form.getTxt_Sinav_Yeri().getText()+ "','" + form.getCm_Ders().getSelectedItem() +  "','" + sqlDate + "','" + Kullanici.getId() + "')");
                    
                    res=st.executeQuery("select * from Sinav ");
                
            
            int id=0;
            while (res.next()) {
                id=res.getInt("id");
   
            }
                    for (int i = 0; i < form.getTablo_Random_Soru().getRowCount(); i++) {
                        
                    
                    st.executeUpdate("insert into Sinav_Sorulari (soru,cevap,sinav_id,save_date,save_user) values ( '" + form.getTablo_Random_Soru().getValueAt(i, 1) + "','" + form.getTablo_Random_Soru().getValueAt(i, 2)+ "','"+ id + "','"+ sqlDate + "','" + Kullanici.getId() + "')");
}
                   
                    view.mesaj( "Sinav Başarıyla Eklendi", "Sinav Türü İşlemleri");
                    form.getTxt_Sinav_Yeri().setText(null);
                    form.getTxt_Tarih().setText(null);
                    form.getTxt_gozetmen().setText(null);
                    form.getTxt_Soru_Sayisi().setText(""+sorular.size());
                    tabloYenile();

                } catch (Exception e) {
                    Logger.getLogger(Ana_Form.class.getName()).log(Level.SEVERE, null, e);
                }
            }
       
    
    }

    @Override
    public void dersSec() {
      try {
            
            String sql = "Select * from Dersler where ders_adi='"+form.getCm_Ders().getSelectedItem().toString()+"'";
            Statement st = (Statement) baglanti.createStatement();
            res = st.executeQuery(sql);

            while (res.next()) {
                dersSecimi = res.getString("id");
                
            }
            
            res.close();
            st.close();
        } catch (Exception ex) {
            Logger.getLogger(Ana_Form.class.getName()).log(Level.SEVERE, null, ex);
        } 
    
    }

    @Override
    public void zorlukSec() {
          try {
            
            String sql = "Select * from Zorluk where zorluk_derecesi='"+form.getCm_Zorluk_Tip().getSelectedItem().toString()+"'";
            Statement st = (Statement) baglanti.createStatement();
            res = st.executeQuery(sql);

            while (res.next()) {
                zorlukSecimi = res.getString("id");
                
            }
            
            res.close();
            st.close();
        } catch (Exception ex) {
            Logger.getLogger(Ana_Form.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }

    @Override
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

    @Override
    public void cm_Zorluk_Turu_Doldurma() {
     
     form.getCm_Zorluk_Tip().removeAllItems();
        try {
            String sql = "select * from Zorluk order by id";
            Statement st = (Statement) baglanti.createStatement();
            res = st.executeQuery(sql);

            while (res.next()) {
                String zorluk_turu = res.getString("zorluk_derecesi");
                form.getCm_Zorluk_Tip().addItem(zorluk_turu);
            }
            res.close();
            st.close();

        } catch (Exception ex) {
            Logger.getLogger(Ana_Form.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }


    
    
    
}
