import java.util.*;

class FindKClosestElements {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int pos = Arrays.binarySearch(arr, x);
        if (pos < 0) pos = -pos - 1;
        int left = Math.max(0, pos - k);
        int right = Math.min(arr.length-1, pos + k);

        List<Integer> res = new ArrayList<>();
        while (right - left > k - 1) {
            if (x - arr[left] > arr[right] - x) {
                left++;
            } else {
                right--;
            }
        }

        while (left <= right) {
            res.add(arr[left++]);
        }
        return res;
    }
}