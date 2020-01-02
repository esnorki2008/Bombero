/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Carga;

import java.util.LinkedList;
/**
 *
 * @author Norki
 */
public class Usuario {

    /**
     * @return the Nombre
     */
    public String getNombre() {
        return Nombre;
    }

    /**
     * @param Nombre the Nombre to set
     */
    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    /**
     * @return the Partidas
     */
    public ListaSimple getPartidas() {
        return Partidas;
    }

    /**
     * @param Partidas the Partidas to set
     */
    public void setPartidas(ListaSimple Partidas) {
        this.Partidas = Partidas;
    }
    private String Nombre;
    private ListaSimple Partidas; 
    
    
    public Usuario(String Nombre){
        Partidas= new ListaSimple();
        this.Nombre=Nombre;
    }
    
}
