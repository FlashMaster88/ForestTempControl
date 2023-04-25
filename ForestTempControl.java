/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package foresttempcontrol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.microedition.io.Connector;
import javax.microedition.io.SocketConnection;
import javax.microedition.midlet.MIDlet;

/**
 *
 * @author karan
 */
public class ForestTempControl extends MIDlet implements Listeners{
        double maxTemp = 38;
        String serverIPAddress = "10.20.5.177";         
        SocketConnection socket = (SocketConnection) Connector.open("socket://" + serverIPAddress + ":" + 7777);
            
    @Override
    public void startApp() {           
                
        TemperatureSensor temp1 = new TemperatureSensor(maxTemp);
        temp1.addListener(this);
        temp1.start();  
        temp1.setName("Temp1 :");
        
        TemperatureSensor temp2 = new TemperatureSensor(maxTemp);
        temp2.addListener(this);
        temp2.start(); 
        temp2.setName("Temp2 :");
        
        TemperatureSensor temp3 = new TemperatureSensor(maxTemp);
        temp3.addListener(this);
        temp3.start(); 
        temp3.setName("Temp3 :");       
                 
    }    
    @Override
    public void destroyApp(boolean unconditional) {
    }      
    @Override
    public void MaxTempReached (double temp, String threadname1) {
            try {
                
                PrintStream outToServer = new PrintStream(socket.openOutputStream ());
                String sentence =" Temperature is above the upper limit: ";
                System.out.println("Write to Sever: " + sentence + threadname1);  
                outToServer.println(sentence);
                outToServer.flush();
                
            } catch (IOException ex) {
                Logger.getLogger(ForestTempControl.class.getName()).log(Level.SEVERE, null, ex);
            }
                   
    //outToServer.println(threadname1 + " " + " Temperature is above the upper limit: " + temp + " Irrigation Pumps must be opened. ");
    }
    @Override
    public void MinTempReached (double temp, String threadname1) {
        
        try {                
                PrintStream outToServer = new PrintStream(socket.openOutputStream ());
                String sentence =" Temperature is above the upper limit: ";
                System.out.println("Write to Sever: " + sentence + threadname1);  
                outToServer.println(sentence);
                outToServer.flush();
                
            } catch (IOException ex) {
                Logger.getLogger(ForestTempControl.class.getName()).log(Level.SEVERE, null, ex);
            }outToServer.println();
    }

}
