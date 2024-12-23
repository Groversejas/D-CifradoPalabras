import java.util.ArrayList;

/**
 * Write a description of class ListaPalabras here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ListaPalabras
{
    private ArrayList<Palabra> palabras;
    
    public ListaPalabras (){
        palabras = new ArrayList<>();
    }
    
    public void agregarPalabra(Palabra palabra){
        palabras.add(palabra);
    }
    
    public Palabra obtenerPalabra(int index){
        return palabras.get(index);
    }
    
    public int contarPalabras(){
        return palabras.size();
    }
    
    public ArrayList<Palabra> getPalabras(){
        return palabras;
    }
}
