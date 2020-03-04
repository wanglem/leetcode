import java.util.Map;
import java.util.TreeMap;

class MyCalendarI {
    private TreeMap<Integer, Integer> booked;
    public MyCalendarI() {
        booked = new TreeMap<>();
    }

    public boolean book(int start, int end) {
        Map.Entry<Integer, Integer> floor = booked.floorEntry(start);
        Map.Entry<Integer, Integer> ceiling = booked.ceilingEntry(start);
        if ((floor == null || floor.getValue() <= start) &&
                (ceiling == null || ceiling.getKey() >= end)) {
            booked.put(start, end);
            return true;
        }
        return false;
    }
}