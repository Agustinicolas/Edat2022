/*
 *
 * @author Hernandez Agustin 
 * FAI-505
 *
 */
package conjuntistas.dinamicas;
import lineales.dinamicas.Lista;

public class ArbolAVL {
    
    //ATRIBUTOS

    private NodoAVL raiz;


    //CONSTRUCTOR

    public ArbolAVL(){
        this.raiz = null;
    }


    //METODOS PROPIOS

    public Lista listar(){
        Lista lis = new Lista();
        if(this.raiz != null){
            listarAux(this.raiz, lis);
        }
        return lis;
    }


    private void listarAux(NodoAVL n, Lista lis){
        
        if(n != null){
            if(n.getIzquierdo() != null){
                listarAux(n.getIzquierdo(), lis);
            }
            lis.insertar(n.getElem(), lis.longitud()+1);
            if(n.getDerecho() != null){
                listarAux(n.getDerecho(), lis);
            }
        }
    }


    public Comparable minimoElem(){
        Comparable elem = null;
        if(this.raiz != null){
            elem = minimoElemAux(this.raiz);
        }
        return elem;
    }

    private Comparable minimoElemAux(NodoAVL n){
        Comparable elem;
        if(n.getIzquierdo() == null){
            elem = n.getElem();
        }else{
            elem = minimoElemAux(n.getIzquierdo());
        }
        return elem;
    }
    
    
    public Comparable maximoElem(){
        Comparable elem = null;
        if(this.raiz != null){
            elem = maximoElemAux(this.raiz);
        }
        return elem;
    }

    private Comparable maximoElemAux(NodoAVL n){
        Comparable elem;
        if(n.getDerecho() == null){
            elem = n.getElem();
        }else{
            elem = maximoElemAux(n.getDerecho());
        }
        return elem;
    }
    
    
    public Lista listarRango(Comparable min, Comparable max){
        Lista lis = new Lista();
        if(this.raiz != null){
            listarRangoAux(this.raiz, min, max, lis); //por primera vez ingresa con parameto booleano false
        }
        return lis;
    }


    private void listarRangoAux(NodoAVL n, Comparable min, Comparable max, Lista lis){
        //metodo recursivo auxiliar al metodo listarRango
        //parametro booleano completado indica si se completó el recorrido, es decir n es mayor a cota superior
        if(n != null){
            boolean limiteIzq = (n.getElem().compareTo(min) >= 0);     //si n es mayor a cota inferior
            boolean limiteDer = (n.getElem().compareTo(max) <= 0);      //si n es menor a cota superior           

            if(n.getElem().compareTo(min) < 0){    //n es menor a la cota menor, se busca en subarbol derecho
                listarRangoAux(n.getDerecho(), min, max, lis);
            }else if(n.getElem().compareTo(max) > 0){   //n es mayor a cota superior, se busca en subarbol izquierdo
                listarRangoAux(n.getIzquierdo(), min, max, lis);
            }else{  //si n se encuentra en el intervalo
                if (limiteIzq && n.getIzquierdo() != null){     //si n es mayor o igual a cota izq y n tiene HI -> se recorre subarbol izquierdo
                    listarRangoAux(n.getIzquierdo(), min, max, lis);
                }
                if(limiteIzq && limiteDer){
                    lis.insertar(n.getElem(), lis.longitud()+1);    //si n está en el intervalo se agrega a la lista
                }
                if(limiteDer && n.getDerecho() != null){        //si n es menor o igual a cota derecha y tiene HD -> se recorre subarbol derecho
                    listarRangoAux(n.getDerecho(), min, max, lis);
                }
            }
            
        }

    }    


    private int balance(NodoAVL n){
        int altIzq = -1;
        int altDer = -1;
        int balance = -1;
        
        if(n.getIzquierdo() != null){
            altIzq = n.getIzquierdo().getAltura();
            altDer = n.getDerecho().getAltura();
            balance = altIzq - altDer;
        }

        return balance;

    }   


    public boolean insertar(Comparable elemento){
        boolean exito = true;
        if (this.raiz == null){
            this.raiz = new NodoAVL(elemento, null,null);
        }else{
            exito = insertarAux(this.raiz , elemento);
        }
        return exito;
    }

    private boolean insertarAux(NodoAVL n, Comparable elemento){
        //precondicion: n no es nulo
        boolean exito = true;
        
        if((elemento.compareTo(n.getElem()))== 0){
        //Reportar error, elemento repetido
            exito = false;
        }else{
            if(elemento.compareTo(n.getElem())<0){
            //el elemento a insertar es menor que el elemento del nodo, se inserta al subarbol izquierdo
            //si el nodo tiene HI baja a la izq, sino agrega elemento
                if (n.getIzquierdo() != null){
                    exito = insertarAux(n.getIzquierdo(), elemento);
                }else{
                    n.setIzquierdo(new NodoAVL(elemento, null, null));
                }
            }else{ //el elemento a insertar es mayor que el elemento del nodo, se inserta al subarbol derecho
                //si el nodo tiene HD baja a la derecha, sino agrega elemento
                if(n.getDerecho()!= null){
                    exito = insertarAux(n.getDerecho(), elemento);
                }else{
                    n.setDerecho(new NodoAVL(elemento, null,null));
                }
            }
            /////////////////////////////balancear/////////////////
        }
        return exito;
    }


    public boolean esVacio(){
        boolean vacio = false;

        if(this.raiz == null){
            vacio = true;
        }
        return vacio;
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

    
    private String toStringAux(NodoAVL n){
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
