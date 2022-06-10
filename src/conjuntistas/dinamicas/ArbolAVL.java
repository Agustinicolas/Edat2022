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
        int altIzq = 0;
        int altDer = 0;
        int balance = -1;
        
        if(n.getIzquierdo() != null){
            altIzq = n.getIzquierdo().getAltura() +1;
            
            
        }
        if(n.getDerecho() != null){
            altDer = n.getDerecho().getAltura() +1;
        }

        balance = altIzq - altDer;

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
                    n.recalcularAltura();                   
                }
            }else{  //el elemento a insertar es mayor que el elemento del nodo, se inserta al subarbol derecho
                    //si el nodo tiene HD baja a la derecha, sino agrega elemento
                if(n.getDerecho()!= null){
                    exito = insertarAux(n.getDerecho(), elemento);
                }else{
                    n.setDerecho(new NodoAVL(elemento, null,null));
                    n.recalcularAltura();
                }
            }
            n = verificacionBalance(n);     //metodo que comprueba si el subarbol de raiz n esta balanceado
        }
        return exito;
    }


    private NodoAVL verificacionBalance(NodoAVL n){    //metodo que comprueba si el subarbol de raiz n esta balanceado
        int balance = balance(n);
        int balancehijo;

        if (balance == 2){  //arbol caido hacia la izquierda
            balancehijo = balance(n.getIzquierdo());
                if (balancehijo == 1 || balancehijo == 0){      //subarbol izquierdo caido tambien hacia la izquierda, rotacion simple
                    n = rotacionSimpleDerecha(n);
                }else if(balancehijo == -1){                    //subarbol izquierdo caido hacia la derecha, rotacion doble
                    n = rotacionDobleIzqDer(n);                    
                }
        }else if(balance == -2){    //arbol caido hacia la derecha
            balancehijo = balance(n.getDerecho());
            if(balancehijo == -1 || balancehijo == 0){          //subarbol derecho caido hacia la derecha, rotacion simple
                n = rotacionSimpleIzquierda(n);
            }else if(balancehijo == 1){                         //subarbol derecho caido hacia la izquierda, rotacion doble
                n = rotacionDobleDerIzq(n);                
            }
        }

        return n;
    }


    private NodoAVL rotacionSimpleIzquierda(NodoAVL r){
        NodoAVL hijoDer = r.getDerecho();
        NodoAVL temp = hijoDer.getIzquierdo();

        hijoDer.setIzquierdo(r);
        r.setDerecho(temp);

        r.recalcularAltura();
        hijoDer.recalcularAltura();

        return hijoDer;
    }


    private NodoAVL rotacionSimpleDerecha(NodoAVL r){
        NodoAVL hijoIzq = r.getIzquierdo();
        NodoAVL temp = hijoIzq.getDerecho();

        hijoIzq.setDerecho(r);
        r.setIzquierdo(temp);

        r.recalcularAltura();
        hijoIzq.recalcularAltura();

        return hijoIzq;
    }


    private NodoAVL rotacionDobleDerIzq(NodoAVL r){
        NodoAVL q = r.getDerecho();
        q = rotacionSimpleDerecha(q);
        r = rotacionSimpleIzquierda(r);

        return r;
    }


    private NodoAVL rotacionDobleIzqDer(NodoAVL r){
        NodoAVL q=r.getIzquierdo();
        q = rotacionSimpleIzquierda(q);
        r = rotacionSimpleDerecha(r);

        return r;
    }


    public boolean esVacio(){
        boolean vacio = false;

        if(this.raiz == null){
            vacio = true;
        }
        return vacio;
    }


    public boolean eliminar(Comparable elemento){
        boolean exito = false;
        if (this.raiz != null){
            exito = eliminarAux(this.raiz, null, elemento);
        }
    return exito;
    }

    private boolean eliminarAux(NodoAVL n,NodoAVL padre, Comparable elem){
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
                padre = verificacionBalance(padre);     //metodo que comprueba si el subarbol de raiz n esta balanceado
                
            }else if(elem.compareTo(n.getElem()) < 0){    //Si el elemento buscado es menor que el elemento del nodo, busca en el subarbol izquierdo
                exito = eliminarAux(n.getIzquierdo(), n, elem);
            }else if(elem.compareTo(n.getElem()) > 0){  //Si el elemento buscadao es mayor que el elemento del nodo, busca en el subarbol derecho
                exito = eliminarAux(n.getDerecho(), n, elem);
            }
        }
        return exito;
    }


    private int cantHijos(NodoAVL n){
        int hijos = 0;
    
        if(n.getIzquierdo() != null){
            hijos++;
        }
        if(n.getDerecho() != null){
            hijos++;
        }  

        return hijos;
    }


    private void casoA(NodoAVL n, NodoAVL padre){
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


    private void casoB(NodoAVL n, NodoAVL padre){
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


    private void casoC(NodoAVL n, NodoAVL padre, Comparable elem){
        NodoAVL nuevoElem = n.getIzquierdo();
        NodoAVL hermano = n.getIzquierdo().getDerecho();
        NodoAVL padreAux = n;
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
