/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Actor;

import Model.ProductCatalog;
import Model.ProductItem;
import Model.SaledItem;
import post.Sale;

/**
 * Actor class for a customer of a store. A customer can create a sale and
 * purchase a sale. Class includes getter/setter methods for a customer's name.
 */
public class Customer {
    private String name;
    Sale sale;
    public Customer(String name){
        this.name = name;
    }
    
    /**
     * Creates a sale for the current customer.
     * Items can be added by checking their UPCs with a store's product catalog.
     * @param catalog Product catalog for a store
     * @return Sale object containing items to be purchased by the customer
     */
    public Sale saleBuilder(ProductCatalog catalog){
        sale = new Sale(getName()); // insert customer name
        int upc= 0;
        ProductItem item = new ProductItem();
        
        /* Customer Enter Item the System*/
        upc = 1002;
        item = catalog.getItemByUPC(upc);
        if(item.getUpc()>0){ // check UPC is existed
            SaledItem saledItem2 = new SaledItem(item,4);
            sale.enterItem(saledItem2);
        }else{
            System.err.println("Incorrect UPC :"+upc);
        }
        
        upc = 1004;
        item = catalog.getItemByUPC(upc);
        if(item.getUpc()>0){ // check UPC is existed
            SaledItem saledItem2 = new SaledItem(item,4);
            sale.enterItem(saledItem2);
        }else{
            System.err.println("Incorrect UPC :"+upc);
        }
        
        upc = 1007;
        item = catalog.getItemByUPC(upc);
        if(item.getUpc()>0){ // check UPC is existed
            SaledItem saledItem3 = new SaledItem(item,1);
            sale.enterItem(saledItem3);
        }else{
            System.err.println("Incorrect UPC :"+upc);
        }
        return sale;
    }
    
    /**
     * Allows current customer to purchase items in the current sale.
     * @param paymentType String containing payment type; "cash" for cash transaction, "card" for credit card transaction
     * @param paymentAmount Amount to be paid; usually same amount as balance on current sale
     * @param cardNo String containing a 16-digit credit card number
     */
    public void MakePurchase(String paymentType, double paymentAmount, String cardNo){
        sale.makePayment(paymentType,paymentAmount,sale.getAmount(),cardNo);
    }

    /**
     * Retrieves current customer's name.
     * @return Name of the current customer
     */
    public String getName() {
        return name;
    }

    /**
     * Sets current customer's name to the name passed as a parameter in the method call.
     * @param name New name for the current customer
     */
    public void setName(String name) {
        this.name = name;
    }
    
}
