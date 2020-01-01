/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Carga;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Norki
 */
public class OperacionesArchivo {
    private String Leido;
    private String Leido(){
        return Leido;
    }
    public OperacionesArchivo(){
        Leido="";
    }
    public String Leer(String Path) {
        String Linea = "";
        try {
            Scanner input = new Scanner(new File(Path));
            while (input.hasNextLine()) {
                Linea =Linea+ input.nextLine();
            }
            input.close();
        } catch (FileNotFoundException ex) {
        }
        Leido=Linea;
        return Linea;
    }

    public void Escribir(String Path,String Contenido) {
        String ruta = Path;
        File file = new File(ruta);
        // Si el archivo no existe es creado
        if (!Existe(Path)) {
            try {
                file.createNewFile();
            } catch (IOException ex) {
                Logger.getLogger(OperacionesArchivo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        FileWriter fw = null;
        try {
            fw = new FileWriter(file);
        } catch (IOException ex) {
            Logger.getLogger(OperacionesArchivo.class.getName()).log(Level.SEVERE, null, ex);
        }
        BufferedWriter bw = new BufferedWriter(fw);
        try {
            bw.write(Contenido);
        } catch (IOException ex) {
            Logger.getLogger(OperacionesArchivo.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            bw.close();
        } catch (IOException ex) {
            Logger.getLogger(OperacionesArchivo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public boolean Existe(String Path) {
        File archivo = new File(Path);
        return archivo.exists();
    }
}
