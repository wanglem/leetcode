import java.util.ArrayList;
import java.util.List;

// split string into parts, all of which are palindrome
// find all possible splits
class PalindromePartitioning {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        if (s.length() == 0) {
            return res;
        }
        for (int i = 0; i < s.length(); i++) {
            String part = s.substring(0, i);
            if (isPalindrome(part)) {
                List<List<String>> childPartitions = partition(s.substring(i));
                for (List<String> child : childPartitions) {
                    List<String> curPartition = new ArrayList<>();
                    curPartition.add(part);
                    curPartition.addAll(child);
                    res.add(curPartition);
                }
            }
        }
        if (isPalindrome(s)) {
            res.add(new ArrayList<>());
            res.get(res.size() - 1).add(s);
        }
        return res;
    }


    private boolean isPalindrome(String s) {
        if (s.length() == 0) return false;
        int i = 0, j = s.length() - 1;
        while (i <= j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}