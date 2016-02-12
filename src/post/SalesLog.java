/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package post;

import Model.Invoice;
import Model.SaledItem;
import java.io.IOException;
import java.util.Date;

/**
 *
 * @author ninjung
 */
public class SalesLog {
    
    public void addNewSale(Sale sale, Store store) throws IOException{
        Invoice invoice = new Invoice(sale.getCustName(), sale.getSaledItems(), sale.getSaledtime(), 
                sale.getPayment().isCash(), sale.getPayment().amount(), sale.getPayment().cashRecieve(), 
                sale.getPayment().cashReturned(), sale.getPayment().cardNo());
        invoice.run();//write transaction.txt
        
        /*Display Invoice*/
        System.out.println("----Invoice Printed by Program------");
        System.out.println(store.getSname().toUpperCase());// display store name
        System.out.println("Customer name: "+sale.getCustName()+", Date Time: "+ sale.getSaledtime());
        for(SaledItem item:sale.getSaledItems()){
            double subtotal = item.getQuantity()*item.getItem().getPrice();
            System.out.println("ITEM: <"+item.getItem().getDescription()+" "+item.getQuantity()+
                    " @ "+item.getItem().getPrice()+" "+subtotal+">");
        }
        System.out.println("----");
        System.out.println("Total $"+sale.getPayment().amount());
        if(sale.getPayment().isCash()){
            System.out.println("Amount Tendered: "+sale.getPayment().cashRecieve());
            System.out.println("Amount Returned: "+sale.getPayment().cashReturned());
        }else{
            System.out.println("Paid by Credit Card "+sale.getPayment().cardNo());
        }
    }
    
    public void printSalesLog(Date time){
        
    }
    
    public void printRecord(String Custname){
        
    }
}
