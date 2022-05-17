package tests.jerarquicas;

import jerarquicas.dinamicas.ArbolGen;
import lineales.dinamicas.Lista;

public class testFrontera {
    

    public static void main(String[] args){
        
        ArbolGen a1 = new ArbolGen();
        Lista listaFrontera = new Lista();

        listaFrontera = a1.frontera();
        System.out.println("Metodo frontera arbol vacío: espera Lista vacía\n"+listaFrontera.toString());

        a1.insertar('A', "ASDASD"); //insercion elemento raíz

        System.out.println("\n"+a1.toString()+"\n");

        listaFrontera = a1.frontera();
        System.out.println("Metodo frontera arbol con un solo elemento: espera elemento raíz 'A'\n"+(listaFrontera.toString()));

        a1.insertar('B', 'A');
        a1.insertar('C', 'A');
        a1.insertar('D', 'A');
        a1.insertar('E', 'B');
        a1.insertar('F', 'D');
        a1.insertar('G', 'D');
        a1.insertar('H', 'D');

        System.out.println("\n"+a1.toString()+"\n");

        listaFrontera = a1.frontera();
        System.out.println("Metodo frontera, espera E | C | G | H \n"+listaFrontera.toString());

        Lista lista1 = new Lista(); //lista vacía
        Lista lista2 = new Lista(); //lista que no contiene todos los elementos de frontera
        Lista lista3 = new Lista(); //lista que contiene exactamente los elementos de frontera
        Lista lista4 = new Lista(); //lista con elementos repetidos, contiene los elementos de frontera

        lista2.insertar('E',1);
        lista2.insertar('C',2);
        lista2.insertar('F',3);

        lista3.insertar('E', 1);
        lista3.insertar('C', 1);
        lista3.insertar('F', 1);
        lista3.insertar('G', 1);
        lista3.insertar('H', 1);

        lista4.insertar('E', 1);
        lista4.insertar('C', 1);
        lista4.insertar('F', 1);
        lista4.insertar('G', 1);
        lista4.insertar('H', 1);
        lista4.insertar('E', 1);

        System.out.println("Metodo sonFrontera con lista vacía, espera false \t"+a1.sonFrontera(lista1));
        System.out.println("Metodo sonFrontera con lista incorrecta, espera false \t"+a1.sonFrontera(lista2));
        System.out.println("Metodo sonFrontera con lista correcta, espera true \t"+a1.sonFrontera(lista3));
        System.out.println("Metodo sonFrontera con lista correcta (sobran elementos), espera true \t"+a1.sonFrontera(lista4));
    }
}
