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
public class Arbitro extends Thread{
    
    Golpear g;
    
    public Arbitro(Golpear g) {
        this.g = g;
    }

    @Override
    public void run() {
        try {
            for (int i = 3; i > 0; i--) {
                System.out.println("El partido comienza en "+i);
                Thread.sleep(1000);
            }
            System.out.println("Comienza el partido.");  
            g.empezar();
            Thread.sleep(10000);
            g.fin();
            System.out.println("PIIIII Fin del partido.");
        } catch (InterruptedException ex) {
            Logger.getLogger(Arbitro.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
}
