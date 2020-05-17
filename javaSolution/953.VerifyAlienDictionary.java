import java.util.HashMap;
import java.util.Map;

// FB
// no comparator stuff for String comparison
class VerifyAlienDictionary {
    public boolean isAlienSorted(String[] words, String order) {
        int[] charIndex = new int[256];
        for (int i = 0; i < order.length(); i++) {
            charIndex[order.charAt(i)] = i;
        }

        for (int i = 1; i < words.length; i++) {
            if (!smaller(words[i-1], words[i], charIndex)) return false;

        }
        return true;
    }

    private boolean smaller(String a, String b, int[] charIndex) {
        for (int j = 0; j < Math.min(a.length(), b.length()); j++) {
            if (a.charAt(j) != b.charAt(j)) {
                return charIndex[a.charAt(j)] <= charIndex[b.charAt(j)];
            }
        }
        return a.length() < b.length();
    }
}