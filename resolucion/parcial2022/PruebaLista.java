package resolucion.parcial2022;

public class PruebaLista {
    public static void main(String[] args) {
        SinglyLinkedList<Character> list = new SinglyLinkedList<>();
        list.addFirst('D');
        list.addFirst('C');
        list.addFirst('B');
        list.addFirst('A');
        System.out.println("Original list: " + listToString(list));
        System.out.println("Alternate(true): " + listToString(list.alternate(true)));
        System.out.println("Alternate(false): " + listToString(list.alternate(false)));
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
