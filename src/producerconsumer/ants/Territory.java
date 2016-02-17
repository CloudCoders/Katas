package producerconsumer.ants;

/**
 * Created by toni on 17/02/16.
 */
public class Territory {

    private boolean[][] territory;
    private int cm;

    public Territory(int cm) {
        territory = new boolean[cm][cm];
        for (int i = 0; i < territory.length; i++){
            for (int j = 0; j < territory[i].length; j++){
                territory[i][j] = false;
            }
        }
    }

    public int getCm() {
        return cm;
    }

    public synchronized void move(int x0, int y0, int x, int y){
        while(territory[x][y]){
            try {
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
