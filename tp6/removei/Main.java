package removei;

public class Main {

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();

        // Agregando elementos a la lista
        list.add(5);
        list.add(10);
        list.add(15);
        list.add(20);

        // Imprimiendo la lista antes de eliminar un elemento
        System.out.println("Lista antes de eliminar un elemento:");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

        // Eliminando un elemento
        list.remove(1); // Eliminando el elemento en el índice 1 (10)

        // Imprimiendo la lista después de eliminar un elemento
        System.out.println("\nLista después de eliminar un elemento:");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}
