package introduction;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.applet.Applet;
import java.awt.Graphics;
import java.awt.HeadlessException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author alumno
 */
public class Reloj extends Applet implements Runnable {

    private String hora;
    private String horaCanarias;
    
    private SimpleDateFormat formato;
    
    private Thread hilo;

    public Reloj() throws HeadlessException {
    }
   
    @Override
    public void init() {
        this.setSize(300, 200);
    }
    
    @Override
    public void start() {
        
        formato = new SimpleDateFormat("H:mm:ss");
       
        
        if (hilo == null) {
            hilo = new Thread(this);
            hilo.start();
        }
    }

    @Override
    public void run() {
        Thread hiloActual = Thread.currentThread();
         while (hilo==hiloActual) {
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
     public void paint(Graphics g) {
            g.drawString("Hora:", 50, 50);
            g.drawString(hora, 140, 50);
            
            g.drawString("Hora en Canarias:", 50, 100);
            g.drawString(horaCanarias, 200, 100);
    }

}