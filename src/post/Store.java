/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package post;

import Model.ProductCatalog;
import Actor.*;
import java.rmi.server.UnicastRemoteObject;
import java.rmi.*;
import javax.swing.*;
import java.io.*;
import java.rmi.registry.LocateRegistry;
/**
 *
 * @author ninjung
 */
public class Store extends UnicastRemoteObject implements iRMI{
    protected static String          m_strName;

    public final static String USERLOGIN = "Jason";
    public final static String PASSLOGIN = "helloworld";
    String managerUsername;
    String managerPassword;


    public  Store() throws RemoteException{super();}
    
    public Boolean verifyLogin(String username, String password){
        if((username.equals(USERLOGIN)) && username.equals(USERLOGIN)){
            return true;
        }
        else{
            return false;
        }
    }
    
    public ProductCatalog getProductCatalog(){
        return ProductCatalog.getInstance();
    }
    public void print(){
      
        POST a = new POST();
    
        
    }
    public static void main(String args[]){
        
        //POST a = new POST();
        try
        {
            LocateRegistry.createRegistry(1099);
            m_strName = "rmi://localhost:1099/TheRMIExample";
            System.out.println("Server: Registering RMIExampleImpl as \"" + m_strName +"\"");
            Store Example = new Store();
            Naming.rebind(m_strName, Example);
            System.out.println("Server: Ready...");
        }
        catch (Exception e)
        {
            System.out.println("Server: Failed to register RMIExampleImpl: " + e);
        }

    }
}
