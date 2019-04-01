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
}