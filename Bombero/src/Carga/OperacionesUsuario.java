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
public class OperacionesUsuario {

    private OperacionesArchivo Archivo;

    public OperacionesUsuario() {
        this.Archivo = new OperacionesArchivo();
    }
    public JTable Tiempos(Usuario Usu){
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
        Usu.setPartidas(new ListaSimple());
        String[] Punteo = Lectura.split("}");
        for (int i = 0; i < Punteo.length; i++) {
            if (!Punteo[i].equals("")) {
                String[] Valores = Punteo[i].split(",");
                boolean Bool = false;
                    if (Valores[3].toLowerCase().equals("t")) {
                        Bool = true;
                    }
                
                if (Valores[0].toLowerCase().trim().equals(Usu.getNombre().toLowerCase()) && Bool) {
                    
                    
                    Usu.getPartidas().Add(Integer.parseInt(Valores[2]),
                            new Historial(Integer.parseInt(Valores[1]), Integer.parseInt(Valores[2]), Bool));
                    
                    
                }
            }
        }

        int Veces = 0;
        Node Cabeza = Usu.getPartidas().Head;
        while (Cabeza != null) {
            Historial Histo = (Historial) Cabeza.getContenido();
            model.addRow(new Object[]{Usu.getNombre(), Histo.getPunteo(), Histo.getTiempo(), Histo.isCompletada()});
            if (Veces >= 20) {
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
        Usu.setPartidas(new ListaSimple());
        String[] Punteo = Lectura.split("}");
        for (int i = 0; i < Punteo.length; i++) {
            if (!Punteo[i].equals("")) {
                String[] Valores = Punteo[i].split(",");
                if (Valores[0].toLowerCase().trim().equals(Usu.getNombre().toLowerCase())) {
                    boolean Bool = false;
                    if (Valores[3].toLowerCase().equals("t")) {
                        Bool = true;
                    }
                    Usu.getPartidas().Add(Integer.parseInt(Valores[1]),
                            new Historial(Integer.parseInt(Valores[1]), Integer.parseInt(Valores[2]), Bool));
                }
            }
        }

        int Veces = 0;
        Node Cabeza = Usu.getPartidas().Head;
        while (Cabeza != null) {
            Historial Histo = (Historial) Cabeza.getContenido();
            model.addRow(new Object[]{Usu.getNombre(), Histo.getPunteo(), Histo.getTiempo(), Histo.isCompletada()});
            if (Veces >= 20) {
                break;
            }
            Veces++;
            Cabeza = Cabeza.getNext();
        }

        return Tabla;
    }
    public JTable TodasPartidas(Usuario Usu){
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
        Usu.setPartidas(new ListaSimple());
        String[] Punteo = Lectura.split("}");
        for (int i = 0; i < Punteo.length; i++) {
            if (!Punteo[i].equals("")) {
                String[] Valores = Punteo[i].split(",");
                if (Valores[0].toLowerCase().trim().equals(Usu.getNombre().toLowerCase())) {
                    boolean Bool = false;
                    if (Valores[3].toLowerCase().equals("t")) {
                        Bool = true;
                    }
                    Historial Histo= new Historial(Integer.parseInt(Valores[1]), Integer.parseInt(Valores[2]), Bool);
                    
                    model.addRow(new Object[]{Usu.getNombre(), Histo.getPunteo(), Histo.getTiempo(), Histo.isCompletada()});
                }
            }
        }

       

        return Tabla;
    }
}
