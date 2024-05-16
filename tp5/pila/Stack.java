package pila;

public interface Stack<E> {
    void push(E element); // Agrega un elemento a la pila

    E pop(); // Quita y devuelve el elemento superior de la pila

    E peek(); // Devuelve el elemento superior de la pila sin quitarlo

    boolean isEmpty(); // Verifica si la pila está vacía

    int size(); // Devuelve el tamaño de la pila
}