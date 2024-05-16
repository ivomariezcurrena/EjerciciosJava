package resolucion.parcial2017;

public class Coche extends Vehiculo {
    private double valorKm;

    public Coche(String patente, String marca, int modelo, double valorKm) {
        super(patente, marca, modelo);
        this.valorKm = valorKm;
    }

    public double getValorKm() {
        return valorKm;
    }

    public void setValorKm(double valorKm) {
        this.valorKm = valorKm;
    }

    @Override
    public double calcularAlquiler(int dias, int kms) {
        return valorKm * kms;
    }

}
