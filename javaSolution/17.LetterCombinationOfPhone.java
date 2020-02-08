import java.util.*;

class LetterCombinationOfPhone {
    private HashMap<String, List<String>> letterMap = new HashMap<>();
    LetterCombinationOfPhone()  {
        letterMap.put("2", Arrays.asList("a", "b", "c"));
        letterMap.put("3", Arrays.asList("d", "e", "f"));
        letterMap.put("4", Arrays.asList("g", "h", "i"));
        letterMap.put("5", Arrays.asList("j", "k", "l"));
        letterMap.put("6", Arrays.asList("m", "n", "o"));
        letterMap.put("7", Arrays.asList("p", "q", "r", "s"));
        letterMap.put("8", Arrays.asList("t", "u", "v"));
        letterMap.put("9", Arrays.asList("w", "x", "y", "z"));
    }
    public List<String> letterCombinations(String digits) {
        if (digits.length() == 1) {
            return letterMap.get(digits);
        }
        List<String> res = new LinkedList<>();
        if (digits.length() == 0) {
            return res;
        }
        List<String> headLetters = letterMap.get(digits.substring(0, 1));
        headLetters.forEach( headLetter ->
            letterCombinations(digits.substring(1))
                    .forEach(rest -> res.add(headLetter + rest))
        );
        return res;
    }
}