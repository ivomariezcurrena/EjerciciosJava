package cola;

import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        // Creamos una cola para cargar empleados y facturas
        Queue<Empleado> colaEmpleados = new LinkedList<>();
        Queue<Factura> colaFacturas = new LinkedList<>();

        // Cargamos algunos empleados y facturas en las colas
        colaEmpleados.offer(new Empleado("Juan", 2000));
        colaEmpleados.offer(new Empleado("María", 2500));

        colaFacturas.offer(new Factura("Factura 1", 500));
        colaFacturas.offer(new Factura("Factura 2", 700));

        // Calculamos el total a pagar a los empleados y a los proveedores
        double totalEmpleados = calcularTotalEmpleados(colaEmpleados);
        double totalFacturas = calcularTotalFacturas(colaFacturas);

        // Imprimimos los resultados
        System.out.println("Total a pagar a empleados: " + totalEmpleados);
        System.out.println("Total a pagar por facturas: " + totalFacturas);
    }

    // Método para calcular el total a pagar a los empleados
    private static double calcularTotalEmpleados(Queue<Empleado> colaEmpleados) {
        double total = 0;
        for (Empleado empleado : colaEmpleados) {
            total += empleado.getSalario();
        }
        return total;
    }

    // Método para calcular el total a pagar por facturas
    private static double calcularTotalFacturas(Queue<Factura> colaFacturas) {
        double total = 0;
        for (Factura factura : colaFacturas) {
            total += factura.getMonto();
        }
        return total;
    }
}