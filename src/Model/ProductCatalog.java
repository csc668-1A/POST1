/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ninjung
 */
public class ProductCatalog {
    
   //create an object of SingleObject of ProductCatalog
   private static ProductCatalog catalog = new ProductCatalog();
    
   //make the constructor private so that this class cannot be
   //instantiated
   private ProductCatalog(){}

   //Get the only object available
   public static ProductCatalog getInstance(){
      return catalog;
   }
   
   private final List<ProductItem> items =  new ArrayList<ProductItem>();
    
   public void addItem(ProductItem item){
        items.add(item);
    }
    
    public void deleteItem(int upc){
        for(ProductItem item: items){
            if(item.getUpc()==upc){
                items.remove(item);
            }
        }
    }
    
    public void showitem(){
        for(ProductItem item: items){
                System.out.println("UPC: "+item.getUpc()+ ", Description: "+ item.getDescription()
                                +", Price: "+item.getPrice());
        }
    }
}
