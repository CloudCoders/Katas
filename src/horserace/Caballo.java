/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package horserace;

import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Antonio López Marín
 */
public class Caballo extends Thread{
    
    private Boolean[] longitud;
    private int posicion;
    private String resultado;
    private boolean haTerminado;
    
    public Caballo(String name, Boolean[] longitud) {
        super(name);
        this.longitud = longitud;
        resultado = "";
        haTerminado = false;
    }

    public boolean isHaTerminado() {
        return haTerminado;
    }

    public void setHaTerminado(boolean haTerminado) {
        this.haTerminado = haTerminado;
    }

    public void setPosicion(int posicion){
        this.posicion = posicion;
    }
    
    public int getPosicion(){
        return posicion;
    }
    
    public Boolean[] getRecorrido(){
        return Arrays.copyOf(longitud, longitud.length);
    }
    
    @Override
    public void run() {
        for (int i = 0; i < longitud.length; i++) {
            longitud[i] = true;
            Arrays.fill(longitud, 0, i, false);
            try {
                Thread.sleep((int)(Math.random()*1000)+0);
            } catch (InterruptedException ex) {
                Logger.getLogger(Caballo.class.getName())
                        .log(Level.WARNING, null, ex);
            }
        }
        resultado = "El "+getName()+" ha terminado la carrera";
        haTerminado = true;
    }  

    public String getResultado() {
        return resultado;
    }
}
