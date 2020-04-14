import java.util.Stack;

class ImplementQueueUsingStacks {

    private Stack<Integer> st1;
    private Stack<Integer> st2;
    private Integer top = null;
    /** Initialize your data structure here. */
    public ImplementQueueUsingStacks() {
        st1 = new Stack<>();
        st2 = new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        if (top == null) top = x;
        while (!st2.isEmpty()) {
            st1.push(st2.pop());
        }
        st1.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        while (!st1.isEmpty()) {
            st2.push(st1.pop());
        }
        int tmp = st2.pop();
        top = null;
        if (!st2.isEmpty()) top = st2.peek();
        return tmp;
    }

    /** Get the front element. */
    public int peek() {
        return top;
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return st1.isEmpty() && st2.isEmpty();
    }
}