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
 * Actor class for a customer of a store. Customer can create invoice with saleBuilder() and make purchases with MakePurchase().
 */
public class Customer {
    private String name;
    Sale sale;
    
    /**
     * Constructor method. Creates customer with a name passed as a parameter in the function call.
     * @param name Name of new customer.
     */
    public Customer(String name){
        this.name = name;
    }
    
    /**
     * Builds an invoice for a customer. Products added are checked with the passed ProductCatalog object.
     * @param catalog ProductCatalog object for a store. Includes UPCs and associated product descriptions and prices.
     * @return Sale object built from products added from catalog by builder.
     */
    public Sale saleBuilder(ProductCatalog catalog){
        sale = new Sale(getName()); // insert customer name
        
        /* Customer Enter Item the System*/
        ProductItem item = catalog.getItemByUPC(1004);
        SaledItem saledItem = new SaledItem(item,2);
        sale.enterItem(saledItem);
        ProductItem item2 = catalog.getItemByUPC(1001);
        SaledItem saledItem2 = new SaledItem(item2,2);
        sale.enterItem(saledItem2);
        ProductItem item3 = catalog.getItemByUPC(1005);
        SaledItem saledItem3 = new SaledItem(item3,1);
        sale.enterItem(saledItem3);
        
        return sale;
    }
    
    /**
     * Makes purchase on a sale for a customer. 
     * @param paymentType String containing payment type: "cash" for cash transaction; "card" for card transaction.
     * @param paymentAmount The amount to be paid; generally the balance of the current sale.
     * @param cardNo 16-digit number of credit card number. If paymentType is "cash", NULL can be passed.
     */
    public void MakePurchase(String paymentType, double paymentAmount, String cardNo){
        sale.makePayment(paymentType,paymentAmount,sale.getAmount(),cardNo);
    }

    /**
     * Getter method; retrieves name of a customer.
     * @return String containing name of customer.
     */
    public String getName() {
        return name;
    }

    /**
     * Setter method; sets name of a customer to name passed as parameter.
     * @param name String containing new name of customer.
     */
    public void setName(String name) {
        this.name = name;
    }
    
}
