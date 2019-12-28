/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Elementos;

/**
 *
 * @author 50241
 */
public class Pared extends Entidad{

    public Pared(int Vida, int X, int Y, int Ataque, Tablero Tabla) {
        super(Vida, X, Y, Ataque, Tabla);
    }

   
    @Override
    public void Mover() {
       //No Hace Nada
    }

    @Override
    public int Tipo() {
        return 0;
    }

    @Override
    public String Info() {
        return "Pared: "+super.X+","+super.Y;
    }

    @Override
    public void Esperar() {
    }
}
