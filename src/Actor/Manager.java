/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Actor;

import Model.ProductCatalog;
import Model.ProductItem;
import post.Store;
import java.rmi.server.UnicastRemoteObject;
import java.rmi.*;
import post.iRMI;
/**
 *
 * @author ninjung
 */
public class Manager{
    private String username;
    private String password;
    Store store;
    public Manager(String username, String password){
        this.username = username;
        this.password = password;
    }
    
    public boolean Openstore(){
        try{
        store = new Store();
        }catch(RemoteException e){
        }
        boolean isLogin = store.verifyLogin(this.getUsername(), this.getPassword());
        return isLogin;
    }
    
    public ProductCatalog manageCatalog(){
        try{
            store = new Store();
        }catch(RemoteException e){
        }
        ProductCatalog catalog = store.getProductCatalog();
        ProductItem item = new ProductItem(1001, "pencil", 5.50);
        catalog.addItem(item);
        item = new ProductItem(1002, "pen", 4.50);
        catalog.addItem(item);
        item = new ProductItem(1003, "Rubber", 3.00);
        catalog.addItem(item);
        item = new ProductItem(1004, "Notebook", 4.00);
        catalog.addItem(item);
        System.out.println("-------Display Catalog-------");
        catalog.showitem();
        
        //System.out.println("-------Display Catalog-------");
        //catalog.deleteItem(1004);
        //catalog.showitem();
        return catalog;

    }
    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }
    
    
}
