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
public class CreditCardPayment implements iPayment{
    
    private String creditCardNo;
    private double amount;
    
    @Override
    public double amount() {
        return amount;
    }

    @Override
    public void payCash(double paymentAmount, double saleAmount) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void payCredit(double saleAmount, String cardNo) {
        amount = saleAmount;
        creditCardNo = cardNo;
    }
    

    @Override
    public double cashReturned() {
        return 0.0;
    }

    @Override
    public double cashRecieve() {
        return 0.0;
    }

    @Override
    public String cardNo() {
        return creditCardNo;
    }

    @Override
    public boolean isCash() {
        return false;
    }
}
