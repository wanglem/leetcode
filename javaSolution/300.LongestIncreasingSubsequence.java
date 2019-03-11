import java.util.Arrays;

class LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) return 0;
        int[] longestAtIndex = new int[nums.length];
        int longest = 1;
        Arrays.fill(longestAtIndex, 1);
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    longestAtIndex[i] = Math.max(longestAtIndex[i], longestAtIndex[j] + 1);
                    longest = Math.max(longest, longestAtIndex[i]);
                }
            }
        }
        return longest;
    }
}