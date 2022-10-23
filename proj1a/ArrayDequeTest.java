import static org.junit.Assert.*;
import org.junit.Test;

public class ArrayDequeTest {

    @Test
    public static boolean checkEmpty(boolean expected, boolean actual) {
        if (expected != actual) {
            System.out.print("isEmpty() returned " + actual);
            System.out.println(" , but expected: " + expected);
            return false;
        }
        return true;
    }

    @Test
    public static void testGet() {
        ArrayDeque A = new ArrayDeque();
        A.addLast(3);
        A.addFirst(2);
        A.addLast(4);
        A.addFirst(1);

        assertEquals(A.get(0), 1);
        assertEquals(A.get(1), 2);
        assertEquals(A.get(2), 3);
        assertEquals(A.get(3), 4);
        assertNull(A.get(100));
    }
}
