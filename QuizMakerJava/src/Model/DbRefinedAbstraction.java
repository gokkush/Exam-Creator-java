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
public class DbRefinedAbstraction extends DbAbstraction {

   
    
    public  DbRefinedAbstraction(DbImplementor implementor) {
        super(implementor);
    }

    @Override
    public void Exec(String Sql) {
       
       implementor.Execute(Sql);
    }

    @Override
    public void ConOpen(String ConStr) {
           implementor.OpenCon(ConStr);
    
    }
    
}
