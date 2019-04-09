import java.util.Arrays;
import java.util.Collections;

//fb
// ez
class LongestContinousIncreasingSubsequence {
    public int findLengthOfLCIS(int[] nums) {
        if (nums.length == 0) return 0;
        int longestSeq = 1, longSeq = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i-1]) {
                longSeq++;
            } else {
                longSeq = 1;
            }
            longestSeq =Math.max(longestSeq, longSeq);
        }
        return longestSeq;
    }
}