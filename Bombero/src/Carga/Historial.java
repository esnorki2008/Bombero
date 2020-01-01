/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Carga;

/**
 *
 * @author Norki
 */
public class Historial {
    private boolean Completada;
    private int Tiempo;
    private int Punteo;
    public Historial(boolean Completada,int Tiempo,int Punteo){
        this.Completada=Completada;
        this.Tiempo=Tiempo;
        this.Punteo=Punteo;
    }
    /**
     * @return the Completada
     */
    public boolean isCompletada() {
        return Completada;
    }

    /**
     * @param Completada the Completada to set
     */
    public void setCompletada(boolean Completada) {
        this.Completada = Completada;
    }

    /**
     * @return the Tiempo
     */
    public int getTiempo() {
        return Tiempo;
    }

    /**
     * @param Tiempo the Tiempo to set
     */
    public void setTiempo(int Tiempo) {
        this.Tiempo = Tiempo;
    }

    /**
     * @return the Punteo
     */
    public int getPunteo() {
        return Punteo;
    }

    /**
     * @param Punteo the Punteo to set
     */
    public void setPunteo(int Punteo) {
        this.Punteo = Punteo;
    }
    
}
