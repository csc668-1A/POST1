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
 * Model class for a store's product catalog. Class can create a product catalog and
 * add, remove, and retrieve items to/from a catalog.
 */
public class ProductCatalog {
   //create an object of SingleObject of ProductCatalog
   private static ProductCatalog catalog = new ProductCatalog();
   private static List<ProductItem> items =  new ArrayList<ProductItem>();
    
   /**
    * Constructor method; creates new instance of ProductCatalog.
    */
   private ProductCatalog(){}

   /**
    * Retrieves current product catalog.
    * @return Product catalog for a store
    */
   public static ProductCatalog getInstance(){
      return catalog;
   }
   
   /**
    * Adds item passed as a parameter to product catalog.
    * @param item Product item to be added to product catalog
    */
   public void addItem(ProductItem item){
        items.add(item);
    }
    
   /**
    * Removes item from product catalog based on UPC passed as a parameter.
    * @param upc UPC of item to be removed from product catalog
    */
    public void deleteItemByUPC(int upc){
        for(ProductItem item: items){
            if(item.getUpc()==upc){
                items.remove(item);
            }
        }
    }
    
    /**
     * Removes all items from product catalog.
     */
    public void deleteAllItem(){
        items.clear();
    }
    
    /**
     * Prints details of all items currently in product catalog.
     */
    public void showitem(){
        for(ProductItem item: items){
                System.out.println("UPC: "+item.getUpc()+ ", Description: "+ item.getDescription()
                                +", Price: "+item.getPrice());
        }
    }
    
    /**
     * Retrieves product item with UPC passed as a parameter from product catalog.
     * @param upc UPC of item to retrieve from product catalog
     * @return Product item for corresponding UPC
     */
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
    
    /**
     * Writes current product catalog to a file located at the directory specified in iFileDirectory.
     * @param items Items in current product catalog
     * @throws FileNotFoundException
     */
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
    
    /**
     * Appends catalog items to a file located at the directory specified in iFileDirectory.
     * @param items
     * @throws FileNotFoundException
     */
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
    
    /**
     * Formats a passed string by appending whitespace to the string until it is of specified length.
     * Used for formatting text upon writing catalog to file.
     * @param str String to be formatted
     * @param leng Length of which to extend str by appending whitespace
     * @return Formatted string with appended whitespace
     */
    public static String padString(String str, int leng) {
        for (int i = str.length(); i < leng; i++)
            str += " ";
        return str;
    }
}
