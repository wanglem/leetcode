class MinDistanceTypeWordTwoFingers {
    /*
        dp[i][j][k] means:
        finger A at ith char, finger B at jth char, with total kth char moved.
     */
    public int minimumDistance(String word) {
        int[][][] costToMove = new int[27][27][word.length()];
        return move(word, costToMove, 26, 26, 0);
    }

    private int move(String W, int[][][] costToMove, int left, int right, int position) {
        if (position >= W.length()) return 0;

        if (costToMove[left][right][position] == 0) {
            costToMove[left][right][position] = Math.min(
                    move(W, costToMove, W.charAt(position)-'A', right, position+1) + distance(left, W.charAt(position)),
                    move(W, costToMove, left, W.charAt(position)-'A', position+1) + distance(right, W.charAt(position))
            );
        }
        return costToMove[left][right][position];
    }

    private int distance(int fingerLetter, char to) {
        if (fingerLetter == 26) return 0;
        int ia = fingerLetter;
        int iTo = to - 'A';
        return Math.abs(ia/6 - iTo/6) + Math.abs(ia%6 - iTo%6);
    }
}