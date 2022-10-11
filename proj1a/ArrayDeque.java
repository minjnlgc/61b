public class ArrayDeque<T> {
    private static final int INITIAL_SIZE = 8;
    private T[] items;
    private int size;
    private int nextFirst;
    private int nextLast;
    public ArrayDeque() {
        items = (T[]) new Object[INITIAL_SIZE];
        size = 0;
        nextFirst = 4;
        nextLast = 5;
    }

    private double getUsageRatio(int s, int itemLength) {
        return (double) s / (double) itemLength;
    }

    private void resize() {
        boolean resizeOrNot = false;
        T[] a = (T[]) new Object[items.length * 2];

        if (getUsageRatio(size, items.length) >= 0.75) {
            resizeOrNot = true;
        } else if (getUsageRatio(size, items.length) < 0.25 && items.length >= 8) {
            resizeOrNot = true;
            a = (T[]) new Object[items.length / 2];
        }

        if (resizeOrNot) {
            int index = 0;
            for (int i = 0; i < nextLast; i++) {
                a[index] = items[i];
                index++;
            }
            int newNextFirst = a.length - items.length + nextFirst;
            int j = nextFirst + 1;
            int i = newNextFirst + 1;
            while (i < a.length && j < items.length) {
                a[i] = items[j];
                i++;
                j++;
            }
            nextFirst = newNextFirst;
            items = a;
        }
    }


    /** Adds an item of type T to the front ot the deque. */
    public void addFirst(T item) {
       /* if (size == items.length) {
            resize();
        }*/
        items[nextFirst] = item;
        size++;
        nextFirst -= 1;
        if (nextFirst == -1) {
            nextFirst = items.length - 1;
        }
        resize();
    }

    /** Adds an item of type T to the back of the deque. */
    public void addLast(T item) {
        /*if (size == items.length) {
            resize();
        }*/
        if (nextLast == items.length) {
            nextLast = 0;
        }
        items[nextLast] = item;
        size++;
        nextLast++;
        resize();
    }

    /** Returns true if deque is empty, false otherwise. */
    public boolean isEmpty() {
        return size == 0;
    }

    /** Returns the number of items in the deque. */
    public int size() {
        return size;
    }

    /** Prints the items in the deque from first to last, separated by a space. */
    public void printDeque() {
        String result = "";
        int count = 0;
        for (int i = nextFirst + 1; i < items.length; i++) {
            result += items[i].toString() + " ";
            count++;
        }
        if (count < size) {
            for (int i = 0; i < nextLast; i++) {
                result += items[i].toString() + " ";
            }
        }
        System.out.println(result);
    }

    /** Removes and returns the item at the front of the deque.
     * if no such item exits, return null. */
    public T removeFirst() {
        if (size == 0) {
            return null;
        }
        nextFirst += 1;
        size--;
        resize();
        return items[nextFirst];
    }

    /** Removes and returns the item at the back of the deque.
     * if no such item exits, return null. */
    public T removeLast() {
        if (size == 0) {
            return null;
        }
        nextLast -= 1;
        if (nextLast < 0) {
            nextLast = items.length - 1;
        }
        size--;
        resize();
        return items[nextLast];
    }

    /** Gets the item at the given index, where 0 is the front, 1 is the next item,
     * and so forth. If no such item exists, returns null.
     * Must not alter the deque! */
    public T get(int index) {

        if (index >= size) {
            return null;
        }
        int mod = (nextFirst + 1 + index) % items.length;
        return items[mod];
    }

}
