package Model;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author User
 */
public class Islemler {

    private static Islemler form = new Islemler();
    
    public static Islemler yeniFormOlustur (){
        return form;
    }
    
    private Islemler() {
    }
   
    
    
    private   String secilenKayit;
    private   String id;
    private  String cevap;
    private  String dogruCevap;
    private  int cevapSayisi;
    private  String dersSecimi;
    private  String soruTurSecimi;
    private  String zorlukSecimi;



    public String getSecilenKayit() {
        return secilenKayit;
    }

    public void setSecilenKayit(String secilenKayit) {
        this.secilenKayit = secilenKayit;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

   
  

    public String getCevap() {
        return cevap;
    }

    public void setCevap(String cevap) {
        this.cevap = cevap;
    }

    public String getDogruCevap() {
        return dogruCevap;
    }

    public void setDogruCevap(String dogruCevap) {
        this.dogruCevap = dogruCevap;
    }

    public int getCevapSayisi() {
        return cevapSayisi;
    }

    public void setCevapSayisi(int cevapSayisi) {
        this.cevapSayisi = cevapSayisi;
    }

    public String getDersSecimi() {
        return dersSecimi;
    }

    public void setDersSecimi(String dersSecimi) {
        this.dersSecimi = dersSecimi;
    }

    public String getSoruTurSecimi() {
        return soruTurSecimi;
    }

    public void setSoruTurSecimi(String soruTurSecimi) {
        this.soruTurSecimi = soruTurSecimi;
    }

    public String getZorlukSecimi() {
        return zorlukSecimi;
    }

    public void setZorlukSecimi(String zorlukSecimi) {
        this.zorlukSecimi = zorlukSecimi;
    }

   
   
    
    
    

}
