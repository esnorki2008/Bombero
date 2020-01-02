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
    private double Tiempo;
    private int Punteo;
    public Historial(int Punteo,double Tiempo,boolean Completada){
        this.Completada=Completada;
        this.Tiempo=Tiempo;
        this.Punteo=Punteo;
    }
    @Override
    public String toString(){
        return Punteo+"_"+Tiempo+"_"+Completada;
    }
    /**
     * @return the Completada
     */
    public boolean GetCompletada(){
        return Completada;
    }
    public String isCompletada() {
        if(Completada)
            return "Completado";
        else
            return "Sin Completar";
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
    public double getTiempo() {
        return Tiempo;
    }

    /**
     * @param Tiempo the Tiempo to set
     */
    public void setTiempo(double Tiempo) {
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
