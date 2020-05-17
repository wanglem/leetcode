import java.util.ArrayList;
import java.util.List;

// fb
// find substring which is anagram of p
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

    /*
        two pointer with window length of p.length().
        counter only increments/decrements for number occurance of char in P.
        In this case, when counter reach 0, we know we found one.
     */
    public List<Integer> findAnagramsOnAlgo(String s, String p) {
        int[] hash = new int[256];
        for (char c : p.toCharArray()) {
            hash[c]--;
        }
        int count = 0, left = 0, right = 0;
        List<Integer> starts = new ArrayList<>();
        while (right < s.length()) {
            hash[s.charAt(right)]++;
            if (hash[s.charAt(right)] <= 0) {
                count++;
            }

            if (count == p.length()) starts.add(left);

            if (right - left == p.length() - 1) {
                if (hash[s.charAt(left)] <= 0) {
                    count--;
                }
                hash[s.charAt(left)]--;
                left++;
            }

            right++;
        }

        return starts;
    }
}