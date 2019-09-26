package Model;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class SqlLiteImplementor extends DbImplementor {

    private static Connection baglan=null;
    
    private static String yol = "jdbc:sqlite";//veritabanının adresi ve portu
    private static String dbAdi = ":db/SoruHazirlama.db"; //veritabanının dosya yolu
    private static String surucu = "org.sqlite.JDBC";


    @Override
    public void Execute(String Sql) {
     
        System.out.println("SqlLİte Çalıştı" + Sql);
    
    }

public void dene(){
    
}

    public  Connection OpenCon(String SqlCon) {
       try {
            Class.forName(surucu).newInstance();
            baglan=DriverManager.getConnection(yol+dbAdi);
           // JOptionPane.showMessageDialog(null, "Başarıyla Bağlandı");
             //System.out.println("SqlLİte Çalıştı" + SqlCon);
            return baglan;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
    
    }

    
}
