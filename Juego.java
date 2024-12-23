
/**
 * Write a description of class Juego here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;

public class Juego
{
    private List<Palabra> listaPalabras;
    private Cifrado cifrado;
    private Nivel nivelActual;
    private Jugador jugador;
    private Stack<String> pilaPistas;
    private Queue<String> colaPalabras;
    private String palabraActualCifrada;

    public Juego (Jugador jugador , Nivel nivel, ListaPalabras listaPalabras){
        this.jugador = jugador;
        this.nivelActual = nivel; // Asignar correctamente el parámetro 'nivel'
        this.listaPalabras = listaPalabras.getPalabras();
        this.pilaPistas = new Stack<>();
        this.colaPalabras = new LinkedList<>();
    }
    
    public void prepararJuego() {
        if (nivelActual == null) {
            throw new IllegalStateException("El nivel actual no ha sido configurado.");
        }
        // Configurar cifrado basado en el nivel actual
        this.cifrado = new Cifrado(nivelActual.getClaveInicial(), nivelActual.getIncremento());
    
        for (Palabra p : listaPalabras) {
            String cifrada = cifrado.cifrar(p.getOriginal());
            p.setCifrada(cifrada);
            colaPalabras.add(cifrada);
        }
    }
    
    public String obtenerPalabraCifrada() {
        if (colaPalabras.isEmpty()) {
            return null; // Indica que no hay más palabras
        }
        palabraActualCifrada = colaPalabras.poll();
        return palabraActualCifrada;
    }
        
    public boolean verificarRespuesta(String respuesta) {
        for (Palabra p : listaPalabras) {
            if (p.getCifrada().equals(palabraActualCifrada)) {
                if (p.getOriginal().equalsIgnoreCase(respuesta)) {
                    jugador.incrementarPuntuacion(10); // Incrementar puntuación
                    return true;
                }
            }
        }
        // Reducir intentos restantes
        jugador.setIntentosRestantes(jugador.getIntentosRestantes() - 1);
        if (jugador.getIntentosRestantes() <= 0) {
            System.out.println("Sin intentos restantes. El juego ha terminado.");
        }
        return false;
    }

    public void generarPistas() {
        for(Palabra p : listaPalabras) {
            if(p.getCifrada().equals(palabraActualCifrada)) {
                Pista pista = new Pista(p.getOriginal());
                pilaPistas.push(pista.generarPista(p.getOriginal().length()));
                pilaPistas.push(pista.generarPistaInicial(p.getOriginal().charAt(0)));
            }
        }
    }

    public String obtenerPista() {
        if (pilaPistas.size() > 0) {
            StringBuilder pistas = new StringBuilder();
            
            // Extraer todas las pistas disponibles
            while (!pilaPistas.isEmpty()) {
                pistas.append(pilaPistas.pop()).append("\n");
            }
    
            return pistas.toString(); // Devolver todas las pistas disponibles
        }
        return "No hay más pistas disponibles.";
    }

    
    public Cifrado getCifrado(){
        return cifrado;
    }
    
    public void setCifrado(Cifrado cifrado){
        this.cifrado = cifrado;
    }
    
    public Nivel getNivelActual(){
        return nivelActual;
    }
    
    public void setNivelActual(Nivel nivelAcual){
        this.nivelActual = nivelActual;
    }
    
    public Jugador getJugador(){
        return jugador;
    }
    
    public void setJugador (Jugador jugador){
        this.jugador = jugador;
    }
    
    public String getPalabraActualCifrada(){
        return palabraActualCifrada;
    }
    
    public void setPalabraActualCifrada(String palabraActualCifrada){
        this.palabraActualCifrada = palabraActualCifrada;
    }   
    
    public String descifrar(String palabra){
        return cifrado.descifrar(palabra);
    }
    
    public Queue<String> getColaPalabras() {
        return colaPalabras;
    }

}