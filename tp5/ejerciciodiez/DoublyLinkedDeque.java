package ejerciciodiez;

import java.util.NoSuchElementException;

public class DoublyLinkedDeque<E> implements Deque<E> {
    private DoublyLinkedList<E> list;

    public DoublyLinkedDeque() {
        list = new DoublyLinkedList<>();
    }

    @Override
    public void addFirst(E element) {
        list.addFirst(element);
    }

    @Override
    public void addLast(E element) {
        list.addLast(element);
    }

    @Override
    public E removeFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException("Deque is empty");
        }
        return list.removeFirst();
    }

    @Override
    public E removeLast() {
        if (isEmpty()) {
            throw new NoSuchElementException("Deque is empty");
        }
        return list.removeLast();
    }

    @Override
    public E first() {
        if (isEmpty()) {
            throw new NoSuchElementException("Deque is empty");
        }
        return list.first();
    }

    @Override
    public E last() {
        if (isEmpty()) {
            throw new NoSuchElementException("Deque is empty");
        }
        return list.last();
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

}
