package lineales.estaticas;

public class Cola {
    
    //ATRIBUTOS
    private static final int TAMANIO = 10;
    private Object[] arreglo;
    private int frente;
    private int fin;
    
    
    //CONSTRUCTOR
    public Cola(){
        this.arreglo = new Object[this.TAMANIO];
        this.frente = 0;
        this.fin = 0;
    }


    //METODOS PROPIOS

    public boolean esVacia(){
        boolean vacia = false;

        if (this.frente == this.fin)
            vacia = true;

        return vacia;
    }


    public boolean poner(Object elemento){
        boolean exito = false;

        if(!((this.fin+1)%TAMANIO == this.frente)){ //verifica que cola no este llena
            exito = true;
            this.arreglo[this.fin] = elemento;
            this.fin = (this.fin + 1) % TAMANIO; //corrimiento circular de indice fin
        }
        return exito;
    }


    public boolean sacar(){
        boolean exito = true;

        if (this.esVacia()) //VERIFICA QUE COLA NO ESTE vacia
            exito = false;
        else{
            this.arreglo[this.frente] = null;
            this.frente = (this.frente +1) % TAMANIO; //corrimiento "circular" de indice frente
        }
        return exito;
    }


    public Object obtenerFrente(){
        Object elem = null;

        if (!this.esVacia()){
            elem = this.arreglo[this.frente];
        }
        return elem;

    }


    public void vaciar(){

        if (!this.esVacia()){
            while ( this.fin != this.frente){
                arreglo[this.frente] = null;
                this.frente = (this.frente +1)%TAMANIO;
            }
            this.frente = 0;
            this.fin = 0;
        }
    }


    public Cola clone(){
        Cola colaClon = new Cola();

        colaClon.arreglo = this.arreglo.clone();
        colaClon.frente = this.frente;
        colaClon.fin = this.fin;
        return colaClon;
        
    }


    public String toString(){
        String cadena = "frente -> | ";
        int i = this.frente;

        if (this.esVacia())
            cadena = "Cola vacía.";
        else{
            while ( i != this.fin){
                cadena = cadena + this.arreglo[i].toString() + " | ";
                i = (i + 1)%TAMANIO;
            }
            cadena = cadena + " <- final";
        }
        return cadena;
    }


}
