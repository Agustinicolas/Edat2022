package grafos;

public class NodoAdy {

    //atributos
    private NodoVert vertice;
    private NodoAdy sigAdyacente;
    private int etiqueta;


    public NodoAdy(){
        this.vertice = null;
        this.sigAdyacente = null;
        this.etiqueta = 0;
    }

    public NodoAdy(NodoVert vertice, int etiqueta){
        this.vertice = vertice;
        this.sigAdyacente = null;
        this.etiqueta = etiqueta;
    }


    public NodoVert getVertice(){
        return this.vertice;
    }

    public void setVertice(NodoVert nuevoVert){
        this.vertice = nuevoVert;
    }

    public NodoAdy getSigAdyacente(){
        return this.sigAdyacente;
    }

    public void setSigAdyacente(NodoAdy nuevoAdy){
        this.sigAdyacente = nuevoAdy;
    }

    public int getEtiqueta(){
        return this.etiqueta;
    }

    public void setEtiqueta(int nuevaEtiiqueta){
        this.etiqueta = nuevaEtiiqueta;
    }


}
