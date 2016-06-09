/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package producerconsumer;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        CircularBuffer circularBuffer = new CircularBuffer();

        Producer producto = new Producer(circularBuffer);
        Consumer consumer = new Consumer(circularBuffer);

        producto.start();
        consumer.start();
        try {
            producto.join();
            consumer.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("End program");
    }

}
