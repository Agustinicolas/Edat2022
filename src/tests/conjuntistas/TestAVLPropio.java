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
        exito = a1.eliminar(5);
        System.out.println("METODO ELIMINAR ARBOL VACIO, ESPERA FALSE ->\t" + exito);



        //INSERCION ELEMENTOS
        exito = a1.insertar(5);
        System.out.println("METODO INSERTAR ELEMENTO 5, ESPERA TRUE ->\t"+ exito);
        System.out.println(a1.toString()); 
        exito = a1.insertar(3);
        System.out.println("METODO INSERTAR ELEMENTO 1, ESPERA TRUE ->\t"+ exito);
        System.out.println(a1.toString()); 
        exito = a1.insertar(1);
        System.out.println("METODO INSERTAR ELEMENTO 3, ESPERA TRUE ->\t"+ exito);
        System.out.println(a1.toString()); 
        exito = a1.insertar(9);
        System.out.println("METODO INSERTAR ELEMENTO 9, ESPERA TRUE ->\t"+ exito);
        System.out.println(a1.toString()); 
        exito = a1.insertar(2);
        System.out.println("METODO INSERTAR ELEMENTO 2, ESPERA TRUE ->\t"+ exito); 
        System.out.println(a1.toString()); 
        exito = a1.insertar(4);
        System.out.println("METODO INSERTAR ELEMENTO 4, ESPERA TRUE ->\t"+ exito);
        System.out.println(a1.toString()); 
        exito = a1.insertar(8);
        System.out.println("METODO INSERTAR ELEMENTO 8, ESPERA TRUE ->\t"+ exito);
        System.out.println(a1.toString()); 
        exito = a1.insertar(13);
        System.out.println("METODO INSERTAR ELEMENTO 13, ESPERA TRUE ->\t"+ exito);
        System.out.println(a1.toString()); 
        
        System.out.println("IMPRESION AVL:");
        System.out.println(a1.toString());        
        System.out.println("METODO LISTAR AVL:\n");
        lis = a1.listar();
        System.out.println(lis.toString());



        

    }

}
