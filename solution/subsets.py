# 78.
# two solutions:
# 1. resursively go to each len(nums) of subset level, added all
# 2. bit manipulation and add everything
class Solution(object):
    def subsets(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        