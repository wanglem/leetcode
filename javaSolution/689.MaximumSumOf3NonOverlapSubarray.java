//fb
// find 3 integers sum max of non-overlapping subarray each size with k
/*
    1. Basically find [a, b, c]. loop array and say index `i` build the middle one - b
    2. then find max from [0, i] as a, [i+k, n] as c.
    3. build presum array and post sum array to speed up step 2.
 */
class MaximumSumOf3NonOverlapSubarray {
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int kArrSize = nums.length - k + 1;
        int[] ksum = new int[kArrSize];
        int[] ksumNonDecreasingMinIndex = new int[kArrSize];
        int[] ksumNonIncreasingMinIndex = new int[kArrSize];
        for (int i = 0; i < k; i++) {
            ksum[0] += nums[i];
        }
        for (int i = 1; i < kArrSize; i++) {
            ksum[i] = ksum[i-1] - nums[i-1] + nums[i+k-1];
        }
        for (int i = 1; i < kArrSize; i++) {
            ksumNonDecreasingMinIndex[i] = ksum[i-1] >= ksum[i] ? ksumNonDecreasingMinIndex[i-1]: i;
        }
        for (int i = kArrSize-2; i >= 0; i--) {
            ksumNonIncreasingMinIndex[i] = ksum[i] >= ksum[i+1] ? i: i+1;
        }
        ksumNonIncreasingMinIndex[kArrSize-1] = kArrSize-1;
        /*
               nums: 0 - n. return [a,b,c]
               `b` is middle index, so k <= b <= n-k
               so `a` can be chose from [0, b-k], inclusive
               so `c` can be chose from [b+k, n-1], inclusive
         */
        int[] res = new int[]{0, k, k+k};
        for (int i = k; i <= nums.length-2*k; i++) {
            if (ksum[res[0]] + ksum[res[1]]  +ksum[res[2]] < ksum[i] + ksum[ksumNonDecreasingMinIndex[i-k]] + ksum[ksumNonIncreasingMinIndex[i+k]]) {
                res[0] = ksumNonDecreasingMinIndex[i-k];
                res[1] = i;
                res[2] = ksumNonIncreasingMinIndex[i+k];
            }
        }
        return res;
    }
}