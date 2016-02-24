# 265. paint houses II, basically same idea, but just with K pointers
class Solution(object):
    def minCostII(self, costs):
        """
        :type costs: List[List[int]]
        :rtype: int
        """
        if len(costs) < 1: return 0
        costTracking = [costs[0]]
        for i in xrange(1, len(costs)):
            iHouse = []
            for j in xrange(len(costs[0])):
                minOther = self.minOther(costTracking[i-1], j)
                iHouse.append(minOther+costs[i][j])
            costTracking.append(iHouse)

        return min(costTracking[-1])

    def minOther(self, tracking, j):
        minLeft = tracking[-1]+1
        if j > 0: minLeft = min(tracking[:j])
        minRight = tracking[0]+1
        if j  < len(tracking)-1:minRight = min(tracking[j+1:])
        return min(minLeft, minRight)

costs = [[1,5],[2,4]]

s = Solution()
print s.minCostII(costs)