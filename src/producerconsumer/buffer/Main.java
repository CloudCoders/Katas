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
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        myBuffer buffer = new myBuffer();

        Productor producto = new Productor(buffer);
        Consumidor consumidor = new Consumidor(buffer);

        producto.start();
        consumidor.start();
        try {
            producto.join();
            consumidor.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Termino el programa");
    }

}
