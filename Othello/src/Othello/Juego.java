/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Othello;

import java.util.ArrayList;
import java.util.Scanner;
import jugador.*;

/**
 *
 * @author juan
 */
public class Juego {

    /**
     * @param args the command line arguments
     */
          private static  boolean opc;
    private Jugador jugador1;
    private Jugador jugador2;
    private static Jugador turno;
    private String menu="ingrese la posicion: ";
    private static Tablero tablero;
    public Juego(int a){
        if(a==1){
            jugador1=new Persona("Stark", 0 ,"X");
            jugador2=new Persona("Ultron",0,"O");
        }else{
            jugador1=new Persona("Stark",0,"X");
            jugador2=new Maquina("Ultron", 0,"O");
        }
        this.turno= jugador1;
        tablero = new Tablero(8);
        this.opc = true;
    }
    public Tablero getTablero() {
        return tablero;
    }

    public String getMenu() {
        return menu;
    }

    public  void setMenu(String menu) {
        this.menu = menu;
    }
    
    public Jugador getTurno() {
        return turno;
    }

    public void setTurno(Jugador turno) {
        this.turno = turno;
    }
    
    public  void imprimir(){
        System.out.print("  ");
        for(int i = 0; i<8 ;i++){
            System.out.print(i+" ");
        }
        System.out.println();
        for(int i=0;i<8;i++){
            System.out.print(i+" ");
            for(int j=0;j<8;j++){
                System.out.print(tablero.getMatriz()[i][j].getColor()+" ");
            }
            System.out.println();
        }
    }
    public  boolean movimiento (ArrayList<Integer> a,String color){
        return tablero.senalarPosicion( a.get(0),  a.get(1), color);
    }
    public Juego (){
        tablero=new Tablero(8);
    }
    private boolean comprobarTablero(){
        return tablero.comprobarTablero();
    
    }
    public Jugador traerTurnoContrario(Jugador turno){
        if(turno instanceof Persona){
            return jugador2;
        }else{
            return jugador1;
        }
    }
    public String comprobarFinal(){
        return tablero.comprobarFinal();
    }
    public boolean comprobarFin(String turno){
        return tablero.comprobarFin(turno);
    } 
    public boolean jugar(Tablero tablero){

        boolean opc1=true;
        int x1 = 0,y1 = 0;
        if(movimiento(turno.jugar(tablero),getTurno().getColor())){
                setTurno(traerTurnoContrario(getTurno()));
                opc1=true;
        }else{
                if(comprobarFin(turno.getColor())){
                    opc1=true;
                    System.out.println("movimiento no valido Repite turno ");
                }else if(opc1==true){
                    System.out.println("Usted no posee movimiento, juega el otro jugador ");
                    opc1=false;
                    setTurno(traerTurnoContrario(turno));
                    if (comprobarFin(turno.getColor())){
                    }else{
                        System.out.println(comprobarFinal());
                        opc= false;
                        
                    }
                }else if(opc1==false){
                    System.out.println(comprobarFinal());
                    opc=false;
                }
            }
        return opc;
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        
        Juego juego=new Juego(2);
        juego.setTurno(juego.getTurno());
        juego.imprimir();
        while(juego.jugar(juego.getTablero())){
            System.out.println(juego.getMenu()+juego.getTurno());
            System.out.println("/*********************************************************/");
            juego.imprimir();
        }
    }
}
