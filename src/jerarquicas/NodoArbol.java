package jerarquicas;

public class NodoArbol {
    
    private Object elem;
    private NodoArbol izquierdo;
    private NodoArbol derecho;


    //CONSTRUCTOR
    public NodoArbol(Object elem, NodoArbol izquierdo, NodoArbol derecho){
        this.elem = elem;
        this.izquierdo = izquierdo;
        this.derecho = derecho;
    }


    //OBSERVADORES

    public Object getElem(){

        return this.elem;
    }


    public NodoArbol getIzquierdo(){

        return this.izquierdo;
    }


    public NodoArbol getDerecho(){

        return this.derecho;
    }


    //MODIFICADORES

    public void setElem(Object elemento){

        this.elem = elemento;
    }


    public void setIzquierdo(NodoArbol nodo){

        this.izquierdo = nodo;
    }


    public void setDerecho(NodoArbol nodo){

        this.derecho = nodo;
    }
}
