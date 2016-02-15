# 192.  rob non-adjacent houses
class Solution(object):
    def rob(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if len(nums) == 0: return 0
        if len(nums) < 3: return max(nums)
        pre3, pre2, pre1 = nums[0], nums[1], nums[0]+nums[2]
        for x in nums[3:]:
            pre3, pre2, pre1 = pre2, pre1, x + max(pre3, pre2)
        
        return max(pre1, pre2)

s = Solution()
print s.rob([4,1,2,7,5,3,1])