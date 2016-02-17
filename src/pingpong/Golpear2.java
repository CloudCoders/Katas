/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pingpong;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author toni
 */
public class Golpear2 {
     String nombre;
    private boolean isFin = true;
    private boolean isGolpe;
    public Golpear2() {
        nombre = "PONG"; //Lo inicio vacio
    }
    
    public synchronized void terminar(){
        notifyAll();
    }
    
//    public synchronized void golpear(String name){
//        if (!nombre.equals(name)) {
//            try {
//                System.out.println(name);
//                this.nombre = name;
//                notify();
//                wait();
//            } catch (InterruptedException ex) {
//                Logger.getLogger(Golpear.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }
//    }

    public synchronized void put(String name){
        while (isGolpe) {
            try {
                wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(Golpear2.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        
    }
    
    void empezar(){
        isFin = false;
    }
    
    void fin() {
       isFin = true;
    }
    
    boolean isFin(){
        return isFin;
    }
}
