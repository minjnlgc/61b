
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
        this.size = 0;
    }

    public LinkedListDeque(T x){
        sentinel = new Node(null, x, null);
        sentinel.next = new Node(null, null, null);
        sentinel.prev = sentinel.next;
        this.size = 1;
    }

    /** Add method:
     * Must not involve any looping or recursion,
     * The operation time should take 'constant time'*/

    /** Adds an item of type T to the front of the deque. */
    public void addFirst(T item){
    }

    /** Adds an item of type T to the back of the deque. */
    public void addLast(T item){

    }

    /** Returns true is deque is empty, false otherwise. */
    public boolean isEmpty(){
        return true;
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

    /** Gets the items at the given index, where 0 is the front,
     * 1 is the next item, and so forth.
     * If no such item, return null.
     * Must not alter the deque!.
     */
    public T get(int index){
        return null;
    }
}
