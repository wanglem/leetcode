// 327. count of range sum
// naive: precompute prefix range sum, two for loop to count all ranges
// this would require O(n^2)

// improved:
// sort precomputed sum range, with sum and original index (sum, i)
// for each element, bsearch lower and upper bound index after it, all range
// begie with that element should fall under that range! [supLower, supUpper]
// question is? how to make sure no outer range within [supLower, supUpper], say
// k > supUpper or k < supLower. 
// Of course we can scan through and take them out, but it's O(m). instead, we
// can partition precompuated sum range into half, for each index in first half,
// bsearch the second half!
// [0 - n], compuate range sum postRangeSum = [0, n], postRangeSum.sort()
// for i in [0 - n/2], find index of lower upper bound (guaranteed range)
public int countRangeSum(int[] nums, int lower, int upper) {
    if (nums == null || nums.length == 0 || lower > upper) {
        return 0;
    }
    return countRangeSumSub(nums, 0, nums.length - 1, lower, upper);
}

private int countRangeSumSub(int[] nums, int l, int r, int lower, int upper) {
    if (l == r) {
        return nums[l] >= lower && nums[r] <= upper ? 1 : 0;  // base case
    }

    int m = l + (r - l) / 2;
    long[] arr = new long[r - m];  // prefix array for the second subarray
    long sum = 0;
    int count = 0;

    for (int i = m + 1; i <= r; i++) {
        sum += nums[i];
        arr[i - (m + 1)] = sum; // compute the prefix array
    }

    Arrays.sort(arr);  // sort the prefix array

    // Here we can compute the suffix array element by element.
    // For each element in the suffix array, we compute the corresponding
    // "insertion" indices of the modified bounds in the sorted prefix array
    // then the number of valid ranges sums will be given by the indices difference.
    // I modified the bounds to be "double" to avoid duplicate elements.
    sum = 0;
    for (int i = m; i >= l; i--) {
        sum += nums[i];  
        count += findIndex(arr, upper - sum + 0.5) - findIndex(arr, lower - sum - 0.5);
    }

    return countRangeSumSub(nums, l, m, lower, upper) + countRangeSumSub(nums, m + 1, r, lower, upper) + count;
}

// binary search function
private int findIndex(long[] arr, double val) {
    int l = 0, r = arr.length - 1, m = 0;

    while (l <= r) {
        m = l + (r - l) / 2;

        if (arr[m] <= val) {
            l = m + 1;
        } else {
            r = m - 1;
        }
    }

    return l;
}