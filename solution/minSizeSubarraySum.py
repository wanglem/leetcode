# 209. find min sinze subarray which sum >= given target, return 0 if not found
# solution: start from size 1, incremental to size n calculate sum, use dp
class Solution(object):
    def minSubArrayLen(self, s, nums):
        minWindow = len(nums)
        i, j = 0, 0
        subSum = 0
        while i < len(nums):
            subSum += nums[i]
            while subSum >= s and j <= i:
                minWindow = min(minWindow, i - j + 1)
                if minWindow == 1: return minWindow
                subSum -= nums[j]
                j += 1
            i += 1

        return minWindow if sum(nums) >= s else 0

    def minSubArrayLenDP(self, s, nums):
        """
        :type s: int
        :type nums: List[int]
        :rtype: int
        """
        dp = [0 for _ in xrange(len(nums))]
        for size in xrange(len(nums)):
            for start in xrange(size,len(nums)):
                subsum = dp[start-size] + nums[start]
                if subsum >= s: return size + 1
                dp[start-size] = subsum

        return 0

s = Solution()
t = 7
n = [1,7,7]
print s.minSubArrayLen(t, n)