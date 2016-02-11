/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Actor;

import Model.ProductCatalog;
import Model.ProductItem;
import post.Store;

/**
 * Actor class for a manager of a store. Manager can open store with Openstore() and manage a product catalog with manageCatalog().
 */
public class Manager {
    private String username;
    private String password;
    Store store = new Store();
    
    /**
     * Constructor method. Creates manager with name and password passed as parameters in the function call.
     * @param username Name of new manager.
     * @param password Password of new manager.
     */
    public Manager(String username, String password){
        this.username = username;
        this.password = password;
    }
    
    /**
     * Creates/opens a store for a manager.
     * @return Boolean verifying login of manager. True on success; false on failure.
     */
    public boolean Openstore(){
        store = new Store();
        boolean isLogin = store.verifyLogin(this.getUsername(), this.getPassword());
        return isLogin;
    }
    
    /**
     * Allows manager to add and retrieve the product catalog of a store.
     * @return The product catalog of a store.
     */
    public ProductCatalog manageCatalog(){
        store = new Store();
        ProductCatalog catalog = store.getProductCatalog();
        ProductItem item = new ProductItem(1001, "Pencil", 5.50);
        catalog.addItem(item);
        item = new ProductItem(1002, "Pen", 4.50);
        catalog.addItem(item);
        item = new ProductItem(1003, "Rubber", 3.00);
        catalog.addItem(item);
        item = new ProductItem(1004, "Notebook", 4.00);
        catalog.addItem(item);
        item = new ProductItem(1005, "Paper", 1.00);
        catalog.addItem(item);
        System.out.println("-------Display Catalog-------");
        catalog.showitem();
        
        //System.out.println("-------Display Catalog-------");
        //catalog.deleteItem(1004);
        //catalog.showitem();
        return catalog;
    }
    /**
     * Getter method; retrieves username of a manager.
     * @return The username of a manager.
     */
    public String getUsername() {
        return username;
    }

    /**
     * Getter method; retrieves password of a manager.
     * @return The password of a manager.
     */
    public String getPassword() {
        return password;
    }
    
    
}
