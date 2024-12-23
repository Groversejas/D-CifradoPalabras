
/**
 * Write a description of class Pista here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Pista {
    private String palabraOriginal;

    public Pista(String palabraOriginal) {
        this.palabraOriginal = palabraOriginal;
    }

    public String generarPista(int longitud) {
        return "La palabra tiene " + longitud + " letras.";
    }

    public String generarPistaInicial(char inicial) {
        return "La palabra comienza con la letra '" + inicial + "'.";
    }
    
    public String getPalabraOriginal(){
        return palabraOriginal;
    }
}
