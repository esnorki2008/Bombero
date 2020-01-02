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
public class ListaSimple extends GenericLST{

    @Override
    public boolean Delete(int Id){
        return super.Delete(Id);
    }
    
     @Override
    public void Add(int Clave,Object Inf) {
        Node NewNode = new Node(Clave,Inf);
        super.Size++;
        if (Head==null){
            Head=NewNode;
        }else{
            Node TempNode= Head; 
            if(TempNode==Head &&(Comp(TempNode,NewNode))){
                        NewNode.setNext(TempNode);
                      //
                       //
                        Head=NewNode;
                        return;
            }  
            while(TempNode.getNext()!=null){
                if(Comp(TempNode.getNext(),NewNode)){
                    NewNode.setNext(TempNode.getNext() );
                    //
                    //
                    TempNode.setNext(NewNode);  
                    return ;
                }
                TempNode=TempNode.getNext();                
            }       
            TempNode.setNext(NewNode);
        }
    }
     
    
}