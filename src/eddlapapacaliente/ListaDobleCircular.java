package eddlapapacaliente;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author maria
 */
public class ListaDobleCircular {
    Nodo L;
    Nodo aux;
    
    void Agregar(String dato){
        if (L==null){
            L=new Nodo(dato);
            L.siguiente=L;
            L.anterior=L;
        }else{
            aux=L;
            while(aux.siguiente!=L){
                aux=aux.siguiente;
            }
            aux.siguiente=new Nodo(dato,aux);
            Nodo aux2=null;
            aux2=aux;
            aux=aux.siguiente;
            aux.siguiente=L;
            aux.anterior=aux2;
            L.anterior=aux;
        }
    }
    
    String SentidoHorario(int num){
        String nombreperdedor=null;
        aux=L;
        Nodo aux2 = null;
        int i=0;
        while(i!=num){
            aux2 = aux;
            aux=aux.siguiente;
            i++;
        }
        nombreperdedor=aux.dato;
        if (aux==L){
            L=aux.siguiente;
        }
        
        if(aux2 == null){
            aux2 = aux.anterior;
        }
        
        aux = aux.siguiente;
        aux2.siguiente=aux;
        aux.anterior=aux2;
        return nombreperdedor;
    }
    
    String SentidoAntihorario(int num){
        String nombreperdedor=null;
        aux=L;
        Nodo aux2 = null;
        int i=0;
        while(i!=num){
            aux2 = aux;
            aux=aux.anterior;
            i++;
        }
        nombreperdedor=aux.dato;
        if (aux==L){
            L=aux.siguiente;
        }
        
        if(aux2 == null){
            aux2 = aux.siguiente;
        }
        
        aux = aux.anterior;
        aux2.anterior=aux;
        aux.siguiente=aux2;
        return nombreperdedor;
    }
        
    void EliminarJugador(String direc, int numexp){
        String perdedor = null;
        if (direc.equals("I")){
            perdedor = SentidoAntihorario(numexp);
        }else if(direc.equals("D")){
            perdedor = SentidoHorario(numexp);
        }
                    
        try
        {            
            FileWriter fw = new FileWriter("perdedores.out", true);
            fw.write(perdedor);
            fw.write(System.lineSeparator()); // Añadir una nueva línea después de cada línea
            fw.close();
        } catch (Exception e) {
            System.out.print("Error:" + e.getMessage());
        }
    }
    
    void Jugar(String direc){
        try {
            Files.deleteIfExists(Paths.get("perdedores.out"));
            Files.deleteIfExists(Paths.get("ganador.out"));
        } catch (IOException ex) {
            System.out.print("Error:" + ex.getMessage());
        }

        while (L.siguiente!=L && L.anterior!=L){
            int num=(int) (Math.random() * 100);
            EliminarJugador(direc, num);
        }
        
        try
        {            
            FileWriter fw = new FileWriter("ganador.out", true);
            fw.write(L.dato);
            fw.write(System.lineSeparator()); // Añadir una nueva línea después de cada línea
            fw.close();
        } catch (Exception e) {
            System.out.print("Error:" + e.getMessage());
        }
    }
}
