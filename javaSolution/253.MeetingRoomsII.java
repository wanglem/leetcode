import java.util.Arrays;
import java.util.PriorityQueue;

/**

 */
class MeetingRoomsII {
     public class Interval {
         int start;
         int end;
         Interval() { start = 0; end = 0; }
         Interval(int s, int e) { start = s; end = e; }
     }
    public int minMeetingRooms(Interval[] intervals) {
         if (intervals.length == 0) return 0;
         Arrays.sort(intervals, (x, y) -> x.start - y.start);
         PriorityQueue<Interval> allocator = new PriorityQueue<>((x, y) -> Integer.compare(x.end, y.end));
         allocator.offer(intervals[0]);
         int minRoom = 1;
         for (int i = 1; i < intervals.length; i++) {
             if (intervals[i].start >= allocator.peek().end) {
                 allocator.poll();
             }
             allocator.offer(intervals[i]);
             minRoom = Math.max(minRoom, allocator.size());
         }
         return minRoom;
    }
}