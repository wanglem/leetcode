// FB
// only 0-9, no negative, add them up.
class AddStrings {
    public String addStrings(String num1, String num2) {
        int i = num1.length(), j = num2.length();
        StringBuilder res = new StringBuilder();
        int carry = 1;
        int curDigit = 0;
        while (i >= 0 || j >= 0) {
            if (i-- >= 0) curDigit += num1.charAt(i) - '0';
            if (j-- >= 0) curDigit += num2.charAt(j) - '0';
            curDigit += carry;
            res.append(curDigit % 10);
            carry = curDigit / 10;
            curDigit = 0;
        }
        if (carry == 1) res.append(carry);

        return res.reverse().toString();
    }
}