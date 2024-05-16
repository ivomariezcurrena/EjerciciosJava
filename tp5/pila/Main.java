package pila;

// Clase principal para probar y medir las implementaciones de pila
// Clase principal para probar y medir las implementaciones de pila
public class Main {
    public static void main(String[] args) {
        int numElements = 1000000; // Número de elementos a agregar a la pila

        // Medir tiempo para ArrayStack
        long startTime = System.nanoTime(); // Tiempo de inicio de la medición
        Stack<Integer> arrayStack = new ArrayStack<>(); // Crear una pila utilizando ArrayStack
        for (int i = 0; i < numElements; i++) {
            arrayStack.push(i); // Agregar elementos a la pila
        }
        while (!arrayStack.isEmpty()) {
            arrayStack.pop(); // Quitar elementos de la pila
        }
        long arrayTime = System.nanoTime() - startTime; // Calcular el tiempo transcurrido

        // Medir tiempo para LinkedStack
        startTime = System.nanoTime(); // Tiempo de inicio de la medición
        Stack<Integer> linkedStack = new LinkedStack<>(); // Crear una pila utilizando LinkedStack
        for (int i = 0; i < numElements; i++) {
            linkedStack.push(i); // Agregar elementos a la pila
        }
        while (!linkedStack.isEmpty()) {
            linkedStack.pop(); // Quitar elementos de la pila
        }
        long linkedTime = System.nanoTime() - startTime; // Calcular el tiempo transcurrido

        // Medir tiempo para DoublyLinkedStack
        startTime = System.nanoTime(); // Tiempo de inicio de la medición
        Stack<Integer> doublyLinkedStack = new DoublyLinkedStack<>(); // Crear una pila utilizando DoublyLinkedStack
        for (int i = 0; i < numElements; i++) {
            doublyLinkedStack.push(i); // Agregar elementos a la pila
        }
        while (!doublyLinkedStack.isEmpty()) {
            doublyLinkedStack.pop(); // Quitar elementos de la pila
        }
        long doublyLinkedTime = System.nanoTime() - startTime; // Calcular el tiempo transcurrido

        // Imprimir resultados de tiempo
        System.out.println("Tiempo para ArrayStack: " + arrayTime + " ns");
        System.out.println("Tiempo para LinkedStack: " + linkedTime + " ns");
        System.out.println("Tiempo para DoublyLinkedStack: " + doublyLinkedTime + " ns");
    }
}
