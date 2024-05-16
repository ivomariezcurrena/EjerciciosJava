public class PowerCalculator {
    // Implementación recursiva simple para calcular la potencia de un número
    public static double powerSimple(double base, int exponente) {
        if (exponente == 0) {
            return 1;
        }
        return base * powerSimple(base, exponente - 1);
    }

    // Función para trazar la ejecución de powerSimple
    public static void tracePowerSimple(double base, int exponente) {
        System.out.println("powerSimple(" + base + ", " + exponente + ")");
        if (exponente == 0) {
            System.out.println("= 1");
        } else {
            System.out.println("= " + base + " * powerSimple(" + base + ", " + (exponente - 1) + ")");
            tracePowerSimple(base, exponente - 1);
        }
    }

    public static void main(String[] args) {
        // Probar ambos algoritmos con distintos números
        double base = 2;
        int exponente = 10;
        System.out.println("Trayectoria de powerSimple:");
        tracePowerSimple(base, exponente);

        long inicioSimple = System.nanoTime();
        double resultadoSimple = powerSimple(base, exponente);
        long finSimple = System.nanoTime();
        System.out.println("Resultado simple: " + resultadoSimple);
        System.out.println("Tiempo de ejecución (simple): " + (finSimple - inicioSimple) + " nanosegundos");

    }
}
