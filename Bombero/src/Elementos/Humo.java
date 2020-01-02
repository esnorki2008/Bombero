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
 * @author Norki
 */
public class Humo extends Entidad{

    public Humo(int Vida, int X, int Y, int Ataque, Tablero[] Tabla) {
        
        super(Vida, X, Y, Ataque, Tabla);
    }

    @Override
    public void Esperar() {
        try {

            Thread.sleep(500);

        } catch (InterruptedException ex) {
            Logger.getLogger(Humo.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.VidaActual=-1;
    }

    @Override
    public int Tipo() {
        return 5;
    }

    @Override
    public String Info() {
        return "Humo";
    }

    @Override
    public void Mover() {
        //No Se Mueve
    }
    
}
