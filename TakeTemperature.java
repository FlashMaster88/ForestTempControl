/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package foresttempcontrol;

import java.util.ArrayList;
import java.util.TimerTask;

class TakeTemperature extends TimerTask {
    
    String threadname1;
    double Max_Temp ;
    double numeric_temperature ;
    ArrayList<Listeners> CurrentListeners ;
    
    public TakeTemperature(double maxTemp, ArrayList<Listeners> listeners, String threadname1) 
    {
        Max_Temp = maxTemp;
        this.CurrentListeners = listeners;
        this.threadname1 = threadname1;
    }
    @Override    
    public void run() {   

            Thermometer temp = new Thermometer();
            numeric_temperature = temp.getCurrentTemperature();

           if ( (numeric_temperature>= Max_Temp))
            {
                for (Listeners c:CurrentListeners){
                    c.MaxTempReached(numeric_temperature,threadname1);
                }
            }          
           if ( (numeric_temperature<= Max_Temp))
            {
                 for (Listeners c:CurrentListeners){
                    c.MinTempReached(numeric_temperature, threadname1);
                }
            }             

    }
    
}
