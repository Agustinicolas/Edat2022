package tests.jerarquicas;

import jerarquicas.dinamicas.ArbolBin;
import lineales.dinamicas.*;

public class TestArbolBinPropio {
    
    public static void main(String[] args){
        
        ArbolBin arbol1 = new ArbolBin();
        ArbolBin arbol2;
        Lista listaPre = new Lista();    
        Lista listaPos = new Lista(); 
        Lista listaIn = new Lista();
        Lista listaNiv = new Lista();     
        System.out.println("IMPRESION ARBOL VACIO, ESPERA ARBOL VACIO --- " + arbol1.toString()); 
        arbol2 = arbol1.clone();
        System.out.println("IMPRESION ARBOL CLON VACIO, ESPERA ARBOL VACIO --- " + arbol2.toString()); 
        System.out.println("METODO ESVACIO EN ARBOL VACIO, ESPERA TRUE --- "+arbol1.esVacio()); 
        System.out.println("METODO ALTURA EN ARBOL VACIO, ESPERA -1 --- "+ arbol1.altura());
        System.out.println("METODO NIVEL EN ELEMENTO INEXISTENTE, ESPERA -1 --- " + arbol1.nivel("ASD"));
        System.out.println("METODO NIVEL EN ELEMENTO 'A', ESPERA -1 --- " + arbol1.nivel('A'));
        boolean exito;
        exito = arbol1.insertar('A', "asd", 'D'); //INSERTO ELEMENTO
        System.out.println("\nInsercion: "+exito + "\n"+ arbol1.toString()+"\n"); //IMPRIMO ARBOL
        System.out.println("IMPRESION ARBOL CLON, ESPERA ARBOL VACIO --- " + arbol2.toString());        
        System.out.println("METODO ESVACIO EN ARBOL  NO VACIO, ESPERA FALSE --- "+(arbol1.esVacio())); //METODO ESVACIO EN ARBOL NO VACIO
        exito = arbol1.insertar('B','Z','I');
        System.out.println("INTENTO INSERTAR NODO EN PADRE INEXISTENTE, ESPERA FALSE --- "+exito);
        System.out.println("\n"+arbol1.toString()+"\n");
        System.out.println("METODO NIVEL EN ELEMENTO INEXISTENTE, ESPERA -1 --- " + arbol1.nivel("ASD"));
        System.out.println("METODO NIVEL EN ELEMENTO 'A', ESPERA 0 --- " + arbol1.nivel('A'));
        System.out.println("METODO ALTURA EN ARBOL, ESPERA 0 --- "+ arbol1.altura());
        System.out.println("METODO PADRE EN RAIZ, ESPERA NULL-TRUE --- " + (arbol1.padre('A') == null));

        exito = arbol1.insertar('B', 'A', 'I');
        System.out.println("\nInsercion: "+exito + "\n"+ arbol1.toString()+"\n"); //INSERTO B HIJO IZQUIERDO A, ESPERO TRUE

        exito = arbol1.insertar('C', 'A', 'I');
        System.out.println("\nInsercion: "+exito + "\n"+ arbol1.toString()+"\n"); //INSERTO C HIJO IZQUIERDO A, ESPERO FALSE

        exito = arbol1.insertar('C', 'A', 'D');
        System.out.println("\nInsercion: "+exito + "\n"+ arbol1.toString()+"\n"); //IMPRIMO C HIJO DERECHO A, ESPERO TRUE

        System.out.println("METODO NIVEL EN ELEMENTO 'C', ESPERA 1 --- " + arbol1.nivel('C'));
        System.out.println("METODO ALTURA EN ARBOL, ESPERA 1 --- "+ arbol1.altura());

        exito = arbol1.insertar('D', 'C', 'D');
        System.out.println("\nInsercion: "+exito + "\n"+ arbol1.toString()+"\n"); //IMPRIMO D HIJO DERECHO C, ESPERO TRUE
        System.out.println("METODO NIVEL EN ELEMENTO INEXISTENTE, ESPERA -1 --- " + arbol1.nivel("ASD"));
        System.out.println("METODO NIVEL EN ELEMENTO 'D', ESPERA 2 --- " + arbol1.nivel('D'));
        System.out.println("METODO ALTURA EN ARBOL, ESPERA 2 --- "+ arbol1.altura());
        System.out.println("METODO PADRE EN RAIZ, ESPERA NULL-TRUE --- " + (arbol1.padre('A') == null));
        System.out.println("METODO PADRE EN 'D', ESPERA C --- " + arbol1.padre('D'));
        System.out.println("METODO PADRE EN 'C', ESPERA A --- " + arbol1.padre('C'));

        listaPre = arbol1.listarPreOrden();
        listaPos = arbol1.listarPosOrden();
        listaIn = arbol1.listarInOrden();
        listaNiv = arbol1.listarNiveles();

        System.out.println("\n LISTA PREORDEN:\n" + listaPre.toString() );
        System.out.println("\n LISTA POSORDEN:\n" + listaPos.toString());
        System.out.println("\n LISTA INORDEN:\n"+listaIn.toString());        
        System.out.println("\n LISTA POR NIVELES:\n"+listaNiv.toString());

        arbol2 = arbol1.clone();

        System.out.println("IMPRESION ARBOL ORIGINAL:\n"+arbol1.toString());
        System.out.println("IMPRESION ARBOL CLON:\n" +arbol2.toString());

        arbol1.vaciar();

        System.out.println("IMPRESION ARBOL ORIGINAL VACIO:\n"+arbol1.toString());
        System.out.println("IMPRESION ARBOL CLON:\n" +arbol2.toString());

        arbol2.insertar('E', 'B', 'I');
        arbol2.insertar('F','C','I');
        arbol2.insertar('G','F','I');
        arbol2.insertar('H','F','D');

        System.out.println("IMPRESION ARBOL CLON:\n" +arbol2.toString());
        System.out.println("METODO ESVACIO EN ARBOL VACIO, ESPERA TRUE --- "+arbol1.esVacio()); 
        System.out.println("METODO ALTURA EN ARBOL CLON, ESPERA 3 --- "+ arbol2.altura());
        System.out.println("METODO NIVEL EN ELEMENTO INEXISTENTE, ESPERA -1 --- " + arbol1.nivel("ASD"));
        System.out.println("METODO NIVEL EN ELEMENTO 'G', ESPERA 3 --- " + arbol2.nivel('G'));
        System.out.println("METODO PADRE EN ELEMENTO INEXISTENTE, ESPERA NULL/true --- " +(arbol2.padre('K')==null));
        System.out.println("METODO PADRE EN ELEMENTO G, ESPERA F --- " +arbol2.padre('G'));
        
    }
}
