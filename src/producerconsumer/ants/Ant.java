package producerconsumer.ants;

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
        int random = (int)((Math.random()*0)+cm-1);
        point.x = random;
        point.y = random+1;
        sayMyName();
    }

    private Point move(){

        return null;
    }

    @Override
    public void run() {
        int cm = territory.getCm();
        while (true){

        }
    }

    public void sayMyName(){
        System.out.println(antName+": ("+point.x+","+point.y+")");
    }

}
