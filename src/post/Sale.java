/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package post;

import Model.CashPayment;
import Model.CreditCardPayment;
import Model.SaledItem;
import Model.iPayment;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Class for a sale made by the POST. Class handles all aspects that go into a sale,
 * including items and payment.
 */
public class Sale {
    
    private final List<SaledItem> saledItems =  new ArrayList<SaledItem>();
    private iPayment payment;
    private String custName;
    private Date saledtime;
    private Double amount;
    
    /**
     * Constructor method; creates a new sale for a customer.
     * @param name Customer name
     */
    public Sale(String name){
        this.custName = name;
    }
    
    /**
     * Adds item to current sale.
     * @param saledItem Item to add to current sale.
     */
    public void enterItem(SaledItem saledItem){
        getSaledItems().add(saledItem);
    }
    
    /**
     * Retrieves total balance of current sale.
     * @return Balance of current sale
     */
    public double getAmount(){
        amount = 0.0;
        
        for(SaledItem saleditem:getSaledItems()){
            amount += saleditem.getsaleItemAmount();
        }
        return amount;
    }
    
    /**
     * Displays item details of all items in current sale.
     */
    public void showItem(){
        for(SaledItem saleditem:getSaledItems()){
            System.out.println("UPC: "+saleditem.getItem().getUpc()+ ", Description: "+ saleditem.getItem().getDescription()
                                +", Price: "+saleditem.getItem().getPrice()+", Quantity: "+saleditem.getQuantity());
        }
    }
    
    /**
     * Handles payment for the current sale based on the parameters passed.
     * @param paymentType Type of payment used; "cash" for cash payment, "card" for credit card payment
     * @param paymentAmount Amount paid by customer
     * @param saleAmount Balance of current sale
     * @param cardNo 16-digit number of credit card used in payment
     */
    public void makePayment(String paymentType, double paymentAmount, double saleAmount, String cardNo){
        if(paymentType.equals("cash")){
            setPayment(new CashPayment());
            getPayment().payCash(paymentAmount, saleAmount);
        }else{
            setPayment(new CreditCardPayment());
            getPayment().payCredit(saleAmount, cardNo);
        }
        setSaledtime( new Date());
        
    }

    /**
     * Retrieves name of current sale's customer.
     * @return Name of customer
     */
    public String getCustName() {
        return custName;
    }

    /**
     * Sets name of current sale's customer to name passed as a parameter.
     * @param custName New name of customer
     */
    public void setCustName(String custName) {
        this.custName = custName;
    }

    /**
     * Retrieves time of current sale.
     * @return Time of current sale
     */
    public Date getSaledtime() {
        return saledtime;
    }

    /**
     * Sets time of current sale to time passed as a parameter.
     * @param saledtime New time of current sale
     */
    public void setSaledtime(Date saledtime) {
        this.saledtime = saledtime;
    }

    /**
     * Retrieves payment type used for current sale.
     * @return Payment type used for current sale
     */
    public iPayment getPayment() {
        return payment;
    }

    /**
     * Set payment type for current sale to new type passed as a parameter.
     * @param payment New payment type for current sale
     */
    public void setPayment(iPayment payment) {
        this.payment = payment;
    }

    /**
     * Retrieves all items in current sale.
     * @return All items in current sale.
     */
    public List<SaledItem> getSaledItems() {
        return saledItems;
    }
    
    
}
