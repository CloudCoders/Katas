package introduction;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alumno
 */
public class Ejercicio3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new Ejercicio3().load();
    }
    
    public void load(){
        Hilo h = new Hilo(1000);
        Hilo hilo = new Hilo(1500);
    }
    
    class Hilo implements Runnable{
        Thread hilo;
        int milisegundos;
        
        public Hilo(int mil){
            start(mil);
        }
        
        public void start(int miliseconds){
            milisegundos = miliseconds;
            
            hilo = new Thread(this);
            hilo.start();
        }
        
        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(milisegundos);
                    System.out.println(i);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Ejercicio3.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
}
