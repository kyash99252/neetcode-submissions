class NumMatrix {
    private int[][] prefixSum;

    public NumMatrix(int[][] matrix) {
        int n = matrix.length, m = matrix[0].length;
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = 0; j < m; j++) {
                matrix[i][j] += sum;
                sum = matrix[i][j];
            }
        }

        for (int j = 0; j < m; j++) {
            int sum = 0;
            for (int i = 0; i < n; i++) {
                matrix[i][j] += sum;
                sum = matrix[i][j];
            }
        }

        this.prefixSum = matrix;
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int ans = prefixSum[row2][col2];

        if (row1 == 0 && col1 == 0) {
            return ans;
        } else if (row1 == 0) {
            return ans - prefixSum[row2][col1 - 1];
        } else if (col1 == 0) {
            return ans - prefixSum[row1 - 1][col2];
        } else {
            return ans - prefixSum[row2][col1 - 1] - prefixSum[row1 - 1][col2] + prefixSum[row1 - 1][col1 - 1];
        }
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */