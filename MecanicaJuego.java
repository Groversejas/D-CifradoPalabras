
/**
 * Write a description of class MecanicaJuego here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.Scanner;

public class MecanicaJuego {
    private Juego juego;

    public MecanicaJuego(Juego juego) {
        this.juego = juego;
    }

      public void iniciarJuego() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Jugador: " + juego.getJugador().getNombre());
    
        // Bucle para continuar mientras haya palabras y el jugador tenga intentos restantes
        while (!juego.getColaPalabras().isEmpty()) {
            String palabraCifrada = juego.obtenerPalabraCifrada();
            if (palabraCifrada == null) {
                System.out.println("¡Felicidades! Has adivinado todas las palabras.");
                break;
            }
    
            System.out.println("Palabra Cifrada: " + palabraCifrada);
            boolean acertada = false;
    
            // Ciclo de intentos para cada palabra
            for (int i = 0; i < 3; i++) { // 3 intentos por palabra
                System.out.print("Ingresa tu respuesta: ");
                String respuesta = scanner.nextLine();
    
                if (juego.verificarRespuesta(respuesta)) {
                    System.out.println("¡Correcto! Puntuación: " + juego.getJugador().getPuntuacion());
                    acertada = true;
                    break; // Salir si la respuesta es correcta
                } else {
                    System.out.println("Incorrecto. Intentos restantes: " + (2 - i));
    
                    if (i < 2) { // Solo generar pistas si quedan intentos
                        juego.generarPistas(); // Generar nuevas pistas en cada intento
                        System.out.println("Generando pistas...");
                        System.out.println("Pista: " + juego.obtenerPista());
                    }
                }
            }
    
            if (!acertada) {
                System.out.println("La palabra era: " + juego.descifrar(palabraCifrada));
            }
    
            System.out.println("");
            System.out.println("");
            System.out.println("");
            System.out.println("");
        }
    
        // Fin del juego, mostrar puntuación final
        if (juego.getColaPalabras().isEmpty()) {
            System.out.println("¡Has adivinado todas las palabras!");
        } else {
            System.out.println("Fin del juego. Puntuación final: " + juego.getJugador().getPuntuacion());
        }
    
        scanner.close();
    }

}

