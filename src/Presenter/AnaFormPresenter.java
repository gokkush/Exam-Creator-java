/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presenter;

import Model.DbAbstraction;
import Model.DbRefinedAbstraction;
import Model.Kullanici;
import Model.SqlLiteImplementor;
import View.Ana_Form;
import View.IViewAnaForm;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author User
 */
public class AnaFormPresenter {
    private IViewAnaForm view;
    private Connection baglanti;
    private Statement st=null;
    private ResultSet res;
    private DbAbstraction abs = new DbRefinedAbstraction(new SqlLiteImplementor());
    private Ana_Form anaForm=Ana_Form.yeniFormOlustur();
    private Kullanici k;
    public AnaFormPresenter(IViewAnaForm view) {
        this.view = view;
        baglanti = abs.getImplementor().OpenCon(" Ana Form Presenter");
        k=new Kullanici();
    }
    
    public void FormGirisi(){
          if(k.getkTuru().equals("Admin")){
             
           
        }
        else if(k.getkTuru().equals("Öğrenci")){
            anaForm.getTabbed_Menu().remove(0);
            anaForm.getTabbed_Menu().remove(0);
            anaForm.getTabbed_Menu().remove(0);

        }
        else if(k.getkTuru().equals("Öğretim Üyesi")){
            anaForm.getTabbed_Menu().remove(0);
            anaForm.getTabbed_Menu().remove(2);

        }
        
       
    }
    
    
    
    
    
}
