import java.util.ArrayList;
import java.util.List;

class FindAllAnagramsInString {
    public List<Integer> findAnagrams(String s, String p) {
        int window = p.length();
        int[] count = new int[26];
        for (char c : p.toCharArray()) {
            count[c-'a']--;
        }
        List<Integer> starts = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i)-'a']--;
            if (i >= window) {
                count[s.charAt(i-window)-'a']++;
            }
            if (checkCount(count)) {
                starts.add(i-window+1);
            }
        }
        return starts;
    }

    private boolean checkCount(int[] count) {
        for (int c : count) {
            if (c != 0) return false;
        }
        return true;
    }
}