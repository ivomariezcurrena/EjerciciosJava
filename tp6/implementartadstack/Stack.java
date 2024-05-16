package implementartadstack;

import java.util.ArrayList;

class Stack<T> {
    private ArrayList<T> stack = new ArrayList<>();

    // Método para agregar un elemento al tope de la pila
    public void push(T data) {
        stack.add(data);
    }

    // Método para eliminar y devolver el elemento en el tope de la pila
    public T pop() {
        if (!isEmpty()) {
            return stack.remove(stack.size() - 1);
        } else {
            System.out.println("La pila está vacía");
            return null;
        }
    }

    // Método para devolver el elemento en el tope de la pila sin eliminarlo
    public T peek() {
        if (!isEmpty()) {
            return stack.get(stack.size() - 1);
        } else {
            System.out.println("La pila está vacía");
            return null;
        }
    }

    // Método para verificar si la pila está vacía
    public boolean isEmpty() {
        return stack.isEmpty();
    }

    // Método para obtener el tamaño de la pila
    public int size() {
        return stack.size();
    }
}
