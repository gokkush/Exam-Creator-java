package Model;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author User
 */
public  class Sorular {
   private int  alinan_id1;
   private int id;
    private String soru;
    private String cevap;
    private String dogru_cevap;
    private int cevap_sayisi;    
    private int ders_id;
    private int zorluk_id;
    private float soru_puan;
    private int soru_tur_id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSoru() {
        return soru;
    }

    public void setSoru(String soru) {
        this.soru = soru;
    }

    public String getCevap() {
        return cevap;
    }

    public void setCevap(String cevap) {
        this.cevap = cevap;
    }

    public String getDogru_cevap() {
        return dogru_cevap;
    }

    public void setDogru_cevap(String dogru_cevap) {
        this.dogru_cevap = dogru_cevap;
    }

    public int getCevap_sayisi() {
        return cevap_sayisi;
    }

    public void setCevap_sayisi(int cevap_sayisi) {
        this.cevap_sayisi = cevap_sayisi;
    }

    public int getDers_id() {
        return ders_id;
    }

    public void setDers_id(int ders_id) {
        this.ders_id = ders_id;
    }

    public int getZorluk_id() {
        return zorluk_id;
    }

    public void setZorluk_id(int zorluk_id) {
        this.zorluk_id = zorluk_id;
    }

    public float getSoru_puan() {
        return soru_puan;
    }

    public void setSoru_puan(float soru_puan) {
        this.soru_puan = soru_puan;
    }

    public int getSoru_tur_id() {
        return soru_tur_id;
    }

    public void setSoru_tur_id(int soru_tur_id) {
        this.soru_tur_id = soru_tur_id;
    }

    public int getAlinan_id1() {
        return alinan_id1;
    }

    public void setAlinan_id1(int alinan_id1) {
        this.alinan_id1 = alinan_id1;
    }
    
    
    
}
