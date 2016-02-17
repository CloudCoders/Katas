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
public class Ejercicio1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new Ejercicio1().load();
    }
    
    public void load(){
        Hilo1 hola = new Hilo1();
        Hilo2 adios = new Hilo2();

        hola.start();
        adios.start();
    }
    class Hilo1 extends Thread{

        public Hilo1() {
        }

        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                try {
                    int sleep = (int)(Math.random()* 3000)+0;
                    sleep(sleep);
                    System.out.println("Hola");
                    Logger.getLogger(sleep+"");
                } catch (InterruptedException ex) {
                    Logger.getLogger(Ejercicio1.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }              
    }
    
   class Hilo2 extends Thread{

        public Hilo2() {
        }

        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                try {
                    int sleep = (int)(Math.random()* 3000)+0;
                    sleep(sleep);
                    System.out.println("Adios");
                    Logger.getLogger(sleep+"");
                } catch (InterruptedException ex) {
                    Logger.getLogger(Ejercicio1.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }              
    }
}
