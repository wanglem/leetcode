# 153. find minimum in a rotated sorted array
# [4,5,6,7,3]
class Solution(object):
    def findMin(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        l, r = 0, len(nums) - 1
        if r == -1: return None
        if nums[l] < nums[r]: return nums[l] # not rotated at all
        while l < r - 1:
            mid = l + (r-l)/2
            if nums[mid] > nums[0]:l = mid + 1
            else: r = mid

        return min(nums[l], nums[r])


s = Solution()
t = [4,1]
print s.findMin(t)