package jerarquicas.dinamicas;

public class NodoGen {
    
    private Object elem;
    private NodoGen hijoIzquierdo;
    private NodoGen hermanoDerecho;


    //CONSTRUCTOR 
    public NodoGen(Object elem, NodoGen hijo, NodoGen hermano){
        this.elem = elem;
        this.hijoIzquierdo = hijo;
        this.hermanoDerecho = hermano;

    }


    //OBSERVADORES
    public Object getElem(){
        return this.elem;
    }

    public NodoGen getHijoIzquierdo(){
        return this.hijoIzquierdo;
    }

    public NodoGen getHermanoDerecho(){
        return this.hermanoDerecho;
    }

    //MODIFICADORES
    public void setElem(Object elem){
        this.elem = elem;
    }

    public void setHijoDerecho(NodoGen nodo){
        this.hijoIzquierdo = nodo;
    }

    public void setHermanoDerecho(NodoGen nodo){
        this.hermanoDerecho = nodo;
    }
}
