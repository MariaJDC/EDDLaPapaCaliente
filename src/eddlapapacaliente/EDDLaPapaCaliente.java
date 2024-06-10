/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eddlapapacaliente;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;
/**
 *
 * @author maria
 */
public class EDDLaPapaCaliente {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) { 
        ListaDobleCircular njugadores=new ListaDobleCircular();
        Scanner sc=new Scanner (System.in);

        FileReader jugadores;
        BufferedReader leer;
        try{
            jugadores=new FileReader("jugadores.in");
            if (jugadores.ready()){
                leer=new BufferedReader(jugadores);
                String njugador;
                while ((njugador=leer.readLine())!=null){
                    System.out.println(njugador);
                    njugadores.Agregar(njugador);
                }
            }else{
                System.out.println("Archivo no capacitado");
            }
        }catch (Exception e){
            System.out.println("Error: "+ e.getMessage());
        }
        
        System.out.println("Ingrese la direccion de la papa");
        System.out.println("I(Izquierda)  D(Derecha)");
        
        String direccion = sc.next();
        njugadores.Jugar(direccion);
        
    }
}
