import java.util.Stack;

// Google
class BackspaceStringCompare {
    public boolean backspaceCompare(String S, String T) {
        return process(S).equals(process(T));
    }

    private String process(String s) {
       StringBuilder processed = new StringBuilder();
        int skip = 0;
        for (int i = s.length()-1; i >= 0; i--) {
            char c = s.charAt(i);
            if (c == '#') {
                skip++;
            } else if (skip > 0) {
                skip--;
            } else {
                processed.append(c);
            }
        }
        return processed.toString();
    }
}