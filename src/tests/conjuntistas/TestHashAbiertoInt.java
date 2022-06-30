package tests.conjuntistas;

import conjuntistas.dinamicas.TablaHashInt;
import lineales.dinamicas.Lista;

public class TestHashAbiertoInt {
    public static void main(String[] args){

        TablaHashInt hash = new TablaHashInt();
        boolean exito;
        Lista lis;
        
        //METODOS SOBRE HASH VACIO

        lis = hash.listar();
        System.out.println("Metodo listar hash vacio:\n"+lis.toString());
        exito = hash.pertenece(5);
        System.out.println("Metodo pertenece hash vacio, espera false ->\t"+exito);
        exito = hash.eliminar(8);
        System.out.println("Metodo eliminar hash vacio, espera false ->\t"+exito);

        //INSERCIONES
        exito = hash.insertar(154);
        System.out.println("Metodo insertar elemento 154, espera true ->\t"+exito);
        exito = hash.insertar(285);
        System.out.println("Metodo insertar elemento 285, espera true ->\t"+exito);
        exito = hash.insertar(427);
        System.out.println("Metodo insertar elemento 427, espera true ->\t"+exito);
        exito = hash.insertar(37);
        System.out.println("Metodo insertar elemento 37, espera true ->\t"+exito);
        exito = hash.insertar(175);
        System.out.println("Metodo insertar elemento 175, espera true ->\t"+exito);
        exito = hash.insertar(399);
        System.out.println("Metodo insertar elemento 399, espera true ->\t"+exito);

        lis = hash.listar();
        System.out.println("Metodo listar hash vacio:\n"+lis.toString());
    }
}
