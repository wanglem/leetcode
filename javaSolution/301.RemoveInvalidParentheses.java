import java.util.*;

// fb
// find invalidLeft and invalidRight, only try remove invalids instead try removing any
class RemoveInvalidParentheses {
    public List<String> removeInvalidParentheses(String s) {
        int[] invalid = findInvalid(s);
        int l = invalid[0], r = invalid[1];
        return new ArrayList<>(removeInvalid(s.toCharArray(), 0, l, r));
    }

    private Set<String> removeInvalid(char[] s, int index, int invalidLeft, int invalidRight) {
        Set<String> res = new HashSet<>();
        if (invalidLeft == 0 && invalidRight == 0) {
            String toTry = construct(s);
            if (isValid(toTry)) {
                res.add(toTry);
            }
            return res;
        }
        if (index >= s.length || invalidLeft < 0 || invalidRight < 0) {
            return res;
        }
        for (int i = index; i < s.length; i++) {
            if (s[i] == '(' && invalidLeft > 0) {
                s[i] = '.';
                Set<String> child = removeInvalid(s, i + 1, invalidLeft-1, invalidRight);
                s[i] = '(';
                res.addAll(child);
            } else if (s[i] == ')' && invalidRight > 0) {
                s[i] = '.';
                Set<String> child = removeInvalid(s, i + 1, invalidLeft, invalidRight-1);
                s[i] = ')';
                res.addAll(child);
            }
        }
        return res;

    }

    private String construct(char[] s) {
        StringBuilder sb = new StringBuilder();
        for (char c : s) {
            if (c != '.') {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    private boolean isValid(String s) {
        Stack<Character> buf = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                buf.add('(');
            } else if (s.charAt(i) == ')') {
                if (buf.isEmpty() || buf.peek() != '(') {
                    return false;
                } else {
                    buf.pop();
                }
            }
        }
        return buf.isEmpty();
    }

    private int[] findInvalid(String s) {
        int invalidLeft = 0, invalidRight = 0;
        int left = 0;
        for(int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                if (left > 0 && i > 0 && s.charAt(i-1) == ')') {
                    invalidLeft += left;
                    left = 0;
                } else {
                    left++;
                }
            } else if (s.charAt(i) == ')') {
                if (left == 0) {
                    invalidRight++;
                } else {
                    left--;
                }
            }
        }
        invalidLeft += left;
        return new int[]{invalidLeft, invalidRight};
    }
}