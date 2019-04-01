import java.util.Collections;
import java.util.PriorityQueue;

/*
    difference of using minHeap v.s. maxHeap is time complexity at extreme case.
    when k is very close to n, or k is much smaller than n (constant k).
 */
class KthLargestElementInArray {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(nums.length, Collections.reverseOrder());
        for (int n : nums) {
            maxHeap.offer(n);
        }
        int maxK = 0;
        while (k-- != 0) {
            maxK = maxHeap.poll();
        }
        return maxK;
    }
}