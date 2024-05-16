/*
 * Copyright 2014, Michael T. Goodrich, Roberto Tamassia, Michael H. Goldwasser
 *
 * Developed for use with the book:
 *
 *    Data Structures and Algorithms in Java, Sixth Edition
 *    Michael T. Goodrich, Roberto Tamassia, and Michael H. Goldwasser
 *    John Wiley & Sons, 2014
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package net.datastructures;

/**
 * A basic singly linked list implementation.
 *
 * @author Michael T. Goodrich
 * @author Roberto Tamassia
 * @author Michael H. Goldwasser
 */
public class SinglyLinkedList<E> implements Cloneable {
  // ---------------- nested Node class ----------------
  /**
   * Node of a singly linked list, which stores a reference to its
   * element and to the subsequent node in the list (or null if this
   * is the last node).
   */
  private static class Node<E> {

    /** The element stored at this node */
    private E element; // reference to the element stored at this node

    /** A reference to the subsequent node in the list */
    private Node<E> next; // reference to the subsequent node in the list

    /**
     * Creates a node with the given element and next node.
     *
     * @param e the element to be stored
     * @param n reference to a node that should follow the new node
     */
    public Node(E e, Node<E> n) {
      element = e;
      next = n;
    }

    // Accessor methods
    /**
     * Returns the element stored at the node.
     * 
     * @return the element stored at the node
     */
    public E getElement() {
      return element;
    }

    /**
     * Returns the node that follows this one (or null if no such node).
     * 
     * @return the following node
     */
    public Node<E> getNext() {
      return next;
    }

    // Modifier methods
    /**
     * Sets the node's next reference to point to Node n.
     * 
     * @param n the node that should follow this one
     */
    public void setNext(Node<E> n) {
      next = n;
    }
  } // ----------- end of nested Node class -----------

  // instance variables of the SinglyLinkedList
  /** The head node of the list */
  private Node<E> head = null; // head node of the list (or null if empty)

  /** The last node of the list */
  private Node<E> tail = null; // last node of the list (or null if empty)

  /** Number of nodes in the list */
  private int size = 0; // number of nodes in the list

  /** Constructs an initially empty list. */
  public SinglyLinkedList() {
  } // constructs an initially empty list

  // access methods
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
   * Returns (but does not remove) the first element of the list
   * 
   * @return element at the front of the list (or null if empty)
   */
  public E first() { // returns (but does not remove) the first element
    if (isEmpty())
      return null;
    return head.getElement();
  }

  /**
   * Returns (but does not remove) the last element of the list.
   * 
   * @return element at the end of the list (or null if empty)
   */
  public E last() { // returns (but does not remove) the last element
    if (isEmpty())
      return null;
    return tail.getElement();
  }

  // update methods
  /**
   * Adds an element to the front of the list.
   * 
   * @param e the new element to add
   */
  public void addFirst(E e) { // adds element e to the front of the list
    head = new Node<>(e, head); // create and link a new node
    if (size == 0)
      tail = head; // special case: new node becomes tail also
    size++;
  }

  /**
   * Adds an element to the end of the list.
   * 
   * @param e the new element to add
   */
  public void addLast(E e) { // adds element e to the end of the list
    Node<E> newest = new Node<>(e, null); // node will eventually be the tail
    if (isEmpty())
      head = newest; // special case: previously empty list
    else
      tail.setNext(newest); // new node after existing tail
    tail = newest; // new node becomes the tail
    size++;
  }

  /**
   * Removes and returns the first element of the list.
   * 
   * @return the removed element (or null if empty)
   */
  public E removeFirst() { // removes and returns the first element
    if (isEmpty())
      return null; // nothing to remove
    E answer = head.getElement();
    head = head.getNext(); // will become null if list had only one node
    size--;
    if (size == 0)
      tail = null; // special case as list is now empty
    return answer;
  }

  @SuppressWarnings("rawtypes")
  public boolean equals(Object o) {
    if (o == null)
      return false;
    if (getClass() != o.getClass())
      return false;
    SinglyLinkedList other = (SinglyLinkedList) o; // use nonparameterized type
    if (size != other.size)
      return false;
    Node walkA = head; // traverse the primary list
    Node walkB = other.head; // traverse the secondary list
    while (walkA != null) {
      if (!walkA.getElement().equals(walkB.getElement()))
        return false; // mismatch
      walkA = walkA.getNext();
      walkB = walkB.getNext();
    }
    return true; // if we reach this, everything matched successfully
  }

