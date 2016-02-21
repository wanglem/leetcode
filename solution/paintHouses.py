# 256. paint houses, no adjacent houses have same color
# simple DP, r,g,b are in index 0, 1, 2
# for each house i, if paint it to r, price = cost[i][0] + min(cost[i-1][1], cost[i-1][2])
# similar to other two color
class Solution(object):
    def minCost(self, costs):
        """
        :type costs: List[List[int]]
        :rtype: int
        """
        