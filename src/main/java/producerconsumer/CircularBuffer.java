/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package producerconsumer;

import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CircularBuffer {

    char[] buffer;
    
    public CircularBuffer() {
        //CircularBuffer of 5
        buffer = new char[5];
       Arrays.fill(buffer, ' ');
    }

    public void show(){
        for (int i = 0; i < buffer.length; i++) {
            System.out.print(buffer[i]+"|");
        }
        System.out.println("");
    }

    public boolean hasAPlace(){
        boolean hasAPlaze = false;
        for (int i = 0; i < buffer.length; i++) {
            if (buffer[i]==' ') {
                hasAPlaze = true;
                break;
            }
        }
        return hasAPlaze;
    }

    public boolean hasProduce(){
         boolean hasAPlaze = false;
        for (int i = 0; i < buffer.length; i++) {
            if (buffer[i]!=' ') {
                hasAPlaze = true;
                break;
            }
        }
        return hasAPlaze;
    }

    public synchronized void put(int producir, char caracter) {
        if (!hasAPlace()) {
            try {
                wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(CircularBuffer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        System.out.println("Produced: " + caracter);
        buffer[producir] = caracter;
        show();
        notify();
    }

    public synchronized void get(int consumir) {
        if (!hasProduce()) {
            try {
                wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(CircularBuffer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        System.out.println("Consumed: "+buffer[consumir]);
        buffer[consumir] = ' ';
        notify();
    }
}
