package lineales.dinamicas;

public class Pila {
    
    //ATRIBUTOS
    private Nodo tope;


    //CONSTRUCTORES
    public Pila(){
        this.tope = null;
    }


    //METODOS PROPIOS
    public boolean apilar(Object elem){
        Nodo nuevoNodo = new Nodo(elem, this.tope); //Crea nuevo nodo apuntando a tope de pila
        this.tope = nuevoNodo; //El tope de la pila apunta hacia el nuevo nodo

        return true; //No hay caso en el que la pila no pueda apilar. No existe caso de pila llena en pila dinamica
    }


    public void desapilar(){
        this.tope = this.tope.getEnlace();
    }


    public Object obtenerTope(){
        return this.tope.getElem(); //Devuelve el Object del nodo tope

    }


    public boolean esVacia(){
        boolean vacia = false;

        if (this.tope.getElem()== null){
            vacia = true;
        }
        return vacia;
    }

    public Pila clone(){
        Pila clon = new Pila();
        Nodo nodoAux = new Nodo(null,null);
    }
}
