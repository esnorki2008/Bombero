/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Elementos;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

/**
 *
 * @author 50241
 */
public class Juego {
    private Tablero T;
    public void IniciarJuego(JLabel Visualizar,JFrame Contenedor,JLabel[][] Matriz,JLabel L1,JLabel L2,JLabel L3,JLabel L4,JLabel L5,String Path){
        T = new Tablero(Visualizar,Contenedor,Matriz,L1,L2,L3,L4,L5,Path);
        T.Iniciar();
        T.start();
        
    }
    public int Punteo(){
        return T.Punteo();
    }
    public double Tiempo(){
        return T.Tiempo();
    }
    public boolean Terminado(){
        return T.EstadoTablero();
    }
    public void TerminarJuego(){
        T.Terminar();
    }
    public Entidad[][] VerTablero(){
        return T.RetornarTabla();
    }
    public void Listener(java.awt.event.KeyEvent evt){
        T.Listener(evt);
    }
}
