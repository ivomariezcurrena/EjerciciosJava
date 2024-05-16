import java.util.Scanner;

public class TorresHanoi {

    // Método principal que inicia la resolución del juego
    public static void resolverHanoi(int numDiscos, char varillaOrigen, char varillaAuxiliar, char varillaDestino) {
        if (numDiscos == 1) {
            System.out.println("Mover disco 1 de varilla " + varillaOrigen + " a varilla " + varillaDestino);
            return;
        }
        // Mover n-1 discos de varillaOrigen a varillaAuxiliar usando varillaDestino
        // como auxiliar
        resolverHanoi(numDiscos - 1, varillaOrigen, varillaDestino, varillaAuxiliar);
        // Mover el disco más grande de varillaOrigen a varillaDestino
        System.out
                .println("Mover disco " + numDiscos + " de varilla " + varillaOrigen + " a varilla " + varillaDestino);
        // Mover n-1 discos de varillaAuxiliar a varillaDestino usando varillaOrigen
        // como auxiliar
        resolverHanoi(numDiscos - 1, varillaAuxiliar, varillaOrigen, varillaDestino);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Solicitar al usuario el número de discos
        System.out.print("Ingrese el número de discos: ");
        int numDiscos = scanner.nextInt();

        // Definir las varillas
        char varillaOrigen = 'A'; // Varilla de origen
        char varillaAuxiliar = 'B'; // Varilla auxiliar
        char varillaDestino = 'C'; // Varilla de destino

        // Llamada al método para resolver el juego de las Torres de Hanoi
        System.out.println("Movimientos para resolver el juego de las Torres de Hanoi con " + numDiscos + " discos:");
        resolverHanoi(numDiscos, varillaOrigen, varillaAuxiliar, varillaDestino);

        scanner.close();

    }

}
