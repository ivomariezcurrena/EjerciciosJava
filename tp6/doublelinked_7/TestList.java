package doublelinked_7;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class TestList {

    private List<String> list = new LinkedList<String>();

    @Before
    public void setUp() throws Exception {
        list.addLast("Juan");
        list.addLast("Ana");
        list.addLast("Pedro");
        list.addLast(null);
        list.addLast("Mar�a");
        list.addLast("Pedro");

    }

    @Test
    public void testClear() {
        list.clear();
        assertEquals(list.size(), 0);
    }

    @Test
    public void testContains() {
        // Crea un nuevo objeto, para verificar si se usa equals en lugar de ==
        assertTrue(list.contains(new String("Pedro")));
        assertFalse(list.contains(new String("Mario")));
        assertTrue(list.contains(null));
    }

    @Test
    public void testIndexOf() {
        assertEquals(list.indexOf(new String("Pedro")), 2);
        assertEquals(list.indexOf(new String("Mario")), -1);
        assertEquals(list.indexOf(null), 3);
    }

    @Test
    public void testLastIndexOf() {
        assertEquals(list.lastIndexOf(new String("Pedro")), 5);
        assertEquals(list.lastIndexOf(new String("Mario")), -1);
        assertEquals(list.lastIndexOf(null), 3);
    }

    @Test
    public void testRemove() {
        list.remove(new String("Pedro"));
        list.remove(null);
        assertEquals(list.indexOf(new String("Pedro")), 3);
        assertEquals(list.indexOf(null), -1);
    }

}
