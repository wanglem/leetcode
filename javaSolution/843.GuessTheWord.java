import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * // This is the Master's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface Master {
 *     public int guess(String word) {}
 * }
 */
//Google
/*
    Tricky question.
    1. Pick one from wordlist and guess it.
    2. reduce wordlist and only keep words with char matches same to returned guess value.
        1a. pick first one is bad, might not find solution at all.
        1b. pick random one is better.
        1c. best pick from those have no matches.

 */
class GuessTheWord {
    class Master{
        public int guess(String x){
            return 0;
        }
    }
    public void findSecretWord(String[] wordlist, Master master) {
        for (int i = 0, x = 0; i < 10 && x < 6; ++i) {
            String guess = wordlist[new Random().nextInt(wordlist.length)];
            x = master.guess(guess);
            List<String> wordlist2 = new ArrayList<>();
            for (String w : wordlist)
                if (matches(guess, w) == x)
                    wordlist2.add(w);
            wordlist = wordlist2.toArray(new String[wordlist2.size()]);
        }
    }

    private int matches(String a, String b) {
        if (a.length() != b.length()) throw new RuntimeException("no way");
        int match = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) == b.charAt(i)) match++;
        }
        return match;
    }
}
