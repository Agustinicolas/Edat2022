package jerarquicas.dinamicas;
import lineales.dinamicas.*;

public class ArbolGen {
    private NodoGen raiz;


    //CONSTRUCTOR
    public ArbolGen(){
        this.raiz = null;
    }

    public Lista listarInorden(){
        Lista salida = new Lista();
        listarInordenAux(this.raiz, salida);
        return salida;
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


    public Object padre(Object elem){
        //Dado un elemento devuelve el objeto almacenado en su nodo padre (busca la primera aparicion del elemento)
        NodoGen padre = null;
        Object elemPadre = null;
        if(this.raiz != null){
            padre = padreAux(this.raiz,elem);
            if(padre != null)
                elemPadre = padre.getElem();
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
                        padre = padreAux(hermano, buscado);
                        hermano = hermano.getHermanoDerecho();
                    }
                }
            }
        }
        return padre;
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

}
