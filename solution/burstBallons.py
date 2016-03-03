# 312. burst ballons and collect coins
# Brute force: burst each ballon, remove it and recursively burst others
# time: O(n!), space: 0
# 
# DP: 2D DP, dp[i] ususally means from 0 to i max or min something
#     3D DP, dp[i][j] usually means from i to j max or min something.
#     Just remember this as some kind of magic formula.
# the coins you get for a balloon does not depend on the balloons already burst. 
# Therefore instead of divide the problem by the first balloon to burst, we 
# divide the problem by the last balloon to burst.
# first and last balloons we are sure of their adjacent balloons before hand!
# 
# DP works, keep in mind that if the last to burst is i, burst i is:
#   num[i]*num[left-1]*num[right+1] not num[i]*num[i-1]*num[i+1]
# 
class Solution(object):
    def maxCoins(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if len(nums) == 0: return 0
        total = 0
        for i in xrange(len(nums)):
            collected = self.product(i, nums)
            restCollected = self.maxCoins(nums[:i]+nums[i+1:])
            total = max(total, collected+restCollected)

        return total

    def product(self, i, num):
        left = 1 if i == 0 else num[i-1]
        right = 1 if i == len(num)-1 else num[i+1]
        return left*right*num[i]

    def coins(self, i, left, right, num):
        x = num[i]
        if left != 0: x *= num[left-1]
        if right != len(num)-1: x *= num[right+1]
        return x

    def calc(self, nums):
        cache = [[-1 for _ in xrange(len(nums))] for _ in xrange(len(nums))]

        return self.maxCoinDP(nums, cache, 0, len(nums)-1)

    def maxCoinDP(self, nums, cache, left, right):
        if left > right: return 0
        if left == right: return self.coins(left, left, right, nums)
        if cache[left][right] != -1: return cache[left][right]

        collect = 0
        for i in xrange(left, right+1):
            collect = max(
                collect, 
                self.coins(i, left, right, nums) + \
                self.maxCoinDP(nums, cache, left, i-1) + \
                self.maxCoinDP(nums, cache,i+1, right))
        cache[left][right] = collect

        return collect




s = Solution()
print s.calc([3,1,5,8])
print s.maxCoins([3,1,5,8])