package Elementos;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 50241
 */
public abstract class Entidad extends Thread{
    protected int VidaActual,Ataque;  
    protected int X,Y;
    private int Rango;
    protected Tablero Tabla;
    public int Rango(){
        return Rango;
    }
    public Entidad(int Vida,int X,int Y,int Ataque,Tablero []Tabla){
        this.X=X;
        this.Y=Y;
        this.Ataque=Ataque;
        this.VidaActual=Vida;
        this.Tabla=Tabla[0];
    }
    public void Terminar(){
        this.VidaActual=0;
        this.Limpiar();
    }
    public Entidad(int Vida,int X,int Y,int Ataque,Tablero []Tabla,int Rango){
        this.X=X;
        this.Y=Y;
        this.Ataque=Ataque;
        this.VidaActual=Vida;
        this.Tabla=Tabla[0];
        this.Rango=Rango;
    }
    @Override
    public void run() {
        Esperar();
    }
     protected int Margen(int Coordenada,int Random){
        switch(Random){
            case 0:
                Random=0;
                break;
            case 1:
                Random=1;
                break;
            default:
                Random=-1;
                break;
        }
        
        if(Coordenada+Random<=11 && Coordenada+Random>=0){
            Coordenada=Coordenada+Random;
        }
        return Coordenada;
    }
    public abstract void Esperar();
    public abstract int Tipo();
    public abstract String Info();
    public abstract void Mover();
    public void Limpiar(){
        this.Tabla=null;
    }
    public void RecibirDaño(int Daño){
        this.VidaActual=this.VidaActual-1;
    }
    public int Atacar(){
        return Ataque;
    }
    public boolean EsJugador(){
        return false;
    }
    public int VidaActual(){
        return VidaActual;
    }
}
