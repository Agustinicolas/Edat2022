package lineales.estaticas;

public class Pila {
    
    //ATRIBUTOS
    private Object[] arreglo;
    private int tope;
    private static final int TAMANIO = 20;


    //CONSTRUCTOR
    public Pila(){
        this.arreglo = new Object[this.TAMANIO];
        this.tope = -1;
    }


    //METODOS PROPIOS

    public boolean apilar(Object elem){
        boolean exito;

        if (this.tope +1 >= this.TAMANIO) //pila llena, error
            exito = false;
        else{ //incrementa el tope e ingresa el elemento en la pila
            this.tope ++;
            this.arreglo[tope] = elem;
            exito = true;
        }
        return exito;
    }

    public boolean desapilar(){
        boolean exito;

        if(this.tope == -1) //pila vacía, error
            exito = false;
        else{ //elimina el elemento del tope y decrementa el tope
            arreglo[tope] = null;
            this.tope --;
            exito = true;
        }
        return exito;
    }

    public Object obtenerTope(){
        //Devuelve el elemento que se encuentra en el tope. Si la pila esta vacía retorna un Object null.
        Object elemento = new Object();
        elemento = null;
        if(this.tope >= 0){
            elemento = this.arreglo[tope];
         }
        return elemento;
    }

    public boolean esVacía(){
        //Devuelve true si la pila es vacía, caso contrario devuelve false
        boolean vacia = false;

        if(this.tope == -1){
            vacia = true;
        }
        return vacia;
    }

    public void vaciar(){
        //vacía todos los elementos de la pila y coloca el tope en -1
        int n = this.tope;
        int i;
        for ( i = 0; i <= n; i++){
            arreglo[i] = null;
        }
        this.tope = -1;
    }

    public Pila clone(){
        //clona la pila y devuelve su clon.

        Pila clon = new Pila();
        clon.tope = this.tope;
        clon.arreglo = this.arreglo.clone();
        return clon;
    }

    public String toString(){
        //Devuelve un String con los elementos de la pila. Método para testeo
        String cadena =" ";
        int n = this.tope;
        int i;

        if (n == -1){ //caso de pila vacía
            cadena = "Pila vacía";
        }else{ // caso de pila no vacía
            for (i = 0; i <= n; i++){
                cadena = cadena + (String)arreglo[i] + " | ";
            }
            cadena = cadena + "<- tope";
        }
        return cadena;
    }
}