  @SuppressWarnings({ "unchecked" })
  public SinglyLinkedList<E> clone() throws CloneNotSupportedException {
    // always use inherited Object.clone() to create the initial copy
    SinglyLinkedList<E> other = (SinglyLinkedList<E>) super.clone(); // safe cast
    if (size > 0) { // we need independent chain of nodes
      other.head = new Node<>(head.getElement(), null);
      Node<E> walk = head.getNext(); // walk through remainder of original list
      Node<E> otherTail = other.head; // remember most recently created node
      while (walk != null) { // make a new node storing same element
        Node<E> newest = new Node<>(walk.getElement(), null);
        otherTail.setNext(newest); // link previous node to this one
        otherTail = newest;
        walk = walk.getNext();
      }
    }
    return other;
  }

  @SuppressWarnings("rawtypes")
  public int hashCode() {
    int h = 0;
    for (Node walk = head; walk != null; walk = walk.getNext()) {
      h ^= walk.getElement().hashCode(); // bitwise exclusive-or with element's code
      h = (h << 5) | (h >>> 27); // 5-bit cyclic shift of composite code
    }
    return h;
  }

  /* Inserta el elemento e en la posicion n de la lista */
  public void addPos(E e, int n) throws IndexOutOfBoundsException {
    if (n < 0 || n > size) {
      throw new IndexOutOfBoundsException("Posición fuera de rango");
    }
    if (n == 0) {
      addFirst(e); // Si la posición es 0, agregar al inicio de la lista
    } else if (n == size) {
      addLast(e); // Si la posición es el tamaño actual, agregar al final de la lista
    } else {
      Node<E> current = head;
      for (int i = 0; i < n - 1; i++) {
        current = current.getNext(); // Avanzar hasta el nodo anterior a la posición deseada
      }
      Node<E> newNode = new Node<>(e, current.getNext()); // Crear un nuevo nodo
      current.setNext(newNode); // Establecer el enlace del nodo anterior al nuevo nodo
      size++; // Incrementar el tamaño de la lista
    }
  }

  /* Elimina el elemento e de la lista */
  /* Retorna NULL si no lo encuentra */
  public E removeElement(E e) {
    if (isEmpty()) {
      return null; // La lista está vacía
    }
    if (head.getElement().equals(e)) {
      return removeFirst(); // Si el elemento está en la primera posición, removerlo del inicio
    }
    Node<E> current = head;
    while (current.getNext() != null && !current.getNext().getElement().equals(e)) {
      current = current.getNext(); // Avanzar hasta el nodo anterior al nodo que contiene el elemento
    }
    if (current.getNext() == null) {
      return null; // El elemento no se encontró en la lista
    }
    Node<E> removedNode = current.getNext(); // Nodo que contiene el elemento a eliminar
    current.setNext(removedNode.getNext()); // Establecer el enlace del nodo anterior al nodo siguiente
    if (removedNode == tail) {
      tail = current; // Si el nodo eliminado era el último, actualizar la cola
    }
    size--; // Decrementar el tamaño de la lista
    return removedNode.getElement();
  }

  /* Elimina el elemento que se encuentra en la posición n de la lista */
  /* Retorna NULL si no es una posición válida */
  public E removePos(int n) throws IndexOutOfBoundsException {
    if (n < 0 || n >= size) {
      throw new IndexOutOfBoundsException("Posición fuera de rango");
    }
    if (n == 0) {
      return removeFirst(); // Si la posición es 0, remover el primer elemento
    } else if (n == size - 1) {
      return removeLast(); // Si la posición es la última, remover el último elemento
    } else {
      Node<E> current = head;
      for (int i = 0; i < n - 1; i++) {
        current = current.getNext(); // Avanzar hasta el nodo anterior al nodo que se eliminará
      }
      Node<E> removedNode = current.getNext(); // Nodo que se eliminará
      current.setNext(removedNode.getNext()); // Establecer el enlace del nodo anterior al nodo siguiente
      size--; // Decrementar el tamaño de la lista
      return removedNode.getElement();
    }
  }

  /* Inserta todos los elementos de la Lista l al final de la lista */
  public void concatenate(SinglyLinkedList l) {

  }

  /* Busca el elemento e dentro de la lista */
  /* Retorna el elemnto si lo encuentra o Null si no esta en la lista */
  public E search(E e) {

  }

  /**
   * Produces a string representation of the contents of the list.
   * This exists for debugging purposes only.
   */
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
}
