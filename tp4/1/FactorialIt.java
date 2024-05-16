import java.util.Scanner;

public class FactorialIt {
    public static long factorialIterativo(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("El número no puede ser negativo");
        }
        long factorial = 1;
        for (int i = 1; i <= n; i++) {
            factorial *= i;
        }
        return factorial;
    }

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int numero;
        System.out.print("Ingrese el número para calcular el factorial: ");
        numero = entrada.nextInt();
        System.out.println("Factorial de " + numero + " (iterativo): " + factorialIterativo(numero));
        entrada.close();
    }
}
