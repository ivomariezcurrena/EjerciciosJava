package resolucion.parcial2022;

public class Actividad {
    private int codigo;
    private String actividad;
    private double costo;

    public Actividad(int codigo, String actividad, double costo) {
        this.codigo = codigo;
        this.actividad = actividad;
        this.costo = costo;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getActividad() {
        return actividad;
    }

    public void setActividad(String actividad) {
        this.actividad = actividad;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

}
