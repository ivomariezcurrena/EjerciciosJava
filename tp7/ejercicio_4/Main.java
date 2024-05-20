package ejercicio_4;

public class Main {
    public static void main(String[] args) {
        LinkedBinaryTree<String> tree = new LinkedBinaryTree<String>();
        LinkedBinaryTree<String> cloneTree = new LinkedBinaryTree<String>();
        Position<String> p, q, r, s, t;
        p = tree.addRoot("1");
        q = tree.addLeft(p, "2");
        r = tree.addRight(p, "3");
        tree.addRight(q, "4");
        tree.addLeft(q, "5");

        System.out.println("Arbol preorder: ");
        for (Position<String> pos : tree.preorder())
            System.out.print(pos.getElement() + " ");
        System.out.println();

        cloneTree = tree.clone();
        System.out.println("Arbol copiado preorder: ");
        for (Position<String> pos : cloneTree.preorder())
            System.out.print(pos.getElement() + " ");

        System.out.println();

        if (tree.equals(cloneTree)) {
            System.out.print("son iguales");
        }
    }
}
