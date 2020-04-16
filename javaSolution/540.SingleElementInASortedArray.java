class SingleElementInASortedArray {
    public int singleNonDuplicate(int[] nums) {
        if (nums.length == 0) return 0;
        for (int i = 1; i < nums.length; i+=2) {
            if (nums[i-1] != nums[i]){
                return nums[i-1];
            }
        }

        return nums.length > 1 ? nums[nums.length-1] : nums[0];
    }

    public int singleNonDuplicateBS(int[] nums) {
        int lo = 0, hi = nums.length;

        while (lo < hi) {
            int mid = ((hi - lo) + lo) / 2;
            if (mid == 0) return nums[0];
            if (mid == nums.length - 1) return nums[nums.length-1];
            if (mid % 2 == 0) {
                if (nums[mid] != nums[mid-1]) {
                    hi = mid;
                } else {
                    lo = mid + 1;
                }
            } else {
                if (nums[mid] != nums[mid+1]) {
                    lo = mid + 1;
                } else {
                    hi = mid;
                }
            }
        }

        return nums[lo-1];
    }
}