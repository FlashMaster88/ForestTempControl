/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package foresttempcontrol;

/**
 *
 * @author karan
 */
public interface Listeners {
   public void MaxTempReached (double temp, String threadname1);
   public void MinTempReached (double temp, String threadname1);
}
