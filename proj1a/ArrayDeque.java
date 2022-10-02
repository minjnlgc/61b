public class ArrayDeque<T> {
    private static final int initialSize = 8;
    private T[] items;
    private int size;
    private int nextFirst;
    private int nextLast;

    public ArrayDeque(){
        items = (T[]) new Object[initialSize];
        size = 0;
        nextFirst = 4;
        nextLast = 5;
    }

    private void resize(){
        T[] a = (T[]) new Object[items.length * 2];
        int index = 0;
        for(int i = 0; i < nextLast; i++){
            a[index] = items[i];
            index ++;
        }
        int newNextFirst = a.length - items.length + nextFirst;
        for(int i = newNextFirst+1; i < items.length; i++){
            a[i] = items[nextFirst+1];
            nextFirst+=1;
        }
        nextFirst = newNextFirst;
        items = a;
    }

    /** Adds an item of type T to the front ot the deque. */
    public void addFirst(T item){
        if(size == items.length){
            resize();
        }
        items[nextFirst] = item;
        size ++;
        nextFirst-=1;
    }

    /** Adds an item of type T to the back of the deque. */
    public void addLast(T item){
        if(size == items.length){
            resize();
        }
        items[nextLast] = item;
        size ++;
        if(nextLast == items.length-1){
            nextLast = 0;
        }
        nextLast++;
    }

    /** Returns true if deque is empty, false otherwise. */
    public boolean isEmpty(){
        return size == 0;
    }

    /** Returns the number of items in the deque. */
    public int size(){
        return size;
    }

    /** Prints the items in the deque from first to last, separated by a space. */
    public void printDeque(){
        String result = "";
        int count = 0;
        for(int i = nextFirst+1; i < items.length; i++){
            result += items[i].toString() + " ";
            count++;
        }
        if(count < size){
            for(int i = 0; i < nextLast; i++){
                result += items[i].toString() + " ";
            }
        }
        System.out.println(result);
    }

    /** Removes and returns the item at the front of the deque.
     * if no such item exits, return null. */
    public T removeFirst(){
        if(size == 0){
            return null;
        }
        nextFirst += 1;
        size --;
        return items[nextFirst];
    }

    /** Removes and returns the item at the back of the deque.
     * if no such item exits, return null. */
    public T removeLast(){
        if(size == 0){
            return null;
        }
        nextLast -= 1;
        size --;
        return items[nextLast];
    }

    /** Gets the item at the given index, where 0 is the front, 1 is the next item,
     * and so forth. If no such item exists, returns null.
     * Must not alter the deque! */
    public T get(int index){
        return null;
    }
}