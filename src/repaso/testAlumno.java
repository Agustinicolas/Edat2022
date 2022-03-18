package repaso;

public class testAlumno {
    
    public static void main(String[] args){

        Alumno a = new Alumno("FAI-222");
        Alumno b = new Alumno("FAI-505", "Agustin", "Hernandez", "DNI", 37175399);

        System.out.println("Estados iniciales:\n");
        System.out.println("ALUMNO A");
        System.out.println(a.aCadena());
        System.out.println("ALUMNO b");
        System.out.println(b.aCadena());

        a.setNombre("AAAA");
        a.setApellido("BBBB");
        a.setTipoDni("DNI");
        a.setNumDni(40222545);
        a.setDomicilioCalle("Illia");
        a.setDomicilioNum(555);
        a.setDomicilioCiudad("Neuquen");
        a.setTelefono(155221456);
        a.setUsuarioSiu(Integer.toString(a.getNumDni()));
        a.setClaveSiu(Integer.toString(a.getNumDni()));

        System.out.println("Estados modificados:\n");
        System.out.println("ALUMNO A");
        System.out.println(a.aCadena());
        System.out.println("ALUMNO b");
        System.out.println(b.aCadena());
        
    }

}
