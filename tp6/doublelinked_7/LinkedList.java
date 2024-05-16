package doublelinked_7;

public class LinkedList<E> implements List<E> {
    private static class Node<E> {

        /** The element stored at this node */
        private E element; // reference to the element stored at this node

        /** A reference to the preceding node in the list */
        private Node<E> prev; // reference to the previous node in the list

        /** A reference to the subsequent node in the list */
        private Node<E> next; // reference to the subsequent node in the list

        /**
         * Creates a node with the given element and next node.
         *
         * @param e the element to be stored
         * @param p reference to a node that should precede the new node
         * @param n reference to a node that should follow the new node
         */
        public Node(E e, Node<E> p, Node<E> n) {
            element = e;
            prev = p;
            next = n;
        }

        // public accessor methods
        /**
         * Returns the element stored at the node.
         * 
         * @return the element stored at the node
         */
        public E getElement() {
            return element;
        }

        /**
         * Returns the node that precedes this one (or null if no such node).
         * 
         * @return the preceding node
         */
        public Node<E> getPrev() {
            return prev;
        }

        /**
         * Returns the node that follows this one (or null if no such node).
         * 
         * @return the following node
         */
        public Node<E> getNext() {
            return next;
        }

        // Update methods
        /**
         * Sets the node's previous reference to point to Node n.
         * 
         * @param p the node that should precede this one
         */
        public void setPrev(Node<E> p) {
            prev = p;
        }

        /**
         * Sets the node's next reference to point to Node n.
         * 
         * @param n the node that should follow this one
         */
        public void setNext(Node<E> n) {
            next = n;
        }
    } // ----------- end of nested Node class -----------

    // instance variables of the DoublyLinkedList
    /** Sentinel node at the beginning of the list */
    private Node<E> header; // header sentinel

    /** Sentinel node at the end of the list */
    private Node<E> trailer; // trailer sentinel

    /** Number of elements in the list (not including sentinels) */
    private int size = 0; // number of elements in the list

    /** Constructs a new empty list. */
    public LinkedList() {
        header = new Node<>(null, null, null); // create header
        trailer = new Node<>(null, header, null); // trailer is preceded by header
        header.setNext(trailer); // header is followed by trailer
    }

    // public accessor methods
    /**
     * Returns the number of elements in the linked list.
     * 
     * @return number of elements in the linked list
     */
    public int size() {
        return size;
    }

    /**
     * Tests whether the linked list is empty.
     * 
     * @return true if the linked list is empty, false otherwise
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Returns (but does not remove) the first element of the list.
     * 
     * @return element at the front of the list (or null if empty)
     */
    public E first() {
        if (isEmpty())
            return null;
        return header.getNext().getElement(); // first element is beyond header
    }

    /**
     * Returns (but does not remove) the last element of the list.
     * 
     * @return element at the end of the list (or null if empty)
     */
    public E last() {
        if (isEmpty())
            return null;
        return trailer.getPrev().getElement(); // last element is before trailer
    }

    // public update methods
    /**
     * Adds an element to the front of the list.
     * 
     * @param e the new element to add
     */
    public void addFirst(E e) {
        addBetween(e, header, header.getNext()); // place just after the header
    }

    /**
     * Adds an element to the end of the list.
     * 
     * @param e the new element to add
     */
    public void addLast(E e) {
        addBetween(e, trailer.getPrev(), trailer); // place just before the trailer
    }

    /**
     * Removes and returns the first element of the list.
     * 
     * @return the removed element (or null if empty)
     */
    public E removeFirst() {
        if (isEmpty())
            return null; // nothing to remove
        return remove(header.getNext()); // first element is beyond header
    }

    /**
     * Removes and returns the last element of the list.
     * 
     * @return the removed element (or null if empty)
     */
    public E removeLast() {
        if (isEmpty())
            return null; // nothing to remove
        return remove(trailer.getPrev()); // last element is before trailer
    }

    // private update methods
    /**
     * Adds an element to the linked list in between the given nodes.
     * The given predecessor and successor should be neighboring each
     * other prior to the call.
     *
     * @param predecessor node just before the location where the new element is
     *                    inserted
     * @param successor   node just after the location where the new element is
     *                    inserted
     */
    private void addBetween(E e, Node<E> predecessor, Node<E> successor) {
        // create and link a new node
        Node<E> newest = new Node<>(e, predecessor, successor);
        predecessor.setNext(newest);
        successor.setPrev(newest);
        size++;
    }

