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


    public boolean desapilar(){
        boolean exito = false;
        if (this.tope != null){
            this.tope = this.tope.getEnlace();
            exito = true;
        }
        return exito;
    }


    public Object obtenerTope(){
        return this.tope.getElem(); //Devuelve el Object del nodo tope

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
		Nodo aux1 = new Nodo(this.tope.getElem(), this.tope.getEnlace()); //primer nodo auxiliar, recorre pila original
		Nodo topeCopia = new Nodo(aux1.getElem(),aux1.getEnlace()); //nodo tope de pila clon, clona elementos de aux1 (tope pila original)
		pilaClon.tope = topeCopia; //setea el tope de pila clon
		Nodo aux2 = topeCopia; //segundo nodo auxiliar, recorre pila clon
		
		while (aux1 != null) {
			aux1 = aux1.getEnlace(); //"corrimiento" del aux1 sobre la pila original
			Nodo nuevo = aux1; //se crea nuevo nodo, apunta a aux1
			aux2.setEnlace(nuevo); //nodo aux2 apunta a nodo nuevo
			aux2 = aux2.getEnlace(); //"corrimiento" de aux2
			
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
