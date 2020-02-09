import java.util.Stack;

class LongestValidParentheses {
    /*
        use stack.
        track each sub longest valid one.
        Stack should be empty when an invalid found - additional ")".
        Push index to Stack and calculate sub longest directly.
     */
    public int longestValidParentheses(String s) {
        Stack<Integer> buffer = new Stack<>();
        buffer.push(-1);
        int maxLen = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                buffer.push(i);
            } else {
                buffer.pop();
                if (!buffer.isEmpty()) {
                    buffer.push(i);
                } else {
                    maxLen = Math.max(maxLen, i - buffer.peek());
                }
            }
        }
        return maxLen;
    }
}