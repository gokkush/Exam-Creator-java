/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presenter;

import Model.DbAbstraction;
import Model.DbRefinedAbstraction;
import Model.ITabloVerileriDoldurabilme;
import Model.Islemler;
import Model.Kullanici;
import Model.SoruGuncelleyebilme;
import Model.Sorular;
import Model.SqlLiteImplementor;
import Model.VeriGuncelleyebilme;
import Model.VeriSecebilme;
import Model.VeriSilebilme;
import Model.VeriYenileyebilme;
import View.Ana_Form;
import View.IViewSoruGuncelle;
import View.Soru_Guncelle_Form;

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
public class SoruGuncellePresenter implements SoruGuncelleyebilme, ITabloVerileriDoldurabilme,VeriGuncelleyebilme, VeriSecebilme,VeriSilebilme,VeriYenileyebilme{
    private Connection baglanti;
    private Statement st=null;
    private ResultSet res;
    private DbAbstraction abs = new DbRefinedAbstraction(new SqlLiteImplementor());
    private IViewSoruGuncelle view;
    private Soru_Guncelle_Form form;
    private Islemler islem = Islemler.yeniFormOlustur();
    
    
    public SoruGuncellePresenter(IViewSoruGuncelle view) {
        this.view = view;
         baglanti = abs.getImplementor().OpenCon(" Soru Güncelle Presenter");
        form = Soru_Guncelle_Form.yeniFormOlustur();
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

        if (form.getLbl_Secilen().getText() == null) {
            Statement st = null;
            ResultSet res;
           cevapAl();
           dersSec();
           soru_turu_Sec();
           zorlukSec();
            if ((form.getTxt_soru().getText().equals("")) || (islem.getDogruCevap() == null)) {
                JOptionPane.showConfirmDialog(null, "Boş girişleri giriniz!.", "Kayıt işlemleri", JOptionPane.DEFAULT_OPTION);
            } else {
                try {
                    st = baglanti.createStatement();

                    st.executeUpdate("insert into Sorular (ders_id,soru_tur_id,zorluk_id,Soru,cevaplar,dogru_cevap,cevap_sayisi,save_date,save_user) values ( '" + islem.getDersSecimi() + "','" + islem.getSoruTurSecimi()+ "','" + islem.getZorlukSecimi()+ "','" + form.getTxt_soru().getText() + "','" + islem.getCevap() + "','" + islem.getDogruCevap() + "','" + islem.getCevapSayisi() + "','" + sqlDate + "','" + Kullanici.getId() + "')");

                    
                  
                    view.mesaj("Soru Başarıyla Eklendi", "Soru Türü İşlemleri");
                    
                    form.getTxt_soru().setText(null);
                    tabloYenile();

                } catch (Exception e) {
                    Logger.getLogger(Ana_Form.class.getName()).log(Level.SEVERE, null, e);
                }
            }
        } else {

            cevapAl();
            dersSec();
            soru_turu_Sec();
            zorlukSec();
            if ((form.getTxt_soru().getText().equals("")) ||  (islem.getDogruCevap() == null)) {
                System.out.println(form.getTxt_soru().getText());
                System.out.println(islem.getDogruCevap());
                JOptionPane.showConfirmDialog(null, "Güncelleme için verileri doldurunuz.!", "Güncelleme", JOptionPane.DEFAULT_OPTION);
            } else {
                try {
                    //String [] id={String.valueOf(tablo.getValueAt(tablo.getSelectedRow(), 0))};
                    st = (Statement) baglanti.createStatement();
                    st.executeUpdate("update Sorular set id='" + form.getLbl_Secilen().getText() + "', ders_id='" + islem.getDersSecimi()+ "', soru_tur_id='" + islem.getSoruTurSecimi()+ "', zorluk_id='" + islem.getZorlukSecimi()+ "', Soru='" + form.getTxt_soru().getText() + "',cevaplar='" + islem.getCevap() + "',dogru_cevap='" + islem.getDogruCevap() + "',cevap_sayisi='" +islem.getCevapSayisi() + "', edit_date='" + sqlDate + "', edit_user='" + Kullanici.getId() + "' where id='" + form.getLbl_Secilen().getText() + "'");
                    JOptionPane.showConfirmDialog(null, "Kayıt Başarıyla Güncellendi...", "Güncelleme", JOptionPane.DEFAULT_OPTION);
                    tabloYenile();
                } catch (SQLException ex) {
                    Logger.getLogger(Soru_Guncelle_Form.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

    
    }

    @Override
    public void tablodanVeriSecme() {
        
       islem.setSecilenKayit(form.getTablo_Soru().getValueAt(form.getTablo_Soru().getSelectedRow(), 0).toString());
        
        islem.setId(String.valueOf(form.getTablo_Soru().getValueAt(form.getTablo_Soru().getSelectedRow(), 0)));

        ResultSet rs = null;
        try {
            Statement stKayitgetir = (Statement) baglanti.createStatement();
            //JOptionPane.showConfirmDialog(null, idSecilen.getId());
            rs = stKayitgetir.executeQuery("select * from Sorular where id='" + islem.getId() + "'");
            while (rs.next()) {
                form.getLbl_Secilen().setText(rs.getString("id"));
                form.getTxt_soru().setText(rs.getString("Soru"));

            }

        } catch (Exception ex) {
            Logger.getLogger(Soru_Guncelle_Form.class.getName()).log(Level.SEVERE, null, ex);
        }
        form.getLbl_Secilen().setVisible(false);
    }

    @Override
    public void tablodanVeriSilme() {
        if (form.getLbl_Secilen().getText() == null) {
            JOptionPane.showConfirmDialog(null, "Tablodan Soru Türü Seçmediniz!", "Soru Türü İşlemleri", JOptionPane.DEFAULT_OPTION);
        } else {

            if (JOptionPane.showConfirmDialog(null, "Soru silmek istediğinize emin misiniz!?", "UYARI",
                    JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                try {
                    Statement stSil = (Statement) baglanti.createStatement();
                    stSil.executeUpdate("delete from Sorular where id='" + form.getLbl_Secilen().getText() + "'");
                    JOptionPane.showConfirmDialog(null, "Soru silinmiştir.!", "SİLİNDİ", JOptionPane.DEFAULT_OPTION);
                } catch (Exception ex) {
                    Logger.getLogger(Soru_Guncelle_Form.class.getName()).log(Level.SEVERE, null, ex);
                }
             tabloYenile();
            } else {

                form.getLbl_Secilen().setText(null);
                form.getTxt_soru().setText(null);

            }
        } 
    
    }

    @Override
    public void tabloYenile() {
     dersSec();
        
        ArrayList<Sorular> sorular = new ArrayList<Sorular>();
        try {
            form.getLbl_Secilen().setText(null);
            Statement st = (Statement) baglanti.createStatement();
            if (form.getTxt_Arama().getText().equals("")) {
                
                if(islem.getDersSecimi()==null){
                res = st.executeQuery("select * from Sorular ");
                }
                else res = st.executeQuery("select * from Sorular where ders_id='"+islem.getDersSecimi().trim()+"'");

            } else {
                res=st.executeQuery("select * from Sorular where ders_id LIKE '%" +islem.getDersSecimi().trim()+"%' AND (Soru LIKE '%"+
                form.getTxt_Arama().getText()+"%' OR cevaplar LIKE '%"+ 
    form.getTxt_Arama().getText()+"%' OR dogru_cevap LIKE '%"+ 
    form.getTxt_Arama().getText()+"%')");
                
            }

            while (res.next()) {
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

            }
            form.getTxt_soru().setText(null);
            form.getTxt_cevap_1().setText(null);
            form.getTxt_cevap_2().setText(null);
            form.getTxt_cevap_3().setText(null);
            form.getTxt_cevap_4().setText(null);
            form.getTxt_cevap_5().setText(null);
            form.getTxt_Dogru_Cevap().setText(null);
            islem.setCevap(null);
            islem.setDogruCevap(null);
            islem.setCevapSayisi(0);
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

    @Override
    public void cm_Soru_Tip_Doldurma() {
      form.getCm_Soru_Tip().removeAllItems();
        try {
            String sql = "select * from Soru_Turu order by id";
            Statement st = (Statement) baglanti.createStatement();
            res = st.executeQuery(sql);

            while (res.next()) {
                String soru_Turu = res.getString("Soru_Turu");
                form.getCm_Soru_Tip().addItem(soru_Turu);
            }
            res.close();
            st.close();

        } catch (Exception ex) {
            Logger.getLogger(Ana_Form.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }

    @Override
    public void soru_turu_Sec() {
      
      try {
            
            String sql = "Select * from Soru_Turu where Soru_Turu='"+form.getCm_Soru_Tip().getSelectedItem().toString()+"'";
            Statement st = (Statement) baglanti.createStatement();
            res = st.executeQuery(sql);

            while (res.next()) {
                islem.setSoruTurSecimi(res.getString("id"));
                
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
                islem.setZorlukSecimi(res.getString("id"));
                
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
    
        public void cevapAl() {
       
     if (form.getCm_Soru_Tip().getSelectedItem().equals("ÇOKTAN SEÇMELİ")) {
            if (form.getCm_Sayi().getSelectedItem().equals("3")) {
                if ((form.getTxt_cevap_1().getText().equals("")) || (form.getTxt_cevap_2().getText().equals("")) || (form.getTxt_cevap_3().getText().equals(""))) {

                } else {
                    islem.setCevap("a)" + form.getTxt_cevap_1().getText() + " b)" + form.getTxt_cevap_2().getText() + " c)" + form.getTxt_cevap_3().getText());
                    islem.setDogruCevap(form.getCm_Dogru_Cevap().getSelectedItem().toString());
                    islem.setCevapSayisi(3);
                }
            } else if (form.getCm_Sayi().getSelectedItem().equals("4")) {
                if ((form.getTxt_cevap_1().getText().equals("")) || (form.getTxt_cevap_2().getText().equals("")) || (form.getTxt_cevap_3().getText().equals("")) || (form.getTxt_cevap_4().getText().equals(""))) {

                } else {
                    islem.setCevap ("a)" + form.getTxt_cevap_1().getText() + " b)" + form.getTxt_cevap_2().getText() + " c)" + form.getTxt_cevap_3().getText() + " d)" + form.getTxt_cevap_4().getText());
                    islem.setDogruCevap(form.getCm_Dogru_Cevap().getSelectedItem().toString());
                    islem.setCevapSayisi(4);
                }
            } else if (form.getCm_Sayi().getSelectedItem().equals("5")) {
                if ((form.getTxt_cevap_1().getText().equals("")) || (form.getTxt_cevap_2().getText().equals("")) || (form.getTxt_cevap_3().getText().equals("")) || (form.getTxt_cevap_4().getText().equals("")) || (form.getTxt_cevap_5().getText().equals(""))) {

                } else {
                    islem.setCevap("a)" + form.getTxt_cevap_1().getText() + " b)" + form.getTxt_cevap_2().getText() + " c)" + form.getTxt_cevap_3().getText() + " d)" + form.getTxt_cevap_4().getText() + " e)" + form.getTxt_cevap_5().getText());
                   islem.setDogruCevap( form.getCm_Dogru_Cevap().getSelectedItem().toString());
                   islem.setCevapSayisi(5);
                }
            }

        }
        else if (form.getCm_Soru_Tip().getSelectedItem().equals("DOĞRU YANLIŞ")) {
            islem.setCevap ("DOĞRU/YANLIŞ");
            islem.setDogruCevap( form.getCm_Dogru_Cevap().getSelectedItem().toString());
            islem.setCevapSayisi(1);
        } 
        else {
            if ((form.getTxt_Dogru_Cevap().getText().equals(""))) {

            } else {
                islem.setCevap(null);
                islem.setDogruCevap(form.getTxt_Dogru_Cevap().getText());
                islem.setCevapSayisi(1);
            }

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
    public void dersSec() {
        try {
            
            String sql = "Select * from Dersler where ders_adi='"+form.getCm_Ders().getSelectedItem().toString()+"'";
            Statement st = (Statement) baglanti.createStatement();
            res = st.executeQuery(sql);

            while (res.next()) {
                islem.setDersSecimi( res.getString("id"));
                
            }
            
            res.close();
            st.close();
        } catch (Exception ex) {
            Logger.getLogger(Ana_Form.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    
    
    
}
