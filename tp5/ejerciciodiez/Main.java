package ejerciciodiez;

public class Main {
    public static void main(String[] args) {
        // Crear una DoublyLinkedDeque
        Deque<Integer> deque = new DoublyLinkedDeque<>();

        // Agregar elementos al principio y al final de la deque
        deque.addFirst(1);
        deque.addLast(2);
        deque.addFirst(3);
        deque.addLast(4);

        // Imprimir los elementos de la deque
        System.out.println("Elemento al principio: " + deque.first());
        System.out.println("Elemento al final: " + deque.last());

        // Eliminar elementos al principio y al final de la deque
        System.out.println("Eliminando elemento al principio: " + deque.removeFirst());
        System.out.println("Eliminando elemento al final: " + deque.removeLast());

        // Imprimir el tamaño de la deque
        System.out.println("Tamaño de la cola: " + deque.size());

        // Verificar si la deque está vacía
        System.out.println("La deque está vacía: " + deque.isEmpty());
    }
}
