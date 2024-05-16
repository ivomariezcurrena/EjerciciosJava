package resolucion.parcial2023;

public class TestDuplicate {

    public static void main(String[] args) {
        // Crear una lista enlazada
        SinglyLinkedList<String> list = new SinglyLinkedList<>();

        // Agregar elementos a la lista original
        list.addLast("A");
        list.addLast("B");
        list.addLast("C");
        list.addLast("D");
        list.addLast("E");

        // Duplicar la lista original y mostrarla
        SinglyLinkedList<String> duplicatedList = list.duplicate();
        System.out.println("Lista duplicada: " + duplicatedList);

        // Crear una lista para insertar
        SinglyLinkedList<String> insertList = new SinglyLinkedList<>();
        insertList.addLast("X");
        insertList.addLast("Y");

        // Insertar la lista de inserción en la lista original en la posición 2
        list.addList(insertList, 1);
        System.out.println("Lista después de insertar: " + list);
    }
}
