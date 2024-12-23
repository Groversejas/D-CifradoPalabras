public class Main {
    public static void main(String[] args) {
        
        // Configurar el juego
        Juego juego = configurarJuego();
            // Preparar el juego
        juego.prepararJuego();
            // Crear la instancia de MecanicaJuego
        MecanicaJuego mecanicaJuego = new MecanicaJuego(juego);
            // Iniciar el juego
        mecanicaJuego.iniciarJuego();

    }

    private static Juego configurarJuego() {
        // Crear nivel
        Nivel nivelFacil = new Nivel("Fácil", 6, 2, 2);
        Nivel normal = new Nivel("Intermedio", 10, 5, 2);

        // Crear jugador
        
        Jugador jugador1 = new Jugador("Alice", 3);
        Jugador jugador2 = new Jugador("Bob", 3);

        jugador1.competir();
        jugador1.incrementarPuntuacion(10);
        jugador1.desafiarA(jugador2);

        jugador2.observar();
        jugador2.registrarObservacion("Alice es un competidor fuerte.");
        
        Jugador jugador3 = new Jugador("Edmilzon", 3);
        // Crear lista de palabras
        ListaPalabras listaPalabras = new ListaPalabras();
        listaPalabras.agregarPalabra(new Palabra("java", null));
        listaPalabras.agregarPalabra(new Palabra("programa", null));
        listaPalabras.agregarPalabra(new Palabra("teclado", null));
        listaPalabras.agregarPalabra(new Palabra("hola", null));
        listaPalabras.agregarPalabra(new Palabra("golll", null));
        // Crear juego
        return new Juego(jugador1, normal, listaPalabras);
    }
    
    
}
