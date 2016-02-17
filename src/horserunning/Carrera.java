/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package horserunning;

import java.util.Arrays;

/**
 *
 * @author Antonio López Marín
 */
public class Carrera {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
        int posicion = 1;

        boolean caballo1Meta = false;
        boolean caballo2Meta = false;
        boolean caballo3Meta = false;
        boolean caballo4Meta = false;

        Boolean[] carrera = new Boolean[50];
        Arrays.fill(carrera, 0, carrera.length - 1, false);
        carrera[carrera.length - 1] = true;

        Caballo caballo1 = new Caballo("Caballo 1", Arrays.copyOf(carrera, carrera.length));
        Caballo caballo2 = new Caballo("Caballo 2", Arrays.copyOf(carrera, carrera.length));
        Caballo caballo3 = new Caballo("Caballo 3", Arrays.copyOf(carrera, carrera.length));
        Caballo caballo4 = new Caballo("Caballo 4", Arrays.copyOf(carrera, carrera.length));

        for (int i = 3; i >= 1; i--) {
            Thread.sleep(1000);
            for (int j = 0; j < 25; j++) {
                System.out.println("");
            }
            System.out.println("** Carrera de caballos comenzara en " + i + " **  "
                    + "    ** Meta **\n");
            System.out.println("Caballo 1: |" + getRecorridoCaballo(caballo1.getRecorrido()));
            System.out.println("Caballo 2: |" + getRecorridoCaballo(caballo2.getRecorrido()));
            System.out.println("Caballo 3: |" + getRecorridoCaballo(caballo3.getRecorrido()));
            System.out.println("Caballo 4: |" + getRecorridoCaballo(caballo4.getRecorrido()));
        }

        caballo1.start();
        caballo2.start();
        caballo3.start();
        caballo4.start();

        while (caballo1.isAlive()
                || caballo2.isAlive()
                || caballo3.isAlive()
                || caballo4.isAlive()) {
            Thread.sleep(400);
            for (int i = 0; i < 25; i++) {
                System.out.println("");
            }

            System.out.println("** Carrera de caballos **  "
                    + "                      ** Meta **\n");
            if (!caballo1.isAlive()) {
                if (!caballo1Meta) {
                    caballo1.setPosicion(posicion++);
                }
                caballo1Meta = true;
                System.out.println(caballo1.getResultado()
                        + " en la posicion: " + caballo1.getPosicion());
            }
            if (!caballo2.isAlive()) {
                if (!caballo2Meta) {
                    caballo2.setPosicion(posicion++);
                }
                caballo2Meta = true;
                System.out.println(caballo2.getResultado()
                        + " en la posicion: " + caballo2.getPosicion());
            }
            if (!caballo3.isAlive()) {
                if (!caballo3Meta) {
                    caballo3.setPosicion(posicion++);
                }
                caballo3Meta = true;
                System.out.println(caballo3.getResultado()
                        + " en la posicion: " + caballo3.getPosicion());
            }
            if (!caballo4.isAlive()) {
                if (!caballo4Meta) {
                    caballo4.setPosicion(posicion++);
                }
                caballo4Meta = true;
                System.out.println(caballo4.getResultado()
                        + " en la posicion: " + caballo4.getPosicion());
            }
            System.out.println("");
            System.out.println("Caballo 1: |" + getRecorridoCaballo(caballo1.getRecorrido()));
            System.out.println("Caballo 2: |" + getRecorridoCaballo(caballo2.getRecorrido()));
            System.out.println("Caballo 3: |" + getRecorridoCaballo(caballo3.getRecorrido()));
            System.out.println("Caballo 4: |" + getRecorridoCaballo(caballo4.getRecorrido()));
        }
    }

    public static String getRecorridoCaballo(Boolean[] longitudCaballo) {
        String carrera = "*";
        for (int i = 0; i < longitudCaballo.length; i++) {
            if (longitudCaballo[i]) {
                carrera += "*";
            } else {
                carrera += " ";
            }
        }
        return carrera;
    }
}