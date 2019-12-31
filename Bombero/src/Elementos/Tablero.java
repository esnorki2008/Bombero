package Elementos;

import Carga.CargaNiveles;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import Elementos.Bomba;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

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
    private int Final;
    private boolean TableroActivo;
    private int Puntos;
    private Entidad Jugador,Llave;
    private Entidad[][] Tabla;
    JTextArea Texto;
    JFrame Contenedor;
    JLabel L1,L2;
    private JLabel[][] Matriz;

    public Entidad[][] RetornarTabla() {
        return this.Tabla;
    }

    public void CrearJugador(Entidad Jugador) {
        this.Jugador = Jugador;
    }
    public void CrearLlave(Entidad Llave) {
        this.Llave = Llave;
    }
    private int Punteo(int Tipo){
        switch(Tipo){
            case 0 :
                return 1;
            case 1 :
                return 10;
            default :
                return 0;
        }
    }
    public void CargarAMatriz() {
        int Vid=Jugador.VidaActual();
        if(Vid<0)
            Vid=0;
        this.L1.setText(Vid+"");
       
        this.L2.setText(this.Puntos+"");
        if(Llave!=null){
            int i=Llave.X;
            int j=Llave.Y;
            Tabla[i][j] =Llave;
            
            if(i==this.Jugador.X && j == this.Jugador.Y)
                this.TableroActivo=false;
        }
        
        for (int j = 0; j < 12; j++) {

            for (int i = 0; i < 12; i++) {

                if (Tabla[i][j] == null) {
                    Matriz[i][j].setText("");
                   // this.Matriz[i][j].setIcon(null);
                } else {
                 
                    
                    if (Tabla[i][j].VidaActual <= 0) {
                       
                        
                        this.Puntos=this.Puntos+this.Punteo(Tabla[i][j].Tipo());
                        
                        
                        if (Tabla[i][j].Tipo() != 3) {
                            Tabla[i][j].Limpiar();
                            Tabla[i][j] = null;
                            
                            if (this.Jugador.X == i && this.Jugador.Y == j) {
                                Tabla[i][j] = this.Jugador;
                            }

                        }else{
                            Matriz[i][j].setText((Tabla[i][j].Tipo()) + "");
                        }
                    } else {

                        Matriz[i][j].setText(this.DibujarTexto(Tabla[i][j]) + "");
                       //       ImageIcon imageIcon = ImageIconTipo(Tabla[i][j].Tipo());
                        //      this.Matriz[i][j].setText("");
                        //      this.Matriz[i][j].setIcon(imageIcon);
                       // Matriz[i][j].setText((Tabla[i][j].Tipo()) + "");
                    }
                }
            }
        }
    }
    public ImageIcon ImageIconTipo(int Tipo){
        ImageIcon imageIcon =null;
        switch(Tipo){
            case 0:
                imageIcon =new ImageIcon("src\\Imagenes\\0.png");
                break;
            case 1:
                imageIcon =new ImageIcon("src\\Imagenes\\1.png");
                break;
            case 2:
                imageIcon =new ImageIcon("src\\Imagenes\\2.png");
                break;
            case 3:
                imageIcon =new ImageIcon("src\\Imagenes\\3.png");
                break;
            case 4:
                imageIcon =new ImageIcon("src\\Imagenes\\4.png");
                break;
            case 5:
                imageIcon =new ImageIcon("src\\Imagenes\\5.png");
                break;
            default:
                imageIcon =new ImageIcon("src\\Imagenes\\7.jpg");
            break;
        }
        return imageIcon;
    }
    public void ApagarTablero(){
        this.TableroActivo=false;
    }
    public boolean EstadoTablero(){
        return this.TableroActivo;
    }
    public Tablero(JTextArea Grafica, JFrame Contenedor, JLabel[][] Matriz,JLabel L1,JLabel L2) {
        this.TableroActivo=true;
        Texto = Grafica;
        this.Matriz = Matriz;
        Tabla = new Entidad[12][12];
        this.Contenedor = Contenedor;
        CargaNiveles Carga = new CargaNiveles(1);
        Tablero[] Arra={this};
        this.Tabla = Carga.Carga("C:\\Users\\Norki\\Desktop\\Bombero\\Niveles\\Nivel1.txt", Arra);
        this.L1=L1;
        this.L2=L2;
        this.Puntos=0;
        this.Final=15;
    }

    public void Iniciar() {
        for (int j = 0; j < 12; j++) {
            for (int i = 0; i < 12; i++) {
                if (Tabla[i][j] != null) {
                    Tabla[i][j].start();
                }
            }

        }
    }

    public void Listener(java.awt.event.KeyEvent evt) {
        ((Jugador) Jugador).Evento(evt);
    }

    @Override
    public void run() {
        while (this.TableroActivo || this.Final>0) {
            try {
                Contenedor.requestFocus();
                //  TableroTexto(Texto);
                CargarAMatriz();
                Thread.sleep(200);
                if(!this.TableroActivo){
                    this.Final--;
                }

            } catch (InterruptedException ex) {
                Logger.getLogger(Tablero.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        System.out.println("Juego Terminado Ganando");
        
    }

    public Tablero(String Path) {
        CargarInfo(Path);
    }

    public void DañarJugador() {
        this.Jugador.RecibirDaño(1);
    }

    public void DañarEntidad(int X, int Y, int Daño) {
        if (Tabla[X][Y] == null || Tabla[X][Y].Tipo()==4) {
            return;
        }

        //System.out.println("V       " + Tabla[X][Y].Tipo() + "      " + Tabla[X][Y].VidaActual);
        if ((Tabla[X][Y].Tipo() != 5 && Tabla[X][Y].Tipo() != 2)) {
            Tabla[X][Y].RecibirDaño(Daño);
        }

        if (Tabla[X][Y].VidaActual <= 0) {

            if (Tabla[X][Y].Tipo() != 3) {
                //ARREGLAR
                 //Tabla[X][Y].Limpiar();
                 //Tabla[X][Y] = null;
                
                
                if (X == this.Jugador.X && Y == this.Jugador.Y) {
                    Tabla[X][Y] = this.Jugador;
                    this.Jugador.RecibirDaño(1);
                } 
                   
            } else {
                //System.out.println("Menu de Juego Acabado   " + this.Jugador.VidaActual);
            }
        }

    }

    public Entidad DevolverEntidad(int X, int Y) {
        return Tabla[X][Y];
    }

    public boolean CasillaVacia(int X, int Y) {
        if (Tabla[X][Y] == null || Tabla[X][Y].Tipo()==4) {
            return true;
        } else {
           
            return false;
        }
    }

    public boolean EsEnemigo(int X, int Y) {
        if (this.Tabla[X][Y] == null) {
            return false;
        }
        int Tipo = this.Tabla[X][Y].Tipo();
        if (Tipo == 1) {
            return true;
        } else {
            return false;
        }

    }

    public boolean EsJugador(int X, int Y) {
        if (this.Jugador == null) {
            return false;
        }
        if (Jugador.X == X && Jugador.Y == Y) {
            return true;
        } else {
            return false;
        }
    }

    public boolean MoverANuevaCasilla(Entidad Enti, int XNueva, int YNueva) {
        int XVieja = Enti.X;
        int YVieja = Enti.Y;
        if (Tabla[XNueva][YNueva] != null && Tabla[XNueva][YNueva].Tipo()!=4) {
            
            
            
          
            
            return false;
        }
        if (Enti.Tipo() == 3 && Tabla[XVieja][YVieja].Tipo() != 3) {
            Tabla[XNueva][YNueva] = Enti;
        } else {
            Tabla[XNueva][YNueva] = Tabla[XVieja][YVieja];
            Tabla[XVieja][YVieja] = null;
        }

        return true;
    }

    public boolean PonerBomba(Bomba Nueva, int XNueva, int YNueva) {
        Entidad Actual = Tabla[XNueva][YNueva];
        if (Actual.Tipo() == 2) {
            return false;
        }
        Tabla[XNueva][YNueva] = Nueva;
        Tabla[XNueva][YNueva].start();
        return true;
    }

    public void BorrarEntidad1(int X, int Y) {
        this.Tabla[X][Y].Limpiar();
        this.Tabla[X][Y] = null;
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

    public void PonerHumo(int X, int Y) {
        Tablero[] Array = {this};
        if (Tabla[X][Y] != null && Tabla[X][Y].Tipo()>1) {
            this.Puntos = this.Puntos + this.Punteo(Tabla[X][Y].Tipo());
            this.Tabla[X][Y] = new Bonus();
        } else {

            Humo Hum = new Humo(1, X, Y, 0, Array);
            Hum.start();
            this.Tabla[X][Y] = Hum;
        }
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
            case 5:
                
                Simbolo = 'H';
                break;
            default:
                Simbolo = ' ';
                break;
        }

        return Simbolo;
    }

    private void CargarInfo(String Path) {
        throw new UnsupportedOperationException("No Implementado Cargar");
    }

}
