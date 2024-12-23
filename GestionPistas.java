
/**
 * Write a description of class GestionPistas here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.Stack;
import java.util.LinkedList;
import java.util.Queue;

public class GestionPistas {
    private Stack<Pista> pilaPistas;
    private Queue<Pista> colaPistas;

    public GestionPistas() {
        pilaPistas = new Stack<>();
        colaPistas = new LinkedList<>();
    }

    // Agregar una pista a la pila
    public void agregarPistaAStack(Pista pista) {
        pilaPistas.push(pista);
    }

    // Obtener una pista de la pila
    public String obtenerPistaDeStack() {
        if (!pilaPistas.isEmpty()) {
            Pista pista = pilaPistas.pop();
            return pista.generarPista(pista.getPalabraOriginal().length());
        }
        return "No hay más pistas en la pila.";
    }

    // Agregar una pista a la cola
    public void agregarPistaAQueue(Pista pista) {
        colaPistas.add(pista);
    }

    // Obtener una pista de la cola
    public String obtenerPistaDeQueue() {
        if (!colaPistas.isEmpty()) {
            Pista pista = colaPistas.poll();
            return pista.generarPistaInicial(pista.getPalabraOriginal().charAt(0));
        }
        return "No hay más pistas en la cola.";
    }
}
