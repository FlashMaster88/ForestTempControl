/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package foresttempcontrol;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author karan
 */
public class TemperatureSensor extends Thread {
    
     final static int DELAY =1500;
        String threadname1;
        double Max_Temp;
     ArrayList<Listeners> listeners;    
    
    public TemperatureSensor(double maxTemp) 
            { 
                Max_Temp = maxTemp;
                listeners = new ArrayList<>();
            }
    
    public void addListener (Listeners newListener)
    { 
        listeners.add(newListener);
    }    
    
    @Override
    public void run() {   
    
        Timer timer = new Timer();
        threadname1 = Thread.currentThread().getName();
        
        TimerTask check = new TakeTemperature(Max_Temp, listeners,threadname1);
     
        timer.schedule(check, 0, DELAY);  

        try {     
        
        Thread.sleep (10000);
        } catch (InterruptedException ex) {
        Logger.getLogger(TemperatureSensor.class.getName()).log(Level.SEVERE, null, ex);
        }
    } 

    }
