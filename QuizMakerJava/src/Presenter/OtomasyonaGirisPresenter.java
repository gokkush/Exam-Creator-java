/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presenter;


import Model.*;
import Model.Kullanici;
import View.Ana_Form;


import View.Ders_Guncelle_Form;
import View.IViewOtomasyonaGiris;
import View.Otomasyona_Giris_Form;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import soruhazirlama.progressP;
import soruhazirlama.progressP2;

/**
 *
 * @author User
 */
public class OtomasyonaGirisPresenter {
   
    private IViewOtomasyonaGiris view;
  
    private Otomasyona_Giris_Form girisfrm = Otomasyona_Giris_Form.yeniFormOlustur();
  
    private Connection baglanti;
    DbAbstraction abs = new DbRefinedAbstraction(new SqlLiteImplementor());
    
   Statement st=null;
   ResultSet res;
          
            
    public OtomasyonaGirisPresenter(IViewOtomasyonaGiris view) {
        this.view = view;
        
        baglanti = abs.getImplementor().OpenCon(" Otomasyona Giriş Presenter");
        
    }
    
     public void GirisYap(){
         
          
          Kullanici kullanici = new Kullanici();
          
       
          if ((girisfrm.getTxt_Kadi().getText()).equals("")||(girisfrm.getTxt_Sifre().getText()).equals(""))
           view.GirisIslemi("Kullanıcı adı veya parola boş bırakılmamalı!!!");
          
          else {
                 try{
                     
                   
        st = baglanti.createStatement();
        res = st.executeQuery("Select * from Kullanici where k_adi='"+girisfrm.getTxt_Kadi().getText()+"' and sifre='"+String.valueOf(girisfrm.getTxt_Sifre().getText())+"'");
                  
        int id2 = -1;
        String  kadi=null;
        String sifre=null;
        String adi=null;
        String soyadi=null;
        String k_turu=null;
        String d_turu=null;
        
            while (res.next()){
                      
               id2=res.getInt("id");
                kadi=res.getString("k_adi");
                sifre=res.getString("sifre"); 
                adi=res.getString("Adi"); 
                soyadi=res.getString("Soyadi"); 
                k_turu=res.getString("k_turu"); 
                d_turu=res.getString("d_turu"); 
                        
                
            }
        
                
             if ((girisfrm.getTxt_Kadi().getText().equals(kadi))&&(girisfrm.getTxt_Sifre().getText().equals(sifre))){
                    //view.GirisIslemi("Kullanıcı adı ve parola doğru...");
        
                    kullanici.setId(id2);
                    kullanici.setkAdi(kadi);
                    kullanici.setAdi(adi);
                    kullanici.setSoyadi(soyadi);
                    kullanici.setkTuru(k_turu);
                    kullanici.setdTuru(d_turu);
                    kullanici.setSifre(sifre);
       
        
                   
                    
            
                //   new Ders_Guncelle_Form(); 
                   
                   view.Gir();
                     new progressP().setVisible(true);
                   
              
 
                    //  new progressP().setVisible(true);
                    baglanti.close();
      
       
                    }
                
                else
                    view.GirisIslemi("Kullanıcı adı veya parola yanlış!!!");
                    girisfrm.getTxt_Kadi().setText(null);
                    girisfrm.getTxt_Sifre().setText(null);   
                    girisfrm.getTxt_Kadi().requestFocus();
    } 
    catch (Exception ex) {
        Logger.getLogger(Otomasyona_Giris_Form.class.getName()).log(Level.SEVERE, null, ex);
    }
    
     }
    
        
  
             
     
    }
}
