import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        return generate(0, 0, n);
    }

    private List<String> generate(int open, int close, int n) {
        if (open < close) return Arrays.asList();
        if (open == n && close == n - 1) {
            return Arrays.asList(")");
        }
        List<String> res = new LinkedList<>();
        if (open < n) {
            List<String> openAns = generate(open + 1, close, n);
            // think this as further code can assume I added an open curl.
            for (String o: openAns) {
                res.add("(" + o);
            }
        }
        if (close < n) {
            List<String> closeAns = generate(open, close + 1, n);
            for (String c: closeAns) {
                res.add(")" + c);
            }
        }
        return res;
    }
}