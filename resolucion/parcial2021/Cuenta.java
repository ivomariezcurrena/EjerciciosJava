package resolucion.parcial2021;

public abstract class Cuenta {
    private int nroCuenta;
    private double saldo;

    public Cuenta(int nroCuenta, double saldo) {
        super();
        this.nroCuenta = nroCuenta;
        this.saldo = saldo;
    }

    public int getNroCuenta() {
        return nroCuenta;
    }

    public void setNroCuenta(int nroCuenta) {
        this.nroCuenta = nroCuenta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public abstract void extraer(double importe);

    public void depositar(double importe) {
        saldo += nroCuenta;
    }
}
