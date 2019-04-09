// you can jump maximum of nums[i] at i, try reach the end
class JumpGame {

    public int jump(int[] nums) {
        if (nums.length == 0) return 0;
        int jumpCount = 1;
        int i = 0;
        while (i < nums.length) {
            int nextJumpRange = nums[i];
            if (nextJumpRange == 0) {
                return -1; // cannot reach to end
            }
            i = findFarthestStep(i, i + nextJumpRange, nums);
            if (i >= nums.length - 1) break;
            jumpCount++;
        }
        return jumpCount;
    }

    private int findFarthestStep(int start, int end, int[] nums) {
        int farthest = 0;
        int jumpTo = start;
        for (int i = start+1; i <= end; i++) {
            int curFarthest = nums[start] + start + 1;
            if (farthest < curFarthest) jumpTo = i;
            farthest = Math.max(curFarthest, farthest);
        }
        return jumpTo;
    }
}