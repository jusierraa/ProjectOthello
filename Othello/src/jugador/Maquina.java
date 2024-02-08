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
public class Maquina extends Jugador {

    public Maquina(String nombre, int puntaje,String color) {
        super(nombre, puntaje,color);
    }
    @Override
    public ArrayList comprobar(Tablero tab) {
        int alfa=0;
        int auxi=0,auxj=0;
        ArrayList posicion = new ArrayList();
        for(int i=0;i<tab.getTamano();i++){
            for(int j=0;j<tab.getTamano();j++){
                if(tab.comprobarPosicion(i, j, super.getColor())){
                    if(alfa<tab.ponerTurno(i, j, super.getColor())){
                        alfa=tab.ponerTurno(i, j, super.getColor());
                        auxi=i;
                        auxj=j;
                    }
                }
            }
        }
        posicion.add(auxi);
        posicion.add(auxj);
        return posicion;
    }    
}