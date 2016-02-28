# 283. move zeros, and keep other's relative order
# two pointers
class Solution(object):
    def moveZeroes(self, nums):
        """
        :type nums: List[int]
        :rtype: void Do not return anything, modify nums in-place instead.
        """
        if len(nums) < 1: return
        i, j = 0, 1
        while j < len(nums):
            while j < len(nums) and nums[j] == 0:
                j += 1
            if j > len(nums)-1: break
            while i < j and nums[i] != 0:
                i += 1
            if nums[i] == 0:
                nums[i], nums[j] = nums[j], nums[i]
            j += 1

s = Solution()
t = [1,3,0,0,1,2]
print s.moveZeroes(t)
print t