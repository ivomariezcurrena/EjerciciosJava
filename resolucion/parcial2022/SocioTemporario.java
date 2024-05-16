package resolucion.parcial2022;

public class SocioTemporario extends Socio {

    public SocioTemporario(int nroSocio, String nombre) {
        super(nroSocio, nombre);
    }

    @Override
    public double calcularCuota() {
        return super.calcularActividades() + super.getValorCuota();
    }

}
