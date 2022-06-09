/*
 *
 * @author Hernandez Agustin 
 * FAI-505
 *
 */
package conjuntistas.dinamicas;
import java.lang.Math;

public class NodoAVL {
    
    private Comparable elem;
    private NodoAVL izquierdo;
    private NodoAVL derecho;
    private int altura;


    //CONSTRUCTOR
    
    public NodoAVL(Comparable elem, NodoAVL izquierdo, NodoAVL derecho){
        this.elem = elem;
        this.izquierdo = izquierdo;
        this.derecho = derecho;
        this.altura = 0;     
    }


    //OBSERVADORES

    public Comparable getElem(){

        return this.elem;
    }

    public NodoAVL getIzquierdo(){

        return this.izquierdo;
    }

    public NodoAVL getDerecho(){

        return this.derecho;
    }

    public int getAltura(){
        return this.altura;
    }    

    public void recalcularAltura(){
        
        if (this.getDerecho() == null && this.getIzquierdo() == null){
            this.altura = 0;
        }else{
            altura = alturaAux(this);
        }
        
    }


    private int alturaAux(NodoAVL n){
        int altura = -1;
        int alturaIzq;
        int alturaDer;
        if (n != null){
            alturaIzq = alturaAux(n.getIzquierdo());
            alturaDer = alturaAux(n.getDerecho());
            altura = Math.max(alturaIzq, alturaDer)+1;
        }
        return altura;
    }

    //MODIFICADORES

    public void setElem(Comparable elemento){

        this.elem = elemento;
    }

    public void setIzquierdo(NodoAVL nodo){

        this.izquierdo = nodo;
    }

    public void setDerecho(NodoAVL nodo){

        this.derecho = nodo;
    }
}
