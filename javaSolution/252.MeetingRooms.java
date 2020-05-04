import java.util.Arrays;
import java.util.Comparator;

class MeetingRoom {

    public boolean canAttendMeetings(Interval[] intervals) {
        if (intervals.length == 0) return true;
        Arrays.sort(intervals, Comparator.comparingInt(x -> x.start));
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i].start < intervals[i-1].end) {
                return false;
            }
        }
        return true;
    }
}