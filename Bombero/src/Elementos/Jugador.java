/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Elementos;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author 50241
 */
public class Jugador extends Entidad {
    private int BombasEspeciales;
    public void MasBombas(int B){
        this.BombasEspeciales=this.BombasEspeciales+B;
    }
    public Jugador(int Vida, int X, int Y, int Ataque, Tablero []Tabla) {
        super(Vida, X, Y, Ataque, Tabla);
        this.BombasEspeciales=0;
    }
    @Override
    public int Rango(){
        if(this.BombasEspeciales>0){
           this.BombasEspeciales--;
           return 2;
        }else{
        
            if(this.BombasEspeciales<0)
                this.BombasEspeciales=0;
            
            return 1;
        }
    }

    @Override
    public int Tipo() {
        return 3;
    }

    @Override
    public String Info() {
        return "Jugador: " + super.X + "," + super.Y;
    }


    @Override
    public void Mover() {
        //Mover
        EjeX=Margen(X,EjeX);  
        EjeY=Margen(Y,EjeY);  
        //Casilla Vacia
        //Hay Objeto  Enemigo
         if(Tabla.EsEnemigo(EjeX, Y)){
            Tabla.DañarJugador();
            System.out.println("Choque");
        }else
         if(Tabla.EsEnemigo(X, EjeY)){
            Tabla.DañarJugador();
            System.out.println("Choque");
        }
        
        //Mover en X
        if(Tabla.CasillaVacia(EjeX, Y)){
            if(Tabla.MoverANuevaCasilla(this, EjeX, Y))
            X=EjeX;
        }
        //Mover en Y
        if(Tabla.CasillaVacia(X, EjeY)){
            if(Tabla.MoverANuevaCasilla(this, X, EjeY))
            Y=EjeY;
        }
        
            //No Se Mueve
     
        EjeX=0;
        EjeY=0;
    }
    public int Especiales(){
        return this.BombasEspeciales;
    }
    private int EjeX,EjeY=0;
    public void Evento(java.awt.event.KeyEvent evt){
        int Evento=evt.getKeyCode();
        if(Evento==37)
        {
            EjeX=-1;
            //Izquierda
        }else if(Evento==38)
        {
            //Arriba
            EjeY=-1;
        }else if(Evento==39)
        {
            //Derecha
            EjeX=1;
        }else if(Evento==40)
        {
            //Abajo
            EjeY=1;
        }else if(Evento==32)
        {
            Tablero[] Arra= {Tabla};
            
            //Bomba
            int Rango=1;
            boolean Especial=false;
            if(BombasEspeciales>0){
                Rango=2;
                Especial=true;
                BombasEspeciales--;
            }
            if(!this.Tabla.PonerBomba(new Bomba(1,X,Y,this.Ataque,Arra,Rango), X, Y)){
                if(Especial)
                    BombasEspeciales++;
            }
        }
    }
    
    @Override
    public void Esperar() {
        try {
            while(this.VidaActual>0 ){
                Mover();
                //this.VidaActual=3;
                Thread.sleep(200);
            }
            // Thread.sleep(700);
            //System.out.println("Menu de Juego Acabado   " + this.VidaActual);

        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }

    }

}
