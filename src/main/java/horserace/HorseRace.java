/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package horserace;

import java.util.Arrays;

public class HorseRace {

    private static int position = 1;

    private static void showHorse(Horse horse){
        System.out.println(horse.getName()+": |" + getRecorridoCaballo(horse.getTour()));
    }

    private static void showHorses(Horse[] horses){
        for (Horse horse : horses) {
            showHorse(horse);
        }
    }

    private static  void starRace(Horse[] horses){
        for (Horse horse : horses) {
            horse.start();
        }
    }

    private static boolean horsesAlive(Horse[] horses){
        boolean result = false;

        for (Horse horse : horses) {
            result = result || horse.isAlive();
        }

        return result;
    }

    private static void showRace(Horse[] horses){
        System.out.println("** Horse race **  "
                + "                      ** Finishe line **\n");
        for (Horse horse : horses) {
            if (!horse.isAlive()) {
                if (horse.isFinished()) {
                    horse.setPosition(position++);
                    horse.setHasFinished(false);
                }
                System.out.println(horse.getResult()
                        + " at position: " + horse.getPosition());
            }
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
        Boolean[] carrera = new Boolean[50];
        carrera[0] = true;
        Arrays.fill(carrera, 1, carrera.length, false);

        Horse[] horses = new Horse[4];
        for (int c = 0; c < horses.length; c++){
            horses[c] = new Horse("Horse "+c, Arrays.copyOf(carrera, carrera.length));
        }

        for (int i = 3; i >= 1; i--) {
            Thread.sleep(1000);
            for (int j = 0; j < 25; j++) {
                System.out.println("");
            }
            System.out.println("** HorseRace strat on " + i + " **  "
                    + "    ** Meta **\n");
            showHorses(horses);
        }

        starRace(horses);


        while (horsesAlive(horses)) {
            Thread.sleep(400);
            for (int i = 0; i < 25; i++) {
                System.out.println("");
            }

            showRace(horses);
            System.out.println("");
            showHorses(horses);
        }
    }

    public static String getRecorridoCaballo(Boolean[] longitudCaballo) {
        String carrera = "";
        for (int i = 0; i < longitudCaballo.length; i++) {
            if (i == longitudCaballo.length-1){
                carrera += "*";
            }else if (longitudCaballo[i]) {
                carrera += "|->";
            }else {
                carrera += " ";
            }
        }
        return carrera;
    }
}