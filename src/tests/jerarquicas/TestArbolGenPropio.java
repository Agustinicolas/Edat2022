package tests.jerarquicas;
import jerarquicas.dinamicas.*;

public class TestArbolGenPropio {
    public static void main(String[] args){
        ArbolGen arbol1 = new ArbolGen();
        ArbolGen arbol2;
        boolean exito;

        System.out.println("IMPRESION ARBOL VACIO:");
        System.out.println(arbol1.toString()+"\n");

        exito = arbol1.esVacio();
        System.out.println("Metodo esVacio en arbol vacio, espera true: \t"+exito);

        System.out.println("Metodo padre en arbol vacio, espera null\t"+ (arbol1.padre('J')== null));

        exito = arbol1.pertenece(55);
        System.out.println("Metodo pertenece en arbol vacio, espera false: \t"+exito);

        exito = arbol1.insertar('A', 'F');
        System.out.println("Insercion elemento 'A' en arbol vacío, espera true:\t"+exito);

        exito = arbol1.esVacio();
        System.out.println("Metodo esVacio en arbol no vacio, espera false: \t"+exito);

        System.out.println("Metodo padre('A'), espera null\t"+ (arbol1.padre('A')== null));
        System.out.println("Metodo padre('T'), espera null\t"+ (arbol1.padre('A')== null));


        System.out.println(arbol1.toString()+"\n");

        exito = arbol1.insertar('B', 'F');
        System.out.println("Insercion elemento 'B' en padre inexistente, espera false:\t"+exito);

        System.out.println(arbol1.toString()+"\n");

        exito = arbol1.insertar('B', 'A');
        System.out.println("Insercion elemento 'B' en padre A, espera true:\t"+exito);

        System.out.println(arbol1.toString()+"\n");

        exito = arbol1.insertar('C', 'A');
        System.out.println("Insercion elemento 'C' en padre A, espera true:\t"+exito);

        exito = arbol1.insertar('D', 'A');
        System.out.println("Insercion elemento 'D' en padre A, espera true:\t"+exito);

        System.out.println(arbol1.toString()+"\n");

        exito = arbol1.insertar('E', 'D');
        System.out.println("Insercion elemento 'E' en padre D, espera true:\t"+exito);

        System.out.println(arbol1.toString()+"\n");

        exito = arbol1.pertenece(55);
        System.out.println("Metodo pertenece con elemento inexistente, espera false: \t"+exito);

        exito = arbol1.pertenece('A');
        System.out.println("Metodo pertenece con elemento de raiz, espera true: \t"+exito);

        exito = arbol1.pertenece('E');
        System.out.println("Metodo pertenece con elemento 'D', espera true: \t"+exito);

        exito = arbol1.esVacio();
        System.out.println("Metodo esVacio en arbol no vacio, espera false: \t"+exito);

        System.out.println("Metodo padre('E'), espera 'D'\t"+ (arbol1.padre('E').equals('D')));

    }
}
