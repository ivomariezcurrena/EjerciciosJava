package pila;

import java.util.EmptyStackException;

// Implementación de la pila utilizando una lista doblemente enlazada
public class DoublyLinkedStack<E> implements Stack<E> {
    // Clase interna que representa un nodo en la lista doblemente enlazada
    private static class Node<E> {
        E data;
        @SuppressWarnings("unused")
        Node<E> prev;
        Node<E> next;

        // Constructor para inicializar un nodo con un dato específico
        public Node(E data) {
            this.data = data;
        }
    }

    private Node<E> top; // Referencia al nodo superior de la pila
    private int size; // Tamaño actual de la pila

    // Agrega un elemento a la pila
    @Override
    public void push(E element) {
        Node<E> newNode = new Node<>(element); // Crea un nuevo nodo con el elemento
        if (isEmpty()) {
            top = newNode; // Si la pila está vacía, el nuevo nodo se convierte en el nodo superior
        } else {
            newNode.next = top; // Establece el siguiente del nuevo nodo como el nodo superior actual
            top.prev = newNode; // Establece el nodo superior actual como el nodo siguiente del nuevo nodo
            top = newNode; // Actualiza la referencia al nuevo nodo como el nodo superior
        }
        size++; // Incrementa el tamaño de la pila
    }

    // Quita y devuelve el elemento superior de la pila
    @Override
    public E pop() {
        if (isEmpty()) {
            throw new EmptyStackException(); // Lanza una excepción si la pila está vacía
        }
        E element = top.data; // Obtiene el elemento del nodo superior
        top = top.next; // Actualiza la referencia al nodo superior al siguiente nodo
        if (top != null) {
            top.prev = null; // Si el nuevo nodo superior no es nulo, establece su nodo anterior como nulo
        }
        size--; // Decrementa el tamaño de la pila
        return element; // Devuelve el elemento obtenido
    }

    // Devuelve el elemento superior de la pila sin quitarlo
    @Override
    public E peek() {
        if (isEmpty()) {
            throw new EmptyStackException(); // Lanza una excepción si la pila está vacía
        }
        return top.data; // Devuelve el elemento del nodo superior
    }

    // Verifica si la pila está vacía
    @Override
    public boolean isEmpty() {
        return size == 0; // Devuelve verdadero si el tamaño de la pila es 0, falso en caso contrario
    }

    // Devuelve el tamaño actual de la pila
    @Override
    public int size() {
        return size; // Devuelve el tamaño de la pila
    }
}
