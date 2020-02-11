class SortColors {
    // [1,2,0]
    // think about two pass! one pass is so tricky.
    public void sortColors(int[] nums) {
        int left = 0, right = nums.length-1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                swap(nums, i, left);
                left++;
            }
        }
        for (int j = nums.length-1; j >= 0; j--) {
            if (nums[j] == 2) {
                swap(nums, j, right);
                right--;
            }
        }
    }
    private void swap(int[] A, int i, int j) {
        int tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }
}