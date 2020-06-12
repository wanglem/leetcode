import java.util.Stack;

// FB, BB
// use a stack
// open, close to track numbers of open close parenthesis
// if close > open, discard
// since we always try to discard ')', invalid cases (open > end) are at the end of the stack
// remove '(' while popping stack, until open == close
class MinimumRemoveToMakeValidParentheses {
    public String minRemoveToMakeValid(String s) {
        Stack<Character> valid = new Stack<>();
        int open = 0, close = 0;
        for (char c: s.toCharArray()) {
            if (c == '(') {
                valid.push(c);
                open++;
            } else if (c == ')') {
                if (close < open) {
                    valid.push(c);
                    close++;
                }
            } else {
                valid.push(c);
            }
        }

        StringBuilder res = new StringBuilder();
        while (!valid.isEmpty()) {
            Character c = valid.pop();
            if (c == '(' && open > close) {
                open--;
            } else {
                res.append(c);
            }
        }

        return res.reverse().toString();
    }

    public String t(String s) {
        int open = 0, close = 0;
        Stack<Character> st = new Stack<>();
        for (char c: s.toCharArray()) {
            if (c == '(') {
                open++;
                st.push(c);
            } else if (c == ')') {
                if (close < open) {
                    close++;
                    st.push(c);
                }
                // else ignore
            } else {
                st.push(c);
            }
        }

        StringBuilder sb = new StringBuilder();
        int gap = open - close;
        for (char c: st) {
            if (open == gap && c == '(') continue;
            if (c == ')') close--;
            if (c == '(') open--;
            sb.append(c);
        }
        return sb.toString();
    }
}
