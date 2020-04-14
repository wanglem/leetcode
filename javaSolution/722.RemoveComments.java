import java.util.ArrayList;
import java.util.List;

// MSFT
// SO BAD. So many edge cases. I submitted like a million times.
class RemoveComments {
    public List<String> removeComments(String[] source) {
        List<String> res = new ArrayList<>();
        boolean inBlock = false;
        StringBuilder buf = new StringBuilder();

        for (String line: source) {
            if (!inBlock && buf.length() > 0) {
                res.add(buf.toString());
                buf = new StringBuilder();
            }
            int i = 0;
            while (i < line.length()) {
                if (!inBlock && i+1 < line.length() && line.charAt(i) == '/' && line.charAt(i+1) == '/') {
                    break;
                } else if (!inBlock && i+1 < line.length() && line.charAt(i) == '/' && line.charAt(i+1) == '*') {
                    i+=2;
                    inBlock = true;
                    continue;
                } else if (inBlock && i+1 < line.length() && line.charAt(i) == '*' && line.charAt(i+1) == '/') {
                    inBlock = false;
                    i += 2;
                    continue;
                }
                if (!inBlock) {
                    buf.append(line.charAt(i));
                }
                i++;
            }
        }
        if (buf.length() > 0) {
            res.add(buf.toString());
        }
        return res;
    }
}