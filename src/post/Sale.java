/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package post;

import Model.ProductItem;
import Model.SaledItem;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ninjung
 */
public class Sale {
    private final List<SaledItem> saledItems =  new ArrayList<SaledItem>();
    
    public void enterItem(SaledItem saledItem){
        saledItems.add(saledItem);
    }
    
    public double getAmount(){
        double amount = 0.0;
        
        for(SaledItem saleditem:saledItems){
            amount += saleditem.getsaleItemAmount();
        }
        return amount;
    }
    
    public void showItem(){
        for(SaledItem saleditem:saledItems){
            System.out.println("UPC: "+saleditem.getItem().getUpc()+ ", Description: "+ saleditem.getItem().getDescription()
                                +", Price: "+saleditem.getItem().getPrice());
        }
    }
    
    public void makePayment(){
        
    }
    
    
}
