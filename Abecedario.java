public class Abecedario {
    private final char[] letras = "abcdefghijklmnopqrstuvwxyz".toCharArray();

    // Devuelve la posición de una letra en el abecedario
    public int obtenerPosicion(char letra) {
        letra = Character.toLowerCase(letra);
        for (int i = 0; i < letras.length; i++) {
            if (letras[i] == letra) {
                return i;
            }
        }
        throw new IllegalArgumentException("Carácter no válido: " + letra);
    }

    // Devuelve la letra según su posición y si es mayúscula o no
    public char obtenerLetra(int posicion, boolean esMayuscula) {
        posicion = (posicion + letras.length) % letras.length; // Asegura ciclo
        char letra = letras[posicion];
        return esMayuscula ? Character.toUpperCase(letra) : letra;
    }
}
