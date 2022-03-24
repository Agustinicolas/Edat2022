package repaso;

public class testAlumno {
    
    public static void main(String[] args){

        Alumno a = new Alumno("FAI-222");
        Alumno b = new Alumno("FAI-3434");

        System.out.println("ALUMNO A");
        System.out.println(a.aCadena());

        b.setNombre("agustin");
        b.setApellido("hernandez");
        b.setDomicilioCalle("Rio Quinto");
        b.setDomicilioNum(484);
        b.setDomicilioCiudad("Neuquen");
        b.setTelefono(2995216105L);
        System.out.println("ALUMNO B");
        System.out.println(b.aCadena());
    }

}
