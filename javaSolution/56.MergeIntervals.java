import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class MergeIntervals {
    public class Interval {
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }
    }
    public List<Interval> merge(List<Interval> intervals) {
        intervals.sort(Comparator.comparing((Interval i) -> i.start));
        ArrayList<Interval> merged = new ArrayList<>();
        if (intervals.size() == 0) return merged;
        merged.add(intervals.get(0));
        for (int i = 1; i < intervals.size(); i++) {
            Interval lastMerged = merged.get(merged.size() - 1);
            Interval cur =  intervals.get(i);
            if (lastMerged.end >= cur.start) {
                lastMerged.end = Math.max(lastMerged.end, cur.end);
            } else {
                merged.add(cur);
            }
        }
        Collections.binarySearch(intervals, Comparator.comparing((Interval i) -> i.start));
        return merged;
    }
}