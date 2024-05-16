package resolucion.parcial2023;

public class SinglyLinkedList<E> implements Cloneable {
    // Clase anidada que representa un nodo en la lista enlazada
    private static class Node<E> {
        // Elemento almacenado en el nodo
        private E element;
        // Referencia al siguiente nodo en la lista
        private Node<E> next;

        // Constructor para crear un nodo con el elemento dado y el siguiente nodo
        public Node(E e, Node<E> n) {
            element = e;
            next = n;
        }

        // Método para obtener el elemento almacenado en el nodo
        public E getElement() {
            return element;
        }

        // Método para obtener el siguiente nodo en la lista
        public Node<E> getNext() {
            return next;
        }

        // Método para establecer la referencia al siguiente nodo
        public void setNext(Node<E> n) {
            next = n;
        }
    } // Fin de la clase anidada Node

    // Variables de instancia de la lista enlazada
    private Node<E> head = null; // Nodo cabeza de la lista (o null si está vacía)
    private Node<E> tail = null; // Último nodo de la lista (o null si está vacía)
    private int size = 0; // Número de nodos en la lista

    // Constructor para crear una lista enlazada vacía
    public SinglyLinkedList() {
    } // Constructor

    // Método para obtener el número de elementos en la lista
    public int size() {
        return size;
    }

    // Método para verificar si la lista está vacía
    public boolean isEmpty() {
        return size == 0;
    }

    // Método para obtener el primer elemento de la lista (sin removerlo)
    public E first() {
        if (isEmpty())
            return null;
        return head.getElement();
    }

    // Método para obtener el último elemento de la lista (sin removerlo)
    public E last() {
        if (isEmpty())
            return null;
        return tail.getElement();
    }

    // Método para agregar un elemento al inicio de la lista
    public void addFirst(E e) {
        head = new Node<>(e, head); // Crea y enlaza un nuevo nodo
        if (size == 0)
            tail = head; // Caso especial: el nuevo nodo se convierte en la cola también
        size++;
    }

    // Método para agregar un elemento al final de la lista
    public void addLast(E e) {
        Node<E> newest = new Node<>(e, null); // El nodo será la cola eventualmente
        if (isEmpty())
            head = newest; // Caso especial: lista previamente vacía
        else
            tail.setNext(newest); // Nuevo nodo después de la cola existente
        tail = newest; // El nuevo nodo se convierte en la cola
        size++;
    }

    // Método para remover y retornar el primer elemento de la lista
    public E removeFirst() {
        if (isEmpty())
            return null;
        E answer = head.getElement();
        head = head.getNext(); // Se volverá nulo si la lista tenía solo un nodo
        size--;
        if (size == 0)
            tail = null; // Caso especial ya que la lista está vacía
        return answer;
    }

    // Método para comparar si dos listas enlazadas son iguales
    public boolean equals(Object o) {
        if (o == null)
            return false;
        if (getClass() != o.getClass())
            return false;
        @SuppressWarnings("rawtypes")
        SinglyLinkedList other = (SinglyLinkedList) o;
        if (size != other.size)
            return false;
        @SuppressWarnings("rawtypes")
        Node walkA = head;
        @SuppressWarnings("rawtypes")
        Node walkB = other.head;
        while (walkA != null) {
            if (!walkA.getElement().equals(walkB.getElement()))
                return false;
            walkA = walkA.getNext();
            walkB = walkB.getNext();
        }
        return true;
    }

    // Método para clonar la lista enlazada
    @SuppressWarnings({ "unchecked" })
    public SinglyLinkedList<E> clone() throws CloneNotSupportedException {
        SinglyLinkedList<E> other = (SinglyLinkedList<E>) super.clone();
        if (size > 0) {
            other.head = new Node<>(head.getElement(), null);
            Node<E> walk = head.getNext();
            other.tail = other.head;
            while (walk != null) {
                Node<E> newest = new Node<>(walk.getElement(), null);
                other.tail.setNext(newest);
                other.tail = newest;
                walk = walk.getNext();
            }
        }
        return other;
    }

    // Método para calcular el código hash de la lista
    public int hashCode() {
        int h = 0;
        for (@SuppressWarnings("rawtypes")
        Node walk = head; walk != null; walk = walk.getNext()) {
            h ^= walk.getElement().hashCode();
            h = (h << 5) | (h >>> 27);
        }
        return h;
    }

    // Método para obtener una representación en cadena de la lista
    public String toString() {
        StringBuilder sb = new StringBuilder("(");
        Node<E> walk = head;
        while (walk != null) {
            sb.append(walk.getElement());
            if (walk != tail)
                sb.append(", ");
            walk = walk.getNext();
        }
        sb.append(")");
        return sb.toString();
    }

    // Método para buscar todas las ocurrencias de un elemento en la lista
    // Retorna la cantidad de veces encontrado
    public int numSearch(E e) {
        Node<E> aux = head;
        int cant = 0;
        while (aux != null) {
            if (aux.getElement().equals(e))
                cant++;
            aux = aux.getNext();
        }
        return cant;
    }

    public SinglyLinkedList<E> duplicate() {
        SinglyLinkedList<E> newList = new SinglyLinkedList<>();
        Node<E> current = head;
        while (current != null) {
            newList.addLast(current.getElement());
            current = current.getNext();
        }
        return newList;
    }

    public void addList(SinglyLinkedList<E> l, int pos) throws IndexOutOfBoundsException {
        if (pos < 0 || pos > size) {
            throw new IndexOutOfBoundsException("Posición fuera de rango");
        }
        Node<E> current = head;
        for (int i = 0; i < pos - 1; i++) {
            current = current.getNext();
        }
        Node<E> nextNode = current.getNext();
        Node<E> newListHead = l.head;
        Node<E> newListTail = l.tail;
        current.setNext(newListHead);
        newListTail.setNext(nextNode);
        size += l.size();
    }

    // Método para eliminar todos los elementos iguales a uno dado de la lista
    // Retorna el número de elementos eliminados
    public int removeAllElement(E e) {
        int n = 0;
        if (isEmpty())
            return n;
        Node<E> aux = head.getNext(), ant = head;
        while (aux != null) {
            if (aux.getElement().equals(e)) {
                ant.setNext(aux.getNext());
                size--;
                if (tail == aux)
                    tail = ant;
                n++;
            } else
                ant = aux;
            aux = aux.getNext();
        }
        if (head.getElement().equals(e)) {
            removeFirst();
            n++;
        }
        return n;
    }
}
