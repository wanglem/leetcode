// min coins needed for cache[amount]
// when we have coinA * 2 > coinB && coinA < coinB, then we need to try out all options
class CoinChange {
    public int coinChange(int[] coins, int amount) {
        int[] minCoins = new int[amount+1];
        return minCoinChange(coins, amount, minCoins);
    }
    public int minCoinChange(int[] coins, int amount, int[] minCoins) {
        if (amount == 0) {
            return 0;
        }
        if (amount < 0) {
            return -1;
        }
        if (minCoins[amount] != 0) {
            return minCoins[amount];
        }
        int minCoin = Integer.MAX_VALUE;
        for (int coin : coins) {
            int nextMin = minCoinChange(coins, amount - coin, minCoins);
            if (nextMin != -1) {
                minCoin = Math.min(minCoin, nextMin + 1);
            }
        }
        minCoin = minCoin == Integer.MAX_VALUE ? -1 : minCoin;
        minCoins[amount] = minCoin;
        return minCoin;
    }

}