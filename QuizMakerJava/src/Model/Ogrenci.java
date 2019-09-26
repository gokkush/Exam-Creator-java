package Model;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author AB107107
 */
public class Ogrenci {
    
    private String ogrenci_No;
    private String ogrenci_Adi;
    private String ogrenci_Soyadi;

    public String getOgrenci_No() {
        return ogrenci_No;
    }

    public void setOgrenci_No(String ogrenci_No) {
        this.ogrenci_No = ogrenci_No;
    }





    public String getOgrenci_Adi() {
        return ogrenci_Adi;
    }

    public void setOgrenci_Adi(String ogrenci_Adi) {
        this.ogrenci_Adi = ogrenci_Adi;
    }

    public String getOgrenci_Soyadi() {
        return ogrenci_Soyadi;
    }

    public void setOgrenci_Soyadi(String ogrenci_Soyadi) {
        this.ogrenci_Soyadi = ogrenci_Soyadi;
    }

    public Ogrenci(String ogrenci_No, String ogrenci_Adi, String ogrenci_Soyadi) {
        this.ogrenci_No = ogrenci_No;
        this.ogrenci_Adi = ogrenci_Adi;
        this.ogrenci_Soyadi = ogrenci_Soyadi;
    }

    public Ogrenci() {
    }
    
    
    
}
