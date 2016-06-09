/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package producerconsumer;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Producer extends Thread {

    CircularBuffer circularBuffer;

    public Producer(CircularBuffer circularBuffer) {
        super();
        this.circularBuffer = circularBuffer;
    }

    @Override
    public void run() {
        char[] c = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 
            'm', 'n', 'ñ', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
            try {
                int cont = 0;
                for (int j = 0; j < 10; j++) {
                        char aux = c[j];
                        circularBuffer.put(cont, aux);
                        sleep(800);
                    if (cont==4) cont = -1;
                    cont++;
                }                
            } catch (InterruptedException ex) {
                Logger.getLogger(Consumer.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
}
