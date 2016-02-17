package introduction;/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Antonio López Marín
 */
public class Ejercicio5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new Ejercicio5().load();
    }

    public void load() {
        try {
            new Hilo("Hilo 1", 11, 20);
            new Hilo("Hilo 2", 21, 30);
            new Hilo("Hilo 3", 1, 10);
        } catch (Exception e) {
        }
    }

    class Hilo implements Runnable {

        Thread hilo;
        PrintWriter pw;
        int ini, fin;
        String name;

        public Hilo(String name, int ini, int fin) throws IOException {
            this.name = name;
            FileWriter fw = new FileWriter("Hilos.txt", true);
            pw = new PrintWriter(fw);
            this.ini = ini;
            this.fin = fin;
            hilo = new Thread(this);
            hilo.start();
        }

        @Override
        public void run() {
            for (int i = ini; i < fin; i++) {
                try {
                    Thread.sleep((int) ((Math.random()*1)+ini*fin));
                    pw.println(i + " " + name + "\n\n\r\r");
                    System.out.println(i + " " + name);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Ejercicio5.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            pw.close();
        }
    }
}
