# 55.
class Solution(object):
    def canJump(self, nums):
        """
        :type nums: List[int]
        :rtype: bool
        """
        if len(nums) == 0: return False
        maxReached = nums[0]
        for i in xrange(len(nums)):
            if i > maxReached: return False
            if nums[i] + i >= len(nums) - 1:return True
            maxReached = max(nums[i]+i, maxReached)

        return maxReached >= len(nums) - 1




s = Solution()
t = [3,2,1,0,4]
t = [2,3,1,1,4]
t = [0]
print s.canJump(t)