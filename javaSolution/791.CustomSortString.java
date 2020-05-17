import java.util.*;

class CustomSortString {
    public String customSortString(String S, String T) {
        Map<Character, Integer> order = new HashMap<>(S.length());

        for (int i = 0; i < S.length(); i++) {
            order.put(S.charAt(i), i);
        }

        List<Character> tChars = new ArrayList<>();
        for (char c: T.toCharArray()) {
            tChars.add(c);
        }
        tChars.sort(Comparator.comparingInt(x -> order.getOrDefault(x, 0)));
        
        StringBuilder res = new StringBuilder();
        for (char c: tChars) {
            res.append(c);
        }

        return res.toString();
    }

    public String customSortStringConstant(String S, String T) {
        Map<Character, Integer> count = new HashMap<>();
        for (char c: T.toCharArray()) {
            count.put(c, count.getOrDefault(c, 0) + 1);
        }

        StringBuilder res = new StringBuilder();
        for (char c: S.toCharArray()) {
            if (count.containsKey(c)) {
                int numChar = count.get(c);
                while (numChar-- != 0) {
                    res.append(c);
                }
                count.remove(c);
            }
        }
        for (Map.Entry<Character, Integer> e: count.entrySet()) {
            int numChar = e.getValue();
            while (numChar-- != 0) {
                res.append(e.getKey());
            }
        }
        return res.toString();
    }
}