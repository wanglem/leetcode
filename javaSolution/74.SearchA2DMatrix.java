class SearchA2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) return false;
        int lo = 0, hi = matrix.length;
        while (lo < hi) {
            int mid = (hi - lo)/2 + lo;
            if (matrix[mid][0] == target) {
                return true;
            }
            if (matrix[mid][0] < target) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }

        int row = lo-1;
        if (row < 0) return false;
        lo = 0;
        hi = matrix[0].length;
        while (lo < hi) {
            int mid = (hi - lo)/2 + lo;
            if (matrix[row][mid] == target) {
                return true;
            }
            if (matrix[row][mid] < target) {
                lo = mid+1;
            } else {
                hi = mid;
            }
        }

        return false;
    }
}