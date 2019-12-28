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
    public Jugador(int Vida, int X, int Y, int Ataque, Tablero Tabla) {
        super(Vida, X, Y, Ataque, Tabla);
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
        //Mover en X
        if(Tabla.CasillaVacia(EjeX, Y)){
            Tabla.MoverANuevaCasilla(X, Y, EjeX, Y);
            X=EjeX;
        }
        //Mover en Y
        if(Tabla.CasillaVacia(X, EjeY)){
            Tabla.MoverANuevaCasilla(X, Y, X, EjeY);
            Y=EjeY;
        }
        //Hay Objeto  Enemigo
        //else if(Tabla.EsEnemigo(EjeX, EjeY)){
        //    Tabla.DañarEntidad(EjeX, EjeY, Enemigo.Ataque);
        //}else{
            //No Se Mueve
        //}
     
        EjeX=0;
        EjeY=0;
    }
    private int EjeX,EjeY=0;
    public void Evento(java.awt.event.KeyEvent evt){
        System.out.println(evt.getKeyCode());
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
        }
    }
    @Override
    public void Esperar() {
        try {
            while(this.VidaActual>0){
                Mover();
                Thread.sleep(200);
            }
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }

    }

}
