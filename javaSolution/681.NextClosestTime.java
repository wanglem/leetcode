import java.util.Arrays;
import java.util.Collections;
import java.util.stream.IntStream;

class NextClosestTime {
    public String nextClosestTime(String time) {
        int[] n = normalize(time);
        int[] res = Arrays.copyOf(n, 4);
        int min = IntStream.of(n).min().getAsInt();
        for (int i = 3; i >= 0; i--) {
            int found = nextBiggest(n, i);
            if (found != -1) {
                res[i] = found;
                break;
            }
            res[i] = min;
        }
        return build(res);
    }

    private String build(int[] n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            if (i == 2) sb.append(":");
            sb.append(n[i]);
        }
        return sb.toString();
    }
    private int nextBiggest(int[] n, int i) {
        int ceiling = Integer.MAX_VALUE;
        int[] caps = {1, 3, 5, 9};
        int cap = caps[i];
        if (i == 1 && n[0] < 2) cap = 9;
        for (int c: n) {
            if (c > n[i] && c <= cap) {
                ceiling = Math.min(ceiling, c);
            }
        }
        return ceiling == Integer.MAX_VALUE ? -1 : ceiling;
    }

    private int[] normalize(String t) {
        int[] n = new int[4];
        String[] s = t.split(":");
        if (s[0].length()==2) {
            n[0] = s[0].charAt(0) - '0';
            n[1] = s[0].charAt(1) - '0';
        } else {
            n[1] = s[0].charAt(0) - '0';
        }
        if (s[1].length() == 2) {
            n[2] = s[1].charAt(0) - '0';
            n[3] = s[1].charAt(1) - '0';
        } else {
            n[3] = s[1].charAt(0) - '0';
        }
        return n;
    }
}