import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Google
// Two Map<Character, Character> wordToPatter and patterToWord
class FindAndreplacePattern {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> found = new ArrayList<>();
        for (String word : words) {
            if (match(word, pattern)) found.add(word);
        }
        return found;
    }

    private boolean match(String word, String pattern) {
        Map<Character, Character> w2p = new HashMap<>();
        Map<Character, Character> p2w = new HashMap<>();
        for (int i = 0; i < word.length(); i++) {
            char w = word.charAt(i);
            char p = pattern.charAt(i);
            if (!w2p.containsKey(w)) {
                w2p.put(w, p);
            }
            if (!p2w.containsKey(p)) {
                p2w.put(p, w);
            }
            if (w2p.get(w) != p || p2w.get(p) != w) {
                return false;
            }
        }
        return true;
    }
}