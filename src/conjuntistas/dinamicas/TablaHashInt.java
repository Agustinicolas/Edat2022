package conjuntistas.dinamicas;
import lineales.dinamicas.Lista;


public class TablaHashInt {
    //IMPLEMENTACION DE TABLA HASH ABIERTA PARA ELEMENTOS DEL TIPO INT
    
    private static int TAMANIO = 20;
    private NodoHashInt[] tabla;
    int cant;

    public TablaHashInt(){
        tabla = new NodoHashInt[TAMANIO -1];
        cant = 0;
    }


    public boolean insertar(int elem){
        
        int pos;
        pos = Funciones.hashInt(elem);
        boolean encontrado = false;
        NodoHashInt aux = this.tabla[pos];
        int i = 0;

        while( !encontrado && aux != null && i<3 ){     ///////FALLA INSERCION. CORREGIR
            encontrado = aux.getElem() == elem;
            aux = aux.getEnlace();
            i++;
        }

        if(!encontrado && i < 3){
            aux.setEnlace(new NodoHashInt((elem),this.tabla[pos]));
            this.cant++;
        }

        return !encontrado;
        
    }

    public boolean eliminar(int elem){
        boolean encontrado = false;
        int pos;
        NodoHashInt aux;

        pos = Funciones.hashInt(elem);
        aux = this.tabla[pos];
        
        if(this.tabla[pos] != null){
            if(elem == aux.getElem()){      //Busca el elemento en el primer nodo de la lista. En caso positivo, se elimina
                this.tabla[pos] = aux.getEnlace();
                encontrado = true;
            }else{      //Busca el elemento en los nodos siguientes
                NodoHashInt aux2 = aux.getEnlace();
                while(!encontrado && aux2 != null){
                    if(aux2.getElem() == elem){     //si se encuentra el elemento, se elimina el nodo y encontrado pasa a true
                        aux.setEnlace(aux2.getEnlace());
                        encontrado = true;                    
                    }
                    aux.getEnlace();
                    aux2.getEnlace();
                }
            }
            if(encontrado){     
                if(this.tabla[pos] == null){    //si se eliminó el único nodo de la posicion del arreglo, se resta 1 al atributo cant
                    cant--;
                }
            }
        }
            return encontrado;
    }


    public boolean pertenece(int elem){
        int pos;
        boolean pertenece = false;

        pos = Funciones.hashInt(elem);
        NodoHashInt aux = this.tabla[pos];
        if(this.tabla[pos] != null){
            while(!pertenece && aux != null){
                if(aux.getElem()==elem){
                    pertenece = true;
                }
            }
        }
        return pertenece;
    }


    public Lista listar(){
        int elemListados = 0;
        Lista lis = new Lista();
        int indice = 0;
        NodoHashInt aux;

        if(this.cant > 0){
            while(elemListados <= this.cant){
                aux = this.tabla[indice];
                while(aux != null){
                    lis.insertar(aux.getElem(), lis.longitud()+1);
                    aux = aux.getEnlace();
                    elemListados ++;
                }
                indice++;
            }
        }

        return lis;
    }
}
