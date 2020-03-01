import java.util.HashMap;
import java.util.Map;

class StrobogrammaticNumber {

    public boolean isStrobogrammatic(String num) {
        Map<Character, Character> stro = new HashMap<>();
        stro.put('0', '0');
        stro.put('1', '1');
        stro.put('6', '9');
        stro.put('8', '8');
        stro.put('9', '6');

        int left = 0, right = num.length() - 1;
        while (left <= right) {
            char lc = num.charAt(left++);
            char lr = num.charAt(right--);
            if (!stro.containsKey(lc) || stro.get(lc) != lr) return false;
        }
        return true;
    }

}
