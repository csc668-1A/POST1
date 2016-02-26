/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Client;
import java.rmi.*;
import java.rmi.server.*;
import post.*;
/**
 *
 * @author JC
 */
public class Client {
    public static void main(String argv[]){
        String strName = "rmi://localhost:1099/TheRMIExample";
        System.out.println("Client: Looking up " + strName + "...");
        iRMI RemRMIExample = null;

        try
        {
            System.out.println("Working");
            RemRMIExample = (iRMI)Naming.lookup(strName);
            RemRMIExample.print();
        }
        catch (Exception e)
        {
        System.out.println("Client: Exception thrown looking up " + strName);
        System.exit(1);
        }
        
    
    }
}
