# 46.
class Solution(object):
    def permute(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        if len(nums) == 0: return []
        if len(nums) == 1: return [[nums[0]]]

        rs = []
        for permute in self.permute(nums[1:]):
            rs.extend([permute[:i] + [nums[0]] + permute[i:] for i in xrange(len(permute)+1)])
        return rs


s = Solution()
print s.permute([1,2,3,4])