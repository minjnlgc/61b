import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByN {

    static CharacterComparator ob2 = new OffByN(2);
    static CharacterComparator ob5 = new OffByN(5);
    @Test
    public void testEqualChar() {
        assertFalse(ob2.equalChars('a', 'a'));
        assertFalse(ob2.equalChars('a', 'b'));
        assertTrue(ob2.equalChars('a', 'c'));

        assertTrue(ob5.equalChars('a', 'f'));
        assertTrue(ob5.equalChars('f', 'a'));
        assertFalse(ob5.equalChars('f', 'h'));
    }
}
