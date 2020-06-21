// FB
class MissingElementInSortedArray {

//    A = [4,7,9,10], K = 3
//    A = [4,7,8,10], K = 3
    
    public int missingElement(int[] nums, int k) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            // if range of number in left >= missing numbers. Move right pointer
            if (nums[mid] - nums[0] - 1 >= k + (mid - 1)) {
                right = mid;
            } else {
                // else must be in the right
                left = mid + 1;
            }
        }
        // at this point left pointer is out of missing K range. [0, left] should include K missing number
        // move pointer to left - 1, and plus # of elements on the left side array.
        return nums[left-1] + k - (nums[left-1] - nums[0] - (left-1));
    }
}