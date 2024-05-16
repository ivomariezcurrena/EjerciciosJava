package smercado;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Random;

public class Supermercado {
    public static void main(String[] args) {
        int numCajas = 5;
        int numClientes = 20;
        int maxProductosPorCliente = 10;

        List<Caja> cajas = new ArrayList<>();
        for (int i = 0; i < numCajas; i++) {
            int tiempoAtencion = new Random().nextInt(6) + 5; // Tiempo de atención (5 a 10 minutos)
            cajas.add(new Caja(i + 1, tiempoAtencion));
        }

        PriorityQueue<Cliente> colaClientes = new PriorityQueue<>(
                (c1, c2) -> Integer.compare(c1.productos, c2.productos));
        for (int i = 0; i < numClientes; i++) {
            int productos = new Random().nextInt(maxProductosPorCliente) + 1;
            colaClientes.add(new Cliente(productos));
        }

        while (!colaClientes.isEmpty()) {
            Cliente cliente = colaClientes.poll();
            Caja cajaMenosAtendida = cajas.stream().min(Caja::compareTo).orElseThrow(null);

            // Atender al cliente en la caja menos atendida
            cajaMenosAtendida.clientesAtendidos++;
            int tiempoAtencionTotal = cajaMenosAtendida.tiempoAtencion * cliente.productos
                    + cliente.tiempoAdicionalPago;

            // Simulamos el tiempo de atención
            try {
                Thread.sleep(tiempoAtencionTotal * 1000); // Convertimos a milisegundos
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // Reporte
        System.out.println("Reporte:");
        for (Caja caja : cajas) {
            System.out.println("Caja " + caja.id + ": " + caja.clientesAtendidos + " clientes");
        }
        // Calcula otros datos como tiempo sin atender, tiempo promedio, etc.

        System.out.println("Simulación finalizada.");
    }
}
