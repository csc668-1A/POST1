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
 *
 * @author ninjung
 */
public class Customer {
    private String name;
    Sale sale;
    public Customer(String name){
        this.name = name;
    }
    
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
    
    public void MakePurchase(String paymentType, double paymentAmount, String cardNo){
        sale.makePayment(paymentType,paymentAmount,sale.getAmount(),cardNo);
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }
    
}
