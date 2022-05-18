package jerarquicas.dinamicas;
import lineales.dinamicas.*;

public class ArbolGen {
    private NodoGen raiz;


    //CONSTRUCTOR
    public ArbolGen(){
        this.raiz = null;
    }

    
    public boolean insertar(Object elemNuevo, Object padre){
        /*
        Dado un elemento elemNuevo y un elemento padre, agrega elemNuevo como hijo de la primera aparición de padre.
        No se establece ninguna preferencia respecto a la posicion del hijo respecto a sus posibles hermanos.
        Devuelve verdadero cuando se pudo agregar elemNuevo a la estructura y falso en caso contrario.
        */
        
        boolean exito = true;
        if (this.raiz == null){
            //si el arbol esta vacio, se agrega el elemento como raíz
            this.raiz = new NodoGen(elemNuevo, null, null);
        }else{
            //si el arbol no esta vacio, busca el padre
            NodoGen nodoPadre = obtenerNodo(this.raiz, padre);

            if (nodoPadre != null){
                //si el nodo padre existe, se agrega el elemento
                if(nodoPadre.getHijoIzquierdo() == null){
                    //si el nodo padre es hoja, agrega como hijo izquierdo
                    nodoPadre.setHijoIzquierdo(new NodoGen(elemNuevo, null, null));
                }else{
                    //si el nodo padre tiene hijo/s, enlaza elemNuevo
                    NodoGen hermano = nodoPadre.getHijoIzquierdo();
                    while (hermano.getHermanoDerecho() != null){
                        hermano = hermano.getHermanoDerecho();
                    }
                    hermano.setHermanoDerecho(new NodoGen(elemNuevo, null, null));

                }
            }else{
                //si el elemento padre no existe en la estructura
                exito = false;
            }
        }
        return exito;
    }


    private NodoGen obtenerNodo(NodoGen n, Object buscado){
        // metodo privado que busca un elemento y devuelve el nodo que
        //lo contiene. Si no se encuentra el buscado devuelve null
        NodoGen resultado = null;

        if (n != null){
            if(n.getElem().equals(buscado)){
                //si el elemento buscado coincide con n, lo devuelve
                resultado = n;
            }else{
                if(n.getHijoIzquierdo() != null){
                    //busca en el subarbol izquierdo
                    resultado = obtenerNodo(n.getHijoIzquierdo(), buscado);
                    if (resultado == null){
                        //busqueda en subarbol derecho
                        NodoGen hermano = n.getHijoIzquierdo().getHermanoDerecho();
                        while (hermano != null && resultado == null){
                            resultado = obtenerNodo(hermano, buscado);
                            hermano = hermano.getHermanoDerecho();
                        }
                    }
                }
            }
        }
        return resultado;

    }


    public boolean pertenece(Object elem){
        //Devuelve true si el elemento ingresado por parametro se encuentra en el arbol. Caso contrario devuelve false
        boolean encontrado = false;

        if (this.raiz != null){
            encontrado = perteneceAux(this.raiz, elem);
        }

        return encontrado;
    }


    private boolean perteneceAux(NodoGen n, Object elem){
        boolean encontrado = false;
        if (n != null){
            //compara el nodo con el elemento buscado
            encontrado = (n.getElem().equals(elem));
            if (!encontrado){
                //si el elemento del nodo no coincide con el buscado
                if(n.getHijoIzquierdo() != null){
                    //compara con el subarbol izquierdo
                    encontrado = perteneceAux(n.getHijoIzquierdo(), elem);
                    if(!encontrado){
                        //si no encontro el elemento, busca en subarbol derecho
                        NodoGen hermano = n.getHijoIzquierdo().getHermanoDerecho();
                        while ( hermano != null && !encontrado){
                            encontrado = perteneceAux(hermano, elem);
                            hermano = hermano.getHermanoDerecho();
                        }
                    }
                }
            }
        }
        return encontrado;
    }


    public boolean esVacio(){
        //Devuelve true si el arbol es vacio, caso contrario devuelve false
        boolean vacio = false;

        if(this.raiz == null)
            vacio = true;

        return vacio;
    }


    public void vaciar(){
        this.raiz = null;
    }


    public Object padre(Object elem){
        //Dado un elemento devuelve el objeto almacenado en su nodo padre (busca la primera aparicion del elemento)
        NodoGen padre = null;
        Object elemPadre = null;
        if(this.raiz != null ){
            if(!this.raiz.getElem().equals(elem)){
                padre = padreAux(this.raiz,elem);
                if(padre != null)
                    elemPadre = padre.getElem();
            }
        }
        
        return elemPadre;
    }


