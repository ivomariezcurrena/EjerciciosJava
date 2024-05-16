package resolucion.parcial2017;

public class Moto extends Vehiculo {
    private double valorDia;

    public Moto(String patente, String marca, int modelo, double valorDia) {
        super(patente, marca, modelo);
        this.valorDia = valorDia;
    }

    public double getValorDias() {
        return valorDia;
    }

    public void setValorDias(double valorDias) {
        this.valorDia = valorDias;
    }

    @Override
    public double calcularAlquiler(int dias, int kms) {
        double costoMoto = valorDia * dias;
        return costoMoto;
    }
}
