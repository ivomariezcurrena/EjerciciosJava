public class s {

    // Implementación recursiva optimizada multiplicando los resultados parciales
    public static double powerOptimized(double base, int exponente) {
        if (exponente == 0) {
            return 1;
        }
        double mitad = powerOptimized(base, exponente / 2);
        if (exponente % 2 == 0) {
            return mitad * mitad;
        } else {
            return base * mitad * mitad;
        }
    }

    // Función para trazar la ejecución de powerOptimized
    public static void tracePowerOptimized(double base, int exponente) {
        System.out.println("powerOptimized(" + base + ", " + exponente + ")");
        if (exponente == 0) {
            System.out.println("= 1");
        } else {
            double mitad = powerOptimized(base, exponente / 2);
            System.out.print("= ");
            if (exponente % 2 == 0) {
                System.out.print(mitad + " * " + mitad);
            } else {
                System.out.print(base + " * " + mitad + " * " + mitad);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        // Probar ambos algoritmos con distintos números
        double base = 2;
        int exponente = 10;
        System.out.println("\nTrayectoria de powerOptimized:");
        tracePowerOptimized(base, exponente);
        long inicioOptimizado = System.nanoTime();
        double resultadoOptimizado = powerOptimized(base, exponente);
        long finOptimizado = System.nanoTime();
        System.out.println("\nResultado optimizado: " + resultadoOptimizado);
        System.out.println("Tiempo de ejecución (optimizado): " + (finOptimizado - inicioOptimizado) + " nanosegundos");
    }
}
