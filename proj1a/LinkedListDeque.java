/** Using Circular Sentinel. */

public class LinkedListDeque<T> {
    public class Node{

        public T item;
        public Node prev;
        public Node next;

        public Node(Node p, T i, Node n){
            prev = p;
            item = i;
            next = n;
        }
    }
    private Node sentinel;
    private int size;

    public LinkedListDeque(){
        sentinel = new Node(null, null, null);
        sentinel.next = sentinel.prev;
        this.size = 0;
    }

    public LinkedListDeque(T x){
        sentinel = new Node(null, null, null);
        sentinel.next = new Node(null, x, null);
        sentinel.next.next = sentinel.next;
        sentinel.prev = sentinel.next;
        this.size = 1;
    }

    /** Add & Remove method:
     * Must not involve any looping or recursion,
     * The operation time should take 'constant time'*/

    /** Adds an item of type T to the front of the deque. */
    public void addFirst(T item){
        sentinel.next = new Node(sentinel, item, sentinel.next);
        size ++;
    }

    /** Adds an item of type T to the back of the deque. */
    public void addLast(T item){
        sentinel.prev = new Node(sentinel.prev, item, sentinel);
        size ++;
    }

    /** Returns true is deque is empty, false otherwise. */
    public boolean isEmpty(){
        return this.equals(sentinel);
    }

    /** Return the number of items in the deque. */
    public int size(){
        return size;
    }

    /** Prints the items in the deque from the first to last
     * Separated by a space.
     */
    public void printDeque(){

    }

    /** Removes and return the items at the front of the deque.
     * If no such item, return null.
     */
    public T removeFirst(){
        return null;
    }

    /** Removes and returns the items at the back of the deque.
     * If no such item, return null.
     */
    public T removeLast(){
        return null;
    }

    /** Gets the items at the given index, where 0 is the front.
     * If no such item, return null.
     * Must not alter the deque!.
     * Use iteration, not recursion.
     */
    public T get(int index){
        if (index > size-1){
            return null;
        }
        return null;
    }

}
