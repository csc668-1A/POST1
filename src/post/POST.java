/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package post;

import Actor.Customer;
import Actor.Manager;
import Model.ProductCatalog;
import java.io.IOException;

/**
 * Class for a point of sale terminal (POST). Current POST main method goes through
 * opening a store, creating a product catalog, building sales, and running payments.
 */
public class POST {

    /**
     * Main method; currently goes through opening a store, creating a product catalog,
     * building sales, and running payments.
     * @param args Command line arguments (not utilized)
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        
        /*Open Store*/
        Manager manager = new Manager("Jason","helloworld");
        Store store = new Store();
        
        /*Manager login to open the store*/
        if(store.verifyLogin(manager.getUsername(), manager.getPassword()).equals(true)){
            System.out.println("Store is opened");// valid username and password
            
            ProductCatalog catalog=manager.manageCatalog(); //Manage Product Catalog
            manager.addNewItemtoCatalog();
            /*Customer make purchase*/
            Customer customer = new Customer("Robert Alameda");
            Sale sale = customer.saleBuilder(catalog);
            System.out.println("-----Display Saled Item ------");
            sale.showItem();
            System.out.println("Total Amount: "+sale.getAmount());
            
            /*Customer make payment*/
            customer.MakePurchase("cash", 100.00, null); // Cash Payment
            //customer.MakePurchase("credit", sale.getAmount(),"4400 5620 4134 1820"); // Credit Payment
            
            /*Record Sale and Print Invoice*/
            SalesLog log = new SalesLog();
            log.addNewSale(sale, store);
        }else{
            System.out.println("Invalid Username or Password"); //incorrect username or password
        }
    }
    
    
    
}
