import java.util.ArrayList;
import java.util.List;

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