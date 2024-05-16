package smercado;

public class Caja implements Comparable<Caja> {
    int id;
    int tiempoAtencion;
    int clientesAtendidos;

    public Caja(int id, int tiempoAtencion) {
        this.id = id;
        this.tiempoAtencion = tiempoAtencion;
        this.clientesAtendidos = 0;
    }

    @Override
    public int compareTo(Caja otraCaja) {
        return Integer.compare(this.clientesAtendidos, otraCaja.clientesAtendidos);
    }
}