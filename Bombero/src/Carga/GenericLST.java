/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Carga;


import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lizandro
 */
public abstract   class GenericLST {
    protected Node Head=null;
    protected Node End=null;
    protected int Size=0;
    public int Count(){
        return Size;
    }
    public Node getHead(){
        return Head;
    }
    protected abstract void Add(int Clave,Object Inf);
    public boolean Comp(Node N1,Node N2){
        if(N1.getIdentificador() >N2.getIdentificador())
            // Izzquierda
             //return true;
            return false;
        else
            //Derecha
            return true;
    }
    
    public String Graficar(){
        
        if(Head!=null){
            Node TempNode=Head;
            String grafo="";
            grafo = "digraph G{";
            grafo += "node[shape=\"box\"];";
            
            while(TempNode.getNext()!=null){
                grafo += TempNode.toString()+"[label=\" " + TempNode.toString()+ " \"];\n";
                grafo += TempNode.toString()+"->"+TempNode.getNext().toString()+"\n";
                if(TempNode.getBack()!=null)
                grafo += TempNode.toString()+"->"+TempNode.getBack().toString()+"\n";
                TempNode=TempNode.getNext();
            }
            if(TempNode.getBack()!=null)
            grafo += TempNode.toString()+" -> "+TempNode.getBack().toString()+"\n";
            grafo += TempNode.toString().replace(".", "")+"[label=\" " +  TempNode.toString()+ " \"];\n";
            

           
            grafo += "}";
            return grafo;
        }
        return "";
    }
    public String GraficarSinCabecera(int N,String Complemento){
        
        if(Head!=null){
            Node TempNode=Head;
            String grafo="";
         //   grafo = "digraph G{";
         //   grafo += "node[shape=\"box\"];";
            while(TempNode.getNext()!=null){
                grafo += "LST"+Complemento+TempNode.toString()+"[label=\" " + TempNode.getIdentificador()+ " \"];\n";
                grafo += "LST"+Complemento+TempNode.toString()+" -> "+"LST"+Complemento+TempNode.getNext().toString()+"\n";
                if(N==2)
                grafo+="\nLST"+Complemento+TempNode.toString()+" -> "+Complemento+TempNode.toString()+"\n";
                if(TempNode.getBack()!=null)
                grafo += "LST"+Complemento+TempNode.toString()+" -> "+"LST"+Complemento+TempNode.getBack().toString()+"\n";
                TempNode=TempNode.getNext();
            }
            if(TempNode.getBack()!=null)
            grafo += "LST"+Complemento+TempNode.toString()+" -> "+"LST"+Complemento+TempNode.getBack().toString()+"\n";
            grafo += "LST"+Complemento+TempNode.toString()+"[label=\" " + TempNode.getIdentificador()+ " \"];\n";
          //  grafo += "}";
            return grafo;
        }
        return "";
    }
    public void Print(){
        
        
        Node TempNode=Head;
        while(TempNode!=null){
            TempNode.Print();
            TempNode=TempNode.getNext();
        }
    }
    public boolean Modify(Node NewNode){
        Node TempNode=Head;
        if(NewNode.getIdentificador()==(TempNode.getIdentificador())){
            Head=Head.getNext();
            return true;
        }else{
            while(TempNode.getNext()!=null){
                if(NewNode.getIdentificador()==(TempNode.getNext().getIdentificador())){
                   NewNode.setNext(TempNode.getNext());
                   TempNode.setNext(NewNode);
                   return true;
                }           
                TempNode=TempNode.getNext();
            }
        }
        return false;
    }
    public Object Find(int Id){
        Node TempNode=Head;
        while(TempNode!=null){
            if(TempNode.getIdentificador()==(Id)){
                return TempNode.getContenido();
            }           
            TempNode=TempNode.getNext();
        }
        return null;
    }
    protected Object Delete(){
        if(Head!=null){
            Node Temp=Head;
            Head=Head.getNext();             
            return Temp.getContenido();
        }else{
            return null;
        }
       
    }
     protected boolean Delete(int Id){
        if(Head!=null){
        Node TempNode=Head;
        if(Id==(TempNode.getIdentificador())){
            Head=Head.getNext();
            return true;
        }else{
            while(TempNode.getNext()!=null){
                if(Id==TempNode.getNext().getIdentificador()){
                   TempNode.setNext(TempNode.getNext().getNext());
                   return true;
                }           
                TempNode=TempNode.getNext();
            }
         }
        
        } 
        return false;
    }
    protected Object Get(){
        if(Head==null)
            return null;
        return Head.getContenido();
    }
}