    /**
     * Removes the given node from the list and returns its element.
     * 
     * @param node the node to be removed (must not be a sentinel)
     */
    private E remove(Node<E> node) {
        Node<E> predecessor = node.getPrev();
        Node<E> successor = node.getNext();
        predecessor.setNext(successor);
        successor.setPrev(predecessor);
        size--;
        return node.getElement();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("(");
        Node<E> walk = header.getNext();
        while (walk != trailer) {
            sb.append(walk.getElement());
            walk = walk.getNext();
            if (walk != trailer)
                sb.append(", ");
        }
        sb.append(")");
        return sb.toString();
    }

    @Override
    public void clear() {
        header.setNext(trailer);
        trailer.setPrev(header);
        size = 0;
    }

    @Override
    public boolean contains(E e) {
        if (e == null) {
            Node<E> current = header.getNext(); // Empezamos desde el primer elemento después del header

            // Recorremos la lista hasta llegar al trailer
            while (current != trailer) {
                // Verificamos si el elemento actual es null
                if (current != null && current.getElement() == null) {
                    return true; // Si encontramos un elemento null, retornamos true
                }
                current = current.getNext(); // Avanzamos al siguiente elemento
            }
        } else {
            // Si el elemento que se está buscando no es null, buscamos normalmente
            Node<E> current = header.getNext(); // Empezamos desde el primer elemento después del header

            // Recorremos la lista hasta llegar al trailer
            while (current != trailer) {
                // Verificamos si el nodo actual y su elemento no son null
                if (current != null && current.getElement() != null) {
                    // Comparamos el elemento actual con el elemento que buscamos
                    if (current.getElement().equals(e)) {
                        return true; // Si encontramos el elemento, retornamos true
                    }
                }
                current = current.getNext(); // Avanzamos al siguiente elemento
            }
        }

        // Si llegamos al final de la lista sin encontrar el elemento, retornamos false
        return false;
    }

    @Override
    public int indexOf(E e) {
        int index = 0;
        Node<E> current = header.getNext(); // Empezamos desde el primer elemento después del header

        // Recorremos la lista hasta llegar al trailer
        // Recorremos la lista hasta llegar al trailer
        while (current != trailer) {
            // Comparamos el elemento actual con el elemento buscado
            if (e == null) {
                if (current.getElement() == null) {
                    return index; // Si encontramos el elemento, retornamos su índice
                }
            } else {
                if (e.equals(current.getElement())) {
                    return index; // Si encontramos el elemento, retornamos su índice
                }
            }
            current = current.getNext(); // Avanzamos al siguiente elemento
            index++; // Incrementamos el índice
        }
        // Si llegamos al final de la lista sin encontrar el elemento, retornamos -1
        return -1;
    }

    @Override
    public int lastIndexOf(E e) {
        int index = size - 1;
        Node<E> current = trailer.getPrev(); // Empezamos desde el primer elemento después del header

        // recorrer la lista
        while (current != header) {
            // Comparamos el elemento actual con el elemento buscado
            if (e == null) {
                if (current.getElement() == null) {
                    return index; // Si encontramos el elemento, retornamos su índice
                }
            } else {
                if (e.equals(current.getElement())) {
                    return index; // Si encontramos el elemento, retornamos su índice
                }
            }
            current = current.getPrev(); // Avanzamos al siguiente elemento
            index--; // Incrementamos el índice
        }
        // Si llegamos al final de la lista sin encontrar el elemento, retornamos -1
        return -1;
    }

    @Override
    public boolean remove(E e) {
        Node<E> current = header.getNext(); // Empezamos desde el primer elemento después del header

        // Recorremos la lista hasta llegar al trailer
        // Recorremos la lista hasta llegar al trailer
        while (current != trailer) {
            // Comparamos el elemento actual con el elemento buscado
            if (e == null) {
                if (current.getElement() == null) {
                    Node<E> anterior = current.getPrev();
                    Node<E> siguiente = current.getNext();
                    anterior.setNext(siguiente);
                    siguiente.setPrev(anterior);
                    size--; // Decrementamos el tamaño de la lista
                    return true; // Salimos del método después de eliminar el elemento
                }
            } else {
                if (e.equals(current.getElement())) {
                    Node<E> anterior = current.getPrev();
                    Node<E> siguiente = current.getNext();
                    anterior.setNext(siguiente);
                    siguiente.setPrev(anterior);
                    size--; // Decrementamos el tamaño de la lista
                    return true; // Salimos del método después de eliminar el elemento
                }
            }
            current = current.getNext(); // Avanzamos al siguiente elemento
        }
        // Si llegamos al final de la lista sin encontrar el elemento, retornamos -1
        return false;
    }
}
