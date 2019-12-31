package Carga;

import Elementos.Enemigo;
import Elementos.Entidad;
import Elementos.Jugador;
import Elementos.Llave;
import Elementos.Pared;
import Elementos.Tablero;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author 50241
 */
public class CargaNiveles {

    private int Dificultad;

    public CargaNiveles(int Dificultad) {
        this.Dificultad = Dificultad;
    }
    private Entidad GenerarEntidades(char Caracter,int X,int Y,Tablero[] Tabla){
        int Ataque=0;
        
        Entidad Enti=null;
        switch(Caracter)
        {
            case 'J':
                    Enti=new Jugador(3,X,Y,Ataque,Tabla);
                    Tabla[0].CrearJugador(Enti);
                    
                    break;
            case 'X': 
                    Enti=new Pared(1,X,Y,Ataque,Tabla);
                    break;
            case 'L':
                    Enti=new Llave(1,X,Y,0,Tabla);
                    Tabla[0].CrearLlave(Enti);
                    break;
            case 'B':
                    Enti=new Pared(1,X,Y,Ataque,Tabla);
                    ((Pared)Enti).ActivarBonus();
                    break;
            case 'E':
                  Enti = new Enemigo(1, X, Y, Ataque, Tabla);
                break;
            default:
                    Enti= null;
                break;
        }
        
        
        
        return Enti;
    }
    public Entidad[][] Carga(String Path,Tablero[] Tabla) {
        Entidad[][] NuevoNivel = new Entidad[12][12];
        File archivo = new File(Path);
        FileReader fr = null;
        try {
            fr = new FileReader(archivo);
            BufferedReader br = new BufferedReader(fr);
            String Linea=br.readLine();
            int Y=0;
            while(Linea!=null){
                
                int Longitud=Linea.length();
                for(int X=0;X<Longitud;X++){
                   char Caracter=Linea.charAt(X);
                   NuevoNivel[X][Y]=GenerarEntidades(Caracter,X,Y,Tabla);
                }
                if(Y>11)
                    break;
                Linea=br.readLine();
                Y++;
            }
        } catch (Exception ex) {
            Logger.getLogger(CargaNiveles.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return NuevoNivel;
    }
}
