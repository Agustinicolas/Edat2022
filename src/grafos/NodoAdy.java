package grafos;

public class NodoAdy {

    //atributos
    private NodoVert vertice;
    private NodoAdy sigAdyacente;


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


}
