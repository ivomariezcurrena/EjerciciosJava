package ejercicio_5;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.Iterator;
import java.util.List;

public class AbstractTreeTest {
    LinkedBinaryTree<Integer> tree = new LinkedBinaryTree<>();
    Position<Integer> p, q, r, w;

    @Before
    public void setUp() {

        p = tree.addRoot(1);
        q = tree.addLeft(p, 2);
        r = tree.addRight(p, 3);
        tree.addLeft(q, 4);
        tree.addRight(q, 5);
        w = tree.addLeft(r, 4);
        tree.addRight(r, 7);
        tree.addLeft(w, 4);
    }

    @Test
    public void testAncestor() {
        Iterable<Position<Integer>> ancestors = tree.ancestor(w);
        Iterator<Position<Integer>> it = ancestors.iterator();
        assertEquals(Integer.valueOf(3), it.next().getElement());
        assertEquals(Integer.valueOf(1), it.next().getElement());
        assertFalse(it.hasNext());
    }

    @Test
    public void testDuplicate() {

    }

    @Test
    public void testListChildren() {

    }

    @Test
    public void testListDepth() {

    }

    @Test
    public void testListGreaterAncestor() {

    }

    @Test
    public void testSearch() {
        Position<Integer> pos = tree.search(4);
        assertNotNull(pos);
        assertEquals(Integer.valueOf(4), pos.getElement());

        pos = tree.search(10);
        assertNull(pos);
    }

    @Test
    public void testSearchAll() {
        List<Position<Integer>> positions = tree.searchAll(4);
        assertEquals(3, positions.size());
    }

    @Test
    public void testAncestor2() {

    }

    @Test
    public void testDuplicate2() {

    }

    @Test
    public void testListChildren2() {

    }

    @Test
    public void testListDepth2() {

    }

    @Test
    public void testListGreaterAncestor2() {

    }

    @Test
    public void testSearch2() {

    }

    @Test
    public void testSearchAll2() {

    }
}
