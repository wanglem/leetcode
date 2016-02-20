# 229. majority element that appear more than n/3 times
# two solution:
# 1. quick selection, must appear at n/2 or n/3 index, loop through again to check
# 2. boyer-moore voting, track top two frequency nums
class Solution(object):
    def majorityElement(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        """
        