package lineales.dinamicas;


public class Lista {
     
    //ATRIBUTOS
    private Nodo cabecera;
    private int longitud;

    
    //CONSTRUCTOR
    public Lista(){
        this.cabecera = null;
        this.longitud = 0;
    }

    
    //METODOS PROPIOS

    public boolean insertar(Object elem, int pos){
        
        boolean exito = false;
        Nodo aux;
        Nodo nuevoNodo;
        int i;

        if (pos <= this.longitud+1 && pos > 0){
            if (pos == 1){
                this.cabecera = new Nodo(elem, this.cabecera);
            }else{
                aux = this.cabecera;
                i = 1;
                while(i < pos-1){
                    aux = aux.getEnlace(); 
                    i++;
                }
                nuevoNodo = new Nodo(elem, aux.getEnlace());
                aux.setEnlace(nuevoNodo);                
            }
            this.longitud ++;
            exito = true;
        }
        return exito;
    }


    public boolean eliminar(int pos){

        boolean exito = false;
        Nodo aux;
        int i;
        int posicion = pos -1;

        if(pos > 0 && pos <= this.longitud){
            if(pos  == 1){
                this.cabecera = this.cabecera.getEnlace();
            }else{
                aux = this.cabecera;
                i = 1;
                while(i< posicion){
                    aux = aux.getEnlace();
                    i++;
                }
                aux.setEnlace(aux.getEnlace().getEnlace());
            }
            this.longitud --;
            exito = true;
        }

        return exito;
    }


    public Object recuperar(int pos){

        Object elem = null;
        int i=1;
        Nodo aux;

        if(pos > 0 && pos <= this.longitud){
            aux = this.cabecera;
            while(i < pos){
                aux = aux.getEnlace();
                i++;
            }
            elem = aux.getElem();
        }
        return elem;
    }


    public int localizar(Object elem){

        int pos = -1;
        Nodo aux;
        int i = 1;
        boolean encontrado = false;
        int longitud = this.longitud;

        if(!this.esVacia()){
            aux = this.cabecera;
            while (i <= longitud && !encontrado){
                if ( aux.getElem().equals(elem)){
                    pos = i;
                    encontrado = true;                    
                }
                i++;
                aux = aux.getEnlace();
            }
        }
        return pos;        
    }


    public int longitud(){
        
        return this.longitud;
    }


    public boolean esVacia(){
        
        boolean vacia = true;

        if (this.cabecera != null)
            vacia = false;
        return vacia;
    }


    public void vaciar(){

        this.cabecera = null;
        this.longitud = 0;
    }


    public Lista clone(){

        Lista listaClon = new Lista();
        Nodo aux1;
        Nodo aux2;

        if (!this.esVacia()){
            aux1 = this.cabecera;
            listaClon.cabecera = new Nodo(this.cabecera.getElem(), null);
            aux2 = listaClon.cabecera;
            listaClon.longitud++;
            aux1 = aux1.getEnlace();
            while(aux1 != null){
                aux2.setEnlace(new Nodo(aux1.getElem(), null));
                aux1 = aux1.getEnlace();
                aux2 = aux2.getEnlace();
                listaClon.longitud ++;
            }
        }
        return listaClon;
    }


    public String toString(){
        
        String cadena = "";
        Nodo aux;
        int i;
        int longitud = this.longitud;

        if(this.esVacia())
            cadena = "Lista vacia.";
        else{
            cadena = "cabecera -> ";
            i = 0;
            aux = this.cabecera;
            while(i < longitud){
                cadena = cadena + aux.getElem().toString()+ " | ";
                aux = aux.getEnlace();
                i++;
            }
        }
        return cadena;
    }
}
