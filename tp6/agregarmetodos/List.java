package agregarmetodos;

public interface List<E> {
    // Otros métodos de la interfaz List
    int size();

    boolean isEmpty();

    boolean add(E e);

    void add(int index, E element);

    E get(int index);

    E set(int index, E element);

    E remove(int index);

    /* Remueve todos los elementos de la lista */
    void clear();

    /* Retorna true si la lista contiene el elemento especificado */
    boolean contains(E e);

    /*
     * Retorna el índice de la primer ocurrencia del elemento especificado en la
     * lista, o -1 si la lista no contiene el elemento
     */
    int indexOf(E e);

    /*
     * Retorna el índice de la última ocurrencia del elemento especificado en la
     * lista, o -1 si la lista no contiene el elemento
     */
    int lastIndexOf(E e);

    /*
     * Remueve la primer ocurrencia del elemento especificado desde la lista, si
     * está presente.
     */
    boolean remove(E e);

}
