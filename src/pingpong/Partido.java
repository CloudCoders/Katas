/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pingpong;

/**
 *
 * @author alumno
 */
public class Partido {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
        Golpear golpear = new Golpear();
        Arbitro arbitro = new Arbitro(golpear);
        
        Jugador jugador1 = new Jugador(golpear, "PING");
        Jugador jugador2 = new Jugador(golpear, "PONG");
        
        //Se preparan el jugador uno y el jugador dos
        jugador1.start();
        jugador2.start();
        
        //El arbitro se presenta en la cancha
        arbitro.start();
        
        jugador1.join();
        System.out.println("Termino 1");
        jugador2.join();
        System.out.println("Termino 2");        
    }
    
}
