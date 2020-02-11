class JumpGame{
    // bottom back, backwards. If can jump to i, then can jump to i-k.
    public boolean canJump(int[] nums) {
        if (nums.length == 0) return true;
        int canReach = nums.length-1;
        for (int i = nums.length-2; i>=0; i--) {
            if (canReach - i <= nums[i]) canReach = i;
        }
        return canReach == 0;
    }
}