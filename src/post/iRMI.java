/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package post;
import java.rmi.*;
/**
 *
 * @author DC
 */
public interface iRMI extends Remote{
    public void print() throws RemoteException;
}
