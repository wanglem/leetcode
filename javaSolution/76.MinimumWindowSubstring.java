/**
 * continous substring contains all chars in `t`.
 * sliding window with two pointers
 *
 * maintain target[] counter for all occurance in t.
 *  if target[i] > 0, count++.
 *  if count == t.length(), substring convers all letters in t.
 *  move left until count < t.length()
 */

// FB
class MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        int[] target = new int[256];
        for (char c: t.toCharArray()) {
            target[c]++;
        }
        String minWindow = null;
        int count = 0;
        int left = 0, right = 0;
        while (right < s.length()) {
            char rc = s.charAt(right);
            if (target[rc] > 0) {
                count++;
            }
            target[rc]--;

            while (count == t.length()) {
                minWindow = minWindow == null || minWindow.length() > right-left+1 ? s.substring(left, right+1) : minWindow;
                if (target[s.charAt(left)] == 0) count--;
                target[s.charAt(left++)]++;
            }
            right++;
        }
        return minWindow == null ? "" : minWindow;
    }
}