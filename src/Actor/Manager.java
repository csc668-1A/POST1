/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Actor;

import Model.ProductCatalog;
import Model.ProductItem;
import Model.iFileDirectory;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import post.Store;

/**
 * Actor class for a manager of a store. A customer can open a store and both manage and add
 * items to a store's product catalog. Class includes getter methods for username and password.
 */
public class Manager {
    private String username;
    private String password;
    Store store = new Store();
    public Manager(String username, String password){
        this.username = username;
        this.password = password;
    }
    
    /**
     * Opens a new store upon verifying current manager's username and password.
     * @return Boolean value for manager's login; "true" on success, "false" on failure
     */
    public boolean Openstore(){
        store = new Store();
        boolean isLogin = store.verifyLogin(this.getUsername(), this.getPassword());
        return isLogin;
    }
    
    /**
     * Allows a manager to manage a store's product catalog. In its current state, items are added
     * via methods and file I/O.
     * @return Modified product catalog for a store
     * @throws FileNotFoundException
     */
    public ProductCatalog manageCatalog() throws FileNotFoundException{
        store = new Store();
        ProductCatalog catalog = store.getProductCatalog();//get Store Catalog
        
        /*Enter ProductItems to the Catalog*/
        List<ProductItem> addedItems =  new ArrayList<ProductItem>();
        ProductItem addItem = new ProductItem(1001, "Pencil", 5.50);
        addedItems.add(addItem);
        addItem = new ProductItem(1002, "Pen", 4.50);
        addedItems.add(addItem);
        addItem = new ProductItem(1003, "Rubber", 3.00);
        addedItems.add(addItem);
        addItem = new ProductItem(1004, "Notebook", 4.00);
        addedItems.add(addItem);
        addItem = new ProductItem(1005, "Paper", 1.00);
        addedItems.add(addItem);
        catalog.productWriter(addedItems); //write productItems into products.txt
        
        /*read products.txt file*/
        BufferedReader in = null;
        try {
            in = new BufferedReader(new FileReader(iFileDirectory.PRODUCTSFILEDIR));//retrieve file from directory
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        String tempString;
        catalog.deleteAllItem();
        /*read productItems from product.txt file and add to items to store catalog*/
        try {
            while  ((tempString = in.readLine()) != null){
                ProductItem item = new ProductItem(Integer.parseInt((tempString.substring(0, 4)))
                        , tempString.substring(9, 29), Float.parseFloat(tempString.substring(34)));
                catalog.addItem(item);
            }
        } catch (IOException ex) {
            Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        System.out.println("-------Display Catalog-------");
        catalog.showitem();//display productItems from Store Catalog
        return catalog;
    }
    
    /**
     * Allows items to be added to a store's product catalog. In its current state,
     * items are added via methods and file I/O.
     * @return Modified product catalog for a store
     * @throws FileNotFoundException
     */
    public ProductCatalog addNewItemtoCatalog() throws FileNotFoundException{
        store = new Store();
        ProductCatalog catalog = store.getProductCatalog();//get Store Catalog
        
        /*Enter ProductItems to the Catalog*/
        List<ProductItem> addedItems =  new ArrayList<ProductItem>();
        ProductItem addItem = new ProductItem(1006, "Folder", 3.50);
        addedItems.add(addItem);
        addItem = new ProductItem(1007, "Textbook", 25.00);
        addedItems.add(addItem);
        catalog.productAppending(addedItems); //write new productItems into products.txt
        
        /*read products.txt file*/
        BufferedReader in = null;
        try {
            in = new BufferedReader(new FileReader(iFileDirectory.PRODUCTSFILEDIR));//retrieve file from directory
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        String tempString;
        catalog.deleteAllItem();
        /*read productItems from product.txt file and add to items to store catalog*/
        try {
            while  ((tempString = in.readLine()) != null){
                ProductItem item = new ProductItem(Integer.parseInt((tempString.substring(0, 4)))
                        , tempString.substring(9, 29), Float.parseFloat(tempString.substring(34)));
                catalog.addItem(item);
            }
        } catch (IOException ex) {
            Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        System.out.println("-------Display Catalog-------");
        catalog.showitem();//display productItems from Store Catalog
        return catalog;
    }
    /**
     * Retrieves current manager's username.
     * @return Username of the current manager
     */
    public String getUsername() {
        return username;
    }

    /**
     * Retrieves current manager's password.
     * @return Password of the current manager
     */
    public String getPassword() {
        return password;
    }
    
    
}
