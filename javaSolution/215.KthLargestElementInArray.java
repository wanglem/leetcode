import java.util.Collections;
import java.util.PriorityQueue;

/*
    difference of using minHeap v.s. maxHeap is time complexity at extreme case.
    when k is very close to n, or k is much smaller than n (constant k).
    heap(O(NlogK)) v.s. quick selection (best O(n), avg O(nLogn), worst O(n^2))
 */
// FB
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

    public int quickSelectKthLargest(int[] nums, int k) {
        int kSmallest = nums.length - k;
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int pivotIndex = partition(nums, left, right);
            if (pivotIndex == kSmallest) return nums[pivotIndex];
            else if (pivotIndex > kSmallest) right = pivotIndex-1;
            else left = pivotIndex+1;
        }
        return nums[left];
    }


    private int partition(int[] A, int left, int right) {
        int pivot = A[right];
        int pivotIndex  = left;
        for (int i = left; i < right; i++) {
            if (A[i] < pivot) {
                swap(A, i, pivotIndex++);
            }

        }
        swap(A, pivotIndex, right);
        return pivotIndex;
    }

    private void swap(int[] A, int i, int j) {
        int tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }
}