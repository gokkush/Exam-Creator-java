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
public  class Kullanici {
    
    private  static int id;
    private static  String kAdi;
    private static  String adi;
    private static String soyadi;
    private static String kTuru;
    private  static String dTuru;
    private static String sifre;

    public static int getId() {
        return id;
    }

    public static void setId(int id) {
        Kullanici.id = id;
    }

    public static String getkAdi() {
        return kAdi;
    }

    public static void setkAdi(String kAdi) {
        Kullanici.kAdi = kAdi;
    }

    public static String getAdi() {
        return adi;
    }

    public static void setAdi(String adi) {
        Kullanici.adi = adi;
    }

    public static String getSoyadi() {
        return soyadi;
    }

    public static void setSoyadi(String soyadi) {
        Kullanici.soyadi = soyadi;
    }

    public static String getkTuru() {
        return kTuru;
    }

    public static void setkTuru(String kTuru) {
        Kullanici.kTuru = kTuru;
    }

    public static String getdTuru() {
        return dTuru;
    }

    public static void setdTuru(String dTuru) {
        Kullanici.dTuru = dTuru;
    }

    public static String getSifre() {
        return sifre;
    }

    public static void setSifre(String sifre) {
        Kullanici.sifre = sifre;
    }

   
   

  
    
}
