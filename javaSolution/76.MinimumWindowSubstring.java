import java.util.*;

// continous substring contains all chars in `t`.
// sliding window with two pointers
// counter only ++ when occurance < target frequence.
// when counter == t.length(), we know a window formed.
class MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        int[] target = new int[256];
        for (char c: t.toCharArray()) {
            target[c]++;
        }

        int count = 0;
        int[] freq = new int[256];
        int left = 0, right = 0;

        String res = null;
        while (right < s.length()) {
            char rchar = s.charAt(right);
            if (target[rchar] > 0) {
                if (freq[rchar] < target[rchar]) count++;
                freq[rchar]++;
            }
            if (count >= t.length()) {
                while (freq[s.charAt(left)] <= 0 || freq[s.charAt(left)] != target[s.charAt(left)]) {
                    freq[s.charAt(left++)]--;
                }
                if (res == null) res = s.substring(left, right + 1);
                if (right - left + 1 < res.length()) {
                    res = s.substring(left, right + 1);
                }
            }
            right++;
        }
        return null == res ? "" : res;
    }
}