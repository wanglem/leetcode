import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class GoatLatin {
    public String toGoatLatin(String S) {
        String[] words = S.split(" ");
        StringBuilder sb = new StringBuilder();
        Set<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
        for (int i = 0; i < words.length; i++) {
            String w = words[i];
            if (vowels.contains(w.charAt(0))) {
                sb.append(w);
            } else {
                sb.append(w.substring(1));
                sb.append(w.charAt(0));
            }
            sb.append("ma");
            for (int j = 0; j < i+1; j++) {
                sb.append('a');
            }
            sb.append(' ');
        }

        return sb.toString().trim();
    }
}