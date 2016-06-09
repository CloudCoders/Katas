package ants;

import java.awt.*;
import java.util.Arrays;

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

    public synchronized void move(int x0, int y0, Ant ant){
        Point[] points = ant.movements();
        Point p = points[Util.getRandom(points.length)];
        while(territory[p.x][p.y]){
            try {
                //System.out.println(ant.getName()+" is stoped");
                p = points[Util.getRandom(points.length)];
                notifyAll();
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        ant.setPoint(p);
        territory[x0][y0] = false;
        territory[p.x][p.y] = true;
        notifyAll();
    }

    public synchronized void move(int x0, int y0, int x, int y){
        while(territory[x][y]){
            try {
                System.out.println("stoped ant");
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
