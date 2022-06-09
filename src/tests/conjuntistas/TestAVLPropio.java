package tests.conjuntistas;

import conjuntistas.dinamicas.ArbolAVL;
import lineales.dinamicas.Lista;

public class TestAVLPropio {
    
    public static void main(String[] args){
        
        ArbolAVL a1 = new ArbolAVL();
        ArbolAVL a2 = new ArbolAVL();
        Lista lis = new Lista();
        boolean exito;
        Comparable elem;

        //PRUEBAS AVL VACIO
        System.out.println("IMPRESION AVL VACIO:\n");
        System.out.println(a1.toString());        
        System.out.println("METODO LISTAR AVL VACIO:\n");
        lis = a1.listar();
        System.out.println(lis.toString());
        System.out.println("METODO minimoElem , DEBE RETORNAR NULL ->\t"+ (a1.minimoElem() == null));
        System.out.println("METODO maximoElem , DEBE RETORNAR NULL ->\t"+ (a1.maximoElem() == null));
        System.out.println("METODO ESVACIO AVL VACIO, ESPERA TRUE ->\t" + a1.esVacio());


        //INSERCION PRIMER ELEMENTO
        exito = a1.insertar(5);
        System.out.println("METODO INSERTAR ELEMENTO 5, ESPERA TRUE ->\t"+ exito);
        exito = a1.insertar(1);
        System.out.println("METODO INSERTAR ELEMENTO 1, ESPERA TRUE ->\t"+ exito);
        exito = a1.insertar(3);
        System.out.println("METODO INSERTAR ELEMENTO 5, ESPERA TRUE ->\t"+ exito);
        System.out.println("IMPRESION AVL:");
        System.out.println(a1.toString());        
        System.out.println("METODO LISTAR AVL:\n");
        lis = a1.listar();
        System.out.println(lis.toString());



        

    }

}
