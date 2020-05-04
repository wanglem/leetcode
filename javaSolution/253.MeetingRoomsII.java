import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**

 */
class MeetingRoomsII {

    public int minMeetingRooms(Interval[] intervals) {
         if (intervals.length == 0) return 0;
         Arrays.sort(intervals, Comparator.comparingInt(x -> x.start));
         PriorityQueue<Interval> allocator = new PriorityQueue<>(Comparator.comparingInt(x -> x.end));
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