import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*

Given a non-empty string s and a dictionary wordDict containing a list of non-empty words,
determine if s can be segmented into a space-separated sequence of one or more dictionary words.

Note:

The same word in the dictionary may be reused multiple times in the segmentation.
You may assume the dictionary does not contain duplicate words.
Example 1:

Input: s = "leetcode", wordDict = ["leet", "code"]
Output: true
Explanation: Return true because "leetcode" can be segmented as "leet code".
Example 2:

Input: s = "applepenapple", wordDict = ["apple", "pen"]
Output: true
Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
             Note that you are allowed to reuse a dictionary word.
Example 3:

Input: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
Output: false
 */
// FB, DP
class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> dict = new HashSet<>(wordDict);
        return tryBreak(s, 0, dict);

    }

    private boolean tryBreak(String s, int index, Set<String> dict) {

        if (s.length() == index) return true;

        for (int i = index; i < s.length(); i++) {
            if (dict.contains(s.substring(i, i+1)) && tryBreak(s, i+1, dict)) {
                return true;
            }
        }
        return false;
    }

    public boolean wordBreakDP(String s, List<String> wordDict) {
        Set<String> dict = new HashSet<>(wordDict);
        boolean[] canBreak = new boolean[s.length()+1];
        canBreak[0] = true;
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j <= i; j++) {
                if (canBreak[j] && dict.contains(s.substring(j, i+1))) {
                    canBreak[i+1] = true;
                    break;
                }
            }
        }
        return canBreak[s.length()];
    }

}