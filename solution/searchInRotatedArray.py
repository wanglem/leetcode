class Solution(object):
    def search(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: int
        """
        pivotIndex = self.findPivot(nums)
        result = self.bsearch(nums[:pivotIndex+1], target)
        if result != -1: return result
        result = self.bsearch(nums[pivotIndex+1:], target)
        if result != -1: return result + 1 + pivotIndex
        return -1


    def findPivot(self, nums):
        if len(nums) < 2: return 0
        mid = len(nums)/2
        if nums[mid] > nums[-1]:
            return mid + self.findPivot(nums[mid:])
        elif nums[mid] < nums[0]:
            return self.findPivot(nums[:mid])
        else:
            return mid


    def bsearch(self, nums, target):
        if not nums: return -1
        if len(nums) == 1:
            if nums[0] == target: return 0
            else: return -1

        mid = len(nums)/2
        if nums[mid] > target: return self.bsearch(nums[:mid], target)
        elif nums[mid] < target: 
            index = self.bsearch(nums[mid:], target)
            return index if index == -1 else index + mid
        else: return mid




s = Solution()
a = [1]
print s.search(a, 0)