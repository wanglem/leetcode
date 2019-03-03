import java.util.HashMap;
class LengthOfLongestSubstring {
    public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) return 0;
        int curLongest = 1, longest = 1;
        int left = 0, right = 0;

        HashMap<Character, Integer> reg = new HashMap<>();
        reg.put(s.charAt(0), 0);
        while (right < s.length()) {
            if (left == right) {
                curLongest = 1;
            } else if (reg.containsKey(s.charAt(right))) {
                while (left < reg.get(s.charAt(right))) {
                    reg.remove(s.charAt(left));
                    left++;
                }
                left++;
                curLongest = right - left + 1;
                reg.put(s.charAt(right), right);
            } else {
                reg.put(s.charAt(right), right);
                curLongest++;
            }
            right++;
            longest = Math.max(curLongest, longest);
        }
        return longest;
    }
}

