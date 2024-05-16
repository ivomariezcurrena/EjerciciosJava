package pila.clone;

import java.util.EmptyStackException;

import pila.Stack;

import java.util.Arrays;

@SuppressWarnings("unused")
public class ArrayStack<E> implements Stack<E>, Cloneable {
    private static final int DEFAULT_CAPACITY = 10;
    private E[] array;
    private int size;

    public ArrayStack() {
        this(DEFAULT_CAPACITY);
    }

    @SuppressWarnings("unchecked")
    public ArrayStack(int initialCapacity) {
        array = (E[]) new Object[initialCapacity];
        size = 0;
    }

    @Override
    public void push(E element) {
        if (size == array.length) {
            resize(2 * array.length);
        }
        array[size++] = element;
    }

    @Override
    public E pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        E element = array[--size];
        array[size] = null;
        if (size > 0 && size == array.length / 4) {
            resize(array.length / 2);
        }
        return element;
    }

    @Override
    public E peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return array[size - 1];
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public ArrayStack<E> clone() {
        try {
            // Clonar el objeto utilizando el método clone() de la superclase
            @SuppressWarnings("unchecked")
            ArrayStack<E> clonedStack = (ArrayStack<E>) super.clone();
            // Clonar el array utilizando el método clone() de la clase Arrays
            clonedStack.array = array.clone();
            return clonedStack;
        } catch (CloneNotSupportedException e) {
            // Nunca debería ocurrir, ya que ArrayStack<E> implementa Cloneable
            throw new InternalError(e);
        }
    }

    private void resize(int capacity) {
        @SuppressWarnings("unchecked")
        E[] newArray = (E[]) new Object[capacity];
        for (int i = 0; i < size; i++) {
            newArray[i] = array[i];
        }
        array = newArray;
    }
}
