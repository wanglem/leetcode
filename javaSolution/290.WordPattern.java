import java.util.HashMap;

class WordPattern {
    public boolean wordPattern(String pattern, String str) {
        HashMap<Character, String> cToW = new HashMap<>();
        HashMap<String, Character> wToc = new HashMap<>();
        String[] words = str.split(" ");
        if (pattern.length() != words.length) {
            return false;
        }
        for (int i = 0; i < words.length; i++) {
            char c = pattern.charAt(i);
            if (cToW.containsKey(c) ^ wToc.containsKey(words[i])) {
                return false;
            } else if (cToW.containsKey(c) && wToc.containsKey(words[i]) && !cToW.get(c).equals(words[i])) {
                return false;
            } else {
                cToW.put(c, words[i]);
                wToc.put(words[i], c);
            }
        }
        return true;
    }
}