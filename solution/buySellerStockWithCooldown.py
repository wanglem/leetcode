# 309. buy sell stock with 1 day cool down
# 
# buy[i] means max profit at day i either buy or keep (already bought)
# sell[i] means max profit at day i either sell or keep (cooldown)
# buy[i] = max(sell[i-2]-price, buy[i-1])
# sell[i] = max(buy[i-1]+price, sell[i-1])

class Solution(object):
    def maxProfit(self, prices):
        """
        :type prices: List[int]
        :rtype: int
        """
        if len(prices) < 2: return 0
        buy, sell = [-1*prices[0]], [0]
        sell.append(max(buy[0]+prices[1], sell[0]))
        buy.append(max(buy[0], -1*prices[1]))
        for i in xrange(2, len(prices)):
            sell.append(max(buy[i-1]+prices[i], sell[i-1]))
            buy.append(max(sell[i-2]-prices[i], buy[i-1]))
        return sell[-1]
