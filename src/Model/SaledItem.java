/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author ninjung
 */
public class SaledItem {
    private ProductItem item;
    int quantity;
    //double saledItemAmount;
    
    public SaledItem(ProductItem item,int quantity){
        setItem(item);
        this.quantity = quantity;
    }

    
    public double getsaleItemAmount(){
      double amount ;
      amount = getItem().getPrice()*quantity;
      return amount;
    }

    /**
     * @return the item
     */
    public ProductItem getItem() {
        return item;
    }

    /**
     * @param item the item to set
     */
    private void setItem(ProductItem item) {
        this.item = item;
    }
    
    
}
