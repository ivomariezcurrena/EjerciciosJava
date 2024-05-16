package pila;

// Clase para representar un empleado
class Empleado {
    String nombre;
    double salarioBase;
    double horasExtras;
    double sueldoTotal;

    // Constructor para inicializar un empleado con su nombre, salario base y horas
    // extras trabajadas
    public Empleado(String nombre, double salarioBase, double horasExtras) {
        this.nombre = nombre;
        this.salarioBase = salarioBase;
        this.horasExtras = horasExtras;
        calcularSueldoTotal(); // Calcular el sueldo total al crear el empleado
    }

    // Método para calcular el sueldo total del empleado
    private void calcularSueldoTotal() {
        // Calcular el sueldo total sumando el salario base y el pago por horas extras
        sueldoTotal = salarioBase + (horasExtras * 20); // Suponiendo que cada hora extra se paga $20
    }

    // Método para obtener el nombre del empleado
    public String getNombre() {
        return nombre;
    }

    // Método para obtener el sueldo total del empleado
    public double getSueldoTotal() {
        return sueldoTotal;
    }
}