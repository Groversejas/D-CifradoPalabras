
/**
 * Write a description of class Participante here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Participante {
    protected String nombre;
    protected String apellido;

    public Participante(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public void mostrarNombre() {
        System.out.println("Nombre: " + nombre + " " + (apellido != null ? apellido : ""));
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }
}
