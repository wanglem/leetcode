import java.util.Arrays;

class NextPermutation {

    public void nextPermutation(int[] nums) {
        for (int i = nums.length - 1; i >0; i--) {
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] > nums[j]) {
                    swap(i, j, nums);
                    return;
                }
            }
        }
        Arrays.sort(nums);
    }

    private void swap(int i, int j, int[] nums) {
        int tmp = nums[j];
        nums[j] = nums[i];
        nums[i] = tmp;
    }
}