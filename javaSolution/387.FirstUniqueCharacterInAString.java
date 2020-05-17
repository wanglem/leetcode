import java.util.Arrays;
import java.util.Comparator;

class FirstUniqueCharacterInAString {
    public int firstUniqChar(String s) {
        int[][] count = new int[26][2];
        for (int i = 0; i < 26; i++) {
            count[i][1] = -1;
        }
        for (int i = 0; i < s.length(); i++) {
            int idx = s.charAt(i) - 'a';
            if (count[idx][1] == -1) {
                count[idx][1] = i;
            }
            count[idx][0]++;
        }
        Arrays.sort(count, Comparator.comparingInt(x -> x[1]));
        for (int i = 0; i < 26; i++) {
            if (count[i][0] == 1) return count[i][1];
        }
        return -1;
    }
}