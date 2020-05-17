class ToeplitzMatrix {
    public boolean isToeplitzMatrix(int[][] matrix) {
        if (matrix.length == 0) return true;

        for (int i = 0; i < matrix.length; i++) {
            if (!checkdDiagonal(i, 0, matrix)) {
                return false;
            }
        }

        for (int i = 0; i < matrix[0].length; i++) {
            if (!checkdDiagonal(0, i, matrix)) {
                return false;
            }
        }

        return true;
    }

    private boolean checkdDiagonal(int x, int y, int[][] matrix) {
        int base = matrix[x][y];
        while (x < matrix.length && y < matrix[0].length) {
            if (base != matrix[x++][y++]) return false;
        }
        return true;
    }
}