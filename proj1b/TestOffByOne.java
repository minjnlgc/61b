import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByOne {

    // You must use this CharacterComparator and not instantiate
    // new ones, or the auto-grader might be upset.
    static CharacterComparator offByOne = new OffByOne();

    // Your tests go here.
    @Test
    public void testEqualChars() {
        assertFalse(offByOne.equalChars('a', 'a'));
        assertFalse(offByOne.equalChars('a', '%'));
        assertFalse(offByOne.equalChars('z', 'q'));
        assertTrue(offByOne.equalChars('c', 'd'));
        assertTrue(offByOne.equalChars('d', 'c'));
        assertTrue(offByOne.equalChars('&', '%'));
        assertFalse(offByOne.equalChars('a', 'A'));
    }
}
