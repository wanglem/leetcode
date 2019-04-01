import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class SubarraySumToK {
    public int subarraySum(int[] nums, int k) {
        return sumArrayTwoLoop(nums, k);
    }

    /*
        solution 1:
            prefix sum array sumArr[]
            try all possible combination of i, j where i < j.
     */
    private int sumArrayTwoLoop(int[] nums, int k) {
        int count = 0;
        int[] sumArr = new int[nums.length+1];
        for (int i = 1; i <= nums.length; i++) {
            sumArr[i] += sumArr[i-1] + nums[i-1];
        }

        for (int i = 1; i < sumArr.length; i++) {
            for (int j = 0; j < i; j++) {
                if (sumArr[i] - sumArr[j] == k) {
                    count++;
                }
            }
        }
        return count;
    }

    /*
        solution 2
            1. loop nums, sum each element, each loop get `curSum`.
            2. HashMap store curSum and num of curSum occurrence.
            3. for each `curSum`, see any key in hashmap has curSum - key == k
                3a. this means a subarray from indices of k -> curSum exists for `map.value` times
     */
    private int hashMapSumCount(int[] nums, int k) {
        int curSum = 0, count = 0;
        Map<Integer, Integer> preSums = new HashMap<>();
        preSums.put(0, 1);
        for (int n : nums) {
            curSum += n;
            if (preSums.containsKey(curSum - k)) {
                count += preSums.get(curSum-k);
            }
            preSums.put(curSum, preSums.getOrDefault(curSum, 0) + 1);
        }
        return count;
    }
}