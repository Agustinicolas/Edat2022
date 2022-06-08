package conjuntistas.dinamicas;
import java.lang.Math;

public class NodoAVL extends NodoArbol {
    //se utiliza herencia y se declara a nodoAVL como subclase de NodoArbol

    private int altura;


    //CONSTRUCTOR
    public NodoAVL(Comparable elem, NodoArbol izquierdo, NodoArbol derecho){
        super(elem, izquierdo, derecho);
        this.altura = 0;        
    }


    //OBSERVADORES

    public int getAltura(){
        return this.altura;
    }
    

    public void recalcularAltura(){
        
        if (this.getDerecho() == null && this.getIzquierdo() == null){
            this.altura = 0;
        }else{
            altura = alturaAux(this);
        }
        
    }


    private int alturaAux(NodoArbol n){
        int altura = -1;
        int alturaIzq;
        int alturaDer;
        if (n != null){
            alturaIzq = alturaAux(n.getIzquierdo());
            alturaDer = alturaAux(n.getDerecho());
            altura = Math.max(alturaIzq, alturaDer)+1;
        }
        return altura;
    }
}
