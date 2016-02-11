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
 *
 * @author ninjung
 */
public class Invoice {
    private static final String FILENAME = "./transaction.txt";
    private String customerName;
    private List<SaledItem> saledItems =  new ArrayList<SaledItem>();
    private Date saledTime;
    private boolean isCash;
    private double amount;
    private double tendered;
    private double returned;
    private String cardNo;
    
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
    
    public void run() throws IOException {
        //Writes values to a .txt file on the desktop
        
        //Change directory for your computer
        File file = new File(FILENAME);
        file.getParentFile().mkdirs();

        PrintWriter printWriter = new PrintWriter(file);
        printWriter.println("IDENTIFYING INFORMATION:"+ customerName);
        
        for(SaledItem item:saledItems){
            printWriter.println("ITEM: "+item.getItem().getUpc()+" "+item.getQuantity());
        }
        if (isCash == true){
            printWriter.println("PAYMENT: <CASH/CHECK $"+amount+">");
        }
        else {
            printWriter.println("PAYMENT: <CREDIT " + amount+">"+amount+" is credit card#"+cardNo);
        }
        printWriter.println("\n");
        printWriter.close();
        System.out.println("Write File Completed");
        
    }
    
    public void print(){
        System.out.println("------Invoice Printed by Program-------");
        System.out.println("");
    }
}
