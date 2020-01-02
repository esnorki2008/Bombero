/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Elementos;

/**
 *
 * @author Norki
 */
public class Llave extends Entidad{

    public Llave(int Vida, int X, int Y, int Ataque, Tablero[] Tabla) {
        super(Vida, X, Y, Ataque, Tabla);
    }

    @Override
    public void Esperar() {
        //No Hace Nada
    }

    @Override
    public int Tipo() {
        return 4;
    }

    @Override
    public String Info() {
        //
        return "Llave: " + super.X + "," + super.Y;
    }

    @Override
    public void Mover() {
        //No Se Mueve
    }
    
}
