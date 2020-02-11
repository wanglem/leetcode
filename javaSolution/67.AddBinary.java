class AddBinary {
    public String addBinary(String a, String b) {
        int carry = 0;
        StringBuffer res = new StringBuffer();
        int al = a.length(), bl = b.length();
        int i = 0;
        while (i < al || i < bl) {
            int digit = carry;
            if (al - i - 1 >= 0) digit += a.charAt(al-i-1) - '0';
            if (bl - i - 1 >= 0) digit += b.charAt(bl-i-1) - '0';
            res.append(digit%2);
            carry = digit/2;
            i++;
        }
        if (carry == 1) res.append(1);
        return res.reverse().toString();
    }
}