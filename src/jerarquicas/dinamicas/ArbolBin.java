/*
 *
 * @author Hernandez Agustin 
 * FAI-505
 *
 */
package jerarquicas.dinamicas;

import lineales.dinamicas.*;

public class ArbolBin {
    
    private NodoArbol raiz;


    //CONSTRUCTOR
    public ArbolBin(){
        this.raiz = null;
    }


    //METODOS PROPIOS

    public boolean insertar (Object elemNuevo, Object elemPadre, char lugar){
        /*  
            inserta elemNuevo  como hijo del primer nodo encontrado en preorden igual a elemPadre, 
            como hijo izquierdo (I) o hijo derecho (D), segun lo indique el parametro lugar
        */  
        boolean exito = true;

        if(this.raiz == null){
            //si el arbol esta vacio, pone elemNuevo en la raiz
            this.raiz = new NodoArbol(elemNuevo, null, null);
        }else{
            //si arbol no esta vacio, busca el padre
            NodoArbol nPadre = obtenerNodo(this.raiz, elemPadre);

            //si padre existe y lugar no esta ocupado lo pone, sino da error
            if(nPadre != null){
                if (lugar == 'I' && nPadre.getIzquierdo() == null){
                    nPadre.setIzquierdo(new NodoArbol(elemNuevo, null,null));
                }else if(lugar == 'D' && nPadre.getDerecho() == null){
                    nPadre.setDerecho(new NodoArbol(elemNuevo, null, null));
                }else{
                    exito = false;
                }
            }else{
                exito = false;
            }
        }
        return exito;
    }


    private NodoArbol obtenerNodo(NodoArbol n, Object buscado){
        // metodo privado que busca un elemento y devuelve el nodo que
        //lo contiene. Si no se encuentra el buscado devuelve null
        NodoArbol resultado = null;

        if (n != null){
            if (n.getElem().equals(buscado)){
                //si el buscado es n, lo devuelve
                resultado = n;
            }else{
                //no es el buscado: busca primero en el HI
                resultado = obtenerNodo(n.getIzquierdo(), buscado);
                //si no lo encontro en el HI, busca en el HD
                if (resultado == null){
                    resultado = obtenerNodo(n.getDerecho(), buscado);
                }
            }
        }
        return resultado;
    }


    public boolean esVacio(){
        boolean vacio = false;

        if (this.raiz == null){
            vacio = true;
        }
        return vacio;
    }


    public Object padre(Object elemento){
        //Dado un elemento, devuelve el valor almacenado en su nodo padre (busca la primera aparicion del elemento)
        NodoArbol padre = new NodoArbol(null, null, null);
        Object elem = null;

        if (!this.esVacio()){
            if(elemento.equals(this.raiz.getElem()) || this.esVacio()){
                elem = null;
            }else{
                padre = padreAux(elemento, this.raiz);
            }

            if (padre == null)
                elem = null;
         else
             elem = padre.getElem();
        }
            return elem;        
    }


    private NodoArbol padreAux(Object elemento, NodoArbol n){
        //Metodo privado auxiliar del metodo padre
        NodoArbol padre = null;

        if (n != null){
            if (  (n.getIzquierdo() != null && n.getIzquierdo().getElem().equals(elemento)) || (n.getDerecho() != null && n.getDerecho().getElem().equals(elemento)) ){
                padre = n;
            }else{
                padre = padreAux(elemento, n.getIzquierdo());
                if ( padre == null){
                    padre = padreAux(elemento, n.getDerecho());
                }
            }
        }
        return padre;
    }


    public int altura(){
        //Devuelve la altura del arbol, es decir la longitud del camino más largo desde la raíz hasta una hoja
        //Un arbol vacío tiene altura -1, una hoja tiene altura 0
        int altura = -1;

        if (!this.esVacio()){
            altura = 0;
            altura = alturaAux(this.raiz);
        }
        return altura;
    }


    private int alturaAux(NodoArbol n){
        int altura = -1;
        int alturaIzq;
        int alturaDer;
        if (n != null){
            alturaIzq = alturaAux(n.getIzquierdo());
            alturaDer = alturaAux(n.getDerecho());
            altura = mayor(alturaIzq, alturaDer)+1;
        }
        return altura;
    }

    private int mayor(int a, int b){
        //metodo privado auxiliar a altura aux, dados dos enteros ingresados por parametro devuelve el mayor.

        int mayor = a;
        if (b > a){
            mayor = b;
        }
        return mayor;
    }


    public int nivel(Object elem){
        //Devuelve el nivel de un elemento del arbol. Si el elemento no existe el arbol devuelve -1
        int resultado = -1;
        
        if (!this.esVacio()){
            resultado = nivelAux(this.raiz, elem, -1);
        }
        return resultado;
    }


    private int nivelAux(NodoArbol n, Object elem, int nivel){ 
        //metodo privado auxiliar al metodo nivel
        int resul = -1;

        if(n != null){
            if ( n.getElem().equals(elem)){
                resul = nivel+1;
            }else{
                resul = nivelAux(n.getIzquierdo(), elem, nivel+1);
                if (resul == -1){
                    resul = nivelAux(n.getDerecho(), elem, nivel+1);
                }
            }
        }

        return resul;
    }


    public Lista listarPreorden(){
        //retorna una lista con los elementos del arbol en PREORDEN
        Lista lis = new Lista();
        listarPreordenAux(this.raiz, lis);
        return lis;
    }


