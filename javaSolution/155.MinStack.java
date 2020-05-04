import java.util.Stack;

// method 1. each push pushes two integer - element and current_min

// method 2. remember latest min, and push delta between min and current.
class MinStack {


    private Stack<Integer> stack;
    public MinStack() {
        stack = new Stack<>();
    }

    public void push(int x) {
        int min = x;
        if (!stack.isEmpty()) {
            min = Math.min(stack.peek(), x);
        }
        stack.push(x);
        stack.push(min);
    }

    public void pop() {
        stack.pop();
        stack.pop();
    }

    public int top() {
        int min = stack.pop();
        int top = stack.pop();
        stack.push(top);
        stack.push(min);
        return top;
    }

    public int getMin() {
        return stack.peek();
    }
}