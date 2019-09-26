/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presenter;

import Model.DbAbstraction;
import Model.DbRefinedAbstraction;
import Model.Kullanici;
import Model.KullaniciSifreDegistirebilme;
import Model.SqlLiteImplementor;
import View.IViewSifre;
import View.Sifre_Form;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class SifreDegistirPresenter implements KullaniciSifreDegistirebilme{
   private Connection baglanti;
    private Statement st=null;
    private ResultSet res;
    private DbAbstraction abs = new DbRefinedAbstraction(new SqlLiteImplementor());
    private IViewSifre view;
    private Sifre_Form form = Sifre_Form.yeniFormOlustur();
     private Kullanici kullanici;
     private int kul_id;
     
    public SifreDegistirPresenter(IViewSifre view) {
        this.view = view;
         baglanti = abs.getImplementor().OpenCon(" Şifre Değiştir Presenter");
    }
   
    @Override
    public void SifreDegistir() {
        kul_id = kullanici.getId();
       if(form.getTxt_Sifre_Mevcut().getText().equals(kullanici.getSifre())){
        
    
        if(form.getTxt_Sifre().getText().equals(form.getTxt_Sifre_Tekrar().getText())){
            try {
                    st=(Statement) baglanti.createStatement();
        st.executeUpdate("update Kullanici set sifre='"+form.getTxt_Sifre().getText()+"'where id='"+kul_id+"'");
        kullanici.setSifre(form.getTxt_Sifre().getText());
        st.close();
        view.Mesaj("Şifreniz başarıyla Değiştirildi.", "İşlem Başarılı", null);
        
    } catch (Exception e) {
        JOptionPane.showConfirmDialog(null, "BİLİNMEYEN HATA");
    }
        }
        else{
            
         
        Yenile();
        }
        
    }
    else{
     view.Mesaj("Eski şifreniz uyuşmuyor.", "UYARI", null);        
  
    Yenile();
}
    }

    @Override
    public void Yenile() {
       
      form.getTxt_Sifre().setText(null);
        form.getTxt_Sifre_Tekrar().setText(null);
        form.getTxt_Sifre_Mevcut().setText(null);
        form.getTxt_Sifre_Mevcut().requestFocus(); 
    }

    

 
    
}
