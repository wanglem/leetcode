import java.util.HashMap;
import java.util.Map;

class StringToInteger {

    public int myAtoi(String str) {
        if (str.length() == 0) return 0;
        Map<Character, Integer> lut = new HashMap<>();
        lut.put('0', 0);
        lut.put('1', 1);
        lut.put('2', 2);
        lut.put('3', 3);
        lut.put('4', 4);
        lut.put('5', 5);
        lut.put('6', 6);
        lut.put('7', 7);
        lut.put('8', 8);
        lut.put('9', 9);
        int offset = 0;
        while (offset < str.length() && str.charAt(offset) == ' ') {
            offset++;
        }

        if (offset >= str.length()) return 0;

        if (str.charAt(offset) != '-'
                && str.charAt(offset) != '+'
                && (str.charAt(offset) > '9' || str.charAt(offset) < '0')) {
            return 0;
        }

        int ans = 0;
        int sign = 1;
        if (str.charAt(offset) == '-') {
            sign *= -1;
            offset++;
        } else if (str.charAt(offset) == '+') {
            offset++;
        }
        while (offset < str.length() && str.charAt(offset) == '0') offset++;

        for (; offset < str.length(); offset++) {
            char next = str.charAt(offset);
            if (!lut.containsKey(next)) {
                return ans * sign;
            }
            int digit = lut.get(next);
            if (goingOffRange(ans, digit)) {
                return  sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            ans = ans * 10 + digit;
        }

        return ans * sign;
    }

    // base can be both positive and negative
    // addend is always positive
    private boolean goingOffRange(int base, int addend) {
        if (base > 0) {
            return (Integer.MAX_VALUE - addend) / 10 < base;
        } else {
            return (Integer.MIN_VALUE + addend) / 10 > base;
        }
    }
}