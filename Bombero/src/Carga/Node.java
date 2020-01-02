
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Carga;

/**
 *
 * @author lizandro
 */
public  class Node {
    protected int Identificador;
    private Object Contenido=null;
    private Node Next=null;
    private Node Back=null;
    
    public Node(int ID,Object Contenido){
        this.Identificador=ID;
        this.Contenido=Contenido;
    }
    
    public String toString(){
        return this.Contenido.toString();
    }
    public void Print(){
        System.out.println(this.toString());
    }
    public void Change(Node Node1){
        int CId=Node1.getIdentificador();
        Object CCon=Node1.getContenido();
        Node1.setContenido(Contenido);
        Node1.setId(Identificador);
        this.Identificador=CId;
        this.Contenido=CCon;
    }
    /**
     * @return the Id
     */
    
    public int getIdentificador() {
        return Identificador;
    }

    /**
     * @param Id the Id to set
     */
    public void setId(int Id) {
        this.Identificador = Id;
    }

    /**
     * @return the Siguiente
     */
    public Node getNext() {
        return Next;
    }

    /**
     * @param Next the Siguiente to set
     */
    public void setNext(Node Next) {
        this.Next = Next;
    }

    /**
     * @return the Anterior
     */
    public Node getBack() {
        return Back;
    }

    /**
     * @param Anterior the Anterior to set
     */
    public void setBack(Node Back) {
        this.Back = Back;
    }

    /**
     * @return the Contenido
     */
    public Object getContenido() {
        return Contenido;
    }

    /**
     * @param Contenido the Contenido to set
     */
    public void setContenido(Object Contenido) {
        this.Contenido = Contenido;
    }
    
    
    
}
