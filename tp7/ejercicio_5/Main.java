package ejercicio_5;

import ejercicio_10.PositionalList;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        LinkedBinaryTree<Integer> tree = new LinkedBinaryTree<>();
        Position<Integer> p, q, r, w;
        p = tree.addRoot(1);
        q = tree.addLeft(p, 2);
        r = tree.addRight(p, 3);
        tree.addLeft(q, 4);
        tree.addRight(q, 5);
        w = tree.addLeft(r, 4);
        tree.addRight(r, 7);
        tree.addLeft(w, 4);

        System.out.println("Arbol preorder: ");
        for (Position<Integer> pos : tree.preorder())
            System.out.print(pos.getElement() + " ");
        System.out.println();

        System.out.println("Posicion de 2: ");
        Position<Integer> serch = tree.search(2);
        System.out.println(serch.getElement());
        System.out.println();

        System.out.println("Veces que esta el 4: ");
        List<Position<Integer>> sall = tree.searchAll(4);
        System.out.print(sall.size());

    }
}
