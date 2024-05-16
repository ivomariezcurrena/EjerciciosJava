package implemdeque;

public class Main {
    public static void main(String[] args) {
        Deque<Integer> deque = new Deque<>();

        // Agregar elementos al frente de la cola
        deque.addFront(1);
        deque.addFront(2);

        // Agregar elementos al final de la cola
        deque.addRear(3);
        deque.addRear(4);

        // Mostrar el tamaño de la cola
        System.out.println("Tamaño de la cola: " + deque.size());

        // Eliminar y devolver el elemento del frente de la cola
        System.out.println("Elemento eliminado del frente: " + deque.removeFront());

        // Eliminar y devolver el elemento del final de la cola
        System.out.println("Elemento eliminado del final: " + deque.removeRear());

        // Mostrar el tamaño de la cola después de eliminar dos elementos
        System.out.println("Tamaño de la cola después de eliminar dos elementos: " + deque.size());
    }
}
