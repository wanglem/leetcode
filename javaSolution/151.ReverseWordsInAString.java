import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class ReverseWordsInAString {
    public String reverseWords(String s) {
        List<String> reverse = new ArrayList<>();

        int left = 0;
        while (left < s.length()) {
            while (left < s.length() && s.charAt(left) == ' ') {
                left++;
            }
            int right = left;
            while (right < s.length() && s.charAt(right) != ' ') {
                right++;
            }

            if (left < s.length()) reverse.add(s.substring(left, right));
            left = right;
        }
        Collections.reverse(reverse);
        return String.join(" ", reverse);
    }
}