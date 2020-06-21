// FB
class SearchInRotateArray {
    public int search(int[] nums, int target) {
        int pivot = findSmallestIndex(nums);
        // return Math.max(bsRange(nums, pivot, nums.length, target), bsRange(nums, 0, pivot, target));
        if (nums.length == 0) return -1;
        if (nums[nums.length-1] < target) {
            return bsRange(nums, 0, pivot, target);
        } else {
            return bsRange(nums, pivot, nums.length, target);
        }
    }
    private int bsRange(int[] nums, int start, int end, int target) {
        while (start < end) {
            int mid = (start + end) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if(nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return -1;
    }
    // same to binary search, lo will be smallest index
    private int findSmallestIndex(int[] nums) {
        int lo = 0, hi = nums.length - 1;
        while (lo < hi) {
            int mid = (lo + hi)/2;
            if (nums[mid] > nums[hi]) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }
}