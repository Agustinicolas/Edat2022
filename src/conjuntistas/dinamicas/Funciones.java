package conjuntistas.dinamicas;

public class Funciones {
    
    public static int hashInt(int elem){

    int pos;
    int primo = 19;
    
    pos = elem % primo;

    return pos;

    }

    public static int hashString(String cadena){

        int suma = 0;
        int longitud = cadena.length();
        int i;
        char caracter;
        int ascii;
        for (i = 0; i < longitud; i++){
            caracter = cadena.charAt(i);
            ascii = (int) caracter;
            suma = suma + ascii;
        }

        return suma;
    }
}
