class FirstMissingPositive {
    // place any value < nums.length into nums array. Then loop to find any "empty" spot.
    public int firstMissingPositive(int[] nums) {
        int len = nums.length;
        if (len == 0) return 1;
        int i = 0;
        while (i < len) {
            if (nums[i] < len+1 && nums[i] > 0 && nums[nums[i]-1] != nums[i]) {
                int tmp = nums[i];
                nums[i] = nums[tmp-1];
                nums[tmp-1] = tmp;
            } else {
                i++;
            }
        }
        for (int j = 0; j < len; j++) {
            if (nums[j]-1 != j) {
                return j+1;
            }
        }
        return len+1;
    }

    public int firstMissingPositive2(int[] nums) {
        int len = nums.length;
        if (len == 0) return 1;
        int i = 0;
        while (i < len) {
            int j = i;
            int tmp = nums[j];
            // [1,3,4,5]
            while (tmp >0 && tmp <= len && j != tmp - 1 && tmp != nums[tmp-1]) {
                int tmpNext = nums[tmp-1];
                nums[tmp-1] = tmp;
                j = tmp-1;
                tmp = tmpNext;
            }
            i++;
        }
        for (int j = 0; j < len; j++) {
            if (nums[j]-1 != j) {
                return j+1;
            }
        }
        return len+1;
    }
}