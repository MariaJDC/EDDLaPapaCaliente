package eddlapapacaliente;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author maria
 */
public class Nodo {
    Nodo anterior;
    Nodo siguiente;
    String dato;
    public Nodo(String njugador){
        this.dato=njugador;
    }
    public Nodo(String njugador,Nodo anterior){
        this.dato=njugador;
        this.anterior=anterior;
    }
            
}
