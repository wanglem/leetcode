// buy one time
/*
    General buy-sell stock with any conditions.
    T[k][i][0] means at k transaction of price i, take action to have `0` stock - either `rest` or `sell`
    T[k][i][1] means at k transaction of price i, take action to have `1` stock - either `rest` or `buy`
    Base cases:
        T[k][-1][0] = 0, T[k][-1][1] = -Infinity
        T[0][k][0] = 0, T[0][i][1] = -Infinity

    Recurrence relations:
        T[k][i][0] = max(T[k][i-1][0], T[k][i-1][1] + prices[i])
        T[k][i][1] = max(T[k][i-1][1], T[k-1][i-1][0] - prices[i])

    1. buy 1 time: k = 0
    2. buy 2 times: k = [0,1],
    3. buy N times: k = 0
    4.
 */
class BuySellStock {
    public int maxProfit(int[] prices) {
        if (prices.length < 2) return 0;
        int minPrice = prices[0];
        int maxProfit = 0;

        for (int i = 0; i < prices.length; i++) {
            minPrice = Math.min(prices[i], minPrice);
            maxProfit = Math.max(prices[i] - minPrice, maxProfit);
        }
        return maxProfit;
    }
}