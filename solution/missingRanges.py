# 163. find missing ranges
# not hard to understand, but more about clean code and how to  deal with edge cases
# 1. higher values if end is less than upper, so no need post processing
# 2. break after processed, not before
# 3. attention to range start increase
class Solution(object):
    def findMissingRanges(self, nums, lower, upper):
        """
        :type nums: List[int]
        :type lower: int
        :type upper: int
        :rtype: List[str]
        """
        if not nums: return [self.getRange(lower, upper)]
        start = lower
        if nums[-1] < upper:
            nums.append(upper+1)
        result = []
        for i in xrange(len(nums)):
            if nums[i] < start: continue
            if nums[i] == start:
                start += 1
            else:
                rg = self.getRange(start, min(upper+1, nums[i])-1)
                result.append(rg)
                start = nums[i]+1
            if nums[i] > upper: break
        return result

    def getRange(self, low, high):
        rg = str(low)
        if high != low:
            rg += "->" + str(high)

        return rg

s = Solution()
nums = [1,3,7,8]
l = 0
h = 10
print s.findMissingRanges(nums, l, h)