/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Othello;

/**
 *
 * @author juan
 */
public class Tablero {
    private static Ficha[][] matriz;
    private static int tamano;
    public Tablero (int tamano){
        this.tamano=tamano;
        matriz=new Ficha[tamano][tamano];
        inicializarTablero();
        
    }

    public int getTamano() {
        return tamano;
    }

    public void setTamano(int tamaño) {
        this.tamano = tamaño;
    }
    
    private void inicializarTablero() {
        Ficha ficha;
        for(int i=0;i<tamano;i++){
            for(int j=0;j<tamano;j++){
                ficha=new Ficha();
                ficha.setColor("-");
                matriz[i][j]=ficha;
            }
        }
        matriz [3][3].setColor("O");
        matriz [4][4].setColor("O");
        matriz [3][4].setColor("X");
        matriz [4][3].setColor("X");
    }
    public boolean comprobarPosicion(int x,int y,String color ){
        if (((comprobarDiagonal(x,y,color)) || (comprobarHorizontal(x,y,color)) || (comprobarVertical(x,y,color)))&& matriz[x][y].getColor().equals("-")){
             return true;
        }else   {
            return false;
        }
    }
    public boolean senalarPosicion(int x,int y,String color ){
        if (((comprobarDiagonal(x,y,color)) || (comprobarHorizontal(x,y,color)) || (comprobarVertical(x,y,color)))&& matriz[x][y].getColor().equals("-")){
            realizarMovimiento(x,y,color);
            cambiarFicha(x,y,color);
            
            return true;
        }else   {
            return false;
        }
    }
    public boolean comprobarTablero(){
        for(int i=0;i<tamano;i++){
            for(int j=0;j<tamano;j++){
                matriz[i][j].getColor();
                if (matriz[i][j].getColor().equals("-")){
                    return true;
                }
            }
        }
        return false;
    }
    public String comprobarFinal(){
        int aux=0;
        int aux2=0;
        for(int i=0;i<tamano;i++){
            for(int j=0;j<tamano;j++){
                matriz[i][j].getColor();
                if (matriz[i][j].getColor().equals("O")){
                    aux++;
                }else{
                    aux2++;
                }
            }
        }
        if(aux>aux2){
            return "El ganador es circulo con"+ aux+"Fichas";
        }else{
           return "El ganador es X con"+ aux2+"Fichas";
        }
    }
    public Ficha[][] getMatriz() {
        return matriz;
    }
    

    private boolean comprobarHorizontal(int x, int y,String color) {
        if (comprobarIzquierda(x, y, color)|| comprobarDerecha(x, y, color)){
            return true;
        }
        else{
            return false;
        }
        
    }
    private boolean comprobarArriba(int x, int y, String color){
        if(x!=0 && (!matriz[x-1][y].getColor().equals(color)&& !matriz[x-1][y].getColor().equals("-"))){
                for(int i=x-1;i>=0;i--){
                    if(matriz[i][y].getColor().equals(color)){
                        return true;
                    }
                }
            }
        return false;
    }
    private boolean comprobarAbajo(int x,int y,String color){
        if(x!=7 &&(!matriz[x+1][y].getColor().equals(color)&& !matriz[x+1][y].getColor().equals("-"))){
                for(int i=x+1;i<tamano;i++){
                    if(matriz[i][y].getColor().equals(color)){
                        return true;
                    }
                }
            }
        return false;
    }
    private boolean comprobarDerecha(int x,int y,String color){
        
        if (y != 7 && (!matriz[x][y + 1].getColor().equals(color) && !matriz[x][y + 1].getColor().equals("-"))) {
            for (int j = y + 1; j < tamano; j++) {
                if (matriz[x][j].getColor().equals(color)) {
                    return true;
                }
            }
        }
        return false;
    }
    private boolean comprobarIzquierda(int x,int y,String color){
        if(y!=0 &&(!matriz[x][y-1].getColor().equals(color)&& !matriz[x][y-1].getColor().equals("-"))){
                for(int j=y-1;j>=0;j--){
                    if(matriz[x][j].getColor().equals(color)){
                        return true;
                    }
                }
            }
        return false;
    }

    private boolean comprobarVertical(int x, int y,String color) {
        if (comprobarArriba(x, y, color)|| comprobarAbajo(x, y, color)){
            return true;
        }
        else{
            return false;
        }
    }

    private void cambiarFicha(int x, int y,String color) {
        cambiarArriba(x,y,color);
        cambiarAbajo(x,y,color);
        cambiarIzquierda(x,y,color);
        cambiarDerecha(x,y,color);
        cambiarArribaDerecha(x,y,color);
        cambiarArribaIzquierda(x,y,color);        cambiarAbajoDerecha(x,y,color);
        cambiarAbajoIzquierda(x,y,color);
    }

