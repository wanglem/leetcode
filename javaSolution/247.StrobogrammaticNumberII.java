import java.util.*;

class StrobogrammaticNumberII {
    private Map<Character, Character> stro = new HashMap<>();
    public List<String> findStrobogrammatic(int n) {
        stro.put('0', '0');
        stro.put('1', '1');
        stro.put('6', '9');
        stro.put('8', '8');
        stro.put('9', '6');
        if (n == 0) return new ArrayList<>();
        return find(n, n);
    }

    private List<String> find(int n, int k) {
        if (k == 0) return Arrays.asList("");
        if (k == 1) return Arrays.asList("0","1","8");

        Set<Character> candidates = new HashSet<>(stro.keySet());
        if (k == n) candidates.remove('0');
        List<String> res = new ArrayList<>();
        for (char c: candidates) {
            for(String child: find(n, k-2)) {
                res.add(c + child + stro.get(c));
            }
        }
        return res;
    }
}
