import java.util.Collections;
import java.util.Stack;

// Google
class SplitArrayLargestSum {

    /*
        f[i][j] means largestSum when split nums[0..i] to j parts.
        f[i][j] = min(f[k][j-1], nums[k]+nums[k+1]+...+nums[i]) where 0 <= k < i
        Note:
            1. i == nums.length+1, j = m+1
            2. first row is Infinity - split 0 element into i parts
            3. first column is Infinity - split j element into 0 part
            4. f[0][0] = 0. Initialize.
     */
    private int splitArrayDP(int[] nums, int m) {
        int n = nums.length;
        int[][] splitMax = new int[n+1][m+1];
        for (int i = 0; i < n+1; i++) {
            for (int j = 0; j < m+1; j++) {
                splitMax[i][j] = Integer.MAX_VALUE;
            }
        }
        splitMax[0][0] = 0;
        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < m+1; j++) {
                for (int k = 0; k < i; k++) {
                    splitMax[i][j] = Math.min(splitMax[i][j], Math.max(splitMax[k][j-1], sumSubArr(nums, k, i)));
                }
            }
        }
        return splitMax[n][m];
    }

    private int sumSubArr(int[] nums, int start, int end) {
        int sum = 0;
        while (start != end) {
            sum += nums[start++];
        }
        return sum;
    }

    private int maxSum = Integer.MAX_VALUE;
    public int splitArray(int[] nums, int m) {
        tryAll(nums, m, 0, new Stack<>());
        return maxSum;
    }

    private void tryAll(int[] nums, int m, int start, Stack<Integer> splitSum) {
        if (splitSum.size() == m && start != nums.length) return;
        if (start == nums.length) {
            int curMax = Collections.max(splitSum);
            maxSum = Math.min(curMax, maxSum);
            return;
        }
        int numElemCanTry = nums.length - start - (m - splitSum.size() - 1);
        int curSum = 0;
        splitSum.push(curSum);
        for (int i = start; i < start + numElemCanTry; i++) {
            curSum += nums[i];
            splitSum.pop();
            splitSum.push(curSum);
            tryAll(nums, m, i+1, splitSum);
        }
        splitSum.pop();
    }
}