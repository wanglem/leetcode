class HouseRobberII {
    /*
        For house 1 - n, if 1 and n are adjacent, then either rob '1 -> (n-1)" or "2 -> n";
     */
    public int rob(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        return Math.max(
                robSub(nums, 0, nums.length-1),
                robSub(nums, 1, nums.length));
    }

    private int robSub(int[] A, int start, int end) {
        int[] maxRob = new int[A.length];
        for (int i = start; i < end; i++) {
            if (i == start) maxRob[i] = A[i];
            if (i == start + 1) maxRob[i] = Math.max(maxRob[i-1], A[i]);
            if (i >= start + 2) maxRob[i] = Math.max(maxRob[i-2] + A[i], maxRob[i-1]);
        }
        return maxRob[end-1];
    }
}