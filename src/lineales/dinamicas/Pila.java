package lineales.dinamicas;

/**
 *
 * @author Hernandez Agustin 
 * FAI-505
 *
 */

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


    public boolean desapilar(){
        boolean exito = false;
        if (this.tope != null){
            this.tope = this.tope.getEnlace();
            exito = true;
        }
        return exito;
    }


    public Object obtenerTope(){
        
        Object obj = new Object();
        obj = null;
        if (!this.esVacia()){
            obj = this.tope.getElem(); //Devuelve el Object del nodo tope
        }
        return obj;
    }


    public boolean esVacia(){
        boolean vacia = false;

        if (this.tope == null){
            vacia = true;
        }
        return vacia;
    }

    public void vaciar(){
        this.tope = null;
    }

    public Pila clone(){
        
        Pila pilaClon = new Pila();
        Nodo aux1; //nodo auxiliar que recorre pila original
        Nodo aux2; //nodo auxiliar que recorre pila clon
        Nodo nodoClon;
        
		 if (!this.esVacia()){ // si la pila no esta vacía, se clona el tope
            nodoClon = new Nodo(this.tope.getElem(), null);
            pilaClon.tope = nodoClon;
            aux1 = this.tope.getEnlace(); //aux1 apunta al elemento siguiente de pila original
            aux2 = nodoClon;

            while (aux1 != null){ //mientras el elemento siguiente exista
                
                aux2 = new Nodo(aux1.getElem(), null); //creacion de nuevo nodo
                aux1 = aux1.getEnlace(); 
                nodoClon.setEnlace(aux2); //se une el nodo nuevo a la pila clon
                nodoClon = nodoClon.getEnlace();
            }
         }

         return pilaClon;
    }

    @Override
    public String toString(){
        String cadena = "";

        if (this.tope == null)
            cadena = "Pila vacía";
        else{
            Nodo aux = this.tope;
            cadena = "tope -> [ ";
            while (aux != null){
                //Agrega el texto del elemento y avanza
                cadena += aux.getElem().toString();
                aux = aux.getEnlace();
                if (aux != null)
                    cadena += " , ";
            }
            cadena += " ]";
        }
        return cadena;
    }
}
