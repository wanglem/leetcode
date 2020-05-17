import java.util.Stack;

// FB
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
}