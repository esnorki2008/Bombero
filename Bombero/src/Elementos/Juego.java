/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Elementos;

import javax.swing.JFrame;
import javax.swing.JTextArea;

/**
 *
 * @author 50241
 */
public class Juego {
    Tablero T;
    public void IniciarJuego(JTextArea[] Visualizar,JFrame Contenedor){
        T = new Tablero(Visualizar,Contenedor);
        T.start();
        
    }
    public void Listener(java.awt.event.KeyEvent evt){
        T.Listener(evt);
    }
}
