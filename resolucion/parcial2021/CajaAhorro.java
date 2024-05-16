package resolucion.parcial2021;

public class CajaAhorro extends Cuenta {

    public CajaAhorro(int nroCuenta, double saldo) {
        super(nroCuenta, saldo);
    }

    public void extraer(double importe) {
        if (getSaldo() < importe)
            throw new RuntimeException("Saldo Insuficiente");

        setSaldo(getSaldo() - importe);

    }
}
