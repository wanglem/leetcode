# 215. find Kth largest in an unsorted array, quick selection (quick sort methodology)
import random as rd
class Solution(object):
    def findKthLargest(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: int
        """
        lo, hi = 0, len(nums) - 1
        m = self.partition(nums, lo, hi)
        while m != k-1:
            if m < k: lo = m
            else:     hi = m
            m = self.partition(nums, lo, hi)

        return nums[m]

    
    def partition(self, nums, lo, hi):
        # return location of pivot index
        if lo >= hi: return lo
        
        t = rd.randrange(lo, hi+1)
        nums[t], nums[hi] = nums[hi], nums[t] # move to pivot to end
        pivot  = nums[hi]
        l, r = lo, lo
        while r < hi:
            if nums[r] < pivot:
                nums[l], nums[r] = nums[r], nums[l]
                l += 1
            r += 1
        nums[l], nums[hi] = nums[hi], nums[l]
        return l

s = Solution()
n = [0,8,5,7,4,3,9,1,2,6]
print s.findKthLargest(n, 5)
