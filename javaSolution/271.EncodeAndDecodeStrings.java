import java.util.ArrayList;
import java.util.List;

class EncodeAndDecodeStrings {
    private char SEP = '#';
    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuilder res = new StringBuilder();

        for (String str: strs) {
            int len = str.length();
            res.append(len);
            res.append(SEP);
            res.append(str);
        }
        return res.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> res = new ArrayList<>();
        int i = 0;
        int curLen = 0;
        while (i < s.length()) {
            char c = s.charAt(i);
            if (c == SEP) {
                if (i+1+curLen > s.length()) {
                    throw new RuntimeException("Invalid 1");
                }
                res.add(s.substring(i+1, i+1+curLen));
                i = i+1+curLen;
                curLen = 0;
            } else if (c < '0' || c > '9') {
                throw new RuntimeException("Invalid 2");
            } else {
                curLen *= 10;
                curLen += c - '0';
                i++;
            }
        }
        return res;
    }
}