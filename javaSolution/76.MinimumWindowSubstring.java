import java.util.*;

class MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        // occurrence of char in t, reduce to < 0 of all means a valid substring
        HashMap<Character, Integer> occur = new HashMap<>();
        for (Character c : t.toCharArray()) {
            occur.put(c, occur.getOrDefault(c, 0) + 1);
        }
        String shortest = "";
        int left = 0;
        boolean canCompute = false;
        while (left < s.length() && !occur.containsKey(s.charAt(left))) {
            left++;
        }
        int right = 0;
        while (right < s.length()) {
            if (occur.containsKey(s.charAt(right))) {
                if (!canCompute && canCompute(occur)) {
                    canCompute = true;
                }
                occur.put(s.charAt(right), occur.get(s.charAt(right))-1);
                // try move left
                while (left <= right) {
                    if (!occur.containsKey(s.charAt(left))) {
                        left++;
                        continue;
                    } else if (occur.containsKey(s.charAt(left)) && occur.get(s.charAt(left)) < 0) {
                        occur.put(s.charAt(left), occur.get(s.charAt(left))+1);
                    } else {
                        break;
                    }
                    left++;
                }
                // try compute substring
                if (canCompute) {
                    String curShortest = s.substring(left, right+1);
                    if (shortest.equals("")) {
                        shortest = curShortest;
                    } else {
                        shortest = shortest.length() > curShortest.length() ? curShortest : shortest;
                    }
                }
            }
            right++;
        }

        return shortest;
    }
    private Boolean canCompute(HashMap<Character, Integer> occur) {
        for (Integer v: occur.values()){
            if (v > 0) return false;
        }
        return true;
    }
}