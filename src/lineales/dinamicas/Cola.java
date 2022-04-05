package lineales.dinamicas;

public class Cola {
    
    //ATRIBUTOS
    private Nodo frente;
    private Nodo fin;

    //CONSTRUCTOR

    public Cola(){
        this.frente = null;
        this.fin = null;
    }


    //METODOS PROPIOS

    public boolean poner(Object elemento){
        boolean exito = true;
        Nodo nuevoNodo;

        nuevoNodo = new Nodo(elemento,null);
        if (this.esVacia()){ //Si la cola esta vacía, frente y fin apuntan al nuevo nodo creado
            this.frente = nuevoNodo;            
        }else{ //Si la cola no esta vacia, se enlaza el fin de la cola al nodo creado y se setea como el nuevo final.
            this.fin.setEnlace(nuevoNodo);
            }
        this.fin = nuevoNodo;

        return exito;
    }


    public boolean sacar(){
        boolean exito = true;

        if(this.esVacia())
            exito = false; //si la cola esta vacia, retorna falso
        else{ //si la cola no esta vacia, frente apunta al siguiente elemento de la cola
            this.frente = this.frente.getEnlace();
            if (this.frente == null)//si la cola queda vacia luego de sacar, se "arregla" donde apunta fin
                this.fin = null;
        }

        return exito;
    }


    public Object obtenerFrente(){
        Object elemento = null;

        if(!this.esVacia()){
            elemento = this.frente.getElem();
        }
        return elemento;
    }


    public boolean esVacia(){
        boolean exito = false;

        if(this.frente == null){
            exito = true;
        }

        return exito;
    }


    public void vaciar(){

        this.frente = null;
        this.fin = null;
    }


    public Cola clone(){
        Cola colaClon = new Cola();
        Nodo nodoAux; //nodo auxiliar que recorre cola clon
        Nodo aux1; //nodo auxiliar que recorre cola original

        if(!this.esVacia()){ //si la cola no es vacía, se crea el primer elemento en colaClon
            nodoAux = new Nodo(this.frente.getElem(), null);
            colaClon.frente = nodoAux;
            colaClon.fin = nodoAux;
            aux1 = this.frente.getEnlace();

            while (aux1 != null){ //recorre del segundo al ultimo elemento de la cola
                nodoAux.setEnlace(new Nodo(aux1.getElem(),null));
                nodoAux = nodoAux.getEnlace();
                aux1 = aux1.getEnlace();        
            }
            colaClon.fin = nodoAux;
        }

        return colaClon;
    }


    public String toString(){
        String cadena ="";
        Nodo aux;

        if (this.esVacia())
            cadena = "Cola vacia";
        else{
            cadena = "Frente -> | ";
            aux = this.frente;
            cadena = cadena + this.frente.getElem().toString() + " | ";
            aux = aux.getEnlace();
            while(aux != null){
                cadena = cadena + aux.getElem().toString()+ " | ";
                aux = aux.getEnlace();
            }
            cadena = cadena + " <- Final";

        }

        return cadena;
    }
}
