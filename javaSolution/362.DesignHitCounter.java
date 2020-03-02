import java.util.LinkedList;

class DesignHitCounter {
    private class SecUnit {
        int timestamp;
        int count;
        SecUnit(int timestamp) {
            this.timestamp = timestamp;
            count = 1;
        }
    }

    private LinkedList<SecUnit> window;
    private int count;
    /** Initialize your data structure here. */
    public DesignHitCounter() {
        window = new LinkedList<>();
        count = 0;
    }

    /** Record a hit.
     @param timestamp - The current timestamp (in seconds granularity). */
    public void hit(int timestamp) {
//        enforceWindow(timestamp);
        if (window.size() > 0 && window.getLast().timestamp == timestamp) {
            window.getLast().count++;
        } else {
            window.add(new SecUnit(timestamp));
        }
        count++;
    }

    /** Return the number of hits in the past 5 minutes.
     @param timestamp - The current timestamp (in seconds granularity). */
    public int getHits(int timestamp) {
        enforceWindow(timestamp);
        return count;
    }

    private void enforceWindow(int current) {
        while (window.size() != 0 && current - window.getFirst().timestamp >= 300) {
            count -= window.removeFirst().count;
        }
    }
}