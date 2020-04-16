import java.util.*;

class Resurrection {

    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        List<int[]> res = new ArrayList<>();
        for (int[] interval: intervals) {
            if (res.isEmpty()) res.add(interval);
            int[] last = res.get(res.size()-1);
            if (last[1] >= interval[0]) {
                last[1] = Math.max(last[1], interval[1]);
            } else {
                res.add(interval);
            }
        }

        return res.toArray(new int[res.size()][]);
    }
    
}
