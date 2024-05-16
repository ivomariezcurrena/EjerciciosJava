package resolucion.parcial2022;

class ListNode<E> {
    E element;
    ListNode<E> next;

    public ListNode(E element, ListNode<E> next) {
        this.element = element;
        this.next = next;
    }
}

public class SinglyLinkedList<E> {
    private ListNode<E> head;
    private int size;

    public SinglyLinkedList() {
        head = null;
        size = 0;
    }

    public void addFirst(E element) {
        head = new ListNode<>(element, head);
        size++;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        ListNode<E> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.element;
    }

    public SinglyLinkedList<E> alternate(boolean odd) {
        SinglyLinkedList<E> result = new SinglyLinkedList<>();
        ListNode<E> current = head;
        int index = 0;
        while (current != null) {
            if ((odd && index % 2 == 0) || (!odd && index % 2 == 1)) {
                result.addFirst(current.element);
            }
            current = current.next;
            index++;
        }
        return result;
    }

    private static <E> String listToString() {
        StringBuilder sb = new StringBuilder();
        ListNode<E> current = list.head;
        while (current != null) {
            sb.append(current.element).append(" ");
            current = current.next;
        }
        return sb.toString();
    }
}
