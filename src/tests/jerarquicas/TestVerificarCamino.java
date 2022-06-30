package tests.jerarquicas;

import jerarquicas.dinamicas.ArbolGen;
import lineales.dinamicas.Lista;

public class TestVerificarCamino {
    
    public static void main(String[] args){
        ArbolGen a1 = new ArbolGen();
        Lista listado = new Lista();
        boolean exito;

        a1.insertar(20, 65465);
        a1.insertar(13, 20);
        a1.insertar(54, 20);
        a1.insertar(15, 13);
        a1.insertar(12,13);
        a1.insertar(11, 54);
        a1.insertar(27,54);
        a1.insertar(4,54);
        a1.insertar(17,27);
        System.out.println(a1.toString());

        /*
        listado.insertar(20, 1);
        listado.insertar(17,2);
        listado.insertar(12,3);
        listado.insertar(45,4);
        System.out.println(listado.toString());

        exito = a1.verificarCamino(listado);
        System.out.println(exito);
        */

        listado = a1.listarEntreNiveles(1, 2);
        System.out.println(listado);
    }
}
