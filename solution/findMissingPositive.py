# 41
class Solution(object):
    def firstMissingPositive(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        i = 0
        while i < len(nums):
            if 0 < nums[i] < len(nums) and i+1 != nums[i] and nums[i] != nums[nums[i]-1]:
                m, n = i, nums[i]-1
                nums[m], nums[n] = nums[n], nums[m]
            else:
                i += 1
        
        for i in xrange(len(nums)):
            if nums[i] != i+1:
                return i+1

        return len(nums)+1

s = Solution()
print s.firstMissingPositive([1,1])