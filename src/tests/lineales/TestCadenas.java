package tests.lineales;
import lineales.dinamicas.*;

public class TestCadenas {
    
    public static void main(String[] args){

        /*
        Cola cola1 = new Cola();
        Cola cola2 = new Cola();

        cola1.poner('A');
        cola1.poner('B');
        cola1.poner('#');
        cola1.poner('C');
        cola1.poner('#');
        cola1.poner('D');
        cola1.poner('E');
        cola1.poner('F');

        System.out.println(cola1.toString() + "\n");
        System.out.println(cola2.toString() + "\n");

        cola2 = generar(cola1);

        System.out.println(cola2.toString() + "\n");
        */

        Cola q = new Cola();
        
        q.poner('{');
        q.poner('5');
        q.poner('+');
        q.poner('[');
        q.poner('2');
        q.poner('*');
        q.poner('8');
        q.poner(']');
        q.poner('*');
        q.poner('4');
        q.poner('}');

        System.out.println(q.toString());
        System.out.println("cola balanceada?: "+verificarBalanceo(q));
    }

    public static Cola generar(Cola c1){
        Cola cola = c1.clone();
        Cola colaAux = new Cola();
        Cola colaAux2 = new Cola();
        Pila pilaAux = new Pila();
        Cola resul = new Cola();

        if (! c1.esVacia()){
            while( !cola.esVacia() ){
                if ( !cola.obtenerFrente().equals('#')){
                    colaAux.poner(cola.obtenerFrente());
                    colaAux2.poner(cola.obtenerFrente());
                    pilaAux.apilar(cola.obtenerFrente());
                    cola.sacar();
                }else{
                    while(!colaAux.esVacia()){
                        resul.poner(colaAux.obtenerFrente());
                        colaAux.sacar();
                    }
                    while(!pilaAux.esVacia()){
                        resul.poner(pilaAux.obtenerTope());
                        pilaAux.desapilar();
                    }
                    while(!colaAux2.esVacia()){
                        resul.poner(colaAux2.obtenerFrente());
                        colaAux2.sacar();
                    }
                    resul.poner('#');
                    cola.sacar();
                }
            }
            if(!colaAux.esVacia()){
                while(!colaAux.esVacia()){
                    resul.poner(colaAux.obtenerFrente());
                    colaAux.sacar();
                }
                while(!pilaAux.esVacia()){
                    resul.poner(pilaAux.obtenerTope());
                    pilaAux.desapilar();
                }
                while(!colaAux2.esVacia()){
                    resul.poner(colaAux2.obtenerFrente());
                    colaAux2.sacar();
                }
            }
        }

        return resul;
    }

    public static boolean verificarBalanceo(Cola q){
        
        Cola qAux = q.clone();
        Pila pAux = new Pila();
        boolean balanceada = false;
        Object frente;

        if(!qAux.esVacia()){
            while(!qAux.esVacia()){
                frente = qAux.obtenerFrente();
                if(frente.equals('{') || frente.equals('[') || frente.equals('(')){
                    pAux.apilar(frente);
                }else{
                    if(frente.equals(')')){
                        if(pAux.obtenerTope().equals('(')){
                            pAux.desapilar();
                        }
                    }
                    if(frente.equals(']')){
                        if(pAux.obtenerTope().equals('[')){
                            pAux.desapilar();
                        }
                    }
                    if(frente.equals('}')){
                        if(pAux.obtenerTope().equals('{')){
                            pAux.desapilar();
                        }
                    }
                }
                qAux.sacar();
            }
            if(pAux.esVacia()){
                balanceada = true;
            }
        }
        return balanceada;
        
    }

}
