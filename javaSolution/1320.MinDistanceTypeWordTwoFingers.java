class MinDistanceTypeWordTwoFingers {
    /*
        dp[i][j][k] means:
        finger A at ith char, finger B at jth char, with total kth char moved.
     */
    public int minimumDistance(String word) {
        int m = word.length();
        int[] letterIdx = new int[m];
        for (int i = 0; i < m; i++) {
            letterIdx[i] = word.charAt(i) - 'A';
        }
        int[][][] dp = new int[m][m][m];
        for (int k = 1; k < m; k++) {
            for (int i = 0; i < m; i++) {
                
            }
            for (int j = 0; j < m; j++) {
            }
        }
        return 0;
    }

    private int distance(char a, char b) {
        int ia = a - 'A';
        int ib = b - 'B';
        return Math.abs(ia/6 - ib/6) + Math.abs(ia%6 - ib%6);
    }
}