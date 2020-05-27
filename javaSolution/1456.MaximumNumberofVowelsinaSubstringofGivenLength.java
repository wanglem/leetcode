import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class MaximumNumberofVowelsinaSubstringofGivenLength {
    public int maxVowels(String s, int k) {
        int left = 0;
        int numVowels = 0;
        int maxVowels = 0;
        Set<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
        for (int right = 0; right < s.length(); right++) {
            if (right - left + 1 > k) {
                if (vowels.contains(s.charAt(left++))) numVowels--;
            }
            if (vowels.contains(s.charAt(right))) numVowels++;
            maxVowels = Math.max(numVowels, maxVowels);
        }
        return maxVowels;
    }
}