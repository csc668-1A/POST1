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
 *
 * @author ninjung
 */
public class Sale {
    
    private final List<SaledItem> saledItems =  new ArrayList<SaledItem>();
    private iPayment payment;
    private String custName;
    private Date saledtime;
    private Double amount;
    
    public Sale(String name){
        this.custName = name;
    }
    public void enterItem(SaledItem saledItem){
        getSaledItems().add(saledItem);
    }
    
    public double getAmount(){
        amount = 0.0;
        
        for(SaledItem saleditem:getSaledItems()){
            amount += saleditem.getsaleItemAmount();
        }
        return amount;
    }
    
    public void showItem(){
        for(SaledItem saleditem:getSaledItems()){
            System.out.println("UPC: "+saleditem.getItem().getUpc()+ ", Description: "+ saleditem.getItem().getDescription()
                                +", Price: "+saleditem.getItem().getPrice()+", Quantity: "+saleditem.getQuantity());
        }
    }
    
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
     * @return the custName
     */
    public String getCustName() {
        return custName;
    }

    /**
     * @param custName the custName to set
     */
    public void setCustName(String custName) {
        this.custName = custName;
    }

    /**
     * @return the saledtime
     */
    public Date getSaledtime() {
        return saledtime;
    }

    /**
     * @param saledtime the saledtime to set
     */
    public void setSaledtime(Date saledtime) {
        this.saledtime = saledtime;
    }

    /**
     * @return the payment
     */
    public iPayment getPayment() {
        return payment;
    }

    /**
     * @param payment the payment to set
     */
    public void setPayment(iPayment payment) {
        this.payment = payment;
    }

    /**
     * @return the saledItems
     */
    public List<SaledItem> getSaledItems() {
        return saledItems;
    }
    
    
}
