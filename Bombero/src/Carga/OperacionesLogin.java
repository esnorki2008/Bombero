package Carga;

import Carga.OperacionesArchivo;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Norki
 */
public class OperacionesLogin {

    OperacionesArchivo Archivo;

    public OperacionesLogin() {
        this.Archivo = new OperacionesArchivo();
    }

    public boolean VerificarContraseña(String Nombre, String Contraseña) {
        if (!Archivo.Existe("Usuarios")) {
            Archivo.Escribir("Usuarios", "ADMIN,ORGA_DIC_2019,1}");
        }
        String Lectura = Archivo.Leer("Usuarios");
        String[] Usuario = Lectura.split("}");
        for (int i = 0; i < Usuario.length; i++) {
            String[] Contenido = Usuario[i].split(",");
            if (Contenido[2].equals("1")) {
                if (Nombre.toLowerCase().equals(Contenido[0].toLowerCase())) {
                    if (Contraseña.toLowerCase().equals(Contenido[1].toLowerCase())) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean VerificarRegistro(String Nombre, String Contraseña) {
        if (!Archivo.Existe("Usuarios")) {
            Archivo.Escribir("Usuarios", "ADMIN,ORGA_DIC_2019,1}");
        }
        String Lectura = Archivo.Leer("Usuarios");
        String[] Usuario = Lectura.split("}");
        for (int i = 0; i < Usuario.length; i++) {
            String[] Contenido = Usuario[i].split(",");
            if (Nombre.toLowerCase().trim().equals(Contenido[0].toLowerCase().trim())) {
                return false;
            }
        }
        String Contenido = Nombre + "," + Contraseña + ",0}";
        Archivo.Escribir("Usuarios", Lectura + Contenido);
        return true;
    }
    
    public boolean RegistradoAntes(String Nombre){
        if (!Archivo.Existe("Usuarios")) {
            Archivo.Escribir("Usuarios", "ADMIN,ORGA_DIC_2019,1}");
        }
        String Lectura = Archivo.Leer("Usuarios");
        String[] Usuario = Lectura.split("}");
        for (int i = 0; i < Usuario.length; i++) {
            if (!Usuario[i].equals("")) {
                String[] Contenido = Usuario[i].split(",");
                if (Nombre.toLowerCase().trim().equals(Contenido[0].toLowerCase().trim())) {
                    return true;
                }
            }
        }
        
        return false;
    }
}
