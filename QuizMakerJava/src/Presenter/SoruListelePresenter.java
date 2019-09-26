/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presenter;


import Model.DbAbstraction;
import Model.DbRefinedAbstraction;
import Model.ITabloVerileriDoldurabilme;
import Model.SoruDetaylari;
import Model.Sorular;
import Model.SqlLiteImplementor;
import Model.VeriGuncelleyebilme;
import Model.VeriSecebilme;
import Model.VeriSilebilme;
import Model.VeriYenileyebilme;
import View.Ana_Form;
import View.IViewSoruListele;
import View.Soru_Liste_Form;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author User
 */
public class SoruListelePresenter implements VeriYenileyebilme,ITabloVerileriDoldurabilme{
    private Connection baglanti;
    private Statement st=null;
    private ResultSet res;
    private DbAbstraction abs = new DbRefinedAbstraction(new SqlLiteImplementor());
    private IViewSoruListele view;
    private Soru_Liste_Form form = Soru_Liste_Form.yeniFormOlustur();
    
    private SoruDetaylari detay;
       private String dersSecim = detay.getDersSecimi();
              private String zorlukSecim = detay.getZorlukSecimi();
              private String soruTurSecim = detay.getZorlukSecimi();

    public SoruListelePresenter(IViewSoruListele view) {
        this.view = view;
           baglanti = abs.getImplementor().OpenCon(" Soru Listele Presenter");
           detay = new SoruDetaylari();
           
    }

    


    @Override
    public void tabloYenile() {
       dersSec();
        soru_turu_Sec();
       zorlukSec();
//        dersSec();
//        soru_turu_Sec();
//        zorlukSec();

        ArrayList<Sorular> sorular = new ArrayList<Sorular>();
        try {

            Statement st = (Statement) baglanti.createStatement();
            if (form.getTxt_Arama().getText().equals("")) {

                if ((detay.getDersSecimi() == null) && (detay.getZorlukSecimi() == null) && (detay.getSoruTurSecimi() == null)) {

                    res = st.executeQuery("select * from Sorular order by id ");

                } else if ((detay.getSoruTurSecimi() == null) && ((detay.getZorlukSecimi() == null))) {

                    res = st.executeQuery("select * from Sorular where ders_id LIKE '%"
                            + detay.getDersSecimi().trim() + "%'");


                } else if ((detay.getSoruTurSecimi() == null) && ((detay.getDersSecimi() == null))) {

                    res = st.executeQuery("select * from Sorular where zorluk_id LIKE '%"
                            + detay.getZorlukSecimi().trim() + "%'");

                } else if ((detay.getZorlukSecimi() == null) && ((detay.getDersSecimi() == null))) {

                    res = st.executeQuery("select * from Sorular where soru_tur_id LIKE '%"
                            + detay.getSoruTurSecimi().trim() + "%'");

                } else if ((detay.getDersSecimi() == null)) {

                    res = st.executeQuery("select * from Sorular where soru_tur_id LIKE '%"
                            + detay.getSoruTurSecimi().trim() + "%' AND zorluk_id LIKE '%"
                            + detay.getZorlukSecimi() + "%'");

                } else if ((detay.getZorlukSecimi() == null)) {

                    res = st.executeQuery("select * from Sorular where ders_id LIKE '%"
                            + detay.getDersSecimi().trim() + "%' AND soru_tur_id LIKE '%"
                            + detay.getSoruTurSecimi().trim() + "%'");

                } else if ((detay.getSoruTurSecimi() == null)) {

                    res = st.executeQuery("select * from Sorular where ders_id LIKE '%"
                            + detay.getDersSecimi().trim() + "%' AND zorluk_id LIKE '%"
                            + detay.getZorlukSecimi() + "%'");

                } else {

                    res = st.executeQuery("select * from Sorular where ders_id LIKE '%"
                            + detay.getDersSecimi().trim() + "%' AND soru_tur_id LIKE '%"
                            + detay.getSoruTurSecimi().trim() + "%' AND zorluk_id LIKE '%"
                            + detay.getZorlukSecimi() + "%'");

                }

            } else {
                res = st.executeQuery("select * from Sorular where Soru LIKE '%"
                        + form.getTxt_Arama().getText() + "%' OR cevaplar LIKE '%"
                        + form.getTxt_Arama().getText() + "%' OR dogru_cevap LIKE '%"
                        + form.getTxt_Arama().getText() + "%'");
//                dersSec();
//                soru_turu_Sec();
//                zorlukSec();
               dersSec();
        soru_turu_Sec();
        zorlukSec();
            }

            while (res.next()) {
               // Soru_Ekle soru = new Soru_Ekle();
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
            
          

            detay.setCevap(null);
           detay.setDogruCevap(null);
            detay.setCevapSayisi(0);
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
       if (form.getChb_Ders().isSelected()) {
            try {

                String sql = "Select * from Dersler where ders_adi='" + form.getCm_Ders().getSelectedItem().toString() + "'";
                Statement st = (Statement) baglanti.createStatement();
                res = st.executeQuery(sql);

                while (res.next()) {
                    detay.setDersSecimi(res.getString("id"));

                }

                res.close();
                st.close();
            } catch (Exception ex) {
                Logger.getLogger(Ana_Form.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
             detay.setDersSecimi(null);
        }
    
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
      if (form.getChb_Soru().isSelected()) {
            try {

                String sql = "Select * from Soru_Turu where Soru_Turu='" + form.getCm_Soru_Tip().getSelectedItem().toString() + "'";
                Statement st = (Statement) baglanti.createStatement();
                res = st.executeQuery(sql);

                while (res.next()) {
                    detay.setSoruTurSecimi(res.getString("id"));

                }

                res.close();
                st.close();
            } catch (Exception ex) {
                Logger.getLogger(Ana_Form.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
             detay.setSoruTurSecimi(null) ;
        }
    
    }

    @Override
    public void zorlukSec() {
        if (form.getChb_Zorluk().isSelected()) {
            try {

                String sql = "Select * from Zorluk where zorluk_derecesi='" + form.getCm_Zorluk_Tip().getSelectedItem().toString() + "'";
                Statement st = (Statement) baglanti.createStatement();
                res = st.executeQuery(sql);

                while (res.next()) {
                    detay.setZorlukSecimi(res.getString("id"));

                }

                res.close();
                st.close();
            } catch (Exception ex) {
                Logger.getLogger(Ana_Form.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            detay.setZorlukSecimi(null);
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
    
           
    public String getDersSecim() {
        return dersSecim;
    }

    public void setDersSecim(String dersSecim) {
        this.dersSecim = dersSecim;
    }

    public String getZorlukSecim() {
        return zorlukSecim;
    }

    public void setZorlukSecim(String zorlukSecim) {
        this.zorlukSecim = zorlukSecim;
    }

    public String getSoruTurSecim() {
        return soruTurSecim;
    }

    public void setSoruTurSecim(String soruTurSecim) {
        this.soruTurSecim = soruTurSecim;
    }
              
              
}
