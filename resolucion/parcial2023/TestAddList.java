package resolucion.parcial2023;

public class TestAddList {

    public static void main(String[] args) {
        testAddList1();
        testAddList2();
        testAddList3();
        testAddList4();
    }

    public static void testAddList1() {
        SinglyLinkedList<String> l1 = new SinglyLinkedList<String>();
        l1.addLast("A");
        l1.addLast("B");
        l1.addLast("C");
        l1.addLast("D");

        SinglyLinkedList<String> l2 = new SinglyLinkedList<String>();
        l2.addLast("X");
        l2.addLast("Y");

        l1.addList(l2, 2);
        System.out.println(l1 + " Size: " + l1.size());
    }

    public static void testAddList2() {
        SinglyLinkedList<String> l1 = new SinglyLinkedList<String>();
        l1.addLast("A");
        l1.addLast("B");
        l1.addLast("C");
        l1.addLast("D");

        SinglyLinkedList<String> l2 = new SinglyLinkedList<String>();
        l2.addLast("X");
        l2.addLast("Y");

        l1.addList(l2, 0);
        System.out.println(l1 + " Size: " + l1.size());
    }

    public static void testAddList3() {
        SinglyLinkedList<String> l1 = new SinglyLinkedList<String>();
        l1.addLast("A");
        l1.addLast("B");
        l1.addLast("C");
        l1.addLast("D");

        SinglyLinkedList<String> l2 = new SinglyLinkedList<String>();
        l2.addLast("X");
        l2.addLast("Y");

        l1.addList(l2, 4);
        System.out.println(l1 + " Size: " + l1.size());
    }

    public static void testAddList4() {
        SinglyLinkedList<String> l1 = new SinglyLinkedList<String>();
        l1.addLast("A");
        l1.addLast("B");
        l1.addLast("C");
        l1.addLast("D");

        SinglyLinkedList<String> l2 = new SinglyLinkedList<String>();
        l2.addLast("X");
        l1.addList(l2, 4);
        System.out.println(l1 + " Size: " + l1.size());
    }

}
