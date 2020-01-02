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
        Tablero Tabla = this.Tabla;

        int Veces = 0;
        for (int i = super.X; i <= super.X + Rango(); i++) {
            if (i >= 0 && i <= 11) {
                if (Veces == 1) {
                    break;
                }

                if (Tabla.PararExplosion(i, Y)) {
                    Veces = 1;
                }
                Tabla.DañarEntidad(i, Y, super.Ataque);
                Tabla.PonerHumo(i, Y);

            }
        }
        Veces = 0;
        //Izquierda
        for (int i = super.X-1 ; i >= super.X- Rango(); i--) {
            if (i >= 0 && i <= 11) {

                if (Veces == 1) {
                    break;
                }

                if (Tabla.PararExplosion(i, Y)) {
                    Veces = 1;
                }

                Tabla.DañarEntidad(i, Y, super.Ataque);
                Tabla.PonerHumo(i, Y);

            }
        }
        Veces = 0;
        // X Estatica Y Variable

        for (int j = super.Y + 1; j <= super.Y + Rango(); j++) {
            if (j <= 11 && j >= 0) {
                if (Veces == 1) {
                    break;
                }

                if (Tabla.PararExplosion(X, j)) {
                    Veces = 1;
                }

                Tabla.DañarEntidad(X, j, super.Ataque);
                Tabla.PonerHumo(X, j);

            }
        }
        Veces = 0;
        for (int j = super.Y - 1; j >= super.Y-Rango(); j--) {
            if (j <= 11 && j >= 0) {
                if (Veces == 1) {
                    break;
                }

                if (Tabla.PararExplosion(X, j)) {
                    Veces = 1;
                }

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
