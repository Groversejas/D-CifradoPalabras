public class Jugador extends Participante implements Competidor, Observador {
    private int intentosRestantes;
    private int puntuacion;
    private int partidasJugadas;
    private int partidasGanadas;

    public Jugador(String nombre, int intentosRestantes) {
        super(nombre, null);
        this.intentosRestantes = intentosRestantes;
        this.puntuacion = 0;
        this.partidasJugadas = 0;
        this.partidasGanadas = 0;
    }

    @Override
    public void competir() {
        System.out.println(nombre + " está compitiendo.");
        partidasJugadas++;
    }

    @Override
    public void desafiarA(Competidor competidor) {
        System.out.println(nombre + " desafió a " + ((Jugador) competidor).getNombre());
    }

    @Override
    public void observar() {
        System.out.println(nombre + " está observando.");
    }

    @Override
    public void registrarObservacion(String observacion) {
        System.out.println(nombre + " registró la observación: " + observacion);
    }

    @Override
    public void mostrarNombre() {
        System.out.println("Jugador Multijugador: " + nombre);
    }

    public int getIntentosRestantes() {
        return intentosRestantes;
    }

    public void setIntentosRestantes(int intentosRestantes) {
        this.intentosRestantes = Math.max(intentosRestantes, 0);
    }

    public int getPuntuacion() {
        return puntuacion;
    }

    public void incrementarPuntuacion(int puntos) {
        this.puntuacion += puntos;
    }

    public void ganarPartida() {
        partidasGanadas++;
        System.out.println(nombre + " ha ganado una partida.");
    }

    public void mostrarEstadisticas() {
        System.out.println("Estadísticas de " + nombre + ":");
        System.out.println("  Puntuación: " + puntuacion);
        System.out.println("  Partidas jugadas: " + partidasJugadas);
        System.out.println("  Partidas ganadas: " + partidasGanadas);
    }
}