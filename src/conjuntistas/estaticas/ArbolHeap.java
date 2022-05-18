package conjuntistas.estaticas;

public class ArbolHeap {
    
    //ATRIBUTOS
    private static int TAMANIO = 20;
    private Comparable[] arreglo = new Comparable[TAMANIO-1];
    private int ultimo = 0;


    //CONSTRUCTOR
    public ArbolHeap(){

    }


    //METODOS PROPIOS
    
    public boolean esVacio(){
        return (ultimo==0);
    }

    public boolean insertar(Comparable elem){   //metodo que inserta un elemento al final del arbol y lo reacomoda para que cumpla los requerimientos de un arbol heap minimo

        boolean exito = true;
        int padre;
        Comparable aux;
        int pos;

        if(ultimo < TAMANIO-1){

            this.ultimo++;
            arreglo[this.ultimo] = elem;
            padre = this.ultimo/2;
            pos = ultimo;

            while (padre > 0){ //si el elemento tiene padre, se compara para reacomodar en caso de ser necesario

                if (arreglo[pos].compareTo(arreglo[padre]) < 0){ //si el elemento es menor al padre, se intercambian posiciones

                    aux = arreglo[padre];
                    arreglo[padre] = arreglo[pos];
                    arreglo[pos] = aux;
                    pos = padre;
                    padre = padre/2;
                
                }else{ //si el elemento es mayor o igual a su padre, no se realiza ningun cambio
                    padre = 0;
                }                
            }
        }else{
            exito = false; //si se llenó el arreglo retorna false sin poder agregar al elemento al arbol.
        }
        return exito;
    }


    public boolean eliminarCima(){
        boolean exito;
         if (this.ultimo ==0){  //estructura vacía
             exito = false;
         }else{ //saca la raiz y pone la ultima hoja en su lugar
             this.arreglo[1] = this.arreglo[ultimo];
             this.ultimo --;
             hacerBajar(1); //reestablece la propiedad de heap minimo
             exito = true;
         }
         return exito;
    }


    private void hacerBajar(int posPadre){
        int posH;
        Comparable temp = this.arreglo[posPadre];
        boolean salir = false;

        while (!salir){
            posH = posPadre *2;
            if(posH <= this.ultimo){
                //temp tiene al menos un hijo izq y lo considera menor
                if(posH < this.ultimo){ //hijo menor tiene un hermano derecho

                    if(this.arreglo[posH + 1].compareTo(this.arreglo[posH]) <0){
                        posH ++;
                    }
                }

                //compara al hijo menor con el padre
                if (this.arreglo[posH].compareTo(temp) < 0){
                    //el hijo es menor que el padre, los intercambia
                    this.arreglo[posPadre] = this.arreglo[posH];
                    this.arreglo[posH] = temp;
                    posPadre = posH;
                }else{
                    //el padre es menor que sus hijos, esta bien ubicado
                    salir = true;
                }
            }else{
                //el temp es una hoja, esta bien ubicado
                salir = true;
            }
        }
    }


    public Comparable recuperarCima(){
        //devuelve el elemento que está en la raíz
        //Precondición: el arbol no se encuentra vacio
        return arreglo[1];
    }
    

    public String toString(){
        String cadena ="";
        int indice = 1;
        int hi;
        int hd;

        if(this.ultimo == 0){   //Si el arbol esta vacio
            cadena = "Arbol vacio";
        }else{
            while ( indice < TAMANIO && indice <= ultimo){
                cadena = cadena + arreglo[indice].toString()+"\t|";
                hi = indice *2;
                if (hi <= ultimo){
                    cadena = cadena + arreglo[hi].toString()+"\t|";
                }else{
                    cadena = cadena + " - \t";
                }
                hd = indice *2 +1;
                if (hd <= ultimo){
                    cadena = cadena + arreglo[hd].toString()+"\t|";
                }else{
                    cadena = cadena + " - \t";
                }
                cadena = cadena + "\n";

                indice++;
            }
        }
        return cadena;
    }


    public ArbolHeap clone(){
        ArbolHeap clon = new ArbolHeap();
        if (this.ultimo != 0){
            clon.ultimo = this.ultimo;
            clon.arreglo = this.arreglo.clone();
        }
        return clon;
    }
    
}
