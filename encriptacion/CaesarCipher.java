package encriptacion;

public class CaesarCipher {
    // Definición del alfabeto español que incluye letras minúsculas y números
    private static final String ALFABETO = "abcdefghijklmnñopqrstuvwxyz1234567890";
    private static final int LONGITUD_ALFABETO = ALFABETO.length(); // Longitud del alfabeto
    private int clave; // Clave de cifrado

    // Constructor de la clase CaesarCipher
    public CaesarCipher(int clave) {
        this.clave = clave % LONGITUD_ALFABETO; // Ajuste de la clave al tamaño del alfabeto
    }

    // Método para encriptar un mensaje
    public String encriptar(String mensaje) {
        StringBuilder mensajeEncriptado = new StringBuilder();
        // Recorremos cada caracter del mensaje
        for (char caracter : mensaje.toCharArray()) {
            // Verificamos si el caracter es una letra minúscula
            if (Character.isLowerCase(caracter)) {
                int posicion = ALFABETO.indexOf(caracter); // Obtenemos la posición del caracter en el alfabeto
                if (posicion != -1) { // Verificamos si el caracter está en el alfabeto
                    int nuevaPosicion = (posicion + clave) % LONGITUD_ALFABETO; // Calculamos la nueva posición
                    mensajeEncriptado.append(ALFABETO.charAt(nuevaPosicion)); // Añadimos el caracter encriptado
                } else {
                    mensajeEncriptado.append(caracter); // Conservamos el caracter si no está en el alfabeto
                }
            } else if (Character.isDigit(caracter)) { // Verificamos si el caracter es un número
                int posicion = ALFABETO.indexOf(caracter); // Obtenemos la posición del caracter en el alfabeto
                if (posicion != -1) { // Verificamos si el caracter está en el alfabeto
                    int nuevaPosicion = (posicion + clave) % LONGITUD_ALFABETO; // Calculamos la nueva posición
                    mensajeEncriptado.append(ALFABETO.charAt(nuevaPosicion)); // Añadimos el caracter encriptado
                } else {
                    mensajeEncriptado.append(caracter); // Conservamos el caracter si no está en el alfabeto
                }
            } else { // Conservamos el caracter si no es letra minúscula ni número
                mensajeEncriptado.append(caracter);
            }
        }
        return mensajeEncriptado.toString(); // Devolvemos el mensaje encriptado como una cadena
    }

    // Método para desencriptar un mensaje encriptado
    public String desencriptar(String mensajeEncriptado) {
        StringBuilder mensaje = new StringBuilder();
        // Recorremos cada caracter del mensaje encriptado
        for (char caracter : mensajeEncriptado.toCharArray()) {
            // Verificamos si el caracter es una letra minúscula
            if (Character.isLowerCase(caracter)) {
                int posicion = ALFABETO.indexOf(caracter); // Obtenemos la posición del caracter en el alfabeto
                if (posicion != -1) { // Verificamos si el caracter está en el alfabeto
                    int nuevaPosicion = (posicion - clave + LONGITUD_ALFABETO) % LONGITUD_ALFABETO; // Calculamos la
                                                                                                    // nueva posición
                    mensaje.append(ALFABETO.charAt(nuevaPosicion)); // Añadimos el caracter desencriptado
                } else {
                    mensaje.append(caracter); // Conservamos el caracter si no está en el alfabeto
                }
            } else if (Character.isDigit(caracter)) { // Verificamos si el caracter es un número
                int posicion = ALFABETO.indexOf(caracter); // Obtenemos la posición del caracter en el alfabeto
                if (posicion != -1) { // Verificamos si el caracter está en el alfabeto
                    int nuevaPosicion = (posicion - clave + LONGITUD_ALFABETO) % LONGITUD_ALFABETO; // Calculamos la
                                                                                                    // nueva posición
                    mensaje.append(ALFABETO.charAt(nuevaPosicion)); // Añadimos el caracter desencriptado
                } else {
                    mensaje.append(caracter); // Conservamos el caracter si no está en el alfabeto
                }
            } else { // Conservamos el caracter si no es letra minúscula ni número
                mensaje.append(caracter);
            }
        }
        return mensaje.toString(); // Devolvemos el mensaje desencriptado como una cadena
    }
}