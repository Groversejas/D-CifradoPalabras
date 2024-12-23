    
/**
 * Write a description of class Nivel here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Nivel
{
    private String nombre;
    private int claveInicial;
    private int incremento;
    private int pistasDisponibles;
    
    public Nivel (String nombre, int claveInicial, int incremento, int pistasDisponibles){
        this.nombre = nombre;
        this.claveInicial = claveInicial;
        this.incremento = incremento;
        this.pistasDisponibles = pistasDisponibles;
    }
    
    public String getNombre (){
        return nombre;
    }
    
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    
    public int getClaveInicial (){
        return claveInicial;
    }
    
    public void setClaveInicial(int claveInicial){
        this.claveInicial = claveInicial;
    }
    
    public int getIncremento (){
        return incremento;
    }
    
    public void setIncremento (int incremento){
        this.incremento = incremento;
    }
    
    public int getPistasDisponibles(){
        return pistasDisponibles;
    }
    
    public void setPistasDisponibles(int pistasDisponibles){
        this.pistasDisponibles = pistasDisponibles;
    }
}
