package pila;

import java.util.Scanner;

// Clase principal
public class NominaEmpleados {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Crear una pila para almacenar los empleados
        Stack<Empleado> nomina = new LinkedStack<>();

        // Solicitar al usuario la cantidad de empleados
        System.out.print("Ingrese la cantidad de empleados: ");
        int numEmpleados = scanner.nextInt();
        scanner.nextLine(); // Consumir la nueva línea después de leer el número de empleados

        // Cargar los datos de cada empleado en la pila
        for (int i = 0; i < numEmpleados; i++) {
            System.out.println("Ingrese los datos del empleado " + (i + 1) + ":");
            System.out.print("Nombre: ");
            String nombre = scanner.nextLine();
            System.out.print("Salario base: ");
            double salarioBase = scanner.nextDouble();
            System.out.print("Horas extras trabajadas: ");
            double horasExtras = scanner.nextDouble();
            scanner.nextLine(); // Consumir la nueva línea después de leer las horas extras

            // Crear un nuevo empleado y agregarlo a la pila
            Empleado empleado = new Empleado(nombre, salarioBase, horasExtras);
            nomina.push(empleado);
        }

        // Calcular y mostrar el sueldo total de cada empleado
        System.out.println("\nSueldo total de cada empleado:");
        while (!nomina.isEmpty()) {
            Empleado empleado = nomina.pop();
            System.out.println("Empleado: " + empleado.getNombre() + ", Sueldo: $" + empleado.getSueldoTotal());
        }

        // Cerrar el scanner
        scanner.close();
    }
}
