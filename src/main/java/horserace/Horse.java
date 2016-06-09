/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package horserace;

import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Horse extends Thread{
    
    private Boolean[] length;
    private int position;
    private String result;
    private boolean hasFinished;
    
    public Horse(String name, Boolean[] length) {
        super(name);
        this.length = length;
        result = "";
        hasFinished = false;
    }

    public boolean isFinished() {
        return hasFinished;
    }

    public void setHasFinished(boolean hasFinished) {
        this.hasFinished = hasFinished;
    }

    public void setPosition(int position){
        this.position = position;
    }
    
    public int getPosition(){
        return position;
    }
    
    public Boolean[] getTour(){
        return Arrays.copyOf(length, length.length);
    }
    
    @Override
    public void run() {
        for (int i = 0; i < length.length; i++) {
            length[i] = true;
            Arrays.fill(length, 0, i, false);
            try {
                Thread.sleep((int)(Math.random()*1000)+0);
            } catch (InterruptedException ex) {
                Logger.getLogger(Horse.class.getName())
                        .log(Level.WARNING, null, ex);
            }
        }
        result = "The "+getName()+" has finished the race";
        hasFinished = true;
    }  

    public String getResult() {
        return result;
    }
}
