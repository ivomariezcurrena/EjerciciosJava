package pila.clone;

public class Main {
    public static void main(String[] args) {
        // Crear una pila
        ArrayStack<String> array = new ArrayStack<>();

        // Agregar elementos a la pila
        array.push("Elemento 1");
        array.push("Elemento 2");
        array.push("Elemento 3");

        // Clonar la pila
        ArrayStack<String> clonedStack = array.clone();

        // Mostrar la pila original
        System.out.println("Pila original:");
        while (!array.isEmpty()) {
            System.out.println(array.pop());
        }

        // Mostrar la pila clonada
        System.out.println("\nPila clonada:");
        while (!clonedStack.isEmpty()) {
            System.out.println(clonedStack.pop());
        }

        // Lista simplemente enlazada
        LinkedStack<String> enlazada = new LinkedStack<>();

        enlazada.push("1");
        enlazada.push("2");
        enlazada.push("3");
        System.out.println("\nLinkedStack:");
        LinkedStack<String> clonEnlazaada = enlazada.clone();
        System.out.println("Pila original:");
        while (!enlazada.isEmpty()) {
            System.out.println(enlazada.pop());
        }

        System.out.println("\nPila clonada:");
        while (!clonEnlazaada.isEmpty()) {
            System.out.println(clonEnlazaada.pop());
        }
    }
}
