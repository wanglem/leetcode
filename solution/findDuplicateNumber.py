# 287. find the duplicate number
# array contains 1-n inclusive, one number occurs two or more times
# basically check the sum and count of one side from partition
class Solution(object):
    def findDuplicate(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        lo, hi = 1, len(nums)
        while lo < hi:
            pivot = (hi+lo)/2
            lsum = 0
            lcount = 0
            for i in xrange(len(nums)):
                if nums[i] >= lo and (nums[i] - pivot) <= 0:
                    lsum += nums[i]
                    lcount += 1
            if lcount > pivot-lo+1:
                hi  = pivot
            elif lsum == (lo+pivot)*(pivot-lo+1)/2 or lcount < pivot-lo+1:
                lo = pivot + 1
            else:
                hi = pivot
        return lo

s = Solution()
print s.findDuplicate([4,4,16,3,12,18,11,19,10,17,4,15,4,9,4,13,4,4,1,4])