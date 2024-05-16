package resolucion.parcial2021;

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

    public boolean contains(E element) {
        ListNode<E> current = head;
        while (current != null) {
            if (current.element.equals(element)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public SinglyLinkedList<E> noDuplicate() {
        SinglyLinkedList<E> result = new SinglyLinkedList<>();
        ListNode<E> current = head;
        while (current != null) {
            if (!result.contains(current.element)) {
                result.addFirst(current.element);
            }
            current = current.next;
        }
        return result.reverse();
    }

    public SinglyLinkedList<E> reverse() {
        SinglyLinkedList<E> reversed = new SinglyLinkedList<>();
        ListNode<E> current = head;
        while (current != null) {
            reversed.addFirst(current.element);
            current = current.next;
        }
        return reversed;
    }

    public static void main(String[] args) {
        SinglyLinkedList<String> list1 = new SinglyLinkedList<>();
        list1.addFirst("Juan");
        list1.addFirst("Pedro");
        list1.addFirst("Juan");
        list1.addFirst("Ana");
        list1.addFirst("Juan");
        list1.addFirst("Pedro");
        System.out.println("Original list: " + listToString(list1));
        System.out.println("No duplicates: " + listToString(list1.noDuplicate()));

        SinglyLinkedList<String> list2 = new SinglyLinkedList<>();
        list2.addFirst("Alice");
        list2.addFirst("Bob");
        list2.addFirst("Charlie");
        System.out.println("Original list: " + listToString(list2));
        System.out.println("No duplicates: " + listToString(list2.noDuplicate()));

        SinglyLinkedList<String> list3 = new SinglyLinkedList<>();
        list3.addFirst("David");
        list3.addFirst("David");
        list3.addFirst("David");
        System.out.println("Original list: " + listToString(list3));
        System.out.println("No duplicates: " + listToString(list3.noDuplicate()));

        SinglyLinkedList<String> list4 = new SinglyLinkedList<>();
        System.out.println("Original list: " + listToString(list4));
        System.out.println("No duplicates: " + listToString(list4.noDuplicate()));
    }

    private static <E> String listToString(SinglyLinkedList<E> list) {
        StringBuilder sb = new StringBuilder();
        ListNode<E> current = list.head;
        while (current != null) {
            sb.append(current.element).append(" ");
            current = current.next;
        }
        return sb.toString();
    }
}