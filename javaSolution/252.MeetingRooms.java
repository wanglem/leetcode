import java.util.Arrays;

class MeetingRoom {
    public class Interval {
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }
    }
    public boolean canAttendMeetings(Interval[] intervals) {
        if (intervals.length == 0) return true;
        Arrays.sort(intervals, (x, y) -> x.start - y.start);
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i].start < intervals[i-1].end) {
                return false;
            }
        }
        return true;
    }
}