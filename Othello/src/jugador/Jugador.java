/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jugador;

import Othello.Juego;
import Othello.Tablero;
import java.util.ArrayList;

/**
 *
 * @author juan
 */
public abstract class Jugador {
    private int puntaje; 
    private String nombre;
    private String color;
    private ArrayList posiciones= new ArrayList();
    public Jugador(String nombre, int puntaje,String color){
        this.nombre=nombre;
        this.puntaje=puntaje;
        this.color = color;
    }

    public int getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(int puntaje) {
        this.puntaje = puntaje;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
    
    public ArrayList jugar(Tablero tab){
        return this.comprobar(tab);
    }
    public abstract ArrayList comprobar(Tablero tab);   
}
