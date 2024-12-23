// Clase Cifrado
public class Cifrado {
    private int claveInicial;
    private int incremento;
    private Abecedario abecedario;

    public Cifrado(int claveInicial, int incremento) {
        this.claveInicial = claveInicial;
        this.incremento = incremento;
        this.abecedario = new Abecedario();
    }

    public String cifrar(String palabra) {
        StringBuilder cifrada = new StringBuilder();
        int clave = claveInicial;

        for (char c : palabra.toCharArray()) {
            if (Character.isLetter(c)) {
                boolean esMayuscula = Character.isUpperCase(c);
                int posicionOriginal = abecedario.obtenerPosicion(c);
                int nuevaPosicion = (posicionOriginal + clave) % 26;
                cifrada.append(abecedario.obtenerLetra(nuevaPosicion, esMayuscula));
                clave = (clave + incremento) % 26; // Mantener la clave dentro del rango [0, 25]
            } else {
                cifrada.append(c); // Caracteres no alfabéticos no se cifran
            }
        }
        return cifrada.toString();
    }

    public String descifrar(String palabraCifrada) {
        StringBuilder descifrada = new StringBuilder();
        int clave = claveInicial;

        for (char c : palabraCifrada.toCharArray()) {
            if (Character.isLetter(c)) {
                boolean esMayuscula = Character.isUpperCase(c);
                int posicionOriginal = abecedario.obtenerPosicion(c);
                int nuevaPosicion = (posicionOriginal - clave + 26) % 26;
                descifrada.append(abecedario.obtenerLetra(nuevaPosicion, esMayuscula));
                clave = (clave + incremento) % 26; // Mantener la clave dentro del rango [0, 25]
            } else {
                descifrada.append(c); // Caracteres no alfabéticos no se descifran
            }
        }
        return descifrada.toString();
    }

    public int getClaveInicial() {
        return claveInicial;
    }

    public void setClaveInicial(int claveInicial) {
        this.claveInicial = claveInicial;
    }

    public int getIncremento() {
        return incremento;
    }

    public void setIncremento(int incremento) {
        this.incremento = incremento;
    }
}
