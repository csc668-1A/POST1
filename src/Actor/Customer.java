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
