package ejercicio_4;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class LinkedBinaryTreeTest {
    LinkedBinaryTree<String> tree = new LinkedBinaryTree<String>();
    LinkedBinaryTree<String> cloneTree = new LinkedBinaryTree<String>();
    Position<String> p, q, r, s, t;

    @Before
    public void setUp() throws Exception {
        p = tree.addRoot("1");
        q = tree.addLeft(p, "2");
        r = tree.addRight(p, "3");
        tree.addRight(q, "4");
        tree.addLeft(q, "5");

    }

    @Test
    public void testClone() {
        cloneTree = tree.clone();
        assertEquals(tree, cloneTree);
    }

    @Test
    public void testEquals() {
        cloneTree = tree.clone();
        assertTrue(tree.equals(cloneTree));
    }
}
