import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

// sorting is nlogn
// idea for nlogk is to keep the heap (PriorityQueue) size to k.
class TopKFrequentElements {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();

        for (int n: nums) {
            freq.put(n, freq.getOrDefault(n, 0) + 1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> topk = new PriorityQueue<>(
                Comparator.comparingInt(Map.Entry::getValue));

        for (Map.Entry<Integer, Integer> e: freq.entrySet()) {
            if (topk.size() == k && topk.peek().getValue() < e.getValue()) {
                topk.poll();
            }
            if (topk.size() < k) {
                topk.offer(e);
            }
        }
        int[] res = new int[k];
        int i = 0;
        for (Map.Entry<Integer, Integer> e: topk) {
            res[i++] = e.getKey();
        }

        return res;
    }
}