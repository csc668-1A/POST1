/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 * Model class for a sale item. Class can create items and
 * provide getter/setter methods for its data fields.
 */
public class SaledItem {
    private ProductItem item;
    private int quantity;
    
    /**
     * Constructor method; creates a SaledItem object from passed parameters.
     * @param item Product item to add to a sale
     * @param quantity Number of item to add to a sale
     */
    public SaledItem(ProductItem item,int quantity){
        setItem(item);
        this.quantity = quantity;
    }

    /**
     * Retrieves price total for a quantity of an item in a sale.
     * @return Price total for a quantity of a sale item
     */
    public double getsaleItemAmount(){
      double amount ;
      amount = getItem().getPrice()*getQuantity();
      return amount;
    }

    /**
     * Retrieves product of a sale item.
     * @return Product of sale item
     */
    public ProductItem getItem() {
        return item;
    }

    /**
     * Set product of a sale item to new product passed as a parameter. 
     * @param item New product of sale item
     */
    private void setItem(ProductItem item) {
        this.item = item;
    }

    /**
     * Retrieves quantity of a sale item.
     * @return Quantity of sale item
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Sets quantity of a sale item to new quantity passed as a parameter.
     * @param quantity New quantity of sale item
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
    
}
