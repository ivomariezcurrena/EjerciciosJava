package resolucion.parcial2017.listasimplemente;

public class Main {
    public static void main(String[] args) {
        // Crear una lista enlazada
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();

        // Agregar elementos a la lista
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(1);
        list.addLast(4);
        list.addLast(1);

        // Mostrar la lista
        System.out.println("Lista original: " + list);

        // Buscar todas las ocurrencias del elemento 1
        int count = list.numSearch(1);
        System.out.println("Número de ocurrencias del elemento 1: " + count);

        // Eliminar todos los elementos iguales a 1
        int removed = list.removeAllElement(1);
        System.out.println("Elementos eliminados: " + removed);

        // Mostrar la lista después de eliminar los elementos
        System.out.println("Lista después de eliminar elementos: " + list);
    }
}
