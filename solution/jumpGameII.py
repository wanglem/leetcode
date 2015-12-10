# 45.
"""
TimeLimit exceeded, should have a better way.
Come back and review.
"""
class Solution(object):
    def jump(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        dp = [i if i > nums[0] else 1 for i in xrange(len(nums))]
        dp[0] = 0
        for i in xrange(1, len(nums)):
            if nums[i] == 0: continue
            for j in xrange(i):
                if nums[j] == 0: continue
                # if j can't reach i anymore, break
                if nums[j] + j < i: break
                # if greater than current shortest jump, break
                elif dp[j] >= dp[i]: break
                else: dp[i] = min(dp[i], dp[j]+1)

            if nums[i] + i >= len(nums) - 1:
                return min(dp[i]+1, dp[-1])
            k = nums[i] + i # furthest can reach from index i
            while k < len(nums) and k > i:
                # set furthest first
                if dp[i]+1 < dp[k]: dp[k] = dp[i] + 1
                else: break
                k -= 1
        return dp[-1]

s = Solution()
t = [5,9,3,2,1,0,2,3,3,1,0,0]
print s.jump(t)
