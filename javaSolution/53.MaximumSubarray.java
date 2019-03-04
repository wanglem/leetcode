class MaximumSubarray {

    public int maxSubArray(int[] nums) {
        if (nums.length == 0) return 0;
        int maxVal = nums[0];
        int curMax = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (curMax < 0 && nums[i] >= curMax) {
                curMax = nums[i];
            } else {
                curMax += nums[i];
            }
            maxVal = Math.max(maxVal, curMax);
        }
        return maxVal;
    }
}