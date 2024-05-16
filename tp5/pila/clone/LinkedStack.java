package pila.clone;

import pila.Stack;
import java.util.EmptyStackException;

public class LinkedStack<E> implements Stack<E>, Cloneable {
    // Clase interna que representa un nodo en la lista enlazada
    private static class Node<E> implements Cloneable {
        E data;
        Node<E> next;

        // Constructor para inicializar un nodo con un dato específico
        public Node(E data) {
            this.data = data;
        }

        // Método clone para clonar el nodo
        @SuppressWarnings("unchecked")
        @Override
        public Node<E> clone() {
            try {
                // Clonar el nodo utilizando el método clone() de la superclase
                return (Node<E>) super.clone();
            } catch (CloneNotSupportedException e) {
                // Nunca debería ocurrir, ya que Node<E> implementa Cloneable
                throw new InternalError(e);
            }
        }
    }

    private Node<E> top; // Referencia al nodo superior de la pila
    private int size; // Tamaño actual de la pila

    // Agrega un elemento a la pila
    @Override
    public void push(E element) {
        Node<E> newNode = new Node<>(element);
        newNode.next = top;
        top = newNode;
        size++;
    }

    // Quita y devuelve el elemento superior de la pila
    @Override
    public E pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        E element = top.data;
        top = top.next;
        size--;
        return element;
    }

    // Devuelve el elemento superior de la pila sin quitarlo
    @Override
    public E peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return top.data;
    }

    // Verifica si la pila está vacía
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    // Devuelve el tamaño actual de la pila
    @Override
    public int size() {
        return size;
    }

    // Método clone para clonar la pila
    @Override
    public LinkedStack<E> clone() {
        try {
            // Clonar el objeto utilizando el método clone() de la superclase
            @SuppressWarnings("unchecked")
            LinkedStack<E> clonedStack = (LinkedStack<E>) super.clone();
            // Clonar los nodos de la lista enlazada
            if (top != null) {
                Node<E> clonedTop = top.clone();
                clonedStack.top = clonedTop;
                Node<E> current = top.next;
                Node<E> clonedCurrent = clonedTop;
                while (current != null) {
                    clonedCurrent.next = current.clone();
                    current = current.next;
                    clonedCurrent = clonedCurrent.next;
                }
            }
            return clonedStack;
        } catch (CloneNotSupportedException e) {
            // Nunca debería ocurrir, ya que LinkedStack<E> implementa Cloneable
            throw new InternalError(e);
        }
    }
}
