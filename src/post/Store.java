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
    public final static String STORENAME = "SFSU Store";
    public final static String STOREADDRESS = "1600 Holloway Ave, San Francisco";
    private String sname;
    private String saddress;
    String managerUsername;
    String managerPassword;
    
    public Store(){
        this.sname = STORENAME;
        this.saddress = STOREADDRESS;
    }
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

    /**
     * @return the sname
     */
    public String getSname() {
        return sname;
    }

    /**
     * @param sname the sname to set
     */
    public void setSname(String sname) {
        this.sname = sname;
    }

    /**
     * @return the saddress
     */
    public String getSaddress() {
        return saddress;
    }

    /**
     * @param saddress the saddress to set
     */
    public void setSaddress(String saddress) {
        this.saddress = saddress;
    }
}
