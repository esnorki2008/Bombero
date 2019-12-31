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
public class Bomba extends Entidad {

    int Veces;

    public Bomba(int Vida, int X, int Y, int Ataque, Tablero[] Tabla) {
        super(Vida, X, Y, Ataque, Tabla);
        Veces = 0;
    }

    public Bomba(int Vida, int X, int Y, int Ataque, Tablero[] Tabla, int Rango) {
        super(Vida, X, Y, Ataque, Tabla, Rango);
        Veces = 0;
    }

    @Override
    public int Tipo() {
        return 2;
    }

    @Override
    public String Info() {
        return "Bomba: " + super.X + "," + super.Y;
    }

    @Override
    public void Mover() {
        //No Se Mueve
    }

    private void Explotar() {
        //Daña En Forma de cruz
        // Y Estatica X Variable
        Tablero Tabla=this.Tabla;
        for (int i = super.X; i <= super.X + Rango; i++) {
            if (i >= 0 && i<=11) {
                Tabla.DañarEntidad(i, Y, super.Ataque);
                                Tabla.PonerHumo(i, Y);

            }
        }
        for (int i = super.X - Rango; i <= super.X; i++) {
            if (i >= 0 && i<=11) {
              Tabla.DañarEntidad(i, Y, super.Ataque);
               Tabla.PonerHumo(i, Y);

            }
        }
        // X Estatica Y Variable

        for (int j = super.Y+1; j <= super.Y + Rango; j++) {
            if (j <= 11 && j>=0) {
                Tabla.DañarEntidad(X, j, super.Ataque);
                 Tabla.PonerHumo(X, j);
            }
        }
        for (int j = super.Y - Rango; j < super.Y; j++) {
            if (j <= 11 && j>=0) {
                Tabla.DañarEntidad(X, j, super.Ataque);
                 Tabla.PonerHumo(X, j);
            }
        }
    }

    @Override
    public void Esperar() {
            try {
                while (this.VidaActual > 0) {
                    Thread.sleep(1000);
                    Veces++;
                        this.VidaActual = 0;
                }
                Explotar();
            } catch (InterruptedException ex) {
                Logger.getLogger(Bomba.class.getName()).log(Level.SEVERE, null, ex);
            }
    }

}
