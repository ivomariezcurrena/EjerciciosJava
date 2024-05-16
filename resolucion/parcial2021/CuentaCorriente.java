package resolucion.parcial2021;

public class CuentaCorriente extends Cuenta {
    private static double DESCUBIERTO = 5000;

    public CuentaCorriente(int nroCuenta, double saldo) {
        super(nroCuenta, saldo);
    }

    public static double getDESCUBIERTO() {
        return DESCUBIERTO;
    }

    public void extraer(double importe) {
        if (getSaldo() + DESCUBIERTO < importe)
            throw new RuntimeException("Saldo Insuficiente");

        setSaldo(getSaldo() - importe);
    }

}
