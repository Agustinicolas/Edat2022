/*
*
* @author Hernandez Agustin
* FAI-505
*
*/
package conjuntistas.dinamicas;

public class NodoArbol {
    private Comparable elem;
    private NodoArbol izquierdo;
    private NodoArbol derecho;

    //CONSTRUCTOR
    public NodoArbol(Comparable elem, NodoArbol izquierdo, NodoArbol derecho){
        this.elem = elem;
        this.izquierdo = izquierdo;
        this.derecho = derecho;
    }

    //OBSERVADORES

    public Comparable getElem(){

        return this.elem;
    }

    public NodoArbol getIzquierdo(){

        return this.izquierdo;
    }

    public NodoArbol getDerecho(){

        return this.derecho;
    }

    //MODIFICADORES

    public void setElem(Comparable elemento){

        this.elem = elemento;
    }

    public void setIzquierdo(NodoArbol nodo){

        this.izquierdo = nodo;
    }

    public void setDerecho(NodoArbol nodo){

        this.derecho = nodo;
    }
}