    private void realizarMovimiento(int x, int y,String color) {
        matriz[x][y].setColor(color);
    }

    private void cambiarArriba(int x, int y, String color) {
        if(comprobarArriba(x, y, color)){
            while((!matriz[x-1][y].getColor().equals(color))&&(x>1)){
                matriz[x-1][y].setColor(color);
                x=x-1;
            }
        }
    }

    private void cambiarAbajo(int x, int y, String color) {
        if(comprobarAbajo(x,y,color)){
               while((x<7)&&(!matriz[x+1][y].getColor().equals(color))){
                matriz[x+1][y].setColor(color);
                x=x+1;
                }
        }
    }

    private void cambiarIzquierda(int x, int y, String color) {
       if(comprobarIzquierda(x, y, color)){
            while((y>1)&&(!matriz[x][y-1].getColor().equals(color))){
                matriz[x][y-1].setColor(color);
                y=y-1;
            }
       }
    }

    private void cambiarDerecha(int x, int y, String color) {
       if(comprobarDerecha(x, y, color)){
            while((y<7)&&(!matriz[x][y+1].getColor().equals(color))){
                matriz[x][y+1].setColor(color);
                y=y+1;
            }
       }
    }  
    private boolean comprobarArribaDerecha(int x, int y,String color) {
        int i = x;
        int j = y;
        if (x>0 && y<7 && (!matriz[x-1][y+1].getColor().equals(color) && !matriz[x-1][y+1].getColor().equals("-"))) {
            while (i>0 && j<7) {
                if (matriz[i-1][j+1].getColor().equals(color)) {
                    return true;
                }
            i--;
            j++;
            }
        }
        return false;
    }
    private void cambiarArribaDerecha(int x, int y,String color){
         if(comprobarArribaDerecha(x, y, color)){
            while((y<7)&&(x>0)&&(!matriz[x-1][y+1].getColor().equals(color))){
                matriz[x-1][y+1].setColor(color);
                y=y+1;
                x=x-1;
            }
       }
    }
    private boolean comprobarArribaIzquierda(int x, int y,String color) {
        int i = x;
        int j = y;
        if (x>0 && y>0 && (!matriz[x-1][y-1].getColor().equals(color) && !matriz[x-1][y-1].getColor().equals("-"))) {
            while (i>0 && j>0) {
                if (matriz[i-1][j-1].getColor().equals(color)) {
                    return true;
                }
            i--;
            j--;
            }
        }
        return false;
    }
    private void cambiarArribaIzquierda(int x, int y,String color){
         if(comprobarArribaIzquierda(x, y, color)){
            while((y>0)&&(x>0)&&(!matriz[x-1][y-1].getColor().equals(color))){
                matriz[x-1][y-1].setColor(color);
                y=y-1;
                x=x-1;
            }
       }
    }
    private boolean comprobarAbajoDerecha(int x, int y,String color) {
        int i = x;
        int j = y;
        if (x<7 && y<7 && (!matriz[x+1][y+1].getColor().equals(color) && !matriz[x+1][y+1].getColor().equals("-"))) {
            while (i<7 && j<7) {
                if (matriz[i+1][j+1].getColor().equals(color)) {
                    return true;
                }
            i++;
            j++;
            }
        }
        return false;
    }
    private void cambiarAbajoDerecha(int x, int y,String color){
         if(comprobarAbajoDerecha(x, y, color)){
            while((y<7)&&(x<7)&&(!matriz[x+1][y+1].getColor().equals(color))){
                matriz[x+1][y+1].setColor(color);
                y=y+1;
                x=x+1;
            }
       }
    }
    private boolean comprobarAbajoIzquierda(int x, int y,String color) {
        int i = x;
        int j = y;
        if (x<7 && y>0 && (!matriz[x+1][y-1].getColor().equals(color) && !matriz[x+1][y-1].getColor().equals("-"))) {
            while (i<7 && j>0) {
                if (matriz[i+1][j-1].getColor().equals(color)) {
                    return true;
                }
            i++;
            j--;
            }
        }
        return false;
    }
    private void cambiarAbajoIzquierda(int x, int y,String color){
         if(comprobarAbajoIzquierda(x, y, color)){
            while((y>0)&&(x<7)&&(!matriz[x+1][y-1].getColor().equals(color))){
                matriz[x+1][y-1].setColor(color);
                y=y-1;
                x=x+1;
            }
       }
    }
    private boolean comprobarDiagonal(int x, int y, String color) {
        if (comprobarArribaDerecha(x,y,color) || comprobarArribaIzquierda(x,y,color)|| comprobarAbajoDerecha(x,y,color)|| comprobarAbajoIzquierda(x,y,color)){
            return true;
        }
        return false;
    }
    public boolean comprobarFin(String color){
        
        for (int i = 0; i < tamano; i++) {
            for (int j = 0; j < tamano; j++) {
                if (((comprobarDiagonal(i, j, color)) || (comprobarHorizontal(i, j, color)) || (comprobarVertical(i, j, color))) && matriz[i][j].getColor().equals("-")) {
                     return true;
                } 
                
            }

        }
        return false;
    }
    
