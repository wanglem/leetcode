import java.util.Arrays;

class MaximumProductofTwoElementsinanArray {
    public int maxProduct(int[] nums) {
        Arrays.sort(nums);
        int m = nums.length;
        return Math.max((nums[0]-1)*(nums[1]-1), (nums[m-1]-1)*(nums[m-2]-1));
    }
}