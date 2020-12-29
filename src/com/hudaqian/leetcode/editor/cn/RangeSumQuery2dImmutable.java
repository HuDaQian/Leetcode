//给定一个二维矩阵，计算其子矩形范围内元素的总和，该子矩阵的左上角为 (row1, col1) ，右下角为 (row2, col2)。 
//
// 
//上图子矩阵左上角 (row1, col1) = (2, 1) ，右下角(row2, col2) = (4, 3)，该子矩形内元素的总和为 8。 
//
// 示例: 
//
// 给定 matrix = [
//  [3, 0, 1, 4, 2],
//  [5, 6, 3, 2, 1],
//  [1, 2, 0, 1, 5],
//  [4, 1, 0, 1, 7],
//  [1, 0, 3, 0, 5]
//]
//
//sumRegion(2, 1, 4, 3) -> 8
//sumRegion(1, 1, 2, 2) -> 11
//sumRegion(1, 2, 2, 4) -> 12
// 
//
// 说明: 
//
// 
// 你可以假设矩阵不可变。 
// 会多次调用 sumRegion 方法。 
// 你可以假设 row1 ≤ row2 且 col1 ≤ col2。 
// 
// Related Topics 动态规划 
// 👍 133 👎 0


package com.hudaqian.leetcode.editor.cn;

import java.util.Arrays;

public class RangeSumQuery2dImmutable {
    public static void main(String[] args) {
        int[][] matrix = {{3, 0, 1, 4, 2}, {5, 6, 3, 2, 1}, {1, 2, 0, 1, 5}, {4, 1, 0, 1, 7}, {1, 0, 3, 0, 5}};

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class NumMatrix {
        private int[][] dp;
        private int[][] data;

        public NumMatrix(int[][] matrix) {
            /**
             * 3    0   1   4   2
             * 5    6   3   2   1
             * 1    2   0   1   5
             * 4    1   0   1   7
             * 1    0   3   0   5
             *
             * 0    0   0   0   0   0
             * 0    3   3   4   8   10
             * 0    8   14  18  24  27
             * 0    9   17  21  28  36
             * 0    13  22  26  34  49
             * 0    14  23  30  38  58
             */
            int m = matrix.length;
            if (m == 0 || matrix[0].length == 0) return;
            int n = matrix[0].length;
            data = matrix;
            dp = new int[m + 1][n + 1];
            for (int i = 0; i < m; i++) {
                int[] temp = new int[n];
                temp[0] = matrix[i][0];
                dp[i + 1][1] = dp[i][1] + temp[0];
                for (int j = 1; j < n; j++) {
                    temp[j] = temp[j - 1] + matrix[i][j];
                    dp[i + 1][j + 1] = dp[i][j + 1] + temp[j];
                }
            }
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            if (row1 > row2) return sumRegion(row2, col1, row1, col2);
            if (col1 > col2) return sumRegion(row1, col2, row2, col1);
            int m = data.length, n = data[0].length;
            if (col2 >= n) return sumRegion(row1, col1, row2, n);
            if (row2 >= m) return sumRegion(row1, col1, m, col2);
            return dp[row2 + 1][col2 + 1] + dp[row1][col1] - dp[row1][col2 + 1] - dp[row2 + 1][col1];
        }
    }

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */
//leetcode submit region end(Prohibit modification and deletion)

}