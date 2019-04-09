// Google

/*
    read/write distributed evenly
    maintain rowSum[i][j] = matrix[i][0] + matrix[i][1] + .. + matrix[i][j]
 */
class NumMatrix {

    public NumMatrix(int[][] matrix) {
    }
    public void update(int row, int col, int val) {
    }
    public int sumRegion(int row1, int col1, int row2, int col2) {
        return 0;
    }

    // update i += i & -i;
    public static void updateBIT(int[] BITree, int n, int index, int value) {
        index += 1;
        while (index <= n) {
            BITree[index] += value;
            index += (index & -index);
        }
    }

    // getSum: i -= i & -i;
    public static int getSum(int[] BITree, int index) {
        index = index + 1;
        int res = 0;
        while (index > 0) {
            res += BITree[index];
            index -= (index & -index);
        }
        return res;
    }
}
