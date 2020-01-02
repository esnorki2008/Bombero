/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Carga;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Norki
 */
public class OperacionesAdmin {
    private OperacionesArchivo Archivo;

    public OperacionesAdmin() {
        this.Archivo = new OperacionesArchivo();
    }
    public JTable Tiempos(){
        DefaultTableModel model = new DefaultTableModel();
        JTable Tabla = new JTable(model);
        model.addColumn("Usuario");
        model.addColumn("Punteo Obtenido");
        model.addColumn("Tiempo");
        model.addColumn("Nivel Completado");
        if (!Archivo.Existe("Histo")) {
            Archivo.Escribir("Histo", "");
        }
        String Lectura = Archivo.Leer("Histo");
        if (Lectura.equals("")) {
            return Tabla;
        }
        ListaSimple LS = new ListaSimple();
        String[] Punteo = Lectura.split("}");
        for (int i = 0; i < Punteo.length; i++) {
            if (!Punteo[i].equals("")) {
                String[] Valores = Punteo[i].split(",");
                    LS.Add(Integer.parseInt(Valores[2]),Valores);
            }
        }

        int Veces = 0;
        Node Cabeza = LS.Head;
        while (Cabeza != null) {
            String[] Valor=(String[])Cabeza.getContenido();
            model.addRow(new Object[]{Valor[0],Valor[1],Valor[2],Valor[3]});
            if (Veces >= 10) {
                break;
            }
            Veces++;
            Cabeza = Cabeza.getNext();
        }

        return Tabla;
    }
    public JTable Punteos(Usuario Usu) {
        DefaultTableModel model = new DefaultTableModel();
        JTable Tabla = new JTable(model);
        model.addColumn("Usuario");
        model.addColumn("Punteo Obtenido");
        model.addColumn("Tiempo");
        model.addColumn("Nivel Completado");
        if (!Archivo.Existe("Histo")) {
            Archivo.Escribir("Histo", "");
        }
        String Lectura = Archivo.Leer("Histo");
        if (Lectura.equals("")) {
            return Tabla;
        }
        ListaSimple LS = new ListaSimple();
        String[] Punteo = Lectura.split("}");
        for (int i = 0; i < Punteo.length; i++) {
            if (!Punteo[i].equals("")) {
                String[] Valores = Punteo[i].split(",");
                    LS.Add(Integer.parseInt(Valores[1]),Valores);
            }
        }

        int Veces = 0;
        Node Cabeza = LS.Head;
        while (Cabeza != null) {
            String[] Valor=(String[])Cabeza.getContenido();
            model.addRow(new Object[]{Valor[0],Valor[1],Valor[2],Valor[3]});
            if (Veces >= 10) {
                break;
            }
            Veces++;
            Cabeza = Cabeza.getNext();
        }

        return Tabla;
    }
    public JTable VerUsuarios(){
        DefaultTableModel model = new DefaultTableModel();
        JTable Tabla = new JTable(model);
        model.addColumn("Nombre");
        model.addColumn("Contraseña");
        if (!Archivo.Existe("Usuarios")) {
            Archivo.Escribir("Usuarios", "ADMIN,ORGA_DIC_2019,1}");
        }
        String Lectura = Archivo.Leer("Usuarios");
        if (Lectura.equals("")) {
            return Tabla;
        }
        String[] Usuario = Lectura.split("}");
        for (int i = 0; i < Usuario.length; i++) {
            String[] Contenido = Usuario[i].split(",");
             model.addRow(new Object[]{Contenido[0],Contenido[1]});
        }
        return Tabla;
    }
     public void BorrarUsuarios(String Nombre){
        if (!Archivo.Existe("Usuarios")) {
            Archivo.Escribir("Usuarios", "ADMIN,ORGA_DIC_2019,1}");
        }
        String Lectura = Archivo.Leer("Usuarios");
        if (Lectura.equals("")) {
            return ;
        }
        Nombre=Nombre.toLowerCase().trim();
        String Salida="";
        String[] Usuario = Lectura.split("}");
        for (int i = 0; i < Usuario.length; i++) {
            String[] Contenido = Usuario[i].split(",");
            if(!Contenido[0].toLowerCase().trim().equals(Nombre))
            Salida=Salida+Contenido[0]+","+Contenido[1]+","+Contenido[2];
        }
        Archivo.Escribir("Usuarios", Salida);
    }
}
