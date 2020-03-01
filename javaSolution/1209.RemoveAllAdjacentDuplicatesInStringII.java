import java.util.Stack;

class RemoveAllAdjacentDuplicatesInStringII {
    private class Frequency {
        char c;
        int count = 1;
        Frequency(char c) {
            this.c = c;
        }
    }
    public String removeDuplicates(String s, int k) {
        Stack<Frequency> buf = new Stack<>();
        for (char c: s.toCharArray()) {
            if (buf.isEmpty() || buf.peek().c != c) {
                buf.push(new Frequency(c));
            } else if (buf.peek().count >= k-1) {
                buf.peek().count -= k - 1;
                if (buf.peek().count == 0) {
                    buf.pop();
                }
            } else {
                buf.peek().count++;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (Frequency f: buf) {
            int times = f.count;
            while (times-- >= 1) {
                sb.append(f.c);
            }
        }

        return sb.toString();
    }
}