class Solution(object):
    def twoSum(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        sortedIndex = sorted([n for n in xrange(len(nums))], key=lambda x:nums[x])
        i, j = 0, len(nums)-1
        while i < j:
        	current = nums[sortedIndex[i]] + nums[sortedIndex[j]]
        	if current == target: return sorted([sortedIndex[i]+1, sortedIndex[j]+1])
        	elif current < target:i += 1
        	else: j -= 1

        return [-1, -1]

t = [0,4,3,0]
sol = Solution()
print sol.twoSum(t, 7)