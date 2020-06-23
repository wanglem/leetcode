import java.util.Deque;
import java.util.LinkedList;

/*
    Calculate pre-sum array, sum[i] == sum[0] + .. + sum[i]
    Maintain a Queue records increasing sequence of pre-sum values.
        If decreasing: sum[i+1] <= sum[i], then sum[i] with previous whatever index is definitely shorter.
    Queue is increasing, pop first can get minLength if sum >= K.
 */

// This can include both positive/negative numbers.
// only positive use two pointers is sufficient. See 209.
class ShortestSubarraywithSumatLeastK {
    public int shortestSubarray(int[] A, int K) {

        Deque<Integer> monoi = new LinkedList<>();
        int[] sum = new int[A.length+1];
        for (int i = 0; i < A.length; i++) {
            sum[i+1] = sum[i] + A[i];
        }

        int shortest = Integer.MAX_VALUE;
        for (int i = 0; i < A.length+1; i++) {

            while (!monoi.isEmpty() && sum[i] <= sum[monoi.peekLast()]) {
                monoi.pollLast();
            }
            while (!monoi.isEmpty() && sum[i] >= sum[monoi.peekFirst()] + K) {
                shortest = Math.min(shortest, i - monoi.pollFirst());
            }

            monoi.offer(i);
        }

        return shortest == Integer.MAX_VALUE ? -1 : shortest;
    }
}