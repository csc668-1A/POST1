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
public class ProductItem {
    private int upc;
    private String description;
    private double price;

    public ProductItem(int upc, String description, double price) {
    this.upc = upc;
    this.description = description;
    this.price = price;
}
    /**
     * @return the upc
     */
    public int getUpc() {
        return upc;
    }

    /**
     * @param upc the upc to set
     */
    public void setUpc(int upc) {
        this.upc = upc;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the price
     */
    public double getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(double price) {
        this.price = price;
    }
}
