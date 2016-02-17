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
public class Productor extends Thread {

    myBuffer buffer;

    public Productor(myBuffer buffer) {
        super();
        this.buffer = buffer;
    }
    
    /**
     * Pongo las letras del abecedario, y produzco diez caracteres, se podrian
     * producir todos los que se quieran.
     * 
     */
    @Override
    public void run() {
        char[] c = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 
            'm', 'n', 'ñ', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
            try {
                int cont = 0;
                for (int j = 0; j < 10; j++) {
                        char aux = c[j];
                        buffer.put(cont, aux);                        
                        sleep(800);
                    if (cont==4) cont = -1;
                    cont++;
                }                
            } catch (InterruptedException ex) {
                Logger.getLogger(Consumidor.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
}
