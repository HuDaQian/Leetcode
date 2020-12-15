//给定一个正整数 n，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的正方形矩阵。 
//
// 示例: 
//
// 输入: 3
//输出:
//[
// [ 1, 2, 3 ],
// [ 8, 9, 4 ],
// [ 7, 6, 5 ]
//] 
// Related Topics 数组 
// 👍 271 👎 0


package com.hudaqian.leetcode.editor.cn;

import java.util.Arrays;

public class SpiralMatrixIi {
    public static void main(String[] args) {
        Solution solution = new SpiralMatrixIi().new Solution();
        int n = 3;
        System.out.print(Arrays.deepToString(solution.generateMatrix(n)));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[][] generateMatrix(int n) {
            /**
             * 模拟解法
             */
            int left = 0, right = n - 1, top = 0, bottom = n - 1;
            int[][] matrix = new int[n][n];
            int res = n * n;
            int ptr = 1;
            while (ptr <= res) {
                for (int i = left; i <= right; i++) matrix[top][i] = ptr++;
                top++;
                for (int i = top; i <= bottom; i++) matrix[i][right] = ptr++;
                right--;
                for (int i = right; i >= left; i--) matrix[bottom][i] = ptr++;
                bottom--;
                for (int i = bottom; i >= top; i--) matrix[i][left] = ptr++;
                left++;
            }
            return matrix;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}