"""
Given [5, 7, 7, 8, 8, 10] and target value 8,
return [3, 4].
O(logN)
"""
class Solution(object):
    def searchRange(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        return [self.searchLeftmatch(nums, target), self.searchRightMatch(nums, target)]


    def searchLeftmatch(self, nums, target):
        if not nums: return -1
        mid = len(nums)/2
        left = right = -1
        if target > nums[mid]:
            right = self.searchLeftmatch(nums[mid+1:], target)
            if right != -1: right += mid+1
        elif target < nums[mid]:
            left = self.searchLeftmatch(nums[:mid], target)
        else:
            if mid > 0 and nums[mid-1] == target: 
                return self.searchLeftmatch(nums[:mid], target)
            else:
                return mid

        return min(left, right) if left > 0 and right > 0 else max(left, right)

    def searchRightMatch(self, nums, target):
        if not nums: return -1
        mid = len(nums)/2
        left = right = -1
        if target > nums[mid]:
            right = self.searchRightMatch(nums[mid+1:], target)
            if right != -1: right += mid+1
        elif target < nums[mid]:
            left = self.searchRightMatch(nums[:mid], target)
        else:
            if mid < len(nums)-1 and nums[mid+1] == target: 
                r = self.searchRightMatch(nums[mid+1:], target)
                return r if r == -1 else r + mid + 1
            else:
                return mid

        return max(right, left)