// buy K times
// maxProfit[i][j] means when at most i transactions, maxProfit at i price
// either 1. Not selling at i: maxProfit[i][j] is maxProfit[i][j-1]
// either 2. Selling at i: maxProfit[i][j] is prices[j] - prices[k] + maxProfit[i-1][k]
//                                            where k:[0, j) is the buy point for selling j
class BuySellStockIII {
    public int maxProfit(int[] prices) {
        if (prices.length == 0) return 0;
        int times = 2;
        int[][] maxProfit = new int[times+1][prices.length];

        for (int i = 1; i < times + 1; i++) {
            for (int j = 1; j < prices.length; j++) {
                for (int k = 0; k < j; k++) {
                    maxProfit[i][j] = Math.max(maxProfit[i][j-1], maxProfit[i][j]);
                    maxProfit[i][j] = Math.max(maxProfit[i][j], prices[j] - prices[k] + maxProfit[i-1][k]);
                }
            }
        }

        return maxProfit[times][prices.length-1];
    }
}