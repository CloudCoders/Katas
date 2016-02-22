package ants;

import java.awt.*;

/**
 * Created by toni on 17/02/16.
 */
public class Ant extends Thread {

    private Territory territory;
    private Point point;
    private int cm;
    private String antName;

    public Ant(String antName, Territory territory){
        this.antName = antName;
        this.territory = territory;
        this.cm = territory.getCm();
        initPoint();
    }

    private void initPoint() {
        point = new Point();
        int random = getRandom(cm-1);
        point.x = random;
        point.y = random+1;
        sayMyName();
    }

    private int getRandom(int bounder){
        return (int)((Math.random()*bounder));
    }

    public Point move(){
        Point point = new Point();
        do {
            int randomOp = getRandom(2);
            int randomPoint = getRandom(2);
            if (randomOp == 0){
                point.x = moveX(randomPoint);
                point.y = this.point.y;
            }else{
                point.y = moveY(randomPoint);
                point.x = this.point.x;
            }
        }while (this.point.x == point.x && this.point.y == point.y);

        return point;
    }

    private int moveX(int op){
        if (op == 0){
            if (point.x == cm-1){
                return point.x - 1;
            }
            return point.x + 1;
        }else{
            if (point.x == 0){
                return point.x + 1;
            }
            return point.x - 1;
        }
    }

    private int moveY(int op){
        if (op == 0){
            if (point.x == cm-1){
                return point.x - 1;
            }
            return this.point.x + 1;
        }else{
            if (point.y == 0){
                return point.y + 1;
            }
            return this.point.y - 1;
        }
    }

    @Override
    public void run() {
        while (true){
            Point newPoint = move();
            //System.out.println(antName+": ("+point.x+","+point.y+") to ("+newPoint.x+","+newPoint.y+")");
            territory.move(point.x, point.y, newPoint.x, newPoint.y);
            point = newPoint;
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void sayMyName(){
        System.out.println(antName+": ("+point.x+","+point.y+")");
    }

}
