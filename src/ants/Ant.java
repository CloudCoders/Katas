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

    public void setPoint(Point point) {
        this.point = point;
    }

    private void initPoint() {
        point = new Point();
        int random = Util.getRandom(cm-1);
        point.x = random;
        point.y = random+1;
        sayMyName();
    }

    public Point[] movements(){
        Point[] points = new Point[4];

        int x = point.x;
        int y = point.y;

        points[0] = new Point(x-1, y);
        points[1] = new Point(x, y-1);
        points[2] = new Point(x+1, y);
        points[3] = new Point(x, y+1);

        for (int i = 0; i < points.length; i++){
            Point p = points[i];
            if (p.x < 0 || p.y < 0 || p.x > cm-1 || p.y > cm-1){
                points[i] = point;
            }
        }

        return points;
    }

    public Point move(){
        Point point = new Point();
        do {
            int randomOp = Util.getRandom(2);
            int randomPoint = Util.getRandom(2);
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
            territory.move(point.x, point.y, this);
            //territory.move(point.x, point.y, newPoint.x, newPoint.y);
            //point = newPoint;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void sayMyName(){
        System.out.println(antName+": ("+point.x+","+point.y+")");
    }

}
