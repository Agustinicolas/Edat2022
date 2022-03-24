package lineales.estaticas;
import utiles.TecladoIn;

public class TestPila {    
    public static void main (String[] args){

        //CREACION PILA 1 Y PILA 2
        Pila pila1 = new Pila();
        Pila pila2 = new Pila();
        boolean exito;
        System.out.println("IMPRESION PILA RECIEN CREADA (DEBERIA SER VACIA):");
        System.out.println(pila1.toString());
        System.out.println("\nINTENTO DE DESAPILAR PILA VACIA(true = desapiló correctamente, false= no pudo desapilar):");
        exito = pila1.desapilar();
        System.out.println(exito);
        System.out.println("\nAPILAR 22 VECES:");
        int i;
        for (i = 1; i <= 22; i++){
            System.out.println("\nIteración numero "+ i);
            exito = pila1.apilar("algo");
            System.out.println(exito);
            System.out.println(pila1.toString());
        }
        System.out.println("\nDESAPILAR 8 ELEMENTOS:");
        i = 0;
        for (i = 0; i < 8; i++){
            exito = pila1.desapilar();
            System.out.println(exito);
            System.out.println(pila1.toString());
        }
        System.out.println("\n CLONACION PILA 1:");
        pila2 = pila1.clone();
        System.out.println("PILA 1:" + pila1.toString());
        System.out.println("PILA 2:" + pila2.toString());
        System.out.println("\n MODIFICACION PILA 1:");
        pila1.apilar("agregado");
        System.out.println("PILA 1:" + pila1.toString());
        System.out.println("PILA 2:" + pila2.toString());
        System.out.println("\n MODIFICACION PILA 1:");
        pila1.desapilar();
        pila1.desapilar();
        System.out.println("PILA 1:" + pila1.toString());
        System.out.println("PILA 2:" + pila2.toString());
        System.out.println("\n VACIO PILA1:");
        pila1.vaciar();
        exito = pila1.esVacía();
        System.out.println("vaciado: " + exito);
        System.out.println("PILA 1:" + pila1.toString());
        System.out.println("PILA 2:" + pila2.toString());
    }
}
