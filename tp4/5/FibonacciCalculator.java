public class FibonacciCalculator {
    private FibonacciCalculator() {
    } // Constructor privado para evitar instanciar la clase

    // Implementación recursiva estándar para calcular el número de Fibonacci
    public static long fibonacciStandard(int n) {
        if (n <= 1) {
            return n;
        }
        return fibonacciStandard(n - 1) + fibonacciStandard(n - 2);
    }

    // Implementación recursiva optimizada para calcular el número de Fibonacci
    public static long fibonacciOptimized(int n) {
        return fibonacciHelper(n, 0, 1);
    }

    private static long fibonacciHelper(int n, long a, long b) {
        if (n == 0) {
            return a;
        }
        if (n == 1) {
            return b;
        }
        return fibonacciHelper(n - 1, b, a + b);
    }

    // Función para trazar la ejecución de fibonacciStandard
    public static void traceFibonacciStandard(int n) {
        System.out.println("fibonacciStandard(" + n + ")");
        for (int i = 0; i <= n; i++) {
            System.out.print(fibonacciStandard(i) + " ");
        }
        System.out.println();
    }

    // Función para trazar la ejecución de fibonacciOptimized
    public static void traceFibonacciOptimized(int n) {
        System.out.println("fibonacciOptimized(" + n + ")");
        for (int i = 0; i <= n; i++) {
            System.out.print(fibonacciOptimized(i) + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Probar ambos algoritmos con distintos números
        int n = 10;

        System.out.println("Trayectoria de fibonacciStandard:");
        traceFibonacciStandard(n);
        long inicioStandard = System.nanoTime();
        long resultadoStandard = fibonacciStandard(n);
        long finStandard = System.nanoTime();
        System.out.println("Resultado standard: " + resultadoStandard);
        System.out.println("Tiempo de ejecución (standard): " + (finStandard - inicioStandard) + " nanosegundos");

        System.out.println("\nTrayectoria de fibonacciOptimized:");
        traceFibonacciOptimized(n);
        long inicioOptimized = System.nanoTime();
        long resultadoOptimized = fibonacciOptimized(n);
        long finOptimized = System.nanoTime();
        System.out.println("Resultado optimizado: " + resultadoOptimized);
        System.out.println("Tiempo de ejecución (optimizado): " + (finOptimized - inicioOptimized) + " nanosegundos");
    }
}
