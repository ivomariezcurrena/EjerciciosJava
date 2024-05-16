package cola;

import java.util.LinkedList;
import java.util.Queue;

public class ColaEmpleadosFacturas {
    private Queue<Empleado> colaEmpleados;
    private Queue<Factura> colaFacturas;

    public ColaEmpleadosFacturas() {
        colaEmpleados = new LinkedList<>();
        colaFacturas = new LinkedList<>();
    }

    public void agregarEmpleado(Empleado empleado) {
        colaEmpleados.offer(empleado);
    }

    public void agregarFactura(Factura factura) {
        colaFacturas.offer(factura);
    }

    public double calcularTotalSalarios() {
        double totalSalarios = 0;
        for (Empleado empleado : colaEmpleados) {
            totalSalarios += empleado.getSalario();
        }
        return totalSalarios;
    }

    public double calcularTotalFacturas() {
        double totalFacturas = 0;
        for (Factura factura : colaFacturas) {
            totalFacturas += factura.getMonto();
        }
        return totalFacturas;
    }
}