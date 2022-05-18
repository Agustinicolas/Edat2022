package tests.conjuntistas;

import conjuntistas.estaticas.ArbolHeap;

public class TestHeapPropio {
    public static void main(String[] args){
        ArbolHeap a1 = new ArbolHeap();

        System.out.println("IMPRESION ARBOL VACIO:");
        System.out.println(a1.toString());

        System.out.println("METODO ELIMINARCIMA EN ARBOL VACIO, ESPERA FALSE\t"+a1.eliminarCima());
        System.out.println("METODO ESVACIO EN ARBOL VACIO, ESPERA TRUE:\t"+a1.esVacio());

        System.out.println("METODO INSERTAR 15 EN ARBOL VACIO, ESPERA TRUE"+ a1.insertar(15));
        System.out.println(a1.toString());

        System.out.println("METODO INSERTAR 20 EN ARBOL, ESPERA TRUE\t"+ a1.insertar(20));
        System.out.println("METODO INSERTAR 7 EN ARBOL, ESPERA TRUE\t"+ a1.insertar(7));
        System.out.println("METODO INSERTAR 30 EN ARBOL, ESPERA TRUE\t"+ a1.insertar(30));
        System.out.println(a1.toString());

        System.out.println("METODO RECUPERARCIMA EN ARBOL, ESPERA 7\t"+(a1.recuperarCima().equals(7)));
        System.out.println("METODO ELIMINARCIMA EN ARBOL , ESPERA TRUE\t"+a1.eliminarCima());
        System.out.println("METODO ESVACIO EN ARBOL NO VACIO, ESPERA FALSE:\t"+a1.esVacio());

        System.out.println(a1.toString());

        System.out.println("METODO INSERTAR 8 EN ARBOL, ESPERA TRUE\t"+ a1.insertar(8));
        System.out.println(a1.toString());
        System.out.println("METODO INSERTAR 16 EN ARBOL, ESPERA TRUE\t"+ a1.insertar(16));
        System.out.println(a1.toString());
        System.out.println("METODO INSERTAR 11 EN ARBOL, ESPERA TRUE\t"+ a1.insertar(11));
        System.out.println(a1.toString());
        System.out.println("METODO INSERTAR 1 EN ARBOL, ESPERA TRUE\t"+ a1.insertar(1));
        System.out.println(a1.toString());
        System.out.println("METODO INSERTAR 43 EN ARBOL, ESPERA TRUE\t"+ a1.insertar(43));
        System.out.println(a1.toString());
        System.out.println("METODO INSERTAR 20 EN ARBOL, ESPERA TRUE\t"+ a1.insertar(20));

        System.out.println(a1.toString());


    }
}
