# 154. search min in a rotated sorted array, with duplicates
class Solution(object):
    def findMin(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        i, j = 0, len(nums) - 1
        if j == -1: return None
        while i < j and nums[i] == nums[i+1]:
            i += 1
        while i < j and nums[j] == nums[j-1]:
            j -= 1

        if nums[i] < nums[j]: return nums[i]
        while i < j - 1:
            mid = i + (j-i)/2
            if nums[mid] > nums[0]: i = mid + 1
            else: j = mid

        return min(nums[i], nums[j])

s = Solution()
t = [3,1]
print s.findMin(t)