//编写一种算法，若M × N矩阵中某个元素为0，则将其所在的行与列清零。 
//
// 
//
// 示例 1： 
//
// 输入：
//[
//  [1,1,1],
//  [1,0,1],
//  [1,1,1]
//]
//输出：
//[
//  [1,0,1],
//  [0,0,0],
//  [1,0,1]
//]
// 
//
// 示例 2： 
//
// 输入：
//[
//  [0,1,2,0],
//  [3,4,5,2],
//  [1,3,1,5]
//]
//输出：
//[
//  [0,0,0,0],
//  [0,4,5,0],
//  [0,3,1,0]
//]
// 
// Related Topics 数组 
// 👍 18 👎 0


package com.hudaqian.leetcode.editor.cn;

public class ZeroMatrixLcci {
    public static void main(String[] args) {
        Solution solution = new ZeroMatrixLcci().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void setZeroes(int[][] matrix) {
            /**
             * 解法：通过首行和首列来记录当行或者当列是否有0，首先把首行列中是否有0记录出来
             */
            boolean isFirstColHasZero = false;
            boolean isFirstRowHasZero = false;
            int m = matrix.length;
            int n = matrix[0].length;
            for (int i = 0; i < m; i++) {
                if (matrix[i][0] == 0) {
                    isFirstColHasZero = true;
                }
            }
            for (int i = 0; i < n; i++) {
                if (matrix[0][i] == 0) {
                    isFirstRowHasZero = true;
                }
            }
            for (int i = 1; i < m; i++) {
                for (int j = 1; j < n; j++) {
                    if (matrix[i][j] == 0) {
                        matrix[i][0] = 0;
                        matrix[0][j] = 0;
                    }
                }
            }
            for (int i = 1; i < m; i++) {
                for (int j = 1; j < n; j++) {
                    if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                        matrix[i][j] = 0;
                    }
                }
            }
            if (isFirstColHasZero) {
                for (int i = 0; i < m; i++) {
                    matrix[i][0] = 0;
                }
            }
            if (isFirstRowHasZero) {
                for (int i = 0; i < n; i++) {
                    matrix[0][i] = 0;
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}