public class ArrayDequeTest {
    public static void main(String[] args) {
        ArrayDeque<Integer> a = new ArrayDeque<Integer>();
        a.addLast(0);
        a.addLast(1);
        a.addLast(2);
        a.addLast(3);
        a.addLast(4);
        a.addLast(5);
        a.addLast(6);
        a.addLast(7);
        a.addFirst(-1);
        // a.isEmpty();
        // System.out.println(a.removeFirst());
        // System.out.println(a.removeLast());
        a.printDeque();
        System.out.println(a.get(2));

    }
}
