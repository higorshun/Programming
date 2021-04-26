public class StackOfInts {

    /**
     * An object of type Node holds one of the items in the linked list
     * that represents the stack.
     */
    private static class Node {
        int item;
        Node next;
    }

    private Node top;  // Pointer to the Node that is at the top of
    //   of the stack.  If top == null, then the
    //   stack is empty.

    /**
     * Add N to the top of the stack.
     */
    public void push(int N) {
        Node newTop;         // A Node to hold the new item.
        newTop = new Node();
        newTop.item = N;     // Store N in the new Node.
        newTop.next = top;   // The new Node points to the old top.
        top = newTop;        // The new item is now on top.
    }

    /**
     * Remove the top item from the stack, and return it.
     * Throws an IllegalStateException if the stack is empty when
     * this method is called.
     */
    public int pop() {
        if (top == null)
            throw new IllegalStateException("Can't pop from an empty stack.");
        int topItem = top.item;  // The item that is being popped.
        top = top.next;          // The previous second item is now on top.”
        return topItem;
    }

    /**
     * Returns true if the stack is empty.  Returns false
     * if there are one or more items on the stack.
     */

//    // (alternate version, using an array)
//
//
//    public boolean isEmpty() {
//        return (top == null);
//    }
//
//
//
//    private int[] items = new int[10];  // Holds the items on the stack.
//
//    private int top = 0;  // The number of items currently on the stack.
//
//    /**
//     * Add N to the top of the stack.
//     */
//    public void push( int N ) {
//        if (top == items.length) {
//            // The array is full, so make a new, larger array and
//            // copy the current stack items into it.
//            items = Arrays.copyOf( items, 2*items.length );
//        }
//        items[top] = N;  // Put N in next available spot.
//        top++;           // Number of items goes up by one.
//    }
//
//    /**
//     * Remove the top item from the stack, and return it.
//     * Throws an IllegalStateException if the stack is empty when
//     * this method is called.
//     */
//    public int pop() {
//        if ( top == 0 )
//            throw new IllegalStateException("Can't pop from an empty stack.");
//        int topItem = items[top - 1];  // Top item in the stack.
//        top--;    // Number of items on the stack goes down by one.
//        return topItem;
//    }
//
//    /**
//     * Returns true if the stack is empty.  Returns false
//     * if there are one or more items on the stack.
//     */
//    public boolean isEmpty() {
//        return (top == 0);
//    }


} // end class StackOfInts
