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
public abstract class DbAbstraction {
    public abstract void Exec(String Sql);
    public abstract void ConOpen(String ConStr);
    
    
     protected DbImplementor implementor;

    public DbAbstraction(DbImplementor implementor) {
        this.implementor = implementor;
    }

    public DbImplementor getImplementor() {
        return implementor;
    }

    public void setImplementor(DbImplementor implementor) {
        this.implementor = implementor;
    }
    
    
}
