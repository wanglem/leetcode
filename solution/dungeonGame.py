# 174. dungeon game: weight 2d array path find
# bottom up solution, start from bottom right(end), find minimum health needed to get there
# Tricky:
# 1. dp[i][j] means mininum health needed in (i, j) to reach end
# 2. dp[i][j] < 0 means no health is needed, 
#    now set it to 1 to avoid negative health in middle of path!
# 
class Solution(object):
    def calculateMinimumHP(self, dungeon):
        """
        :type dungeon: List[List[int]]
        :rtype: int
        """
        if len(dungeon) == 0 or len(dungeon[0]) == 0: return 0
        d = dungeon
        m, n = len(d), len(d[0])
        dp = [[0 for _ in d[0]] for _ in d]
        dp[-1][-1] = max(1, 1-d[-1][-1])
        for i in xrange(m-2, -1, -1): # fill right path
            dp[i][n-1] = max(1, dp[i+1][n-1] - d[i][n-1])
        for j in xrange(n-2, -1, -1): # fill bottom path
            dp[m-1][j] = max(1, dp[m-1][j+1] - d[m-1][j])

        for i in xrange(m-2, -1, -1):
            for j in xrange(n-2, -1, -1):
                dp[i][j] = max(1, min(dp[i+1][j], dp[i][j+1]) - d[i][j])
        return dp[0][0]

d = [
    [-2, -3, 3],
    [-5, -10, 1],
    [10, 30, -5]
    ]

s = Solution()
print s.calculateMinimumHP(d)