package tests.conjuntistas;
import lineales.dinamicas.Lista;

import conjuntistas.dinamicas.ArbolBB;

public class TestABBPropio {
  public static void main(String[] args){
    ArbolBB a1 = new ArbolBB();
    ArbolBB a2 = new ArbolBB();
    Lista lis = new Lista();
    Comparable elem;
    boolean exito;

    System.out.println("IMPRESION ARBOL VACIO:");
    System.out.println(a1.toString());
    lis = a1.listar();
    System.out.println("listar arbol vacio");
    System.out.println(lis.toString()+"\n");
    elem = a1.minimoElem();
    System.out.println("Metodo minimoElem arbol vacio, espera null\t"+ (elem == null));

    exito = a1.insertar(5);
    System.out.println("Insercion elemento 5 arbol vacio, espera true\t"+exito);
    System.out.println(a1.toString());
    exito = a1.insertar(8);
    System.out.println("Insercion elemento 8 arbol, espera true\t"+exito);
    exito = a1.insertar(2);
    System.out.println("Insercion elemento 2 arbol, espera true\t"+exito);
    System.out.println(a1.toString());
    exito = a1.insertar(13);
    System.out.println("Insercion elemento 13 arbol, espera true\t"+exito);
    exito = a1.insertar(9);
    System.out.println("Insercion elemento 9 arbol, espera true\t"+exito);
    System.out.println(a1.toString());
    exito = a1.insertar(3);
    System.out.println("Insercion elemento 3 arbol, espera true\t"+exito);
    System.out.println(a1.toString());
    exito = a1.insertar(4);
    System.out.println("Insercion elemento 4 arbol, espera true\t"+exito);
    System.out.println(a1.toString());
    exito = a1.insertar(1);
    System.out.println("Insercion elemento 1 arbol, espera true\t"+exito);
    System.out.println(a1.toString());
    
    elem = a1.minimoElem();
    System.out.println("Metodo minimoElem arbol, espera 1\t"+elem.toString());
    
    System.out.println("\nlistar arbol");
    lis = a1.listar();
    System.out.println(lis.toString()+"\n");

    exito = a1.eliminar(2);
    System.out.println("Metodo eliminar elemento 2, espera true\t"+exito);
    System.out.println(a1.toString());
    
    exito = a1.eliminar(59);
    System.out.println("Metodo eliminar elemento inexistente, espera false\t"+exito);
    System.out.println(a1.toString());

    exito = a1.eliminar(5);
    System.out.println("Metodo eliminar elemento raiz, espera true\t"+exito);
    System.out.println(a1.toString());
    }
}
