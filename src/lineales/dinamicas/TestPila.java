package lineales.dinamicas;
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
        exito = pila1.esVacia();
        System.out.println("vaciado: " + exito);
        System.out.println("PILA 1:" + pila1.toString());
        System.out.println("PILA 2:" + pila2.toString());

        System.out.println("\nEJERCICIO 3:");
        Pila pila3 = new Pila();
        pila3.apilar(1);
        pila3.apilar(0);
        pila3.apilar(2);
        pila3.apilar(3);
        pila3.apilar(3);
        pila3.apilar(2);
        pila3.apilar(0);
        pila3.apilar(1);
        Pila pila4 = new Pila();
        pila4.apilar(1);
        pila4.apilar(0);
        pila4.apilar(2);
        pila4.apilar(4);
        pila4.apilar(0);
        pila4.apilar(2);
        pila4.apilar(0);
        pila4.apilar(1);
        Pila pila5 = new Pila();
        pila5.apilar(4);
        pila5.apilar(0);
        pila5.apilar(3);
        pila5.apilar(2);
        pila5.apilar(3);
        pila5.apilar(0);
        pila5.apilar(4);
        Pila pila6 = new Pila();
        pila6.apilar(4);
        pila6.apilar(0);
        pila6.apilar(2);
        pila6.apilar(2);
        pila6.apilar(3);
        pila6.apilar(0);
        pila6.apilar(4);
        exito = esCapicua(pila3);
        System.out.println(pila3.toString()+ "|  capicua: " + exito);
        exito = esCapicua(pila4);
        System.out.println(pila4.toString()+ "|  capicua: " + exito);
        exito = esCapicua(pila5);
        System.out.println(pila5.toString()+ "|  capicua: " + exito);
        exito = esCapicua(pila6);
        System.out.println(pila6.toString()+ "|  capicua: " + exito);
        
        



        
    }

    //EJERCICIO 3

    public static boolean esCapicua(Pila pilaOrig){
        //Retorna true si la pila es capicua, caso contrario retorna false
        boolean capicua = true;
        Pila pilaClon = new Pila();
        pilaClon = pilaOrig.clone();
        Pila pilaAux = new Pila();
        while ( !pilaClon.esVacia() ){
            pilaAux.apilar(pilaClon.obtenerTope());
            pilaClon.desapilar();
        }
        pilaClon = pilaOrig.clone();
        while ( !(pilaClon.esVacia()) && capicua == true){
            if(! pilaClon.obtenerTope().equals(pilaAux.obtenerTope())){
                capicua = false;
            }
            pilaClon.desapilar();
            pilaAux.desapilar();
        }
        return capicua;
    }
}
