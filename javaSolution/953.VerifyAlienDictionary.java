import java.util.HashMap;
import java.util.Map;

// FB
class VerifyAlienDictionary {
    public boolean isAlienSorted(String[] words, String order) {
        Map<Character, Integer> charIndex = new HashMap<>();
        for (int i = 0; i < order.length(); i++) {
            charIndex.put(order.charAt(i), i);
        }

        for (int i = 1; i < words.length; i++) {
            String w = words[i];
            String pre = words[i-1];
            boolean samePrefix = true;
            for (int j = 0; j < Math.min(w.length(), pre.length()); j++) {
                if (w.charAt(j) != pre.charAt(j)) {
                    samePrefix = false;
                    if (!ordered(pre.charAt(j), w.charAt(j), charIndex)) {
                        return false;
                    }
                    break;
                }
            }
            if (samePrefix && pre.length() > w.length()) {
                return false;
            }
        }
        return true;
    }

    private boolean ordered(char i, char j, Map<Character, Integer> charIndex) {
        return charIndex.get(i) <= charIndex.get(j);
    }
}