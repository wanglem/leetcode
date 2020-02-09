class FindFirstLastPositionInSortedArray {
    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) return new int[]{-1, -1};
        return new int[]{findLeft(nums, target), findRight(nums, target)};
    }

    private int findLeft(int[] nums, int target) {
        int lo = 0, hi = nums.length;
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (nums[mid] >= target) {
                hi = mid;
            } else {
                lo= mid + 1;
            }
        }
        return lo != nums.length && nums[lo] == target ? lo : -1;
    }
    private int findRight(int[] nums, int target) {
        int lo = 0, hi = nums.length;
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (nums[mid] <= target) {
                lo= mid + 1;
            } else {
                hi = mid;
            }
        }
        if (lo == 0) {
            return nums[lo] == target ? lo: -1;
        }
        return nums[lo-1] == target ? lo - 1 : -1;
    }
}