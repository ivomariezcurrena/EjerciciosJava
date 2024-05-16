package ejerciciodiez;

import java.util.NoSuchElementException;

public interface Deque<E> {
    void addFirst(E element);

    void addLast(E element);

    E removeFirst() throws NoSuchElementException;

    E removeLast() throws NoSuchElementException;

    E first() throws NoSuchElementException;

    E last() throws NoSuchElementException;

    int size();

    boolean isEmpty();
}
