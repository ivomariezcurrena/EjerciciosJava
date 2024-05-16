package smercado;

import java.util.*;

public class SupermercadoSimulacion {
    private int numCajas;
    private int maxProductos;
    private int tiempoPago;
    private int tiempoSimulacion;
    private List<Queue<Cliente>> cajas;
    private Random random;

    public SupermercadoSimulacion(int numCajas, int maxProductos, int tiempoPago, int tiempoSimulacion) {
        this.numCajas = numCajas;
        this.maxProductos = maxProductos;
        this.tiempoPago = tiempoPago;
        this.tiempoSimulacion = tiempoSimulacion;
        this.cajas = new ArrayList<>();
        for (int i = 0; i < numCajas; i++) {
            cajas.add(new LinkedList<>());
        }
        this.random = new Random();
    }

    public void iniciarSimulacion() {
        int tiempoActual = 0;
        while (tiempoActual < tiempoSimulacion) {
            // Añadir clientes a las cajas
            if (random.nextBoolean()) {
                int productos = random.nextInt(maxProductos) + 1;
                int tiempoAtencion = productos + tiempoPago;
                Cliente cliente = new Cliente(productos, tiempoAtencion);
                Queue<Cliente> cajaMenosOcupada = getCajaMenosOcupada();
                cajaMenosOcupada.add(cliente);
            }

            // Procesar clientes en cada caja
            for (Queue<Cliente> caja : cajas) {
                if (!caja.isEmpty()) {
                    Cliente clienteEnCaja = caja.peek();
                    clienteEnCaja.procesarUnidadTiempo();
                    if (clienteEnCaja.estaAtendido()) {
                        caja.remove();
                    }
                }
            }

            tiempoActual++;
        }

        // Generar reporte al finalizar la simulación
        generarReporte();
    }

    private Queue<Cliente> getCajaMenosOcupada() {
        return Collections.min(cajas, Comparator.comparingInt(Queue::size));
    }

    private void generarReporte() {
        // Implementar lógica para generar el reporte
    }

    public static void main(String[] args) {
        SupermercadoSimulacion simulacion = new SupermercadoSimulacion(5, 20, 5, 1000);
        simulacion.iniciarSimulacion();
    }
}

class Cliente {
    private int productos;
    private int tiempoAtencion;
    private int tiempoProcesado;

    public Cliente(int productos, int tiempoAtencion) {
        this.productos = productos;
        this.tiempoAtencion = tiempoAtencion;
        this.tiempoProcesado = 0;
    }

    public void procesarUnidadTiempo() {
        tiempoProcesado++;
    }

    public boolean estaAtendido() {
        return tiempoProcesado >= tiempoAtencion;
    }
}
