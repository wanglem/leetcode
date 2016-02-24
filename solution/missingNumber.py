# 268. missing number
# use math to calculate
# can also use index and value difference
# for example, if we have 0-n, and n+1 size array, the substraction between 
# index and values should be 0. 
# if 1 is missing, say we have 0,2,3,4, their indexes are 0,1,2,3, the diff would be
# 0-0 + 2-1 + 3-2 + 4-3 == 3
# thus the missing number is n-diff = 4-3 = 1
class Solution(object):
    def missingNumber(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        return (1+len(nums))*len(nums)/2-sum(nums)