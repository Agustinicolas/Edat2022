package tests.grafos;
import grafos.*;
import lineales.dinamicas.Lista;

public class TestGrafo {


    public static void main(String[] args) {
        //CREACION GRAFO
        GrafoEtiq grafo = new GrafoEtiq();

        //GRAFO VACIO, METODO VACIO
        System.out.println("Metodo vacio(), output esperado: true. output test  -> " + grafo.vacio());

        //LISTADO EN PROFUNDIDAD GRAFO VACIO
        Lista listado = new Lista();
        listado = grafo.listarEnProfundidad();
        System.out.println("\nMetodo listarEnProfundidad(), output esperado: lista vacia. output test ->"+listado.toString());

        //INSERCION ELEMENTO GRAFO VACIO
        System.out.println("\nMetodo insertarVertice(obj), output esperado: true. output test -> "+grafo.insertarVertice("A"));

        //GRAFO NO VACIO, METODO VACIO
        System.out.println("\nMetodo vacio(), output esperado: false. output test  -> " + grafo.vacio());

        //EXISTE VERTICE, VERTICE INCORRECTO
        System.out.println("\nMetodo existeVertice(obj). output esperado: false. output test -> "+grafo.existeVertice("Elemento cualquiera"));

        //EXISTE VERTICE, VERTICE CORRECTO
        System.out.println("\nMetodo existeVertice(obj). output esperado: true. output test -> "+grafo.existeVertice("A"));

        //LISTADO EN PROFUNDIDAD GRAFO UNICO ELEMENTO
        listado = grafo.listarEnProfundidad();
        System.out.println("\nMetodo listarEnProfundidad(), output esperado: 'A'. output test ->"+listado.toString());

        //INSERTAR VERTICE EN GRAFO NO VACIO
        System.out.println("\nMetodo insertarVertice(obj), output esperado: true. output test -> "+grafo.insertarVertice("B"));
        System.out.println("\nMetodo insertarVertice(obj), output esperado: true. output test -> "+grafo.insertarVertice("C"));
        System.out.println("\nMetodo insertarVertice(obj), output esperado: true. output test -> "+grafo.insertarVertice("D"));
        

        //LISTADO EN PROFUNDIDAD GRAFO UNICO ELEMENTO
        listado = grafo.listarEnProfundidad();
        System.out.println("\nMetodo listarEnProfundidad(), output esperado: 'D | C | B | A'. output test ->\n"+listado.toString());
    }

}
