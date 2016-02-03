# 90.
# [1,2,2,2]
# for each elemnet E in list, pick E as the first element of subset, 
# then recursively through all list.
# If list[n] == list[n-1] then skip, this way to AVOID DUP!
class Solution(object):
    def subsetsWithDup(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        nums = sorted(nums)
        result = []
        for i in xrange(len(nums)+1):
        	result.extend(self._subWithDup(nums, i, 0))

        return result

    def _subWithDup(self, nums, n, index):
    	if n == 0: return [[]]
    	rst = []
    	for i in xrange(index, len(nums)):
    		if i > index and nums[i] == nums[i-1]:
    			continue
    		picked = nums[i]
    		subs = self._subWithDup(nums, n-1, i+1)
    		for sub in subs:
    			rst.append([picked] + sub)

    	return rst


s = Solution()
t = [0]
print s.subsetsWithDup(t)