package introduction;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.applet.Applet;
import java.awt.Graphics;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author alumno
 */
public class Ejercicio4 extends Applet {

    private String hora;
    private String horaCanarias;
    private SimpleDateFormat formato;

    @Override
    public void init() {
        this.setSize(300, 200);
        new Hilo().start();
    }

    class Hilo extends Thread {
        
        public Hilo() {
            formato = new SimpleDateFormat("H:mm:ss");
        }
        
        @Override
        public void run() {
            while (true) {
                Date date = new Date();
                hora = formato.format(date);
                
                date.setHours(date.getHours()-1);
               horaCanarias = formato.format(date);
                
                try {
                    Thread.sleep(500);
                } catch (InterruptedException ex) {
                    System.out.println("Error al dormir el hilo");
                }

                repaint();
            }

        }


    }
     public void paint(Graphics g) {
            g.drawString("Hora:", 50, 50);
            g.drawString(hora, 140, 50);
            
            g.drawString("Hora en Canarias:", 50, 100);
            g.drawString(horaCanarias, 200, 100);
    }
}
