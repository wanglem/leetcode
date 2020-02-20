import java.util.HashSet;
import java.util.Set;

class ShortestWayToFormString {
    public int shortestWay(String source, String target) {
        int start = 0;
        int ways = 0;
        while (start < target.length()) {
            int newStart = match(source, target, start);
            if (start == newStart) return -1;
            start = newStart;
            ways++;
        }
        return ways;
    }

    private int match(String source, String target, int start) {
        for (int i = 0; i < source.length(); i++) {
            if (start < target.length() && target.charAt(start) == source.charAt(i)){
                start++;
            }
        }

        return start;
    }
}