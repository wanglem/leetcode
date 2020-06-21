import java.util.HashMap;
import java.util.Map;

// On algro
// FB
class LongestSubstringWithAtMostKDistinctCharacters {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        Map<Character, Integer> charCount = new HashMap<>();

        int left = 0, right = 0, longest = 0;
        while (right < s.length()) {
            if (charCount.size() > k) {
                char lc = s.charAt(left);
                charCount.put(lc, charCount.get(lc) - 1);
                if (charCount.get(lc) == 0) {
                    charCount.remove(lc);
                }
                left++;
            } else {
                char rc = s.charAt(right);
                charCount.put(rc, charCount.getOrDefault(rc, 0) + 1);
                if (charCount.size() <= k) {
                    longest = Math.max(longest, right - left + 1);
                }
                right++;
            }

        }
        return longest;
    }
}