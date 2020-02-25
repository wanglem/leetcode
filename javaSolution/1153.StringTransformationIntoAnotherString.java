import java.util.*;

/*
    Can almost always convert as long as str2 does not contain 26 chars.
 */
class StringTransformationIntoAnotherString {
    public boolean canConvert(String str1, String str2) {
        if (str1.length() != str2.length()) return false;
        if (str1.equals(str2)) return true;

        Map<Character, Character> converted = new HashMap<>();
        Set<Character> seen = new HashSet<>();

        for (int i = 0; i< str1.length(); i++) {
            char from = str1.charAt(i);
            char to = str2.charAt(i);
            if (converted.containsKey(from) && converted.get(from) != to){
                return false;
            }
            converted.put(from, to);
            seen.add(to);
        }

        return seen.size() != 26;
    }

}