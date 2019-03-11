class HouseRobber {
    public int rob(int[] nums) {
        if (nums.length == 0) return 0;
        int[] maxRobbed = new int[nums.length];
        for (int i = 0; i < nums.length; i++){
            if (i == 0) {
                maxRobbed[i] = nums[0];
            }
            if (i == 1){
                maxRobbed[i] = Math.max(nums[0], nums[1]);
            }
            if (i >= 2) {
                maxRobbed[i] = maxRobbed[i-2] + nums[i];
            }
            if (i >= 3) {
                maxRobbed[i] = Math.max(maxRobbed[i], maxRobbed[i-3] + nums[i]);
            }
        }

        if (nums.length == 1) {
            return maxRobbed[0];
        }
        return Math.max(maxRobbed[nums.length-1], maxRobbed[nums.length-2]);
    }
}