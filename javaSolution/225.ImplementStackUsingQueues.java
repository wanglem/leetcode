import java.util.LinkedList;
import java.util.Queue;

class ImplementStackUsingQueues {

    private Queue<Integer> q1;
    private Integer top = null;
    /** Initialize your data structure here. */
    public ImplementStackUsingQueues() {
        q1 = new LinkedList<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        top = x;
        q1.offer(x);
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        int size = q1.size();
        while (--size > 0) {
            if (size == 1) top = q1.peek();
            q1.offer(q1.poll());
        }
        return q1.poll();
    }

    /** Get the top element. */
    public int top() {
        return top;
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return q1.isEmpty();
    }
}