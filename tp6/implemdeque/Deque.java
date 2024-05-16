package implemdeque;

import java.util.ArrayList;

class Deque<T> {
    private ArrayList<T> deque = new ArrayList<>();

    // Método para agregar un elemento al frente de la cola
    public void addFront(T data) {
        deque.add(0, data);
    }

    // Método para agregar un elemento al final de la cola
    public void addRear(T data) {
        deque.add(data);
    }

    // Método para eliminar y devolver el elemento del frente de la cola
    public T removeFront() {
        if (!isEmpty()) {
            return deque.remove(0);
        } else {
            System.out.println("La cola está vacía");
            return null;
        }
    }

    // Método para eliminar y devolver el elemento del final de la cola
    public T removeRear() {
        if (!isEmpty()) {
            return deque.remove(deque.size() - 1);
        } else {
            System.out.println("La cola está vacía");
            return null;
        }
    }

    // Método para verificar si la cola está vacía
    public boolean isEmpty() {
        return deque.isEmpty();
    }

    // Método para obtener el tamaño de la cola
    public int size() {
        return deque.size();
    }
}
