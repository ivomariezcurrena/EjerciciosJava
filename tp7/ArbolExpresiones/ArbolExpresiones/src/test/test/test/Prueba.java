package test;

import net.datastructures.LinkedBinaryTree;
import net.datastructures.Position;

public class Prueba {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Michael T. Goodrich, Roberto Tamassia, Michael H. Goldwasser
		// Página 318
		// ((((3+1)*3)/((9-5)+2))-((3*(7-4))+6)) = -13

		LinkedBinaryTree<String> tree = new LinkedBinaryTree<String>();
		
		Position<String> p,q,r,s,t,u;

		p=tree.addRoot("-");
		
		q=tree.addLeft(p, "/");
		
		r=tree.addLeft(q, "*");
		
		s=tree.addLeft(r, "+");
		tree.addLeft(s, "3");
		tree.addRight(s, "1");
		
		tree.addRight(r, "3");
		
		t=tree.addRight(q, "+");		
		u=tree.addLeft(t, "-");
		tree.addLeft(u, "9");		
		
		tree.addRight(u, "5");
				
		tree.addRight(t, "2");
		
		q=tree.addRight(p, "+");
		
		r=tree.addLeft(q, "*");
		
		tree.addLeft(r, "3");
		
		s=tree.addRight(r, "-");		
		tree.addLeft(s, "7");
		tree.addRight(s, "4");
		
		tree.addRight(q, "6");
		
		/* RID */
		System.out.print("Preorder: ");
		for (Position<String> pos : tree.postorder())
			System.out.print(pos.getElement()+" ");
		
		System.out.println();
		
		/* IRD */
		System.out.print("Inorder: ");
		for (Position<String> pos : tree.inorder())
			System.out.print(pos.getElement()+" ");
		
		System.out.println();
		
		/* IDR */
		System.out.print("Postorder: ");
		for (Position<String> pos : tree.postorder())
			System.out.print(pos.getElement()+" ");
		
		System.out.println();
		
		System.out.print("Nivel: ");
		for (Position<String> pos : tree.breadthfirst())
			System.out.print(pos.getElement()+" ");
		
		System.out.println();
		
		/*
		System.out.println("Profundidad: "+tree.depth(p));
		System.out.println("Profundidad: "+tree.depth(s));
		
		System.out.println("Altura: "+tree.height(p));
		System.out.println("Altura: "+tree.height(s));
		
		System.out.println("Root: "+tree.root().getElement());
		System.out.println("Izquierda: "+tree.left(p).getElement());
		System.out.println("Derecha: "+tree.right(p).getElement());		
		System.out.println("Hermano: "+tree.sibling(q).getElement());
		
		System.out.println("Externo?: "+tree.isExternal(p));
		System.out.println("Interno?: "+tree.isInternal(p));		
		*/
	}

	/* 
	 Cálculo notación polaca inversa
	 
	 https://es.wikipedia.org/wiki/Notaci%C3%B3n_polaca_inversa
	 
	3 1 +
	4 3 *
	12 9 5 -
	12 4 2 +
	12 6 /
	2 3 7 4 -
	2 3 3 *
	2 9 6 +
	2 15 -
	-13
	 
	 */

	 
}