    /**************************************************************************************************/
    /*Metodos de comprobar movimientos y cambiar
    
    /**************************************************************************************************/
    private int colocarArriba(int x, int y, String color) {
        int contarriba=0;
        if(comprobarArriba(x, y, color)){
            while((!matriz[x-1][y].getColor().equals(color))&&(x>1)){
                contarriba=contarriba+1;
                x=x-1;
            }
        }
        return contarriba;
    }

    private int colocarAbajo(int x, int y, String color) {
        int contabajo=0;
        if(comprobarAbajo(x,y,color)){
               while((x<7)&&(!matriz[x+1][y].getColor().equals(color))){
                contabajo=contabajo+1;
                x=x+1;
                }
        }
        return contabajo;
    }

    private int colocarIzquierda(int x, int y, String color) {
       int contizquierda=0; 
       if(comprobarIzquierda(x, y, color)){
            while((y>1)&&(!matriz[x][y-1].getColor().equals(color))){
                contizquierda=contizquierda+1;
                y=y-1;
            }
       }
       return contizquierda;
    }

    private int colocarDerecha(int x, int y, String color) {
        int contderecha=0;
       if(comprobarDerecha(x, y, color)){
            while((y<7)&&(!matriz[x][y+1].getColor().equals(color))){
                contderecha=contderecha+1;
                y=y+1;
            }
       }
        return contderecha;
    } 
    private int colocarAbajoIzquierda(int x, int y,String color){
        int contabajoizquierda=0;
         if(comprobarAbajoIzquierda(x, y, color)){
            while((y>0)&&(x<7)&&(!matriz[x+1][y-1].getColor().equals(color))){
                contabajoizquierda=contabajoizquierda+1;
                y=y-1;
                x=x+1;
            }
       }
        return contabajoizquierda;
    }
    private int colocarArribaDerecha(int x, int y,String color){
        int contarribaderecha=0;
         if(comprobarArribaDerecha(x, y, color)){
            while((y<7)&&(x>0)&&(!matriz[x-1][y+1].getColor().equals(color))){
                contarribaderecha=contarribaderecha+1;
                y=y+1;
                x=x-1;
            }
       }
        return contarribaderecha;
    }
    private int colocarArribaIzquierda(int x, int y,String color){
        int contarribaizquierda=0;
         if(comprobarArribaIzquierda(x, y, color)){
            while((y>0)&&(x>0)&&(!matriz[x-1][y-1].getColor().equals(color))){
                contarribaizquierda=contarribaizquierda+1;
                y=y-1;
                x=x-1;
            }
       }
        return contarribaizquierda;
    }
    private int colocarAbajoDerecha(int x, int y,String color){
        int contabajoderecha=0;
         if(comprobarAbajoDerecha(x, y, color)){
            while((y<7)&&(x<7)&&(!matriz[x+1][y+1].getColor().equals(color))){
               contabajoderecha=contabajoderecha+1;
                y=y+1;
                x=x+1;
            }
       }
        return contabajoderecha;
    }
    
    private int colocarVertical(int x, int y,String color) {
        return colocarArriba(x, y, color)+ colocarAbajo(x, y, color);
    }
    private int colocarHorizontal(int x, int y,String color) {
       return colocarIzquierda(x, y, color)+ colocarDerecha(x, y, color);
        
    }
    private int colocarDiagonal(int x, int y, String color) {
        return colocarArribaDerecha(x,y,color) + colocarArribaIzquierda(x,y,color)+ colocarAbajoDerecha(x,y,color)+ colocarAbajoIzquierda(x,y,color);
    }
    public int ponerTurno(int x,int y,String color ){
        if (((colocarDiagonal(x,y,color)) >= (colocarHorizontal(x,y,color)))){
            if ((((colocarDiagonal(x,y,color)>= colocarVertical(x,y,color))))){
                return colocarDiagonal(x,y,color);
            }
            else{
                return colocarVertical(x,y,color);
            }
        }else{
             if ((((colocarHorizontal(x,y,color)>= colocarVertical(x,y,color))))){
                return colocarHorizontal(x,y,color);
            }
            else{
                return colocarVertical(x,y,color);
            }
        }
    }
}
/* (colocarVertical(x,y,color))*/