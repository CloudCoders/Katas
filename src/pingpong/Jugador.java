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
public class Jugador extends Thread{
    
    Golpear g;
    
    public Jugador(Golpear g, String name) {
        super(name);
        this.g = g;
    }
    
    
    @Override
    public void run() {
        while (g.isFin()) {
        }
        while (!g.isFin()) {
            try {
                g.golpear(getName());
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Jugador.class.getName()).log(Level.SEVERE, null, ex);
            }
        }  
        g.terminar();
    }
}   
