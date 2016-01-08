# 80.
# two pointer track element
class Solution(object):
    def removeDuplicates(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if len(nums) < 3: return len(nums)
        p, q = 0, 2
        total = 2
        while q < len(nums):
            if nums[q] == nums[p]:
                if q - p < 2:
                    total += 1
            else:
                p = q
                total += 1
            q += 1
        return total


s = Solution()
print s.removeDuplicates([1,1,1,1,2,2,2,3,9])