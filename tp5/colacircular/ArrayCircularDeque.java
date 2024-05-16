package colacircular;

import java.util.NoSuchElementException;

public class ArrayCircularDeque<E> implements Deque<E> {
    private E[] elements;
    private int size;
    private int front;
    private int rear;

    @SuppressWarnings("unchecked")
    public ArrayCircularDeque(int capacity) {
        elements = (E[]) new Object[capacity];
        size = 0;
        front = 0;
        rear = -1;
    }

    @Override
    public void addFirst(E element) {
        if (isFull()) {
            throw new IllegalStateException("Deque is full");
        }
        if (isEmpty()) {
            rear = 0;
        }
        front = (front - 1 + elements.length) % elements.length;
        elements[front] = element;
        size++;
    }

    @Override
    public void addLast(E element) {
        if (isFull()) {
            throw new IllegalStateException("Deque is full");
        }
        if (isEmpty()) {
            front = 0;
        }
        rear = (rear + 1) % elements.length;
        elements[rear] = element;
        size++;
    }

    @Override
    public E removeFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException("Deque is empty");
        }
        E removedElement = elements[front];
        if (size == 1) {
            front = 0;
            rear = -1;
        } else {
            front = (front + 1) % elements.length;
        }
        size--;
        return removedElement;
    }

    @Override
    public E removeLast() {
        if (isEmpty()) {
            throw new NoSuchElementException("Deque is empty");
        }
        E removedElement = elements[rear];
        if (size == 1) {
            front = 0;
            rear = -1;
        } else {
            rear = (rear - 1 + elements.length) % elements.length;
        }
        size--;
        return removedElement;
    }

    @Override
    public E first() {
        if (isEmpty()) {
            throw new NoSuchElementException("Deque is empty");
        }
        return elements[front];
    }

    @Override
    public E last() {
        if (isEmpty()) {
            throw new NoSuchElementException("Deque is empty");
        }
        return elements[rear];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == elements.length;
    }
}
