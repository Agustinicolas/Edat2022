package grafos;
import lineales.dinamicas.Lista;

public class GrafoEtiq {
    //vertices tipo Object, etiquetas tipo numerico
    //implementacion mediante LISTA DE ADYACENCIA
    
    //atributo
    private NodoVert inicio;


    public GrafoEtiq(){
        this.inicio = null;
    }


    private NodoVert ubicarVertice(Object buscado){
        //Recorre la lista de vertices buscando un elemento
        //Si lo encuentra devuelve el enlace al nodo que lo contiene
        NodoVert aux = this.inicio;
        while ( aux != null && !aux.getElem().equals(buscado)){
            aux = aux.getSigVertice();
        }
        return aux;
    }
    
    //insertarVertice(Object): boolean
    public boolean insertarVertice(Object nuevoVertice){
        boolean exito = false;
        //busca si el elemento a insertar ya existe en el grafo
        NodoVert aux = this.ubicarVertice(nuevoVertice);
        //si el elemento a insertar no existe, lo inserta en el grafo
        if( aux == null){
            this.inicio = new NodoVert(nuevoVertice, this.inicio);
            exito = true;
        }
        return exito;
    }


    //eliminarVertice(Object): boolean
    public boolean elimiarVertice(Object elemento){
        boolean exito = false;
        //busca si el vertice a eliminar existe en el grafo
        NodoVert aux = this.ubicarVertice(elemento);
        if (aux != null){
            //si el vertice a eliminar existe, debo eliminarlo junto a los arcos que lo involucren

            //PENDIENTE
        }
        return exito;
    }


    //existeVertice(Object): boolean
    public boolean existeVertice(Object buscado){
        boolean exito = false;
        //busco vertice con metodo auxiliar
        NodoVert aux = ubicarVertice(buscado);
        if (aux != null){
            exito = true;
        }
        return exito;
    }


    //insertarArco(Object, Object): boolean


    //eliminarArco(Object, Object): boolean


    //existeArco(Object, Object): boolean


    public boolean vacio(){
        boolean esVacio = this.inicio == null;
        return esVacio;
    }


    //otras operaciones de grafo

    public Lista listarEnProfundidad(){
        Lista visitados = new Lista();
        //define un nuevo vertice donde comenzar a recorrer
        NodoVert aux = this.inicio;
        while (aux != null){
            if( visitados.localizar(aux.getElem()) <0){
                //si el vertice no fue visitado aun, avanza en profundidad
                listarEnProfundidadAux(aux, visitados);
            }
            aux = aux.getSigVertice();
        }
        return visitados;
    }


    private void listarEnProfundidadAux(NodoVert n, Lista vis){
        if( n != null){
            //marca al vertice n como visitado
            vis.insertar(n.getElem(), vis.longitud() +1);
            NodoAdy ady = n.getPrimerAdy();
            while (ady != null){
                //visita en profundidad los adyacentes de n aun no visitados
                if( vis.localizar(ady.getVertice().getElem()) < 0){
                    listarEnProfundidadAux(ady.getVertice(), vis);
                }
                ady = ady.getSigAdyacente();
            }
        }
    } 


    public boolean existeCamino(Object origen, Object destino){
        boolean exito = false;
        //verifica si ambos vertices existen
        NodoVert aux0 = null;
        NodoVert auxD = null;
        NodoVert aux = this.inicio;

        while( (aux0 == null || auxD == null) && aux != null){
            if( aux.getElem().equals(origen)){
                aux0=aux;
            }
            if( aux.getElem().equals(destino)){
                auxD = aux;
            }
            aux = aux.getSigVertice();
        }
        if(aux0 != null && auxD != null){
            //si ambos vertices existen busca si existe camino entre ambos
            Lista visitados = new Lista();
            exito = existeCaminoAux(aux0, destino, visitados);
        }
        return exito;
    }


    private boolean existeCaminoAux(NodoVert n, Object dest, Lista vis){
        boolean exito = false;
        if( n != null){
            //si vertice n es el destino, hay camino
            if( n.getElem().equals(dest)){
                exito = true;
            }else{
                //si no es el destino verifica si hay camino entre n y destino
                vis.insertar(n.getElem(), vis.longitud() +1);
                NodoAdy ady = n.getPrimerAdy();
                while( !exito && ady != null){
                    if( vis.localizar(ady.getVertice().getElem()) <0){
                        exito = existeCaminoAux(ady.getVertice(), dest, vis);
                    }
                    ady = ady.getSigAdyacente();
                }
            }
        }
        return exito;
    }


}
