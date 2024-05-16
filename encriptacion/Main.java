package encriptacion;

public class Main {
    // Método main para probar la funcionalidad de la clase
    public static void main(String[] args) {
        CaesarCipher cifrador = new CaesarCipher(3); // Crear un cifrador con clave 3
        String mensaje = "hola123"; // Mensaje a encriptar
        String mensajeEncriptado = cifrador.encriptar(mensaje); // Encriptar el mensaje
        System.out.println("Mensaje encriptado: " + mensajeEncriptado); // Mostrar el mensaje encriptado
        String mensajeDesencriptado = cifrador.desencriptar(mensajeEncriptado); // Desencriptar el mensaje
        System.out.println("Mensaje desencriptado: " + mensajeDesencriptado); // Mostrar el mensaje desencriptado
    }
}
