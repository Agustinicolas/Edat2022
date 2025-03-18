package grafos;

public class NodoVert {
    
    //atributos
    private Object elem;
    private NodoVert sigVertice;
    private NodoAdy primerAdy;

    public Object getElem(){
        return this.elem;
    }

    public void setElem(Object elemNuevo){
        this.elem = elemNuevo;
    }

    public Object getSigVertice(){
        return sigVertice;
    }

    public void setSigVert(NodoVert nuevoVert){
        this.sigVertice = nuevoVert;
    }

    public NodoAdy getPrimerAdy(){
        return this.primerAdy;
    }

    public void setPrimerAdy(NodoAdy nuevoAdy){
        this.primerAdy = nuevoAdy;
    }
}
