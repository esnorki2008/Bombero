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
    public void IniciarJuego(JTextArea Visualizar,JFrame Contenedor,JLabel[][] Matriz,JLabel L1,JLabel L2,JLabel L3){
        T = new Tablero(Visualizar,Contenedor,Matriz,L1,L2,L3);
        T.Iniciar();
        T.start();
        
    }
    public Entidad[][] VerTablero(){
        return T.RetornarTabla();
    }
    public void Listener(java.awt.event.KeyEvent evt){
        T.Listener(evt);
    }
}
