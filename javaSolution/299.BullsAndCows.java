/*
    one pass:
        use one array to track.
        If equals bulls++;
        for [sc,gc] of each secret/guess char pair:
            ++ on sc (positive num means previous we saw sc)
            -- on gc (negative num means previous we saw gc)
            if S[sc] < 0, means previously had "this sc char" in guess -> cows++
            if S[gc] > 0 means previously had "this gc char" in secret -> cows++
 */
class BullsAndCows {
    public String getHint(String secret, String guess) {
        int[] S = new int[10];
        int bulls = 0, cows = 0;

        for (int i = 0; i < secret.length(); i++) {
            int s = secret.charAt(i) - '0';
            int g = guess.charAt(i) - '0';
            if (s == g) {
                bulls++;
            } else {
                if (S[g] > 0) cows++;
                if (S[s] < 0) cows++;
                S[s]++;
                S[g]--;
            }
        }

        return String.format("%dA%dB", bulls, cows);
    }
}