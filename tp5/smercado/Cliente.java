package smercado;

import java.util.Random;

public class Cliente {
    int productos;
    int tiempoAdicionalPago;

    public Cliente(int productos) {
        this.productos = productos;
        this.tiempoAdicionalPago = new Random().nextInt(5) + 1; // Tiempo adicional de pago (1 a 5 minutos)
    }
}