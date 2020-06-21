// FB
/**
 * Idea: Iterate from left to right. For each index i, we want to find:
 *  1. biggest value > N[i] on the right side.
 *  2. if there are multiple such value, find the one on farthest right.
 *
 *
 * Maintain an array with only 0-9 (10) elements. record farthest index of
 * occurance of each digit.
 *
 * Algo: loop through input from left to right, try from [9 -> N[i]] to see
 * if we can find a number. The first one is the biggest swap we can have.
 *
 *
 */
class MaximumSwap {
    public int maximumSwap(int num) {
        char[] N = String.valueOf(num).toCharArray();
        int[] lastOccurOfNum = new int[10];
        for (int i = 0; i < N.length; i++) {
            lastOccurOfNum[N[i] - '0'] = i;
        }

        for (int i = 0; i < N.length; i++) {
            for (int j = 9; j > N[i]-'0'; j--) {
                if (lastOccurOfNum[j] > i) {
                    // found
                    char tmp = N[i];
                    N[i] = N[lastOccurOfNum[j]];
                    N[lastOccurOfNum[j]] = tmp;
                    return Integer.valueOf(new String(N));
                }
            }
        }
        return num;
    }
}