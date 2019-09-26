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
public class KullaniciModeli {
    private  int id;
    private  String kAdi;
    private  String adi;
    private  String soyadi;
    private  String kTuru;
    private  String dTuru;
    private  String sifre;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getkAdi() {
        return kAdi;
    }

    public void setkAdi(String kAdi) {
        this.kAdi = kAdi;
    }

    public String getAdi() {
        return adi;
    }

    public void setAdi(String adi) {
        this.adi = adi;
    }

    public String getSoyadi() {
        return soyadi;
    }

    public void setSoyadi(String soyadi) {
        this.soyadi = soyadi;
    }

    public String getkTuru() {
        return kTuru;
    }

    public void setkTuru(String kTuru) {
        this.kTuru = kTuru;
    }

    public String getdTuru() {
        return dTuru;
    }

    public void setdTuru(String dTuru) {
        this.dTuru = dTuru;
    }

    public String getSifre() {
        return sifre;
    }

    public void setSifre(String sifre) {
        this.sifre = sifre;
    }

}
