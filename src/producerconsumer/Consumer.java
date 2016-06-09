/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package producerconsumer;

import java.util.logging.Level;
import java.util.logging.Logger;


public class Consumer extends Thread {

    CircularBuffer circularBuffer;

    public Consumer(CircularBuffer circularBuffer) {
        super();
        this.circularBuffer = circularBuffer;
    }

    @Override
    public void run() {
        int cont = 0;
        for (int i = 0; i < 10; i++) {            
            circularBuffer.get(cont);
            if (cont==4) cont = -1;
            cont++;
            try {
                sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Consumer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
