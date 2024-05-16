package ejercicio_10;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class LinkedPositionalListTest {
    @Test
    public void testIndexOf() {
        LinkedPositionalList<String> list = new LinkedPositionalList<>();

        list.addFirst("A");
        list.addLast("B");
        list.addLast("C");

        Position<String> positionA = list.first();
        Position<String> positionB = list.after(positionA);
        Position<String> positionC = list.last();

        assertEquals(0, list.indexOf(positionA));
        assertEquals(1, list.indexOf(positionB));
        assertEquals(2, list.indexOf(positionC));
    }
}
