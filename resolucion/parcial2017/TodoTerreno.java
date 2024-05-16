package resolucion.parcial2017;

public class TodoTerreno extends Vehiculo {
    private double valorDia, valorKm;

    public TodoTerreno(String patente, String marca, int modelo, double valorDia, double valorKm) {
        super(patente, marca, modelo);
        this.valorDia = valorDia;
        this.valorKm = valorKm;
    }

    public double getValorDia() {
        return valorDia;
    }

    public void setValorDia(double valorDia) {
        this.valorDia = valorDia;
    }

    public double getValorKm() {
        return valorKm;
    }

    public void setValorKm(double valorKm) {
        this.valorKm = valorKm;
    }

    @Override
    public double calcularAlquiler(int dias, int kms) {
        return (valorDia * dias) + (valorKm * kms);
    }
}
