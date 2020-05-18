import java.util.*;

// fb
// try out all combinations
class RemoveInvalidParentheses {

    private HashSet<String> res;
    public List<String> removeInvalidParentheses(String s) {
        res = new HashSet<>();
        getValid(s, 0, 0, 0, new Stack<>());
        return new ArrayList<>(res);
    }

    private void getValid(String s, int idx, int open, int close, Stack<Character> valid) {
        if (close > open) return;
        if (idx == s.length()) {
            if (open > close) return;
            addResult(valid);
            return;
        }
        char cur = s.charAt(idx);
        if (cur == '(') {
            valid.push(cur);
            getValid(s, idx+1, open + 1, close, valid);
            valid.pop();
            getValid(s, idx+1, open, close, valid);
        } else if (cur == ')') {
            valid.push(cur);
            getValid(s, idx+1, open, close+1, valid);
            valid.pop();
            getValid(s, idx+1, open, close, valid);
        } else {
            valid.push(cur);
            getValid(s, idx+1, open, close, valid);
            valid.pop();
        }

    }

    private void addResult(Stack<Character> st) {
        if (!res.isEmpty()) {
            int len = res.iterator().next().length();
            if (st.size() < len) return;
            else if (st.size() > len) res.clear();
        }

        StringBuilder sb = new StringBuilder();
        for (char c : st) {
            sb.append(c);
        }

        res.add(sb.toString());
    }
}