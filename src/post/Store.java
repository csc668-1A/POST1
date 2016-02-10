/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package post;

import Model.ProductCatalog;

/**
 *
 * @author ninjung
 */
public class Store {
    public final static String USERLOGIN = "Jason";
    public final static String PASSLOGIN = "helloworld";
    String managerUsername;
    String managerPassword;
    
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
}
