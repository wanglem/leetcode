import java.util.Stack;

class ValidateStackSequences {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        if (pushed.length == 0 && popped.length == 0) return true;
        if (pushed.length != popped.length) return false;

        Stack<Integer> buf = new Stack<>();
        int m = pushed.length;
        int i = 0;
        int j = 0;
        while (i <= m && j < m) {
            if (!buf.isEmpty() && buf.peek() == popped[j]) {
                buf.pop();
                j++;
            } else {
                if (i == m) return false;
                buf.push(pushed[i++]);
            }
        }

        return i == m && j == m;
    }
}