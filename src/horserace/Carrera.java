/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package horserace;

import java.util.Arrays;

/**
 *
 * @author Antonio López Marín
 */
public class Carrera {

    private static int posicion = 1;

    private static void showCaballo(Caballo caballo){
        System.out.println(caballo.getName()+": |" + getRecorridoCaballo(caballo.getRecorrido()));
    }

    private static void showCaballos(Caballo[] caballos){
        for (int i = 0; i < caballos.length; i++){
            showCaballo(caballos[i]);
        }
    }

    private static  void startCaballos(Caballo[] caballos){
        for (int i = 0; i < caballos.length; i++){
            caballos[i].start();
        }
    }

    private static boolean caballosAlive(Caballo[] caballos){
        boolean result = false;

        for (int i = 0; i < caballos.length; i++){
            result = result || caballos[i].isAlive();
        }

        return result;
    }

    private static void showCarrera(Caballo[] caballos){
        System.out.println("** Carrera de caballos **  "
                + "                      ** Meta **\n");
        for (int i = 0; i < caballos.length; i++){
            Caballo caballo = caballos[i];
            if (!caballo.isAlive()) {
                if (caballo.isHaTerminado()) {
                    caballo.setPosicion(posicion++);
                    caballo.setHaTerminado(false);
                }
                System.out.println(caballo.getResultado()
                        + " en la posicion: " + caballo.getPosicion());
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

        Caballo[] caballos = new Caballo[4];
        for (int c = 0; c < caballos.length; c++){
            caballos[c] = new Caballo("Caballo "+c, Arrays.copyOf(carrera, carrera.length));
        }

        for (int i = 3; i >= 1; i--) {
            Thread.sleep(1000);
            for (int j = 0; j < 25; j++) {
                System.out.println("");
            }
            System.out.println("** Carrera de caballos comenzara en " + i + " **  "
                    + "    ** Meta **\n");
            showCaballos(caballos);
        }

        startCaballos(caballos);


        while (caballosAlive(caballos)) {
            Thread.sleep(400);
            for (int i = 0; i < 25; i++) {
                System.out.println("");
            }

            showCarrera(caballos);
            System.out.println("");
            showCaballos(caballos);
        }
    }

    public static String getRecorridoCaballo(Boolean[] longitudCaballo) {
        String carrera = "";
        for (int i = 0; i < longitudCaballo.length; i++) {
            if (i == longitudCaballo.length-1){
                carrera += "(¡)";
            }else if (longitudCaballo[i]) {
                carrera += "(_)_)==D";
            }else {
                carrera += " ";
            }
        }
        return carrera;
    }
}