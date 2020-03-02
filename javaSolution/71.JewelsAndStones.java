import java.util.HashSet;
import java.util.Set;

class JewelsAndStones {
    public int numJewelsInStones(String J, String S) {
        Set<Character> jewels = new HashSet<>();
        for (char j: J.toCharArray()) {
            jewels.add(j);
        }
        int count = 0;
        for (char s: S.toCharArray()) {
            if (jewels.contains(s)) count++;
        }
        return count;
    }

    public int numJewelsInStones2(String J, String S) {
        boolean[] js = new boolean[256];
        for (char j: J.toCharArray()) {
            js[j-'A'] = true;
        }
        int count = 0;
        for (char s: S.toCharArray()) {
            if (js[s-'A']) count++;
        }
        return count;
    }
}