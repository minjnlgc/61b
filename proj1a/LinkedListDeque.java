/** Using Circular Sentinel. */

public class LinkedListDeque<T> {
    private class Node {

        public T item;
        public Node prev;
        public Node next;

        public Node(Node p, T i, Node n) {
            prev = p;
            item = i;
            next = n;
        }
    }
    private Node sentinel;
    private int size;
    public LinkedListDeque() {
        sentinel = new Node(null, null, null);
        sentinel.next = sentinel.prev = sentinel;
        this.size = 0;
    }

    /** Adds an item of type T to the front of the deque. */
    public void addFirst(T item) {
        sentinel.next = new Node(sentinel, item, sentinel.next);
        sentinel.next.next.prev = sentinel.next;
        size++;
    }

    /** Adds an item of type T to the back of the deque. */
    public void addLast(T item) {
        sentinel.prev = new Node(sentinel.prev, item, sentinel);
        sentinel.prev.prev.next = sentinel.prev;
        size++;
    }

    /** Returns true is deque is empty, false otherwise. */
    public boolean isEmpty() {
        return size == 0;
    }

    /** Return the number of items in the deque. */
    public int size() {
        return size;
    }

    /** Prints the items in the deque from the first to last
     * Separated by a space.
     */
    public void printDeque() {
        String result = "";
        Node p = sentinel.next;
        for(int i = 0; i < size; i++){
            result += p.item.toString() + " ";
            p = p.next;
        }
        System.out.println(result);
    }

    /** Removes and return the items at the front of the deque.
     * If no such item, return null.
     */
    public T removeFirst() {
        if (this.isEmpty()) {
            return null;
        }else{
            T p = sentinel.next.item;
            sentinel.next = sentinel.next.next;
            sentinel.next.prev = sentinel;
            size -= 1;
            return p;
        }
    }

    /** Removes and returns the items at the back of the deque.
     * If no such item, return null.
     */
    public T removeLast() {
        if (this.isEmpty()) {
            return null;
        }else{
            T p = sentinel.prev.item;
            sentinel.prev = sentinel.prev.prev;
            sentinel.prev.next = sentinel;
            size -= 1;
            return p;
        }
    }

    /** Gets the items at the given index, where 0 is the front.
     * If no such item, return null.
     * Must not alter the deque!.
     * Use iteration, not recursion.
     */
    public T get(int index) {
        if (index > size-1) {
            return null;
        }else{
            Node p = sentinel;
            for(int i = 0; i <= index; i++) {
                p = p.next;
            }
            return p.item;
        }
    }

    /** Same as get, but uses recursion. */
    public T getRecursive(int index) {
        if(index > size) {
            return null;
        }
        return getRecursiveHelper(sentinel.next, index);
    }

    private T getRecursiveHelper(LinkedListDeque<T>.Node node, int index) {
        if(index == 0) {
            return node.item;
        }
        return getRecursiveHelper(node, index-1);
    }
}
