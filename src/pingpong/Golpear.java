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
 * @author alumno
 */
public class Golpear {
    
    String nombre;
    private boolean isFin = true;
    
    public Golpear() {
        nombre = "PONG"; //Lo inicio vacio
    }
    
    public synchronized void terminar(){
        notifyAll();
    }
    
    public synchronized void golpear(String name){
        if (!nombre.equals(name)) {
            try {
                System.out.println(name);
                this.nombre = name;
                notify();
                wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(Golpear.class.getName()).log(Level.SEVERE, null, ex);
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
