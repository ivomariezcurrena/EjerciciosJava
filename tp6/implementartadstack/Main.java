package implementartadstack;

public class Main {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();

        // Agregar elementos a la pila
        stack.push(1);
        stack.push(2);
        stack.push(3);

        // Mostrar el tamaño de la pila
        System.out.println("Tamaño de la pila: " + stack.size());

        // Mostrar el elemento en el tope de la pila
        System.out.println("Elemento en el tope de la pila: " + stack.peek());

        // Eliminar y devolver el elemento en el tope de la pila
        System.out.println("Elemento eliminado: " + stack.pop());

        // Mostrar el tamaño de la pila después de eliminar un elemento
        System.out.println("Tamaño de la pila después de eliminar un elemento: " + stack.size());
    }
}