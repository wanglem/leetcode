import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class RestoreIPAddresses {
    public List<String> restoreIpAddresses(String s) {

        return restore(s, 0, 1);
    }

    private List<String> restore(String s, int start, int part) {
        if (part == 4) {
            String sub = s.substring(start);
            if (isValid(sub)) return Collections.singletonList(sub);
            return Collections.emptyList();
        }

        List<String> res = new ArrayList<>();
        for (int i = start+1; i< s.length();i++) {
            String sub = s.substring(start, i);
            if (!isValid(sub)) {
                return res;
            }

            List<String> children = restore(s, i, part+1);
            for (String child: children) {
                res.add(sub + "." + child);
            }
        }
        return res;
    }

    private boolean isValid(String i) {
        if ((i.length() > 1 && i.startsWith("0")) || i.length() > 3) return false;
        int val = Integer.parseInt(i);
        return val >= 0 && val <= 255;
    }
}