/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package producerconsumer.buffer;

import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Antonio López Marín
 */
public class Consumidor extends Thread {

    myBuffer buffer;

    public Consumidor(myBuffer buffer) {
        super();
        this.buffer = buffer;
    }
    
    /**
     * Consume diez caracteres del buffer que maximo tiene 5, por eso 
     * se le pasa la posicion que quiere consumir y cuando llegue a 5 que 
     * empiece por el primero.
     */
    @Override
    public void run() {
        int cont = 0;
        for (int i = 0; i < 10; i++) {            
            buffer.get(cont);
            if (cont==4) cont = -1;
            cont++;
            try {
                sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Consumidor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
