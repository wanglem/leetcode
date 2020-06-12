import java.util.*;

/*

BB

Given a non-empty string s and a dictionary wordDict containing a list of non-empty words,
add spaces in s to construct a sentence where each word is a valid dictionary word.
Return all such possible sentences.

Note:

The same word in the dictionary may be reused multiple times in the segmentation.
You may assume the dictionary does not contain duplicate words.
Example 1:

Input:
s = "catsanddog"
wordDict = ["cat", "cats", "and", "sand", "dog"]
Output:
[
  "cats and dog",
  "cat sand dog"
]
Example 2:

Input:
s = "pineapplepenapple"
wordDict = ["apple", "pen", "applepen", "pine", "pineapple"]
Output:
[
  "pine apple pen apple",
  "pineapple pen apple",
  "pine applepen apple"
]
Explanation: Note that you are allowed to reuse a dictionary word.
Example 3:

Input:
s = "catsandog"
wordDict = ["cats", "dog", "sand", "and", "cat"]
Output:
[]
 */
class WordBreakII {
    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> dict = new HashSet<>(wordDict);
        return tryBreak(s, dict, new HashMap<>());

    }

    private List<String> tryBreak(String s, Set<String> dict, Map<String, List<String>> segmentAt) {
        if (segmentAt.containsKey(s)) {
            return segmentAt.get(s);
        }
        List<String> res = new LinkedList<>();
        for (int i = 1; i <= s.length(); i++) {
            String wordToTry = s.substring(0, i);
            if (dict.contains(wordToTry)) {
                if (i == s.length()) {
                    // full String s is a word, no need further recursive call.
                    res.add(wordToTry);
                } else {
                    for (String sub: tryBreak(s.substring(i), dict, segmentAt)) {
                        res.add(wordToTry + " " + sub);
                    }
                }
            }
        }
        // segmentAt remembers all break combinations of S.
        // in this case suffix's break combination of the orginal s.
        segmentAt.put(s, res);
        return res;
    }

}