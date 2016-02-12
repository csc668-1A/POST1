/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
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
   
   private static List<ProductItem> items =  new ArrayList<ProductItem>();
    
   
   public void addItem(ProductItem item){
        items.add(item);
    }
    
    public void deleteItemByUPC(int upc){
        for(ProductItem item: items){
            if(item.getUpc()==upc){
                items.remove(item);
            }
        }
    }
    
    public void deleteAllItem(){
        items.clear();
    }
    
    public void showitem(){
        for(ProductItem item: items){
                System.out.println("UPC: "+item.getUpc()+ ", Description: "+ item.getDescription()
                                +", Price: "+item.getPrice());
        }
    }
    
    public ProductItem getItemByUPC(int upc){
        ProductItem productItem = new ProductItem();
        for(ProductItem item: items){
                if(upc == item.getUpc()){
                    productItem = item;
                    break;
                }
        }
        return productItem;
    }
    
    public void productWriter(List<ProductItem> items) throws FileNotFoundException{
        //Change directory for your computer
        File file = new File(iFileDirectory.PRODUCTSFILEDIR);
        file.getParentFile().mkdirs();
        try (PrintWriter printWriter = new PrintWriter(file)) {
            for(ProductItem item: items){
                printWriter.println(item.getUpc()+"-----"+padString(item.getDescription(), 20)+"-----"+item.getPrice());
            }
            printWriter.close();
            System.out.println("Write products.txt file");
        }catch (IOException e) {
                System.err.println("IOException: " + e.getMessage());
        } 
    }
    public void productAppending(List<ProductItem> items) throws FileNotFoundException{
        //Change directory for your computer
        File file = new File(iFileDirectory.PRODUCTSFILEDIR);
        file.getParentFile().mkdirs();
        
        try (PrintWriter printWriter = new PrintWriter(new BufferedWriter(new FileWriter(file, true)))) {
            for(ProductItem item: items){
                printWriter.println(item.getUpc()+"-----"+padString(item.getDescription(), 20)+"-----"+item.getPrice());
            }
            printWriter.close();
            System.out.println("Write products.txt file");
        }catch (IOException e) {
                System.err.println("IOException: " + e.getMessage());
        } 
    }
    public static String padString(String str, int leng) {
        for (int i = str.length(); i < leng; i++)
            str += " ";
        return str;
    }
}
