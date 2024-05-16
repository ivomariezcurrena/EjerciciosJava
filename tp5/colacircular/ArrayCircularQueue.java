package colacircular;

import java.util.NoSuchElementException;

public class ArrayCircularQueue<E> implements CircularQueue<E> {
    private E[] elements;
    private int size;
    private int front;
    private int rear;

    @SuppressWarnings("unchecked")
    public ArrayCircularQueue(int capacity) {
        elements = (E[]) new Object[capacity];
        size = 0;
        front = 0;
        rear = -1;
    }

    @Override
    public void enqueue(E element) {
        if (isFull()) {
            throw new IllegalStateException("Queue is full");
        }
        rear = (rear + 1) % elements.length;
        elements[rear] = element;
        size++;
    }

    @Override
    public E dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }
        E removedElement = elements[front];
        elements[front] = null;
        front = (front + 1) % elements.length;
        size--;
        return removedElement;
    }

    @Override
    public E first() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }
        return elements[front];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean isFull() {
        return size == elements.length;
    }
}