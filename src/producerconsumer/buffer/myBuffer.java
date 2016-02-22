/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package producerconsumer.buffer;

import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Antonio López Marín
 */
public class myBuffer{

    char[] buffer;
    
    public myBuffer() {   
        //Buffer de 5
        buffer = new char[5];
       Arrays.fill(buffer, ' ');
    }

    /**
     * Muestra el buffer
     */
    public void mostrar(){
        for (int i = 0; i < buffer.length; i++) {
            System.out.print(buffer[i]+"|");
        }
        System.out.println("");
    }
    
    /**
     * Si hay espacio en el buffer.
     * 
     * @return 
     */
    public boolean hasEspacio(){
        boolean hasEspacio = false;
        for (int i = 0; i < buffer.length; i++) {
            if (buffer[i]==' ') {
                hasEspacio = true;
                break;
            }
        }
        return hasEspacio;
    }
    
    /**
     * Si se ha producido.
     * 
     * @return 
     */
    public boolean hasProducido(){
         boolean hasEspacio = false;
        for (int i = 0; i < buffer.length; i++) {
            if (buffer[i]!=' ') {
                hasEspacio = true;
                break;
            }
        }
        return hasEspacio;
    }
    
    /**
     * Produce mientras haya espacio.
     * 
     * @param producir
     * @param caracter 
     */
    public synchronized void put(int producir, char caracter) {
        if (!hasEspacio()) {
            try {
                wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(myBuffer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        System.out.println("Producido: " + caracter);
        buffer[producir] = caracter;
        mostrar();
        notify();
    }
    
    /**
     * Consume pero no muestra el buffer porque la mayoria estara vacio porque 
     * consume y lo deja vacio.
     * 
     * @param consumir 
     */
    public synchronized void get(int consumir) {
        //Si intenta consumir algo que aun no se ha producido
        if (!hasProducido()) {
            try {
                wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(myBuffer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        System.out.println("Consumido: "+buffer[consumir]);
        buffer[consumir] = ' ';
        notify();
    }
}
