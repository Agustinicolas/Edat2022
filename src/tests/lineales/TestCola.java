package tests.lineales;

import lineales.dinamicas.Cola;

public class TestCola {
    
    public static void main(String[] args){
        
        Cola cola1 = new Cola();
        Cola cola2;
        boolean exito;

        //IMPRESIÓN COLA VACIA
        System.out.println("IMPRESION COLA VACIA");
        System.out.println(cola1.toString());

        //AGREGO 3 ELEMENTOS
        System.out.println("\nPONGO 3 ELEMENTOS: ");
        exito = cola1.poner("elem1");
        System.out.println("Exito: "+exito+" "+cola1.toString());
        exito = cola1.poner("elem2");
        System.out.println("Exito: "+exito+" "+cola1.toString());
        exito = cola1.poner("elem3");
        System.out.println("Exito: "+exito+" "+cola1.toString());

        //QUITO 4 ELEMENTOS
        System.out.println("\nSACO 4 ELEMENTOS: ");
        exito = cola1.sacar();
        System.out.println("Exito: "+exito+" "+cola1.toString());
        exito = cola1.sacar();
        System.out.println("Exito: "+exito+" "+cola1.toString());
        exito = cola1.sacar();
        System.out.println("Exito: "+exito+" "+cola1.toString());
        exito = cola1.sacar();
        System.out.println("Exito: "+exito+" "+cola1.toString());

        //AGREGO 3 ELEMENTOS
        System.out.println("\nPONGO 3 ELEMENTOS: ");
        exito = cola1.poner("elem1");        
        exito = cola1.poner("elem2");        
        exito = cola1.poner("elem3");
        System.out.println("Exito: "+exito+" "+cola1.toString());

        //VACIO COLA
        System.out.println("\n VACIO COLA: ");
        cola1.vaciar();
        System.out.println(cola1.toString());

        //PONGO 12 ELEMENTOS
        System.out.println("\nPONGO 12 ELEMENTOS:");
        exito = cola1.poner("elem1");
        System.out.println("Exito: "+exito+" "+cola1.toString());
        exito = cola1.poner("elem2");
        System.out.println("Exito: "+exito+" "+cola1.toString());
        exito = cola1.poner("elem3");
        System.out.println("Exito: "+exito+" "+cola1.toString());
        exito = cola1.poner("elem4");
        System.out.println("Exito: "+exito+" "+cola1.toString());
        exito = cola1.poner("elem5");
        System.out.println("Exito: "+exito+" "+cola1.toString());
        exito = cola1.poner("elem6");
        System.out.println("Exito: "+exito+" "+cola1.toString());
        exito = cola1.poner("elem7");
        System.out.println("Exito: "+exito+" "+cola1.toString());
        exito = cola1.poner("elem8");
        System.out.println("Exito: "+exito+" "+cola1.toString());
        exito = cola1.poner("elem9");
        System.out.println("Exito: "+exito+" "+cola1.toString());
        exito = cola1.poner("elem10");
        System.out.println("Exito: "+exito+" "+cola1.toString());
        exito = cola1.poner("elem11");
        System.out.println("Exito: "+exito+" "+cola1.toString());
        exito = cola1.poner("elem12");
        System.out.println("Exito: "+exito+" "+cola1.toString());

        //CLONO COLA
        System.out.println("\nCLONO COLA:");
        cola2 = cola1.clone();
        System.out.println("Cola1: "+cola1.toString());
        System.out.println("Cola2: "+cola2.toString());

        //QUITO 4 ELEMENTOS DE COLA ORIGINAL
        System.out.println("\nSACO 4 ELEMENTOS DE COLA ORIGINAL: ");
        exito = cola1.sacar();
        System.out.println("Exito: "+exito+" "+cola1.toString());
        exito = cola1.sacar();
        System.out.println("Exito: "+exito+" "+cola1.toString());
        exito = cola1.sacar();
        System.out.println("Exito: "+exito+" "+cola1.toString());
        exito = cola1.sacar();
        System.out.println("Exito: "+exito+" "+cola1.toString());
        System.out.println("\nCola1: "+cola1.toString());
        System.out.println("Cola2: "+cola2.toString());

    }
}
