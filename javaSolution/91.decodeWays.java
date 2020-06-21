import java.util.HashMap;
import java.util.Map;

// FB
class DecodeWays {
    public int numDecodings(String s) {
        return decodeOn(s);
    }

    private int decode(String s, int idx, Map<Integer, Integer> countMap) {
        if (countMap.containsKey(idx)) return countMap.get(idx);
        if (idx == s.length()) return 1;

        int count = 0;
        if (s.charAt(idx) == '0') {
            return 0;
        }
        count += decode(s, idx+1, countMap);

        if (idx <= s.length() - 2) {
            int nextTwo = Integer.parseInt(s.substring(idx, idx+2));
            if (nextTwo >= 10 && nextTwo <= 26)  {
                count += decode(s, idx+2, countMap);
            }
        }
        countMap.put(idx, count);
        return count;
    }

    // dp[i] is the max ways at index i
    // like climb ladders.
    // dp with length n+1, so dp[0] is always is for dp[2] with two digits plus 1.
    private int decodeOn(String s) {
        if (s == null || s.length() == 0) return 0;
        if (s.charAt(0) == '0') return 0;
        int n = s.length();

        int[] dp = new int[n+1];
        
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i < n+1; i++) {
            int first = Integer.parseInt(s.substring(i-1, i));
            int second = Integer.parseInt(s.substring(i-2, i));

            if (first != 0) dp[i] += dp[i-1];
            if (second >= 10 && second <= 26) dp[i] += dp[i-2];
        }

        return dp[n];
    }

}