/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jugador;

import Othello.Juego;
import Othello.Tablero;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author juan
 */
public class Persona extends Jugador{

    public Persona(String nombre, int puntaje,String color) {
        super(nombre, puntaje,color);
    }
    
    @Override
    public ArrayList comprobar(Tablero tab) {
        ArrayList<Integer> posicion=new ArrayList();
        int x=Integer.parseInt(JOptionPane.showInputDialog(null,"Ingrese x"));
        int y=Integer.parseInt(JOptionPane.showInputDialog(null,"Ingrese y"));
        posicion.add(x);
        posicion.add(y);
        return posicion;
    }
    
   

    
    
}
