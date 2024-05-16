package resolucion.parcial2017;

public class Main {
    public static void main(String[] args) {
        // Crear clientes
        Cliente cliente1 = new Cliente("ivo Mariezcurrena", "44146783");
        Cliente cliente2 = new Cliente("Joaco Mesa", "3456789");
        Cliente cliente3 = new Cliente("Batman", "1234567");

        // Crear vehículos
        Moto moto = new Moto("ABC123", "Honda", 2020, 20.0);
        Coche coche = new Coche("XYZ987", "Toyota", 2019, 0.15);
        TodoTerreno todoterreno = new TodoTerreno("DEF456", "Jeep", 2018, 50.0, 0.3);

        // Realizar alquileres
        // Alquiler alquiler1 = new Alquiler(3, 100); // 3 días, 100 kms
        // Alquiler alquiler2 = new Alquiler(2, 200); // 2 días, 200 kms
        // Alquiler alquiler3 = new Alquiler(2, 200); // 2 días, 200 kms
        // // Calcular costo de alquiler
        // double costoAlquiler1 = moto.calcularAlquiler(alquiler1.getCantDias(),
        // alquiler1.getCantKms());
        // double costoAlquiler2 = coche.calcularAlquiler(alquiler2.getCantDias(),
        // alquiler2.getCantKms());
        // double costoAlquiler3 = todoterreno.calcularAlquiler(alquiler3.getCantDias(),
        // alquiler3.getCantKms());

        // Mostrar resultados
        // System.out.println("Costo de alquiler para " + cliente1.getNombre() + ": " +
        // costoAlquiler1 + " euros");
        // System.out.println("Costo de alquiler para " + cliente2.getNombre() + ": " +
        // costoAlquiler2 + " euros");
        // System.out.println("Costo de alquiler para " + cliente3.getNombre() + ": " +
        // costoAlquiler3 + " euros");

    }
}