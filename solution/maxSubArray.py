# 53.
class Solution(object):
    def maxSubArray(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        maxVal = currMax = nums[0]
        for item in nums[1:]:
            currMax = max(item, currMax+item)
            maxVal = max(currMax, maxVal)
        return maxVal


s = Solution()
t = [-2,1,-3,4,-1,2,1,-5,4]
print s.maxSubArray(t)
