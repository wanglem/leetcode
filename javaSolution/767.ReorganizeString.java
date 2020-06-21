import java.util.Comparator;
import java.util.PriorityQueue;


// FB
// re-order so no two same chars are neighbors
// Priority Queue. Greedy.
class ReorganizeString {
    
    public String reorganizeString(String S) {
        int[] freq = new int[256];
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(x -> -x[1]));
        for (char c: S.toCharArray()) {
            freq[c]++;
        }
        for (int i = 0; i < freq.length; i++) {
            if (freq[i] > 0) {
                pq.offer(new int[]{i, freq[i]});
            }
        }

        StringBuilder sb = new StringBuilder();
        int[] last = null;
        while (!pq.isEmpty()) {
            int[] next = pq.poll();
            sb.append((char)next[0]);
            if (last != null && last[1] > 0) {
                pq.offer(last);
            }
            next[1]--;
            last = next;
        }

        if (last != null && last[1] > 0) return "";
        return sb.toString();
    }
}