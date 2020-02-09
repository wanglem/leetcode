import java.util.Arrays;

class NextPermutation {

    public void nextPermutation(int[] nums) {
        for (int i = nums.length-1; i > 0; i--) {
            if (nums[i] <= nums[i-1]) continue;
            for (int j = i; j < nums.length; j++) {
                if (j == nums.length-1 || nums[j] < nums[i-1]) {
                    swap(nums, i-1, j);
                    Arrays.sort(nums, i, nums.length);
                    return;
                }
            }
        }
        Arrays.sort(nums);
    }
    private void swap(int[] nums, int x, int y) {
        int tmp = nums[x];
        nums[x] = nums[y];
        nums[y] = tmp;
    }
}