import java.util.Stack;

class StringCompression {
    public int compress(char[] chars) {
        int left = 0;
        int count = 1;
        char buf = chars[0];
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] != buf) {
                left = substitute(left, count, buf, chars);
                count = 1;
                buf = chars[i];
            } else {
                count++;
            }
        }
        left = substitute(left, count, buf, chars);
        return left;
    }

    private int substitute(int left, int count, char buf, char[] chars) {
        chars[left++] = buf;
        if (count == 1) return left;
        Stack<Character> toChars = new Stack<>();
        while (count != 0) {
            toChars.push((char)((count % 10) + '0'));
            count /= 10;
        }
        while (!toChars.isEmpty()) {
            chars[left++] = toChars.pop();
        }
        return left;
    }
}