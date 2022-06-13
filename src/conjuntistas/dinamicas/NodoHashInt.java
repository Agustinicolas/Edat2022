package conjuntistas.dinamicas;

public class NodoHashInt {
    private int elem;
    private NodoHashInt enlace;

    public NodoHashInt(int elem, NodoHashInt enlace){
        this.elem = elem;
        this.enlace = enlace;
    }

    //OBSERVADORES
    public int getElem(){
        return this.elem;
    }

    public NodoHashInt getEnlace(){
        return this.enlace;
    }

    //MODIFICADORES
    public void setElem(int elem){
        this.elem = elem;
    }

    public void setEnlace(NodoHashInt enlace){
        this.enlace = enlace;
    }
}
