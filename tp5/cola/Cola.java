package cola;

public class Cola<E> {
    private static class Nodo<E> {
        E dato;
        Nodo<E> siguiente;

        public Nodo(E dato) {
            this.dato = dato;
            this.siguiente = null;
        }
    }

    private Nodo<E> primero;
    private Nodo<E> ultimo;
    private int tamaño;

    // Constructor para inicializar la cola vacía
    public Cola() {
        this.primero = null;
        this.ultimo = null;
        this.tamaño = 0;
    }

    // Método para agregar un elemento a la cola
    public void agregar(E elemento) {
        Nodo<E> nuevoNodo = new Nodo<>(elemento);
        if (estaVacia()) {
            primero = nuevoNodo;
        } else {
            ultimo.siguiente = nuevoNodo;
        }
        ultimo = nuevoNodo;
        tamaño++;
    }

    // Método para eliminar y devolver el primer elemento de la cola
    public E eliminar() {
        if (estaVacia()) {
            throw new IllegalStateException("La cola está vacía");
        }
        E elementoEliminado = primero.dato;
        primero = primero.siguiente;
        if (primero == null) {
            ultimo = null;
        }
        tamaño--;
        return elementoEliminado;
    }

    // Método para ver el primer elemento de la cola sin eliminarlo
    public E verPrimero() {
        if (estaVacia()) {
            throw new IllegalStateException("La cola está vacía");
        }
        return primero.dato;
    }

    // Método para obtener el tamaño de la cola
    public int tamaño() {
        return tamaño;
    }

    // Método para verificar si la cola está vacía
    public boolean estaVacia() {
        return tamaño == 0;
    }
}
