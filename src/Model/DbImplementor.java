package Model;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.sql.Connection;

/**
 *
 * @author User
 */
public abstract class DbImplementor {
       public abstract void Execute(String Sql);
      public  abstract Connection OpenCon(String SqlCon);
}
