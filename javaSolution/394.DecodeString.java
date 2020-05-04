class DecodeString {
    public String decodeString(String s) {
        int start = 0;
        StringBuilder res = new StringBuilder();
        while (start < s.length()) {
            StringBuilder buf = new StringBuilder();
            start = decodeSub(start, s, buf) + 1;
            res.append(buf.toString());
        }
        return res.toString();
    }
    

    private int decodeSub(int start, String s, StringBuilder buf) {

        while (start < s.length() && Character.isLetter(s.charAt(start))) {
            buf.append(s.charAt(start++));
        }
        if (buf.length() != 0) return start - 1;

        int k = 0;
        StringBuilder str = new StringBuilder();
        while (s.charAt(start) != '[') {
            k *= 10;
            k += Character.getNumericValue(s.charAt(start));
            start++;
        }
        start++;
        while (s.charAt(start) != ']') {
            if (Character.isDigit(s.charAt(start))) {
                StringBuilder subBuf = new StringBuilder();
                start = decodeSub(start, s, subBuf);
                str.append(subBuf.toString());
            } else {
                str.append(s.charAt(start));
            }
            start++;
        }
        String toAppend = str.toString();
        while (k-- > 0) {
            buf.append(toAppend);
        }
        return start;
    }
}