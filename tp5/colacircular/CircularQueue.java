package colacircular;

import java.util.NoSuchElementException;

public interface CircularQueue<E> {
    /**
     * Agrega un elemento al final de la cola circular.
     * 
     * @param element el elemento a agregar
     * @throws IllegalStateException si la cola está llena
     */
    void enqueue(E element);

    /**
     * Elimina y devuelve el primer elemento de la cola circular.
     * 
     * @return el primer elemento de la cola circular
     * @throws NoSuchElementException si la cola está vacía
     */
    E dequeue();

    /**
     * Devuelve el primer elemento de la cola circular sin eliminarlo.
     * 
     * @return el primer elemento de la cola circular
     * @throws NoSuchElementException si la cola está vacía
     */
    E first();

    /**
     * Devuelve el número de elementos en la cola circular.
     * 
     * @return el número de elementos en la cola circular
     */
    int size();

    /**
     * Verifica si la cola circular está vacía.
     * 
     * @return true si la cola circular está vacía, false en caso contrario
     */
    boolean isEmpty();

    /**
     * Verifica si la cola circular está llena.
     * 
     * @return true si la cola circular está llena, false en caso contrario
     */
    boolean isFull();
}
