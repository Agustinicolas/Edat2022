package repaso;

public class Alumno {
    
    //atributos

    private String legajo = "";
    private String nombre = "";
    private String apellido = "";
    private String tipoDni = "";
    private int numDni;
    private String domicilioCalle = "";
    private int domicilioNum;
    private String domicilioCiudad = "";
    private int telefono;
    private String usuarioSiu = "";
    private String claveSiu = "";


    //métodos constructores

    public Alumno(String legajo){
        this.legajo = legajo;
    }

    public Alumno(String legajo, String nombre, String apellido, String tipoDni, int numDni){
        
        this.legajo = legajo;
        this.nombre = nombre;
        this.apellido = apellido;
        this.tipoDni = tipoDni;
        this.numDni = numDni;
        this.usuarioSiu = Integer.toString(numDni);
        this.claveSiu = Integer.toString(numDni);

    }


    //métodos observadores

    public String getNombre(){
        return this.nombre;
    }

    public String getApellido(){
        return this.apellido;
    }

    public String getLegajo(){
        return this.legajo;
    }

    public String getTipoDni(){
        return this.tipoDni;
    }

    public int getNumDni(){
        return this.numDni;
    }

    public String getDomicilioCalle(){
        return this.domicilioCalle;
    }

    public int getDomicilioNum(){
        return this.domicilioNum;
    }

    public String getDomicilioCiudad(){
        return this.domicilioCiudad;
    }

    public int getTelefono(){
        return this.telefono;
    }

    public String getUsuarioSiu(){
        return this.usuarioSiu;
    }

    public String aCadena(){
        String cadena = "Datos del usuario:\n";
        cadena = cadena + "Legajo: " + this.legajo + "\n";
        cadena = cadena + "nombre: " + this.nombre + "\n";
        cadena = cadena + "apellido: " + this.apellido + "\n";
        cadena = cadena + "tipo DNI: " + this.tipoDni + "\n";
        cadena = cadena + "número DNI: " + Integer.toString(this.numDni) + "\n";
        cadena = cadena + "Domicilio: " + this.domicilioCalle + " " + Integer.toString(this.domicilioNum) + ", " +this.domicilioCiudad + "\n";
        cadena = cadena + "telefono: " + Integer.toString(this.telefono) + "\n";
        cadena = cadena + "Usuario SIU: " + this.usuarioSiu + "\n\n";

        return cadena;
    }

    
    //métodos modificadores

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public void setApellido(String apellido){
        this.apellido = apellido;
    }

    public void setTipoDni(String tipoDni){
        this.tipoDni = tipoDni;
    }

    public void setNumDni(int numDni){
        this.numDni = numDni;
    }

    public void setDomicilioCalle(String domicilioCalle){
        this.domicilioCalle = domicilioCalle;
    }

    public void setDomicilioNum(int domicilioNum){
        this.domicilioNum = domicilioNum;
    }

    public void setDomicilioCiudad(String domicilioCiudad){
        this.domicilioCiudad = domicilioCiudad;
    }

    public void setTelefono(int telefono){
        this.telefono = telefono;
    }

    public void setUsuarioSiu(String usuarioSiu){
        this.usuarioSiu = usuarioSiu;
    }

    public void setClaveSiu(String clave){
        this.claveSiu = clave;
    }
}

