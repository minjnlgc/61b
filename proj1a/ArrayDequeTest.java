public class ArrayDequeTest {
    public static void main(String[] args) {
        ArrayDeque<Integer> a = new ArrayDeque<Integer>();
        a.addLast(0);
        a.addFirst(1);
        a.get(1);
        a.addLast(3);
        a.get(2);
        a.addFirst(5);
        a.addLast(6);
        a.removeLast();
        a.addLast(8);
        a.addLast(9);
        a.get(4);
        a.removeLast();
        a.removeFirst();
        System.out.println(a.removeLast());
        a.printDeque();
        System.out.println(a.get(2));
    }
}
