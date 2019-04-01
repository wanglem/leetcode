import java.util.HashMap;
import java.util.Map;

// Google
/*
    Sliding window, two pointers
 */
class LongestSubstringWithAtMostTwoChars {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        int count = 0;
        Map<Character, Integer> charCount = new HashMap<>();
        int maxLen = 0;
        int i = 0, j = 0;
        while (j < s.length()) {
            char atJ = s.charAt(j);
            if (!charCount.containsKey(atJ) || charCount.get(atJ) == 0) {
                count++;
                charCount.put(atJ, 1);
            } else {
                charCount.put(atJ, charCount.get(atJ)+1);
            }
            while (count > 2) {
                char atI = s.charAt(i);
                charCount.put(atI, charCount.get(atI)-1);
                if (charCount.get(atI) == 0) count--;
                i++;
            }
            maxLen = Math.max(maxLen, j - i + 1);
            j++;
        }
        return maxLen;
    }
}