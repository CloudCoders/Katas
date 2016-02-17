package introduction;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alumno
 */
public class Ejercicio2 {
    
    Scanner sc = new Scanner(System.in);
    
    public static void main(String[] args){
        new Ejercicio2().load();
    }
   
   public void load(){
       System.out.print("Di un numero mayor de 10 pliz: ");
       boolean bol = true;
       do {
           try {
               int num = Integer.parseInt(sc.nextLine());
               
               if (num > 10) {
                    new Hilo("Hilo 1",true, num).start();
                    new Hilo("Hilo 2",false, num).start();
                    bol = false;
               }else{
                   bol = true;
                   System.out.println("pliz pon un numero mayor de 10");
               }
           } catch (NumberFormatException e) {
               System.out.println("Error introduzca un numero pliz");
           }
       } while (bol);
       
    }
    
   class Hilo extends Thread{
       
       boolean isNormal;
       int cont;
       
       public Hilo(String name, boolean normal, int cont){
           super(name);
           isNormal = normal;
           this.cont = cont;           
       }
       
       @Override
        public void run() {
            if (isNormal) {
                try {                   
                    for (int i = 0; i <= cont; i++) {
                        sleep(1000);
                        System.out.println(i + " "+ getName());
                    }
                } catch (InterruptedException ex) {
                    Logger.getLogger(Ejercicio2.class.getName()).log(Level.SEVERE, null, ex);
                }
                System.out.println("fin pah lante");
           }else{
                try {                    
                    for (int i = cont; i >= 0; i--) {
                        sleep(1000);
                        System.out.println(i + " "+ getName());
                    }
                } catch (InterruptedException ex) {
                    Logger.getLogger(Ejercicio2.class.getName()).log(Level.SEVERE, null, ex);
                }
                System.out.println("Fin pah tras");
            }
        }
   } 
}