    private void listarPreordenAux(NodoArbol nodo, Lista lis){
        //metodo recursivo privado porque su parametro es del tipo NodoArbol

        if(nodo != null){
            //visita el elemento del nodo
            lis.insertar(nodo.getElem(), lis.longitud()+1); //(1)

            //recorre a sus hijos en preorden
            listarPreordenAux(nodo.getIzquierdo(), lis); //(2)
            listarPreordenAux(nodo.getDerecho(), lis); //(3)
        }
    }


    public Lista listarInorden(){
        //retorna una lista con los elementos del arbol en INORDEN
        Lista lis = new Lista();
        listarInordenAux(this.raiz, lis);
        return lis;
    }


    private void listarInordenAux(NodoArbol nodo, Lista lis){
        //metodo recursivo privado porque su parametro es del tipo NodoArbol

        if(nodo != null){
            //recorre el hijo izquierdo en inorden
            listarInordenAux(nodo.getIzquierdo(), lis); //(1)
            //visita la raiz del subarbol
            lis.insertar(nodo.getElem(), lis.longitud()+1); //(2)
            //recorre el hijo derecho en inorden
            listarInordenAux(nodo.getDerecho(), lis); //(3)
        }
    }


    public Lista listarPosorden(){
        //retorna una lista con los elementos del arbol en POSORDEN
        Lista lis = new Lista();
        listarPosordenAux(this.raiz, lis);
        return lis;
    }


    private void listarPosordenAux(NodoArbol nodo, Lista lis){
        //metodo recursivo privado porque su parametro es del tipo NodoArbol

        if(nodo != null){
            //recorre a sus hijos en posorden
            listarPosordenAux(nodo.getIzquierdo(), lis); //(1)
            listarPosordenAux(nodo.getDerecho(), lis); //(2)
            //visita el elemento del nodo
            lis.insertar(nodo.getElem(), lis.longitud()+1); //(3)
        }
    }


    public Lista listarPorNiveles(){
        //Devuelve una lista con los elementos del arbol binario en recorrido por niveles
        Cola cola = new Cola();
        Lista lis = new Lista();
        NodoArbol nodoActual;
        if (!this.esVacio()){
            cola.poner(this.raiz);
            while ( !cola.esVacia()){
                nodoActual = (NodoArbol) cola.obtenerFrente();
                cola.sacar();
                lis.insertar(nodoActual.getElem(), lis.longitud()+1);
                if ( nodoActual.getIzquierdo() != null){
                    cola.poner(nodoActual.getIzquierdo());
                }
                if(nodoActual.getDerecho() != null){
                    cola.poner(nodoActual.getDerecho());
                }
            }
        }
        return lis;

    }


    public void vaciar(){
        this.raiz = null;
    }

    
    @Override
    public ArbolBin clone(){
        //Genera y crea un arbol binario equivalente al original

        ArbolBin arbolClon = new ArbolBin();

        if(!this.esVacio()){
            arbolClon.raiz = cloneAux(this.raiz);
        }

        return arbolClon;
    }


    private NodoArbol cloneAux(NodoArbol n){
        //metodo privado auxiliar al metodo clone
        
        NodoArbol nodoNuevo = new NodoArbol(null,null,null);
        if (n != null){
            nodoNuevo.setElem(n.getElem());
            if(n.getIzquierdo() != null)
                nodoNuevo.setIzquierdo(cloneAux(n.getIzquierdo()));
            if(n.getDerecho() != null)
                nodoNuevo.setDerecho(cloneAux(n.getDerecho()));
        }
        return nodoNuevo;
    }


    @Override
    public String toString(){
        //Genera y devuelve una cadena de caracteres que indica cual es la raiz del arbol
        //y quienes son los hijos de cada nodo
        String cadena = "";
        if (this.esVacio()){
            cadena = "Arbol vacio.";
        }else{
            cadena = toStringAux(this.raiz);
        }
        return cadena;
    }


    private String toStringAux(NodoArbol n){
        //metodo privado auxiliar al metodo toString
        String cadena = "";
        String hi = " - ";
        String hd = " - ";
        if(n!= null){
            cadena = "\nElem: "+ n.getElem().toString(); // impresión del nodo visitado
            if (n.getIzquierdo() != null)
                hi = n.getIzquierdo().getElem().toString();
            if (n.getDerecho() != null)
                hd = n.getDerecho().getElem().toString();
            cadena = cadena + "\t HI: "+hi+"\t HD: "+hd;
            cadena = cadena + toStringAux(n.getIzquierdo()); //recorre subarbol izquierdo del nodo
            cadena = cadena + toStringAux(n.getDerecho()); //recorre subarbol derecho del nodo
            
        }
        return cadena;
    }


    public Lista frontera(){
        //Devuelve una lista con todos los elementos almacenados en las hojas del arbol
        //listadas de izquierda a derecha
        Lista lis = new Lista();

        if (!this.esVacio())
            lis = fronteraAux(this.raiz, lis);

        return lis;
    }


    private Lista fronteraAux(NodoArbol n, Lista lis){
        //Metodo privado recursivo auxiliar al metodo frontera

        if (n != null){
            if (n.getDerecho() == null && n.getIzquierdo() == null){
                lis.insertar(n.getElem(), lis.longitud()+1);
            }else{
                if ( n.getIzquierdo() != null){
                    lis = fronteraAux(n.getIzquierdo(), lis);
                }
                if( n.getDerecho() != null){
                    lis = fronteraAux(n.getDerecho(), lis);
                }
            }
        }
        return lis;
    }

}
