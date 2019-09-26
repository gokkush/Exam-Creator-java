/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import View.IViewSinavOlustur;
import View.Sinav_Olustur_Form;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author User
 */
public class Z_OrtaSoru implements ZorlukDegeri{
  private Connection baglanti;
    private Statement st=null;
    private ResultSet res;
    private DbAbstraction abs ;
    private Sinav_Olustur_Form form ;
    private IViewSinavOlustur view;
    private ArrayList<Sinav_Sorulari> soru_id;
    private ArrayList<Sorular> sorular;
    private ZorlukHazirla zorlukHazirla;
         private SinavIslemleri detay;
        ArrayList<Sorular> kolaySorularList = new ArrayList<Sorular>();
     ArrayList<Sorular> ortaSorularList = new ArrayList<Sorular>();
      ArrayList<Sorular> zorSorularList = new ArrayList<Sorular>();
           ArrayList<Sorular> uret = new ArrayList<Sorular>();
              int sayi1,sayi2,sayi3;
      int alinan_id1,alinan_id2,alinan_id3
              ;

    public Z_OrtaSoru() {
          abs = new DbRefinedAbstraction(new SqlLiteImplementor());
          baglanti = abs.getImplementor().OpenCon(" z_OrtaSoru Presenter");
         form = Sinav_Olustur_Form.yeniFormOlustur();
           soru_id = new ArrayList<Sinav_Sorulari>();
         sorular = new ArrayList<Sorular>();
       detay= new SinavIslemleri();
         ZorlukDegeri();
    }

      
      
    @Override
    public void ZorlukDegeri() {
          if(form.getCm_Zorluk_Tip().getSelectedItem().equals("ORTA")){
           
        Random rnd= new Random();
        DefaultTableModel tModel = (DefaultTableModel) form.getTablo_Random_Soru().getModel();
        tModel.setRowCount(0);
        int toplamSoru =Integer.parseInt(form.getTxt_Soru_Sayisi().getText()) ;
      
        
           int k1 = (int) (toplamSoru *0.3);
           int k2 = (int) (toplamSoru *0.5);
           int k3 = (int) (toplamSoru *0.2);
           
           
           try {
               
            Statement st = (Statement) baglanti.createStatement();
                
            res = st.executeQuery("select * from Sorular where ders_id LIKE '%"
                            + detay.getDersSecimi() + "%'");
               
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
                            System.out.println("zorluk: "+ res.getInt("zorluk_id"));    
                            if(res.getInt("zorluk_id")==2)
                           kolaySorularList.add(soru);
                           
                           else if(res.getInt("zorluk_id")==5)
                           ortaSorularList.add(soru);
                           
                            else if(res.getInt("zorluk_id")==6)
                           zorSorularList.add(soru);
                            
                    }
            
             
                    uret.clear();
               for (int i = 0; i < k1; i++) {
                    Sorular soru = new Sorular();
                     sayi1 =rnd.nextInt(kolaySorularList.size());
                     
                     soru.setAlinan_id1(kolaySorularList.get(sayi1).getId());
                    soru.setSoru(kolaySorularList.get(sayi1).getSoru());
                    soru.setCevap(kolaySorularList.get(sayi1).getCevap());
                     uret.add(soru);
                     
               }
               for (int i = 0; i < k2; i++) {
                    Sorular soru = new Sorular();
                     sayi2 =rnd.nextInt(ortaSorularList.size());
                     soru.setAlinan_id1(ortaSorularList.get(sayi2).getId());
                     soru.setSoru(ortaSorularList.get(sayi2).getSoru());
                    soru.setCevap(ortaSorularList.get(sayi2).getCevap());
                     uret.add(soru);
                     
               }
               
               for (int i = 0; i < k3; i++) {
                    Sorular soru = new Sorular();
                     sayi3 =rnd.nextInt(zorSorularList.size());
                    soru.setAlinan_id1(zorSorularList.get(sayi3).getId());
                     soru.setSoru(zorSorularList.get(sayi3).getSoru());
                    soru.setCevap(zorSorularList.get(sayi3).getCevap());
                     uret.add(soru);
               }
  
                    
            
                  
            
                    Object[] satir = new Object[3];
                  tModel.setRowCount(0);
        for (int j = 0; j < uret.size(); j++) {
           
                 satir[0] = uret.get(j).getAlinan_id1();
            satir[1] = uret.get(j).getSoru();
            satir[2] = uret.get(j).getCevap();
            tModel.addRow(satir);
            
        
        }
           
       
        
        form.getTablo_Random_Soru().setModel(tModel);
                    
                
              
                       
               
               res.close();
               st.close();
           } catch (Exception e) {
           }
       
       }
    
    
    }
    
}
