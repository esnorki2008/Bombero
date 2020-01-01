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
public class Bonus extends Entidad {

    public Bonus(int Vida, int X, int Y, int Ataque, Tablero[] Tabla) {
        super(Vida, X, Y, Ataque, Tabla);
        Tipo=5;
    }
    private int Tipo;
    @Override
    public void Esperar() {
        try {

            Thread.sleep(500);
            this.Tipo=6;
        } catch (InterruptedException ex) {
            Logger.getLogger(Humo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public int Tipo() {
        return this.Tipo;
    }

    @Override
    public String Info() {
        return ("Bonus");
    }

    @Override
    public void Mover() {
        //no Se Mueve
    }
    
}
