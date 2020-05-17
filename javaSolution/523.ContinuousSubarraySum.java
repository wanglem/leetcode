import java.util.HashMap;
import java.util.Map;

// subarray sum to n*k where n >= 0
class ContinuousSubarraySum {
    public boolean checkSubarraySum(int[] nums, int k) {
        int[] sums = new int[nums.length];
        sums[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sums[i] = sums[i-1] + nums[i];
        }
        for(int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                int sum = sums[j] - sums[i] + nums[i];
                if (sum == 0) {
                    return true;
                }
                if (k != 0 && sum >= k && sum % k == 0) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean checkSubarraySumOn(int[] nums, int k) {
        Map<Integer, Integer> sumToIndex = new HashMap<>();
        sumToIndex.put(0, -1);
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (k != 0) sum %= k;
            if (sumToIndex.containsKey(sum)) {
                if (i - sumToIndex.get(sum) > 1) return true;
            } else {
                sumToIndex.put(sum, i);
            }
        }

        return false;
    }
}