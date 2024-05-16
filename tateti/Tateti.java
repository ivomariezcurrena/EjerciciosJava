package tateti;

import java.util.Scanner;

public class Tateti {
    private char[][] tablero; // Representación del tablero
    private int tamaño; // Tamaño del tablero
    private char jugadorActual; // Jugador actual (X o O)
    private boolean juegoTerminado; // Indica si el juego ha terminado

    // Constructor de la clase Tateti
    public Tateti(int tamaño) {
        this.tamaño = tamaño;
        this.tablero = new char[tamaño][tamaño];
        iniciarTablero();
        jugadorActual = 'X'; // Empieza el jugador X
        juegoTerminado = false;
    }

    // Método para iniciar el tablero con espacios en blanco
    private void iniciarTablero() {
        for (int i = 0; i < tamaño; i++) {
            for (int j = 0; j < tamaño; j++) {
                tablero[i][j] = ' ';
            }
        }
    }

    // Método para imprimir el tablero
    private void imprimirTablero() {
        for (int i = 0; i < tamaño; i++) {
            for (int j = 0; j < tamaño; j++) {
                System.out.print(tablero[i][j]);
                if (j < tamaño - 1) {
                    System.out.print(" | ");
                }
            }
            System.out.println();
            if (i < tamaño - 1) {
                System.out.println("---------");
            }
        }
    }

    // Método para verificar si hay un ganador
    private boolean hayGanador() {
        // Verificar filas y columnas
        for (int i = 0; i < tamaño; i++) {
            if (tablero[i][0] != ' ' && tablero[i][0] == tablero[i][1] && tablero[i][0] == tablero[i][2]) {
                return true; // Hay una línea en la fila i
            }
            if (tablero[0][i] != ' ' && tablero[0][i] == tablero[1][i] && tablero[0][i] == tablero[2][i]) {
                return true; // Hay una línea en la columna i
            }
        }
        // Verificar diagonales
        if (tablero[0][0] != ' ' && tablero[0][0] == tablero[1][1] && tablero[0][0] == tablero[2][2]) {
            return true; // Hay una línea en la diagonal principal
        }
        if (tablero[0][2] != ' ' && tablero[0][2] == tablero[1][1] && tablero[0][2] == tablero[2][0]) {
            return true; // Hay una línea en la diagonal secundaria
        }
        return false; // No hay ganador
    }

    // Método para verificar si hay un empate
    private boolean hayEmpate() {
        for (int i = 0; i < tamaño; i++) {
            for (int j = 0; j < tamaño; j++) {
                if (tablero[i][j] == ' ') {
                    return false; // Todavía hay posiciones vacías
                }
            }
        }
        return true; // No hay posiciones vacías
    }

    // Método para realizar una jugada
    private void hacerJugada(int fila, int columna) {
        if (fila >= 0 && fila < tamaño && columna >= 0 && columna < tamaño && tablero[fila][columna] == ' ') {
            tablero[fila][columna] = jugadorActual;
            if (hayGanador()) {
                System.out.println("¡Jugador " + jugadorActual + " gana!");
                juegoTerminado = true;
            } else if (hayEmpate()) {
                System.out.println("¡Empate!");
                juegoTerminado = true;
            } else {
                jugadorActual = (jugadorActual == 'X') ? 'O' : 'X'; // Cambiar al siguiente jugador
            }
        } else {
            System.out.println("Posición inválida. Intente de nuevo.");
        }
    }

    // Método para jugar el juego
    public void jugar() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("¡Bienvenido al juego de Tateti!");
        System.out.println("Ingrese las coordenadas de su jugada en el formato 'fila columna'.");
        System.out.println("El primer jugador es X y el segundo jugador es O.");
        while (!juegoTerminado) {
            imprimirTablero();
            System.out.println("Turno del jugador " + jugadorActual + ":");
            System.out.print("Ingrese la fila: ");
            int fila = scanner.nextInt();
            System.out.print("Ingrese la columna: ");
            int columna = scanner.nextInt();
            hacerJugada(fila, columna);
        }
        scanner.close();
    }
}
