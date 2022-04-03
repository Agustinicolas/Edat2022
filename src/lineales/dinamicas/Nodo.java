package lineales.dinamicas;

/**
 *
 * @author Hernandez Agustin 
 * FAI-505
 *
 */

public class Nodo {
    
    //ATRIBUTOS
    private Object elem;
    private Nodo enlace;


    //CONSTRUCTOR
    
    public Nodo(Object elem, Nodo enlace){
        this.elem = elem;
        this.enlace = enlace;
    }


    //MODIFICADORES

    public void setElem(Object elem){
        this.elem = elem;
    }

    public void setEnlace(Nodo enlace){
        this.enlace = enlace;
    }


    //OBSERVADORES

    public Object getElem(){
        return this.elem;
    }

    public Nodo getEnlace(){
        return this.enlace;
    }
}
