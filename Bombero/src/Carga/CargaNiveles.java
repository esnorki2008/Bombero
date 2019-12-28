package Carga;

import Elementos.Entidad;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author 50241
 */
public class CargaNiveles {

    private Entidad[][] Nivel;
    private int Dificultad;

    public CargaNiveles(String Path, int Dificultad) {
        Nivel = Carga(Path);
        this.Dificultad = Dificultad;
    }
    private Entidad GenerarEntidades(String Caracter){
        String Salida="";
        Entidad Nulo= new Entidad();
        return Salida;
    }
    private Entidad[][] Carga(String Path) {
        Entidad[][] NuevoNivel = new Entidad[12][12];
        File archivo = new File(Path);
        FileReader fr = null;
        try {
            fr = new FileReader(archivo);
            BufferedReader br = new BufferedReader(fr);
            String Linea=br.readLine();
            int Y=0;
            while(Linea!=null){
                int X=0;
                System.out.println(Linea);
                Linea=br.readLine();
            }
        } catch (Exception ex) {
            Logger.getLogger(CargaNiveles.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return Nivel;
    }
}
