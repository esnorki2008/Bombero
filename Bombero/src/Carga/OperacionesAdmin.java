/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Carga;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JOptionPane;
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
    public JTable Tiempos(JTable Tabla){
        DefaultTableModel model = new DefaultTableModel();
        Tabla.setModel(model);
        model.addColumn("Usuario");
        
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
                    LS.Add((int)Double.parseDouble(Valores[2]),Valores);
            }
        }

        int Veces = 0;
        Node Cabeza = LS.Head;
        while (Cabeza != null) {
            String[] Valor=(String[])Cabeza.getContenido();
            model.addRow(new Object[]{Valor[0],Valor[2],Valor[3]});
            if (Veces >= 10) {
                break;
            }
            Veces++;
            Cabeza = Cabeza.getNext();
        }

        return Tabla;
    }
    public JTable Punteos(JTable Tabla) {
        DefaultTableModel model = new DefaultTableModel();
        Tabla.setModel(model);
        model.addColumn("Usuario");
        model.addColumn("Punteo Obtenido");
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
            model.addRow(new Object[]{Valor[0],Valor[1],Valor[3]});
            if (Veces >= 10) {
                break;
            }
            Veces++;
            Cabeza = Cabeza.getNext();
        }

        return Tabla;
    }
    public void VerUsuariosAceptados(JTable Tabla){
        DefaultTableModel model = new DefaultTableModel();
        Tabla.setModel(model);
        model.addColumn("Nombre");
        model.addColumn("Contraseña");
        model.addColumn("Borrar");
        if (!Archivo.Existe("Usuarios")) {
            Archivo.Escribir("Usuarios", "ADMIN,ORGA_DIC_2019,1}");
        }
        String Lectura = Archivo.Leer("Usuarios");
        if (Lectura.equals("")) {
            return ;
        }
        String[] Usuario = Lectura.split("}");
        for (int i = 0; i < Usuario.length; i++) {
            String[] Contenido = Usuario[i].split(",");
            if(Contenido[2].trim().equals("1"))
             model.addRow(new Object[]{Contenido[0],Contenido[1]});
            
            
        }
        
        Action delete = new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                JTable table = (JTable) e.getSource();
                int modelRow = Integer.valueOf(e.getActionCommand());
                String NombreBorrar=table.getModel().getValueAt(modelRow, 0).toString();
                OperacionesAdmin Ope= new OperacionesAdmin();
                
                int resp = JOptionPane.showConfirmDialog(null, "Desea Borrar El Usuario");
                if (JOptionPane.OK_OPTION == resp) {
                    Ope.BorrarUsuarios(NombreBorrar);
                    VerUsuariosAceptados(table);
                } 
                
                
                
            }

           
        };
        ButtonColumn buttonColumn = new ButtonColumn(Tabla, delete, 2);
        buttonColumn.setMnemonic(KeyEvent.VK_D);

        return ;
    }
    public void VerUsuariosPendientes(JTable Tabla){
        DefaultTableModel model = new DefaultTableModel();
        Tabla.setModel(model);
        model.addColumn("Nombre");
        model.addColumn("Contraseña");
        model.addColumn("");
        if (!Archivo.Existe("Usuarios")) {
            Archivo.Escribir("Usuarios", "ADMIN,ORGA_DIC_2019,1}");
        }
        String Lectura = Archivo.Leer("Usuarios");
        if (Lectura.equals("")) {
            return ;
        }
        String[] Usuario = Lectura.split("}");
        for (int i = 0; i < Usuario.length; i++) {
            String[] Contenido = Usuario[i].split(",");
            if(Contenido[2].trim().equals("0"))
             model.addRow(new Object[]{Contenido[0],Contenido[1]});
        }
        
        Action delete = new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                JTable table = (JTable) e.getSource();
                int modelRow = Integer.valueOf(e.getActionCommand());
                String NombreAceptar=table.getModel().getValueAt(modelRow, 0).toString();
                OperacionesAdmin Ope= new OperacionesAdmin();
                
                int resp = JOptionPane.showConfirmDialog(null, "Desea Aceptar El Usuario "+NombreAceptar);
                if (JOptionPane.OK_OPTION == resp) {
                    Ope.AceptarPendiente(NombreAceptar);
                }else if(JOptionPane.NO_OPTION==resp){
                    Ope.BorrarUsuarios(NombreAceptar);
                } 
                Ope.VerUsuariosPendientes(table);
                
                
            }

           
        };
        ButtonColumn buttonColumn = new ButtonColumn(Tabla, delete, 2);
        buttonColumn.setMnemonic(KeyEvent.VK_D);
        
        return ;
    }
    public void AceptarPendiente(String Nombre){
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
            if(Contenido[0].toLowerCase().trim().equals(Nombre))
            Salida=Salida+Contenido[0]+","+Contenido[1]+","+"1}";
            else
            Salida=Salida+Contenido[0]+","+Contenido[1]+","+Contenido[2]+"}";
        }
        Archivo.Escribir("Usuarios", Salida);
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
            Salida=Salida+Contenido[0]+","+Contenido[1]+","+Contenido[2]+"}";
        }
        Archivo.Escribir("Usuarios", Salida);
    }
}
