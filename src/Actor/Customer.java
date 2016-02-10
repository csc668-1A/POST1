/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Actor;

import Model.ProductItem;
import Model.SaledItem;
import post.Sale;

/**
 *
 * @author ninjung
 */
public class Customer {
    String name;
    
    public Customer(String name){
        this.name = name;
    }
    
    public Sale saleBuilder(){
        Sale sale = new Sale();
        ProductItem item = new ProductItem(1000,"pen",5.50);
        SaledItem saledItem = new SaledItem(item,2);
        sale.enterItem(saledItem);
        ProductItem item2 = new ProductItem(1001,"pencil",3.50);
        SaledItem saledItem2 = new SaledItem(item2,3);
        sale.enterItem(saledItem2);
        ProductItem item3 = new ProductItem(1002,"rubber",4.00);
        SaledItem saledItem3 = new SaledItem(item3,4);
        sale.enterItem(saledItem3);
        
        return sale;
    }
    
}
