package posicionallist_8;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import org.junit.Before;
import org.junit.Test;

public class LinkedPositionalListTest {
    LinkedPositionalList<Integer> list;

    @Before
    public void setUp() throws Exception {
        list = new LinkedPositionalList<>();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.addLast(5);
    }

    @Test
    public void testAddAfter() {
        list.addFirst(0);
        list.addAfter(list.first(), 1);
        assertEquals(1, (int) list.after(list.first()).getElement());
    }

    @Test
    public void testAddBefore() {
        list.addLast(6);
        list.addBefore(list.last(), 5);
        assertEquals(5, (int) list.before(list.last()).getElement());
    }

    @Test
    public void testAddFirst() {
        list.addFirst(0);
        assertEquals(0, (int) list.first().getElement());
    }

    @Test
    public void testAddLast() {
        list.addLast(6);
        assertEquals(6, (int) list.last().getElement());
    }

    @Test
    public void testAfter() {
        assertEquals(2, (int) list.after(list.first()).getElement());
    }

    @Test
    public void testBefore() {
        assertEquals(1, (int) list.before(list.last()).getElement());
    }

    @Test
    public void testFirst() {
        assertEquals(1, (int) list.first().getElement());
    }

    @Test
    public void testIsEmpty() {
        assertFalse(list.isEmpty());
        LinkedPositionalList<Integer> emptyList = new LinkedPositionalList<>();
        assertTrue(emptyList.isEmpty());
    }

    @Test
    public void testIterator() {
        StringBuilder sb = new StringBuilder();
        for (Integer element : list) {
            sb.append(element).append(" ");
        }
        assertEquals("1 2 3 4 5 ", sb.toString());
    }

    @Test
    public void testLast() {
        assertEquals(5, (int) list.last().getElement());
    }

    @Test
    public void testPositions() {
        StringBuilder sb = new StringBuilder();
        for (Position<Integer> position : list.positions()) {
            sb.append(position.getElement()).append(" ");
        }
        assertEquals("1 2 3 4 5 ", sb.toString());
    }

    @Test
    public void testRemove() {
        list.remove(list.first());
        assertEquals(2, (int) list.first().getElement());
    }

    @Test
    public void testSet() {
        list.set(list.first(), 0);
        assertEquals(0, (int) list.first().getElement());
    }

    @Test
    public void testSize() {
        assertEquals(5, list.size());
    }
}