package Elementos;

import Carga.CargaNiveles;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JTextArea;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author 50241
 */
public class Tablero extends Thread {

    private int TiempoPantalla, TiempoEnemigo, TiempoBomba;
    private Entidad Jugador;
    private Entidad[][] Tabla;
    JTextArea Texto;
    JFrame Contenedor;

    public void CrearJugador(Entidad Jugador) {
        this.Jugador = Jugador;
    }

    public Tablero(JTextArea Grafica, JFrame Contenedor) {
        Texto = Grafica;
        Tabla = new Entidad[12][12];
        this.Contenedor = Contenedor;
        CargaNiveles Carga= new CargaNiveles(1);
        this.Tabla= Carga.Carga("C:\\Users\\Norki\\Desktop\\Bombero\\Niveles\\Nivel1.txt", this);
        //Tabla[6][6] = new Enemigo(1, 6, 6, 1, this);
        //Tabla[2][2] = new Jugador(1, 2, 2, 1, this);

        //Jugador = Tabla[2][2];
    }

    public void Iniciar() {
        for (int j = 0; j < 12; j++) {
            for (int i = 0; i < 12; i++) {
                if(Tabla[i][j]!=null)
                Tabla[i][j].start();
            }

        }
    }

    public void Listener(java.awt.event.KeyEvent evt) {
        ((Jugador) Jugador).Evento(evt);
    }

    @Override
    public void run() {
        while (true) {
            try {
                Contenedor.requestFocus();
                TableroTexto(Texto);
                Thread.sleep(200);

            } catch (InterruptedException ex) {
                Logger.getLogger(Tablero.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public Tablero(String Path) {
        CargarInfo(Path);
    }

    public void DañarEntidad(int X, int Y, int Daño) {
        if (Tabla[X][Y] == null) {
            return;
        }

        Tabla[X][Y].RecibirDaño(Daño);
        if (Tabla[X][Y].VidaActual <= 0) {
            Tabla[X][Y] = null;
        }

    }

    public Entidad DevolverEntidad(int X, int Y) {
        return Tabla[X][Y];
    }

    public boolean CasillaVacia(int X, int Y) {
        if (Tabla[X][Y] == null) {
            return true;
        } else {
            return false;
        }
    }

    public boolean EsJugador(int X, int Y) {
        return this.Tabla[X][Y].EsJugador();
    }

    public void MoverANuevaCasilla(int XVieja, int YVieja, int XNueva, int YNueva) {
        Tabla[XNueva][YNueva] = Tabla[XVieja][YVieja];
        Tabla[XVieja][YVieja] = null;
    }

    private void Dibujar(int i, Entidad Actual) {
        char Simbolo;
        switch (Actual.Tipo()) {
            case 0:
                Simbolo = 'B';
                break;
            case 1:
                Simbolo = 'E';
                break;
            case 2:
                Simbolo = 'N';
                break;
            case 3:
                Simbolo = 'J';
                break;
            case 4:
                Simbolo = 'L';
                break;
            default:
                Simbolo = ' ';
                break;
        }

        System.out.print(Simbolo);
    }

    private char DibujarTexto(Entidad Actual) {
        char Simbolo;
        switch (Actual.Tipo()) {
            case 0:
                Simbolo = 'B';
                break;
            case 1:
                Simbolo = 'E';
                break;
            case 2:
                Simbolo = 'N';
                break;
            case 3:
                Simbolo = 'J';
                break;
            case 4:
                Simbolo = 'L';
                break;
            default:
                Simbolo = ' ';
                break;
        }

        return Simbolo;
    }

    public void TableroTexto(JTextArea Grafica) {
        Grafica.setText(null);
        String Texto = "";
        for (int j = 0; j < 12; j++) {
            Texto = Texto + ("\n");
            for (int i = 0; i < 12; i++) {
                Texto = Texto + "";
                Entidad Actual = Tabla[i][j];
                if (Actual != null) {
                    Texto = Texto + DibujarTexto(Actual);
                } else {
                    Texto = Texto + "-";
                }
            }
        }
        
        Grafica.setText(Texto);
    }

    public void DibujarTablero() {
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        for (int j = 0; j < 12; j++) {
            System.out.println("");

            for (int i = 0; i < 12; i++) {
                Entidad Actual = Tabla[i][j];
                if (Actual != null) {
                    Dibujar(i, Actual);
                } else {
                    System.out.print("x");
                }
            }
        }
    }

    private void CargarInfo(String Path) {
        throw new UnsupportedOperationException("No Implementado Cargar");
    }

}
