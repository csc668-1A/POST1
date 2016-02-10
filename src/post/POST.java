/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package post;

import Actor.Customer;
import Actor.Manager;

/**
 *
 * @author ninjung
 */
public class POST {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        /*Open Store*/
        Manager manager = new Manager("Jason","helloworld");
        Store store = new Store();
        
        /*Manager login to open the store*/
        if(store.verifyLogin(manager.getUsername(), manager.getPassword()).equals(true)){
            System.out.println("Store is opened");
            
            manager.manageCatalog(); //Manage Product Catalog
        
            /*Customer make purchase*/
            Customer customer = new Customer("Robert Alameda");
            Sale sale = customer.saleBuilder();
            System.out.println("-----Display SaledItem ------");
            System.out.println("Total Amount: "+sale.getAmount());
            sale.showItem();
        }else{
            System.out.println("Invalid Username or Password");
        }
    }
    
    
    
}
