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
        Nodo aux1;
        Nodo aux2;
        Nodo nodoClon;
        
		 if (!this.esVacia()){
            nodoClon = new Nodo(this.tope.getElem(), null);
            pilaClon.tope = nodoClon;
            aux1 = this.tope.getEnlace();
            aux2 = nodoClon;

            while (aux1 != null){
                
                aux2.setEnlace(new Nodo(aux1.getElem(),null));
                aux1 = aux1.getEnlace();
                aux2 = aux2.getEnlace();
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
