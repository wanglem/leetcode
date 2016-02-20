# 220. find i, j that difference between nums[i] and nums[j] is at most t 
# and the difference between i and j is at most k.
# for range size 2k-1 create bsearch tree, get next index number and find closest,
# if not <= t then popout oldest and insert new index. nLogk
# 
class Solution(object):
    def containsNearbyAlmostDuplicate(self, nums, k, t):
        """
        :type nums: List[int]
        :type k: int
        :type t: int
        :rtype: bool
        """



s = Solution()
n = [2,6,5,9,1,4]
print s.containsNearbyAlmostDuplicate(n, 1, 1)