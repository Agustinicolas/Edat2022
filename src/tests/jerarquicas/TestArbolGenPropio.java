package tests.jerarquicas;
import jerarquicas.dinamicas.*;
import lineales.dinamicas.*;

public class TestArbolGenPropio {
    public static void main(String[] args){
        ArbolGen arbol1 = new ArbolGen();
        ArbolGen arbol2;
        Lista lis;
        boolean exito;

        System.out.println("IMPRESION ARBOL VACIO:");
        System.out.println(arbol1.toString()+"\n");

        System.out.println("CLON ARBOL VACIO");
        arbol2 = arbol1.clone();
        System.out.println(arbol2.toString()+"\n");

        System.out.println("Metodo grado en arbol vacío, espera 0\t"+arbol1.grado('A'));

        lis = arbol1.listarInorden();
        System.out.println("Impresion InOrden arbol vacio:");
        System.out.println(lis.toString());

        lis = arbol1.listarPreorden();
        System.out.println("Impresion PreOrden arbol vacio:");
        System.out.println(lis.toString());

        lis = arbol1.listarPosorden();
        System.out.println("Impresion PosOrden arbol vacio:");
        System.out.println(lis.toString());

        lis = arbol1.listarPorNiveles();
        System.out.println("Impresion por niveles arbol vacio:");
        System.out.println(lis.toString());

        exito = arbol1.esVacio();
        System.out.println("Metodo esVacio en arbol vacio, espera true: \t"+exito);

        System.out.println("Metodo padre en arbol vacio, espera null\t"+ (arbol1.padre('J')== null));

        exito = arbol1.pertenece(55);
        System.out.println("Metodo pertenece en arbol vacio, espera false: \t"+exito);

        System.out.println("Metodo nivel en arbol vacío, espera -1 \t"+(arbol1.nivel(123) == -1));

        exito = arbol1.insertar('A', 'F');
        System.out.println("Insercion elemento 'A' en arbol vacío, espera true:\t"+exito);

        exito = arbol1.esVacio();
        System.out.println("Metodo esVacio en arbol no vacio, espera false: \t"+exito);

        System.out.println("Metodo padre('A'), espera null\t"+ (arbol1.padre('A')== null));
        System.out.println("Metodo padre('T'), espera null\t"+ (arbol1.padre('A')== null));


        System.out.println(arbol1.toString()+"\n");

        exito = arbol1.insertar('B', 'F');
        System.out.println("Insercion elemento 'B' en padre inexistente, espera false:\t"+exito);
        System.out.println("Metodo nivel en elemento inexistente, espera -1 \t"+(arbol1.nivel(123) == -1));
        System.out.println("Metodo nivel en elemento raiz, espera 0 \t"+(arbol1.nivel('A') == -1));

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

        System.out.println("Metodo nivel en elemento B, espera 1\t"+ (arbol1.nivel('B')));
        System.out.println("Metodo nivel en elemento E, espera 2\t"+ (arbol1.nivel('E')));
        System.out.println("Metodo nivel en elemento inexistente, espera -1\t"+ (arbol1.nivel('K')));

        exito = arbol1.pertenece(55);
        System.out.println("Metodo pertenece con elemento inexistente, espera false: \t"+exito);

        exito = arbol1.pertenece('A');
        System.out.println("Metodo pertenece con elemento de raiz, espera true: \t"+exito);

        exito = arbol1.pertenece('E');
        System.out.println("Metodo pertenece con elemento 'D', espera true: \t"+exito);

        exito = arbol1.esVacio();
        System.out.println("Metodo esVacio en arbol no vacio, espera false: \t"+exito);

        lis = arbol1.listarInorden();
        System.out.println("Impresion InOrden arbol:");
        System.out.println(lis.toString());

        lis = arbol1.listarPreorden();
        System.out.println("Impresion PreOrden arbol:");
        System.out.println(lis.toString());

        lis = arbol1.listarPosorden();
        System.out.println("Impresion PosOrden arbol:");
        System.out.println(lis.toString());

        lis = arbol1.listarPorNiveles();
        System.out.println("Impresion por niveles arbol:");
        System.out.println(lis.toString());

        System.out.println("\nCLON ARBOL");
        arbol2 = arbol1.clone();
        System.out.println(arbol2.toString()+"\n");

        System.out.println("Metodo padre('E'), espera 'D'\t"+ (arbol1.padre('E').equals('D')));

        lis = arbol1.ancestros('J');
        System.out.println("Metodo ancestro elem inexistente, espera lista vacía\n"+lis.toString());

        lis = arbol1.ancestros('E');
        System.out.println("Metodo ancestro elem E, espera lista \n"+lis.toString());

        System.out.println("Metodo grado en raíz, espera 3\t"+arbol1.grado('A'));
        System.out.println("Metodo grado en 'B', espera 0\t"+arbol1.grado('B'));
        System.out.println("Metodo grado en 'D', espera 1\t"+arbol1.grado('B'));

        System.out.println("VACIADO ARBOL ORIGINAL");
        arbol1.vaciar();

        System.out.println("Arbol original:\n"+arbol1.toString());
        System.out.println("\nArbol clon:\n"+arbol2.toString());

    }
}
