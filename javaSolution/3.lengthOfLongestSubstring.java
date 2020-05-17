import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

// Given a string, find the length of the longest substring without repeating characters.

// two pointers
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

    public int lengthOfLongestSubstring2(String s) {
        if (s.length() < 1) {
            return 0;
        }
        int left = 0;
        int minDistinct = 0;
        Set<Character> seen = new HashSet<>();
        for (int right = 0; right < s.length(); right++) {
            while (seen.contains(s.charAt(right))) {
                seen.remove(s.charAt(left));
                left++;
            }
            seen.add(s.charAt(right));
            minDistinct = Math.max(minDistinct, seen.size());
        }
        return minDistinct;
    }

    public int lengthOfLongestSubstring3(String s) {
        if (s.length() == 0) return 0;
        // 256 for all ASCII chars, lower/upper case, white space etc.
        boolean[] seen = new boolean[256];
        int left = 0;
        int longest = Integer.MIN_VALUE;
        for (int i = 0; i < s.length(); i++) {
            int idx = s.charAt(i);
            if (seen[idx]) {
                while (left < i && s.charAt(left) != s.charAt(i)) {
                    seen[s.charAt(left++)] = false;
                }
                left++;
            } else {
                seen[idx] = true;
                longest = Math.max(i - left + 1, longest);
            }
        }
        return longest;
    }
}

