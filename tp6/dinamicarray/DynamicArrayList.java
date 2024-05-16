package dinamicarray;

import java.util.Arrays;

public class DynamicArrayList<E> {
    private static final int DEFAULT_CAPACITY = 10;
    private Object[] elements;
    private int size;

    public DynamicArrayList() {
        this.elements = new Object[DEFAULT_CAPACITY];
        this.size = 0;
    }

    // Añade un elemento al final de la lista
    public void add(E element) {
        ensureCapacity();
        elements[size++] = element;
    }

    // Retorna el tamaño actual de la lista
    public int size() {
        return size;
    }

    // Retorna el elemento en la posición especificada
    @SuppressWarnings("unchecked")
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        return (E) elements[index];
    }

    // Reemplaza el array utilizado por uno con la capacidad igual a la cantidad de
    // elementos de la lista
    public void trimToSize() {
        if (size < elements.length) {
            elements = Arrays.copyOf(elements, size);
        }
    }

    // Asegura que la capacidad del array es suficiente para añadir un nuevo
    // elemento
    private void ensureCapacity() {
        if (size == elements.length) {
            int newCapacity = elements.length * 2;
            elements = Arrays.copyOf(elements, newCapacity);
        }
    }
}