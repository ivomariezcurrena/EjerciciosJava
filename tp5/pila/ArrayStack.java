package pila;

import java.util.EmptyStackException;

// Implementación de la pila utilizando un array
//Esta línea declara una clase llamada ArrayStack que implementa la interfaz Stack. Es un tipo genérico, lo que significa que puede contener elementos de cualquier tipo (E).
public class ArrayStack<E> implements Stack<E> {
    private static final int DEFAULT_CAPACITY = 10;// define la capacidad predeterminada del array.
    private E[] array;// un array que almacenará los elementos de la pila.
    private int size;// un entero que llevará el registro del número actual de elementos en la pila.

    // Constructor que inicializa la pila con una capacidad predeterminada
    // Este es un constructor que inicializa la pila con una capacidad
    // predeterminada. Llama al constructor con parámetros ArrayStack(int
    // initialCapacity).
    public ArrayStack() {
        this(DEFAULT_CAPACITY);
    }

    // Constructor que inicializa la pila con una capacidad especificada
    @SuppressWarnings("unchecked")
    public ArrayStack(int initialCapacity) {
        array = (E[]) new Object[initialCapacity];
        size = 0;
    }

    // Agrega un elemento a la pila
    // El método push agrega un elemento a la pila. Si el array está lleno (es
    // decir, el tamaño es igual a la longitud del array), se llama al método resize
    // para duplicar la capacidad del array. Luego, el elemento se agrega al array
    // en la posición size y se incrementa size.
    @Override
    public void push(E element) {
        // Duplica la capacidad del array si está lleno
        if (size == array.length) {
            resize(2 * array.length);
        }
        array[size++] = element;
    }

    // Quita y devuelve el elemento superior de la pila
    // El método pop quita y devuelve el elemento superior de la pila. Primero,
    // verifica si la pila está vacía. Luego, obtiene el elemento en la posición
    // size - 1, decrementa size y limpia la referencia al elemento para ayudar en
    // la recolección de basura. Si el tamaño de la pila es un cuarto de la longitud
    // del array, se reduce la capacidad del array a la mitad.
    @Override
    public E pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        E element = array[--size];
        // Limpia la referencia para ayudar a la recolección de basura
        array[size] = null;
        // Reduce la capacidad del array si está muy vacío
        if (size > 0 && size == array.length / 4) {
            resize(array.length / 2);
        }
        return element;
    }

    // Devuelve el elemento superior de la pila sin quitarlo
    // El método peek devuelve el elemento superior de la pila sin quitarlo.
    // Verifica si la pila está vacía y devuelve el elemento en la posición size -
    // 1.
    @Override
    public E peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return array[size - 1];
    }

    // Verifica si la pila está vacía
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    // Devuelve el tamaño de la pila
    @Override
    public int size() {
        return size;
    }

    // Método privado para redimensionar el array
    // El método resize es un método privado utilizado para redimensionar el array
    // cuando se alcanza su capacidad máxima o cuando está demasiado vacío. Crea un
    // nuevo array de objetos con la capacidad especificada, copia los elementos del
    // array original al nuevo array y actualiza la referencia array para apuntar al
    // nuevo array.
    @SuppressWarnings("unchecked")
    private void resize(int capacity) {
        E[] newArray = (E[]) new Object[capacity];
        for (int i = 0; i < size; i++) {
            newArray[i] = array[i];
        }
        array = newArray;
    }
}
