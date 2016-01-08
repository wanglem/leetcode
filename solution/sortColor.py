# 75.
# nums only contains 0, 1, 2, sort nums
# 1. two pointers sort 0 first then 1

# 2. loop through nums as i, j
# keep track of num of 0 as n, place 0 at n if found, n += 1, place nums[n] to nums[i], i += 1
# if 1 continue
# if 2, swap value at i and j, j -= 1
class Solution(object):
    def sortColors(self, nums):
        """
        :type nums: List[int]
        :rtype: void Do not return anything, modify nums in-place instead.
        """
