import java.util.Arrays;

class ValidTriangleNumber {
    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int count = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] <= 0) continue;
            int k = i+2;
            // don't have to check  && k < nums.length in for loop
            // if k reaches end of nums, then all following i,j combination should work.
            for (int j = i+1; j < nums.length-1; j++) {
                while (k < nums.length && nums[i]+nums[j] > nums[k]) k++;
                count += k - j - 1;
            }
        }
        return count;
    }
}