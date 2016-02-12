/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 * Interface for payment types. Implemented by CashPayment and CreditCardPayment.
 */
public interface iPayment {
	/**
	 * Retrieves amount to be paid in the transaction.
	 * @return Amount to be paid in the transaction
	 */
    public double amount();
    
    /**
     * Retrieves amount of change from a cash transaction.
     * @return Change from cash transaction
     */
    public double cashReturned();
    
    /**
     * Retrieves amount received from customer for a cash transaction. 
     * @return Amount received in cash transaction
     */
    public double cashReceived();
    
    /**
     * Retrieves credit card number for a credit card transaction.
     * @return Credit card number for transaction
     */
    public String cardNo();
    
    /**
     * Checks if payment type is cash.
     * @return Boolean value determining payment type; "true" if cash, "false" if credit card
     */
    public boolean isCash();
    
    /**
     * Conducts cash transaction by calculating amount received and returned.
     * @param paymentAmount Amount paid by cash
     * @param saleAmount Balance on current sale
     */
    public void payCash(double paymentAmount, double saleAmount);
    
    /**
     * Conducts credit card transaction by calculating amount paid.
     * @param saleAmount Amount paid by card
     * @param cardNo 16-digit number of credit card used in transaction
     */
    public void payCredit(double saleAmount, String cardNo);
}
