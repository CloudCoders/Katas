package ants;

import java.util.Arrays;

/**
 * Created by toni on 17/02/16.
 */
public class Territory {

    private boolean[][] territory;
    private int cm;

    public Territory(int cm) {
        this.cm = cm;
        territory = new boolean[cm][cm];
        for (int i = 0; i < territory.length; i++){
            Arrays.fill(territory[i], 0, territory[i].length, false);
        }
    }

    public int getCm() {
        return cm;
    }

    public boolean[][] getTerritory() {
        return territory;
    }

    public synchronized void move(int x0, int y0, int x, int y){
        while(territory[x][y]){
            try {
                System.out.println("DEJAME PASAR CABRON!!!");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        territory[x0][y0] = false;
        territory[x][y] = true;
        notifyAll();
    }
}
