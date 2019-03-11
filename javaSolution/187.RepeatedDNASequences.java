import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

class RepeatedDNASequences {
    public List<String> findRepeatedDnaSequences(String s) {
        HashSet<String> seen = new HashSet<>(), res = new HashSet<>();

        for (int i = 0; i < s.length() - 9; i++) {
            String seq = s.substring(i, i+10);
            if (seen.contains(seq)) {
                res.add(seq);
            } else {
                seen.add(seq);
            }
        }
        return new ArrayList<>(res);
    }
}