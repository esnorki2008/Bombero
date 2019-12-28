/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Elementos;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 50241
 */
public class Bomba extends Entidad{
    public Bomba(int Vida, int X, int Y, int Ataque, Tablero Tabla) {
        super(Vida, X, Y, Ataque, Tabla);
    }
    public Bomba(int Vida, int X, int Y, int Ataque, Tablero Tabla,int Rango) {
        super(Vida, X, Y, Ataque, Tabla,Rango);
    }
  

    @Override
    public int Tipo() {
        return 2;
    }

    @Override
    public String Info() {
        return "Bomba: "+super.X+","+super.Y;    
    }
  
    @Override
    public void Mover() {
        //No Se Mueve
    }
    private void Explotar(){
        //Daña En Forma de cruz
        // Y Estatica X Variable
        for(int i=super.X;i<super.X+Rango;i++){
            if(i>11)
                break;
           Tabla.DañarEntidad(i, Y,super.Ataque);
        }
        for(int i=super.X-Rango;i<=super.X;i++){
            if(i<0)
                break;
           Tabla.DañarEntidad(i, Y,super.Ataque);
        }
        // X Estatica Y Variable
        
        for(int j=super.Y;j<super.Y+Rango;j++){
            if(j>11)
                break;
            Tabla.DañarEntidad(X, j, super.Ataque);
        }
        for(int j=super.Y-Rango;j<=super.Y;j++){
            if(j<0)
                break;
            Tabla.DañarEntidad(X, j, super.Ataque);
        }
    }
    @Override
    public void Esperar() {
        try {
            Thread.sleep(800);
            Explotar();
        } catch (InterruptedException ex) {
            Logger.getLogger(Bomba.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
}
