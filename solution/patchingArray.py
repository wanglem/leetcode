# 330. patching array
# if we are missing K, it means we have all number needed to build from [1-K)
# so, if next number from array P < K, then we know: after add P, we can build
# all in [1, K+P), right??!!
# if next number from array P >= K, then we need add K, and similarly we can now
# build [1, K+K)!
class Solution(object):
    def minPatches(self, nums, n):
        """
        :type nums: List[int]
        :type n: int
        :rtype: int
        """
        target = 1
        i = 0
        patched = 0
        while target <= n:
            if i < len(nums) and nums[i] <= target:
                target += nums[i]
                i += 1
            else:
                target += target
                patched += 1

        return patched