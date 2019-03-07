class ClimbingStairs {
    public int climbStairs(int n) {
        if (n == 1) return 1;
        int[] lastTwoCounts = new int[n];
        lastTwoCounts[0] = 1;
        lastTwoCounts[1] = 2;
        for (int i = 2; i < n; i++) {
            lastTwoCounts[i] += lastTwoCounts[i-1] + lastTwoCounts[i-2];
        }
        return lastTwoCounts[n-1];
    }
}