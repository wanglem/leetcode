# 121. 

# SOLUTION 1: 
# from left to right, if there's a lower valley, there COULD be a higher profit

class Solution(object):
    def maxProfit(self, prices):
        """
        :type prices: List[int]
        :rtype: int
        """
        if len(prices) == 0: return 0
        valley = prices[0]
        maxProfit = 0

        for i in xrange(1, len(prices)):
            maxProfit = max(prices[i] - valley, maxProfit)
            valley = min(valley, prices[i])

        return maxProfit


s = Solution()
t = [2,1,4]
print s.maxProfit(t)