/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 * Model class for a product item. Class can create products and
 * provide getter/setter methods for its data fields.
 */
public class ProductItem {
    private int upc;
    private String description;
    private double price;

    /**
     * Constructor method; creates a ProductItem object from passed parameters.
     * @param upc UPC of new product
     * @param description Description of new product
     * @param price Price of new product
     */
    public ProductItem(int upc, String description, double price) {
        this.upc = upc;
        this.description = description;
        this.price = price;
    }
    
    /**
     * Default constructor method;
     */
    public ProductItem() {
        
    }
    /**
     * Retrieves the UPC of a product.
     * @return UPC of product
     */
    public int getUpc() {
        return upc;
    }

    /**
     * Sets a product's UPC to new UPC passed as a parameter.
     * @param upc New UPC for product
     */
    public void setUpc(int upc) {
        this.upc = upc;
    }

    /**
     * Retrieves the description of a product.
     * @return Description of product
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets a product's description to new description passed as a parameter.
     * @param description New description for product
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Retrieves the price of a product.
     * @return Price of product
     */
    public double getPrice() {
        return price;
    }

    /**
     * Sets a product's price to a new price passed as a parameter.
     * @param price New price for product
     */
    public void setPrice(double price) {
        this.price = price;
    }
}
