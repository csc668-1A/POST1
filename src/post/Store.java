/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package post;

import Model.ProductCatalog;

/**
 * Class for store which utilizes the POST. Class can verify manager logins and manage store info.
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
    
    /**
     * Constructor method; creates instance of Store object.
     */
    public Store(){
        this.sname = STORENAME;
        this.saddress = STOREADDRESS;
    }
    
    /**
     * Verifies username and password of a store manager.
     * @param username Username of the manager
     * @param password Password of the manager
     * @return Boolean value for verification; "true" on success, "false" on failure
     */
    public Boolean verifyLogin(String username, String password){
        if((username.equals(USERLOGIN)) && username.equals(USERLOGIN)){
            return true;
        }
        else{
            return false;
        }
    }
    
    /**
     * Retrieves product catalog of the store.
     * @return Product catalog of the store
     */
    public ProductCatalog getProductCatalog(){
        return ProductCatalog.getInstance();
    }

    /**
     * Retrieves the name of the store.
     * @return Store name
     */
    public String getSname() {
        return sname;
    }

    /**
     * Sets the name of the store to name passed as a parameter.
     * @param sname New store name
     */
    public void setSname(String sname) {
        this.sname = sname;
    }

    /**
     * Retrieves the street address of the store.
     * @return Store street address
     */
    public String getSaddress() {
        return saddress;
    }

    /**
     * Sets the street address of the store to new address passed as a parameter.
     * @param saddress New store address
     */
    public void setSaddress(String saddress) {
        this.saddress = saddress;
    }
}
