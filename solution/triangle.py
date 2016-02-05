# 120. triangle array, find minimum path sum
# DP, same array structure, each elememt remember its minimum
class Solution(object):
    def minimumTotal(self, triangle):
        """
        :type triangle: List[List[int]]
        :rtype: int
        """
        dp = [[0 for x in y] for y in triangle]
        dp[0][0] = triangle[0][0]

        for i in xrange(1, len(dp)): # each level
        	dp[i][0] = dp[i-1][0] + triangle[i][0] # head
        	dp[i][-1] = dp[i-1][-1] + triangle[i][-1] # tail
        	for j in xrange(1, len(dp[i])-1): # all middle element in this level
        		dp[i][j] = min(dp[i-1][j-1], dp[i-1][j]) + triangle[i][j]
        
        return min(dp[-1])


s = Solution()
t = [[-10]]

print s.minimumTotal(t)