package ejercicio_3;

public class Prueba {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        // Michael T. Goodrich, Roberto Tamassia, Michael H. Goldwasser
        // P�gina 318
        // ((((3+1)*3)/((9-5)+2))-((3*(7-4))+6)) = -13

        LinkedBinaryTree<String> tree = new LinkedBinaryTree<String>();

        Position<String> p, q, r, s, t, u, v, w;

        p = tree.addRoot("8)");

        q = tree.addLeft(p, "2)");

        r = tree.addLeft(q, "1))");

        s = tree.addLeft(r, "2)");

        tree.addLeft(s, "(((5");
        tree.addRight(s, "+");

        t = tree.addRight(r, "-");
        tree.addLeft(t, "*");
        tree.addRight(t, "(2");

        u = tree.addRight(q, "-");
        v = tree.addLeft(u, "+");
        tree.addLeft(v, "/");
        tree.addRight(v, "((2");

        w = tree.addRight(u, "((7");
        tree.addLeft(w, "9)");
        tree.addRight(w, "+");

        q = tree.addRight(p, "*");
        tree.addLeft(q, "-");
        tree.addRight(q, "1))");

        /* IDR */
        System.out.print("Postorder: ");
        for (Position<String> pos : tree.postorder())
            System.out.print(pos.getElement() + " ");

        System.out.println();

        System.out.print("Nivel: ");
        for (Position<String> pos : tree.breadthfirst())
            System.out.print(pos.getElement() + " ");

        System.out.println();
    }
}
