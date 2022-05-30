package conjuntistas.dinamicas;

public class ArbolBB {

    //ATRIBUTOS
    private NodoArbol raiz = null;

    //METODOS PROPIOS
    public boolean insertar(Comparable elemento){
        boolean exito = true;
        if (this.raiz == null){
            this.raiz = new NodoArbol(elemento, null,null);
        }else{
            exito = insertarAux(this.raiz , elemento);
        }
        return exito;
    }

    private boolean insertarAux(NodoArbol n, Comparable elemento){
        //precondicion: n no es nulo
        boolean exito = true;
        
        if((elemento.compareTo(n.getElem()))== 0){
        //Reportar error, elemento repetido
            exito = false;
        }else if(elemento.compareTo(n.getElem())<0){
            //el elemento a insertar es menor que el elemento del nodo, se inserta al subarbol izquierdo
            //si el nodo tiene HI baja a la izq, sino agrega elemento
            if (n.getIzquierdo() != null){
                exito = insertarAux(n.getIzquierdo(), elemento);
            }else{
                n.setIzquierdo(new NodoArbol(elemento, null, null));
            }
        }else{ //el elemento a insertar es mayor que el elemento del nodo, se inserta al subarbol derecho
            //si el nodo tiene HD baja a la derecha, sino agrega elemento
            if(n.getDerecho()!= null){
                exito = insertarAux(n.getDerecho(), elemento);
            }else{
                n.setDerecho(new NodoArbol(elemento, null,null));
            }
        }
        return exito;
    }

    public boolean eliminar(Comparable elemento){
        boolean exito = false;
        if (this.raiz != null){
            exito = eliminarAux(this.raiz, null, elemento);
        }
    return exito;
    }

    private boolean eliminarAux(NodoArbol n,NodoArbol padre, Comparable elem){
        boolean exito = false;
        if (n != null){
            if(elem.compareTo(n.getElem()) ==0 ){   //Si se encuentra el nodo, se procede con la eliminacion
                int hijos = cantHijos(n);    
                if (hijos == 0){    //CASO A: n es hoja
                    casoA(n, padre);
                }else if(hijos == 1){   //CASO B: n tiene un hijo, izquierdo o derecho
                    casoB(n, padre);                    
                }else if(hijos == 2){   //CASO C: el nodo a eliminar tiene dos hijos
                    casoC(n, padre, elem);
                }
                exito = true;
            }else if(elem.compareTo(n.getElem()) < 0){    //Si el elemento buscado es menor que el elemento del nodo, busca en el subarbol izquierdo
                exito = eliminarAux(n.getIzquierdo(), n, elem);
            }else if(elem.compareTo(n.getElem()) > 0){  //Si el elemento buscadao es mayor que el elemento del nodo, busca en el subarbol derecho
                exito = eliminarAux(n.getDerecho(), n, elem);
            }
        }
        return exito;
    }


    private int cantHijos(NodoArbol n){
        int hijos = 0;
    
        if(n.getIzquierdo() != null){
            hijos++;
        }
        if(n.getDerecho() != null){
            hijos++;
        }  

        return hijos;
    }


    private void casoA(NodoArbol n, NodoArbol padre){
        //Metodo auxiliar al eliminar.
        //Trata el caso en el que el elemento a eliminar es hoja
        if(this.raiz == n){     //CASO ESPECIAL RAIZ
            this.raiz = null;
        }else{
            if(n.getElem().compareTo(padre.getElem())<0){   //Si el elemento es HI se modifica el enlace al HI del nodo padre
                padre.setIzquierdo(null);
            }else{  //Si el elemento es HD se modifica el enlace al HD del nodo padre
                padre.setDerecho(null);
            }
        }
    }


    private void casoB(NodoArbol n, NodoArbol padre){
        //Metodo auxiliar al eliminar.
        //Trata el caso en el que el elemento a eliminar tiene un hijo
        boolean derecho = true;
        if(n.getDerecho() == null){     //si el nodo tiene HD, derecho es true, caso contrario es false
            derecho = false;
        }
        if(this.raiz == n){     //CASO ESPECIAL RAIZ
            if(derecho){
                this.raiz = n.getDerecho();
            }else{
                this.raiz = n.getIzquierdo();
            }
        }else{
            if(n.getElem().compareTo(padre.getElem())<0){   //Si el elemento es HI se modifica el enlace al HI del nodo padre
                if(derecho){
                    padre.setIzquierdo(n.getDerecho());     //Enlazo HI de padre con HD de nodo
                }else{
                    padre.setIzquierdo(n.getIzquierdo());   //Enlazo HI de padre con HI de nodo
                }
            }else{  //Si el elemento es HD se modifica el enlace al HD del nodo padre
                if(derecho){
                    padre.setDerecho(n.getDerecho());   //Enlazo HD de padre con HD de nodo
                }else{
                    padre.setDerecho(n.getIzquierdo()); //Enlazo HI de padre con HI de nodo
                }
            }
        }
    }


    private void casoC(NodoArbol n, NodoArbol padre, Comparable elem){
        NodoArbol nuevoElem = n.getIzquierdo();
        NodoArbol hermano = n.getIzquierdo().getDerecho();
        NodoArbol padreAux = n;
        while (hermano != null){
            padreAux = nuevoElem;
            nuevoElem = hermano;
            hermano = hermano.getDerecho();
        }
        n.setElem(nuevoElem.getElem());
        if(n.getElem().compareTo(n.getIzquierdo().getElem()) == 0){
            n.setIzquierdo(n.getIzquierdo().getIzquierdo());
        }else{
            eliminarAux(n.getIzquierdo().getDerecho(), n.getIzquierdo(), n.getElem());
        }
    }


    private NodoArbol padre(Comparable buscado){
        NodoArbol padre = new NodoArbol(null,null,null);
        if (this.raiz != null && (buscado.compareTo(this.raiz.getElem())!=0)){
            padre = padreAux(this.raiz, buscado);
        }
        return padre;
    }

    private NodoArbol padreAux(NodoArbol n, Comparable elemento){
    //Metodo privado auxiliar del metodo padre
    NodoArbol padre = null;

    if (n != null){
        if ( (n.getIzquierdo() != null && n.getIzquierdo().getElem().equals(elemento)) || (n.getDerecho() != null && n.getDerecho().getElem().equals(elemento)) ){
            padre = n;
        }else{
            padre = padreAux(n.getIzquierdo(), elemento);
            if ( padre == null){
                padre = padreAux(n.getDerecho(), elemento);
            }
        }
    }
    return padre;
    }

    @Override
    public String toString(){
        //Genera y devuelve una cadena de caracteres que indica cual es la raiz del arbol
        //y quienes son los hijos de cada nodo
        String cadena = "";
        if (this.raiz == null){
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
}

