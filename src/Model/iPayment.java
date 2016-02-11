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
public interface iPayment {
    public double amount();
    public double cashReturned();
    public double cashRecieve();
    public String cardNo();
    public boolean isCash();
    public void payCash(double paymentAmount, double saleAmount);
    public void payCredit(double saleAmount, String cardNo);
}
