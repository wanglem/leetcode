import java.util.*;

class MergeIntervals {

    public List<Interval> merge(List<Interval> intervals) {
        intervals.sort(Comparator.comparingInt(x -> x.start));
        LinkedList<Interval> res = new LinkedList<>();
        res.addLast(new Interval(intervals.get(0).start, intervals.get(0).end));
        for (Interval I : intervals) {
            if (I.start >= res.getLast().end) {
                // merge
                res.getLast().end = I.end;
            } else {
                // not merge
                res.add(I);
            }
        }
        return res;
    }
}