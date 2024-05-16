import java.util.Scanner;

public class FactorialRec {

    public static long factorialRecursivo(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("El número no puede ser negativo");
        } else if (n == 0) {
            return 1;
        } else {
            return n * factorialRecursivo(n - 1);
        }
    }

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int numero;
        System.out.print("Ingrese el número para calcular el factorial: ");
        numero = entrada.nextInt();
        System.out.println("Factorial de " + numero + " (recursivo): " + factorialRecursivo(numero));
        entrada.close();
    }
}
