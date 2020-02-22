import java.util.HashMap;
import java.util.Map;

class ExpressiveWords {
    public int expressiveWords(String S, String[] words) {
        int[] freq = new int[S.length()];
        StringBuilder sb = new StringBuilder();
        int i = 0, j = 1;
        int distinct = 0;
        while (i < S.length() && j < S.length()) {
            while (j < S.length() && S.charAt(i) == S.charAt(j)) j++;
            sb.append(S.charAt(i));
            freq[distinct++] = j-i;
            i = j;
        }
        String SD = sb.toString();

        int count = 0;
        for (String w: words) {
            if (isStretchy(freq, SD, w)) count++;
        }

        return count;
    }

    private boolean isStretchy(int[] freq, String SD, String word) {
        int start = 0;
        int group = 0;
        while (start < word.length() && group < SD.length()) {
            int end = start+1;
            while (end < word.length() && word.charAt(start) == word.charAt(end)) {
                end++;
            }
            int repeated = end - start;
            if (SD.charAt(group) != word.charAt(start) ||
                    (freq[group] < repeated) || (freq[group] != repeated && freq[group] < 3)) {
                return false;
            }
            start = end;
            group++;
        }
        return start == word.length() && group == SD.length();
    }
}