/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package foresttempcontrol;

import java.util.Random;

/**
 *
 * @author karan
 */
public class Thermometer {
    double BASE_TEMPERATURE = 32.5;
    private final Random randomGenerator = new Random();
    public double getCurrentTemperature(){
        
    return (BASE_TEMPERATURE + (randomGenerator.nextDouble()) * 10); 
    }
    
}
