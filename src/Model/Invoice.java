/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Model class for invoice of a sale. Class can create and write invoices to a transaction log.
 */
public class Invoice {
    private String customerName;
    private List<SaledItem> saledItems =  new ArrayList<SaledItem>();
    private Date saledTime;
    private boolean isCash;
    private double amount;
    private double tendered;
    private double returned;
    private String cardNo;
    
    /**
     * Constructor method; creates an invoice from details passed as parameters.
     * @param name Name of the customer
     * @param saledItems Items sold to the customer
     * @param saledTime Time when transaction occurred
     * @param isCash Boolean value determining if cash payment was used
     * @param amount Amount paid by customer
     * @param tendered Cash amount received from customer
     * @param returned Cash amount returned to customer
     * @param cardNo 16-digit number of credit card used in transaction
     */
    public  Invoice(String name, List<SaledItem> saledItems, Date saledTime, Boolean isCash, double amount,
            double tendered, double returned, String cardNo){
        this.customerName = name;
        this.saledItems = saledItems;
        this.saledTime = saledTime;
        this.isCash = isCash;
        this.amount = amount;
        this.tendered = tendered;
        this.returned = returned;
        this.cardNo = cardNo;
    }
    
    /**
     * Writes invoices to a transaction log located at the directory specified by iFileDirectory.
     * @throws IOException
     */
    public void run() throws IOException {
    	//Change directory for your computer
        File file = new File(iFileDirectory.TRANSACTIONFILEDIR);
        file.getParentFile().mkdirs();

        try (PrintWriter printWriter = new PrintWriter(new BufferedWriter(new FileWriter(file, true)))) {
            printWriter.println("IDENTIFYING INFORMATION:"+ customerName);
            
            for(SaledItem item:saledItems){
                printWriter.println("ITEM: "+item.getItem().getUpc()+" "+item.getQuantity()+"\n");
            }
            if (isCash == true){
                printWriter.println("PAYMENT: <CASH/CHECK $"+amount+">");
            }
            else {
                printWriter.println("PAYMENT: <CREDIT " + amount+">"+amount+" is credit card#"+cardNo);
            }
            printWriter.println("\n");
        }catch (IOException e) {
            System.err.println("IOException: " + e.getMessage());
        }
        System.out.println("Write Transaction.txt File Completed");
        
    }
    
    /**
     * Prints message to console confirming logging of invoice to transaction log.
     */
    public void print(){
        System.out.println("------Invoice Printed by Program-------");
        System.out.println("");
    }
}
