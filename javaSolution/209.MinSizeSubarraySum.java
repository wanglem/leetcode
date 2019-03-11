class MinSizeSubarraySum {
    public int minSubArrayLen(int s, int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int i = 0;
        int minSize = Integer.MAX_VALUE;
        int sum = 0;
        for (int j = 0; j < nums.length; j++) {
            sum += nums[j];
            while (sum >= s) {
                minSize = Math.min(minSize, j - i + 1);
                if (i == j) break;
                sum -= nums[i];
                i++;
            }
        }
        return minSize < Integer.MAX_VALUE ? minSize : 0;
    }
}