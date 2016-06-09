package ants;

public class Main {
    public static void main(String... args){
        int territoryDim = 5;
        int antNum = 15;

        Territory territory = new Territory(territoryDim);

        for (int j = 0; j < antNum; j++){
            Ant ant = new Ant("Ant "+j, territory);
            ant.start();
        }

        while (true){
            try {
                Thread.sleep(150);
                for (int i = 0; i < 25; i++){
                    System.out.println();
                }
                showTerritory(territory.getTerritory());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void showTerritory(boolean[][] territory){
       showBounderies(territory.length);
        for (int x = 0; x < territory.length; x++){
            for (int y = 0; y < territory[x].length; y++){
                System.out.print("|"+isAntInPoint(territory, x, y));
                if (y == territory[x].length-1){
                    System.out.print("|");
                }
            }
            System.out.println();
        }
        showBounderies(territory.length);
    }

    private static void showBounderies(int length) {
        for (int i = 0; i < length*2; i++){
            System.out.print("-");
        }
        System.out.println();
    }

    private static String isAntInPoint(boolean[][] territory, int x, int y){
        return territory[x][y]? "*" : " ";
    }
}