    private NodoGen padreAux(NodoGen n, Object buscado){
        NodoGen padre = null;
        if(n != null){
            if(n.getHijoIzquierdo() != null){
                if(n.getHijoIzquierdo().getElem().equals(buscado)){
                    padre = n;
                }
                if (padre == null){
                    padre = padreAux(n.getHijoIzquierdo(), buscado);
                }
                if(padre == null){
                    NodoGen hermano = n.getHijoIzquierdo().getHermanoDerecho();
                    while ( hermano != null && padre == null){
                        if(hermano.getElem().equals(buscado)){
                            padre = n;
                        }
                        if (padre == null){
                            padre = padreAux(hermano, buscado);
                            hermano = hermano.getHermanoDerecho();
                        }
                    }
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


    private int alturaAux(NodoGen n){
        int altura= 0;
        int altAux;
        int altMayor = -1;

        if(n!=null){
            if(n.getHijoIzquierdo()!=null){
                altura = alturaAux(n.getHijoIzquierdo())+1;
            
                NodoGen hermano = n.getHijoIzquierdo().getHermanoDerecho();
                while(hermano != null){
                    altAux = alturaAux(hermano)+1;
                    if (altAux > altMayor){
                        altMayor = altAux;
                    }
                    hermano = hermano.getHermanoDerecho();
                }
                altura = Math.max(altura, altMayor);
            }

            
        }
        return altura;
    }

    public int nivel(Object elem){
        //Devuelve el nivel de un elemento en el arbol. si el elemento no existe en el arbol, o el arbol es vacío devuelve -1.
        
        int nivel = -1;
        if (this.raiz != null){
            nivel = nivelAux(this.raiz, elem, nivel);
        }

        return nivel;
    }


    private int nivelAux(NodoGen n, Object elem, int niv){
        //Metodo privado recursivo auxiliar al metodo nivel
        int resul = -1;

        if (n != null){
            if(n.getElem().equals(elem)){
                resul = niv +1;
            }else{
                    if(n.getHijoIzquierdo()!= null){
                        resul = nivelAux(n.getHijoIzquierdo(), elem, niv+1);
                        if(resul == -1){
                            NodoGen hermano = n.getHijoIzquierdo().getHermanoDerecho();
                            while(hermano != null && resul == -1){
                                resul = nivelAux(hermano, elem, niv+1);
                                hermano = hermano.getHermanoDerecho();
                            }
                        }
                    }
                }
            }
        return resul;
    }


    public Lista ancestros(Object elem){
        //Si el elemento se encuentra en el arbol, devuelve una lista con el camino desde la raiz hasta dicho elemento.
        //el metodo auxiliar devuelve una pila con el recorrido desde el elemento en cuestión hacia la raíz, luego se insertan los elementos de la lista
        //a medida que la pila se vacía, así la lista final muestra el recorrido de ancestros a partir de la raíz
        Lista lis = new Lista();
        Pila pila = new Pila();
        if (this.raiz != null){
            ancestrosAux(elem, pila, this.raiz, false);
        }
        while(!pila.esVacia()){
            lis.insertar(pila.obtenerTope(), lis.longitud()+1);
            pila.desapilar();
        }
        return lis;
    }


    private boolean ancestrosAux(Object elem, Pila pila,NodoGen n, boolean encontrado){
        //Metodo auxiliar recursivo al metodo ancestros
        //recorre en posorden el arbol en busca del Object elem ingresado por parametro
        //Una vez que lo encuentra, apila desde el nodo que tiene su elemento hasta la raíz, recorriendo sus ancestros
        //devuelve true o false en caso de haber encontrado el elemento en el arbol o no
        if (n != null){ 
            
            if (elem.equals(n.getElem())){ //verifica si el nodo n es el elemento buscado
                encontrado = true;
            }
            if (!encontrado){
                if(n.getHijoIzquierdo()!=null){//recorrido posorden del arbol
                    encontrado = ancestrosAux(elem, pila, n.getHijoIzquierdo(), encontrado); //recorre subarbol del primer hijo izquierdo
                    if(!encontrado){
                        NodoGen hermano = n.getHijoIzquierdo().getHermanoDerecho();
                        while(hermano != null && !encontrado){ //recorre recursivamente el resto de los hijos (hermanos del primer hijo izquierdo)
                            encontrado = ancestrosAux(elem, pila, hermano, encontrado);
                            hermano = hermano.getHermanoDerecho();
                        }
                    }
                }
                if (encontrado){
                    pila.apilar(n.getElem()); //si se encontró el elemento en el recorrido, se apila el elemento del nodo
                }
            }
            
        }
        return encontrado;
    }


    public int grado(){
        //metodo que devuelve el grado (cantidad de hijos) de un elemento del arbol dado.
        //utiliza el metodo privado auxiliar obtenernodo para realizar la búsqueda del elemento
        int grado = -1;
        if(this.raiz != null){            
            grado = gradoSubarbolAux(this.raiz, grado);
            
        }
        return grado;
    }


    public int gradoSubarbol(Object elem){
        //metodo que devuelve el grado del subarbol a partir del elemento ingresado por parámetro

        int grado = -1;
        if(this.raiz != null){
            NodoGen buscado = this.obtenerNodo(this.raiz, elem);
            if (buscado != null){
                grado = gradoSubarbolAux(buscado, grado);
            }
        }
        return grado;
    }


    private int gradoSubarbolAux(NodoGen n, int grado){
        //metodo privado auxiliar al metodo gradosubarbol
        int g = 0;
        if (n != null){
            if (n.getHijoIzquierdo() != null){
                g++;
                NodoGen hermano = n.getHijoIzquierdo().getHermanoDerecho();
                while(hermano != null){
                    g++;
                    hermano = hermano.getHermanoDerecho();
                }
                grado = gradoSubarbolAux(n.getHijoIzquierdo(), g);
                if (g > grado)
                    grado = g;
                hermano = n.getHijoIzquierdo().getHermanoDerecho();
                while(hermano != null){
                    grado = gradoSubarbolAux(hermano, g);
                    hermano = hermano.getHermanoDerecho();
                }           
            }
            if (g > grado)
                    grado = g;
        }
        return grado;
    }


    public Lista listarPreorden(){
        Lista salida = new Lista();
        listarPreordenAux(this.raiz, salida);
        return salida;
    }


    private void listarPreordenAux(NodoGen n, Lista lis){
        if(n != null){
            lis.insertar(n.getElem(), lis.longitud()+1);
            if (n.getHijoIzquierdo() != null){
                listarPreordenAux(n.getHijoIzquierdo(), lis);
                NodoGen hermano = n.getHijoIzquierdo().getHermanoDerecho();
                while (hermano != null){
                    listarPreordenAux(hermano, lis);
                    hermano = hermano.getHermanoDerecho();
                }
            }
        }
    }


    public Lista listarPosorden(){
        Lista salida = new Lista();
        listarPosordenAux(this.raiz, salida);
        return salida;
    }


    private void listarPosordenAux(NodoGen n, Lista lis){
        if(n != null){            
            if (n.getHijoIzquierdo() != null){
                listarPosordenAux(n.getHijoIzquierdo(), lis);
                NodoGen hermano = n.getHijoIzquierdo().getHermanoDerecho();
                while (hermano != null){
                    listarPosordenAux(hermano, lis);
                    hermano = hermano.getHermanoDerecho();
                }
            }
            lis.insertar(n.getElem(), lis.longitud()+1);
        }
    }


    public Lista listarInorden(){
        Lista salida = new Lista();
        listarInordenAux(this.raiz, salida);
        return salida;
    }


    private void listarInordenAux(NodoGen n, Lista ls){
        if (n != null){
            //llamado recursivo al primer hijo de n
            if (n.getHijoIzquierdo() != null){
                listarInordenAux(n.getHijoIzquierdo(), ls);
            }

            //visita el nodo n
            ls.insertar(n.getElem(), ls.longitud()+1);

            //llamados recursivos con los otros hijos de n
            if (n.getHijoIzquierdo() != null){
                NodoGen hijo = n.getHijoIzquierdo().getHermanoDerecho();
                while (hijo != null){
                    listarInordenAux(hijo, ls);
                    hijo = hijo.getHermanoDerecho();
                }
            }
        }
    }


    public Lista listarPorNiveles(){
        Lista salida = new Lista();
        Cola colaAux = new Cola();
        NodoGen nodoActual;
        if(this.raiz != null){
            colaAux.poner(this.raiz);
            while(!(colaAux.esVacia())){
                nodoActual = (NodoGen) colaAux.obtenerFrente();
                salida.insertar(nodoActual.getElem(), salida.longitud()+1);
                colaAux.sacar();
                if (nodoActual.getHijoIzquierdo() != null){
                    colaAux.poner(nodoActual.getHijoIzquierdo());
                    NodoGen hermano = nodoActual.getHijoIzquierdo().getHermanoDerecho();
                    while(hermano != null){
                        colaAux.poner(hermano);
                        hermano = hermano.getHermanoDerecho();
                    }
                }
            }
        }
        return salida;
    }


    public ArbolGen clone(){
        ArbolGen clon = new ArbolGen();

            if(this.raiz != null){
                clon.raiz = cloneAux(this.raiz);
            }

        return clon;
    }


    private NodoGen cloneAux(NodoGen n){
        NodoGen nuevo = new NodoGen(null, null, null);
        if (n != null){
            nuevo.setElem(n.getElem());
            if(n.getHijoIzquierdo() != null){
                nuevo.setHijoIzquierdo(cloneAux(n.getHijoIzquierdo()));
                NodoGen hermano = n.getHijoIzquierdo().getHermanoDerecho();
                NodoGen aux = nuevo.getHijoIzquierdo();
                while (hermano != null){
                    aux.setHermanoDerecho(cloneAux(hermano));
                    hermano = hermano.getHermanoDerecho();
                    aux = aux.getHermanoDerecho();
                }
            }
        }
        return nuevo;
    }


    @Override
    public String toString(){
        return toStringAux(this.raiz);
    }

    private String toStringAux(NodoGen n){
        String s = "";
        if (n != null){
            //visita el nodo n
            s += n.getElem().toString() + " -> ";
            NodoGen hijo = n.getHijoIzquierdo();
            while(hijo != null){
                s+= hijo.getElem().toString() + " , ";
                hijo = hijo.getHermanoDerecho();          
            }
            //comienza recorrido de los hijos de n llamando recursivamente para que
            //cada hijo agregue su subcadena a la general
            hijo = n.getHijoIzquierdo();
            while(hijo != null){
                s += "\n"+ toStringAux(hijo);
                hijo = hijo.getHermanoDerecho();
            }
        }else{
            s = "Arbol Vacio";
        }
        return s;
    }


    public Lista frontera(){
        //Devuelve una lista con los elementos frontera del arbol en orden de recorrido preorden
        Lista lis = new Lista();
        if (this.raiz != null){
            fronteraAux(this.raiz, lis);
        }
        return lis;
    }


    private void fronteraAux(NodoGen n, Lista lis){
        if (n != null){
            if(n.getHijoIzquierdo() == null){
                lis.insertar(n.getElem(), lis.longitud()+1);
            }else{
                fronteraAux(n.getHijoIzquierdo(), lis);
                NodoGen hermano = n.getHijoIzquierdo().getHermanoDerecho();
                while (hermano != null){
                    fronteraAux(hermano, lis);
                    hermano = hermano.getHermanoDerecho();
                }
            }
        }
    }

    public boolean sonFrontera(Lista unaLista){
        /*
        recibe una lista de elementos almacenada en una estructura del tipo TDA Lista y verifica si la lista contiene los elementos de la 
        frontera del árbol, sin importar el orden en que aparezcan los elementos en la lista elementos de la frontera del árbol.
        precondición del método sonFrontera: la lista no tiene elementos repetidos
        */
        
        boolean sonFrontera = false;
        Lista frontera = this.frontera();   //Lista con los elementos frontera del arbol
        Pila front = listaApila(frontera);  //pila que contiene la frontera del arbol
        Lista lis = unaLista.clone();   //Lista clon de la lista ingresada por parametro

        if (!lis.esVacia()){
            sonFrontera = true;
            while(!front.esVacia() && sonFrontera){     //Estructura repetitiva, busca el tope de la pila de elementos frontera en la lista ingresada por parametro
                int pos = lis.localizar(front.obtenerTope());
                if (pos == -1){     //si la lista no contiene este elemento de la frontera
                    sonFrontera = false;
                }else{      //si la lista contiene este elemento de la frontera
                    front.desapilar();                    
                }
            }
        }
        return sonFrontera;
    }

    private Pila listaApila(Lista lis){
        //metodo privado auxiliar al metodo sonFrontera
        //crea una pila a partir de la lista que contiene la frontera del arbol

        Pila pila = new Pila();
        while (!lis.esVacia()){
            pila.apilar(lis.recuperar(1));
            lis.eliminar(1);
        }
        return pila;
    }


    

}
