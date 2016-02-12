/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 * Model class for cash payment. Implements iPayment interface.
 */
public class CashPayment implements iPayment{

    private double amount;
    private double cashRecv;
    private double cashChange;
    
    @Override
    public double amount() {
        return amount;
    }

    @Override
    public void payCash(double paymentAmount, double saleAmount) {
        cashChange = paymentAmount - saleAmount;
        amount = saleAmount;
        cashRecv = paymentAmount;
    }
    
    @Override
    public void payCredit(double saleAmount, String cardNo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public double cashReceived(){
        return cashRecv;
    }

    @Override
    public double cashReturned() {
        return cashChange;
    }

    @Override
    public String cardNo() {
        return "";
    }

    @Override
    public boolean isCash() {
        return true;
    }
   
}
