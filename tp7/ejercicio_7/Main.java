package ejercicio_7;

public class Main {
    public static void main(String[] args) {
        // Crear un árbol binario y agregar nodos
        LinkedBinaryTree<String> tree = new LinkedBinaryTree<>();
        Position<String> root = tree.addRoot("/");
        Position<String> node1 = tree.addLeft(root, "*");
        Position<String> node2 = tree.addRight(root, "+");
        Position<String> node3 = tree.addLeft(node1, "+");
        Position<String> node4 = tree.addRight(node1, "4");
        Position<String> node5 = tree.addLeft(node2, "-");
        Position<String> node6 = tree.addRight(node2, "2");
        Position<String> node7 = tree.addLeft(node3, "3");
        Position<String> node8 = tree.addRight(node3, "1");
        Position<String> node9 = tree.addLeft(node5, "9");
        Position<String> node10 = tree.addRight(node5, "5");

        // Reemplazar todas las ocurrencias de "9" con "7"
        Iterable<Position<String>> replacedPositions = tree.replaceAll("9", "7");
        for (Position<String> pos : replacedPositions) {
            System.out.println("Replaced position: " + pos.getElement());
        }

        // Imprimir el árbol en in-order
        for (Position<String> pos : tree.positions()) {
            System.out.print(pos.getElement() + " ");
        }
    }
}
