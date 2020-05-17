import java.util.Stack;

class MinimumAddToMakeParenthesesValid {
    public int minAddToMakeValid(String S) {
        int open = 0, close = 0;
        int minAdd = 0;
        for (char c: S.toCharArray()) {
            if (c == '(') {
                open++;
            } else {
                close++;
            }

            if (close > open) {
                minAdd++;
                open++;
            }
        }

        if (open > close) minAdd += open - close;
        return minAdd;
    }

    public String makeValid(String S) {
        StringBuilder valid = new StringBuilder();

        int open = 0, close = 0;
        for (char c: S.toCharArray()) {
            if (c == '(') {
                open++;
                valid.append('(');
            } else {
                close++;
                if (close > open) {
                    valid.append('(');
                    open++;
                }
                valid.append(')');
            }
        }

        while (open > close++) {
            valid.append(')');
        }

        return valid.toString();
    }
}