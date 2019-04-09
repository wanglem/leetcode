class BuySellStockIV {
    /*
        profit[k][prices.length]
        profit[i][j] means max profit when selling j while having at most i transactions.
            at i, 1 you can:
                1. ignore (no transaction)
                2. sell, at buy at any prices[m] where m in [0, j-1]
                    2a. so profit[i][j] = max(profit[i][j-1], prices[j] - prices[ii] + profit[i-1][ii])

        Note: cooldown then means use j-`cooldown` transaction in loop
     */
    public int maxProfit(int k, int[] prices) {
        if (prices.length == 0) return 0;
        int[][] profit = new int[k+1][prices.length];
        for (int i = 1; i < k+1; i++) {
            for (int j = 1; j < prices.length; j++) {
                for (int m = 0; m < j; m++){
                    int curMaxProfit = Math.max(profit[i][j-1], prices[j] - prices[m] + profit[i-1][m]);
                    profit[i][j] = Math.max(curMaxProfit, profit[i][j]);
                }
            }
        }
        return profit[k][prices.length-1];
    }
}