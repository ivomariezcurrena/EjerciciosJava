import java.util.*;

public class Main {

    public static void main(String[] args) {
        // Crear una lista de empleados
        List<Empleado> nomina = new ArrayList<>();

        // Agregar empleados a la lista
        nomina.add(new Empleado("Juan", 1));
        nomina.add(new Empleado("Ana", 2));
        nomina.add(new Empleado("Carlos", 3));

        // Mostrar la lista de empleados
        System.out.println("Lista de empleados:");
        for (Empleado empleado : nomina) {
            System.out.println(empleado);
        }

        // Obtener el tamaño de la lista
        System.out.println("Número de empleados: " + nomina.size());

        // Verificar si la lista está vacía
        System.out.println("¿La lista está vacía? " + nomina.isEmpty());

        // Obtener un empleado específico
        Empleado empleado = nomina.get(0);
        System.out.println("Primer empleado: " + empleado);

        // Eliminar un empleado
        nomina.remove(0);
        System.out.println("Lista de empleados después de eliminar el primero:");
        for (Empleado e : nomina) {
            System.out.println(e);
        }
    }
}
