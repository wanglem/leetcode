#64.
class Solution(object):
    def minPathSum(self, grid):
        """
        :type grid: List[List[int]]
        :rtype: int
        """
        dp = [[0]*len(grid[0]) for _ in xrange(len(grid))]
        dp[0][0] = grid[0][0]
        for i in xrange(1, len(dp[0])):
            dp[0][i] = dp[0][i-1] + grid[0][i]

        for j in xrange(1, len(dp)):
            dp[j][0] = dp[j-1][0] + grid[j][0]

        for i in xrange(1,len(dp)):
            for j in xrange(1, len(dp[0])):
                dp[i][j] = min(dp[i-1][j], dp[i][j-1]) + grid[i][j]

        return dp[-1][-1]

s = Solution()
t = [[1,3,1],[1,5,1],[4,2,1]]

print s.minPathSum(t)