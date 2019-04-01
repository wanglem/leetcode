import java.util.ArrayDeque;
import java.util.Deque;

/*
    Keep a queue to track k window
    when offer `m` to queue, keep popping right when `m` is bigger. This way `m` is always biggest in k window.
 */
class SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> maxInK = new ArrayDeque<>();
        int[] res = new int[nums.length - k + 1];
        for (int i = 0; i < nums.length; i++) {
            while (!maxInK.isEmpty() && nums[i] >= nums[maxInK.peekLast()]) {
                maxInK.poll();
            }
            maxInK.offer(i);
            if(maxInK.peekFirst() < i - k + 1) {
                maxInK.poll();
            }
            if (k == i - 1) {
                res[i-1-k] = nums[maxInK.peek()];
            }
        }
        return res;
    }
}