package resolucion.parcial2017;

public abstract class Vehiculo {
    // atributos
    private String patente;
    private String marca;
    private int modelo;

    // constructor
    public Vehiculo(String patente, String marca, int modelo) {
        this.patente = patente;
        this.marca = marca;
        this.modelo = modelo;
    }

    // getters and setters
    public String getPatente() {
        return patente;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getModelo() {
        return modelo;
    }

    public void setModelo(int modelo) {
        this.modelo = modelo;
    }
    // Fin getters and setters

    public abstract double calcularAlquiler(int dias, int kms);
}
