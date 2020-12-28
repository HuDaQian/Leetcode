//给定一个仅包含 0 和 1 、大小为 rows x cols 的二维二进制矩阵，找出只包含 1 的最大矩形，并返回其面积。 
//
// 
//
// 示例 1： 
//
// 
//输入：matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"]
//,["1","0","0","1","0"]]
//输出：6
//解释：最大矩形如上图所示。
// 
//
// 示例 2： 
//
// 
//输入：matrix = []
//输出：0
// 
//
// 示例 3： 
//
// 
//输入：matrix = [["0"]]
//输出：0
// 
//
// 示例 4： 
//
// 
//输入：matrix = [["1"]]
//输出：1
// 
//
// 示例 5： 
//
// 
//输入：matrix = [["0","0"]]
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// rows == matrix.length 
// cols == matrix[0].length 
// 0 <= row, cols <= 200 
// matrix[i][j] 为 '0' 或 '1' 
// 
// Related Topics 栈 数组 哈希表 动态规划 
// 👍 743 👎 0


package com.hudaqian.leetcode.editor.cn;

public class MaximalRectangle {
    public static void main(String[] args) {
        Solution solution = new MaximalRectangle().new Solution();
        char[][] matrix = {{'1', '0', '1', '0', '0' }, {'1', '0', '1', '1', '1' }, {'1', '1', '1', '1', '1' }, {'1', '0', '0', '1', '0' }};
        System.out.print(solution.maximalRectangle(matrix));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maximalRectangle(char[][] matrix) {
            int m = matrix.length;
            if (m == 0) return 0;
            int n = matrix[0].length;
            int[][] temp = new int[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (matrix[i][j] == '1') {
                        temp[i][j] = (j == 0 ? 0 : temp[i][j - 1]) + 1;
                    }
                }
            }
            //  模拟检索
            int maxRect = 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (temp[i][j] == 0) {
                        continue;
                    }
                    int width = temp[i][j];
                    int area = width;
                    int ptr = i - 1;
                    while (ptr >= 0 && temp[ptr][j] != 0) {
                        width = Math.min(width, temp[ptr][j]);
                        area = Math.max(width * (i - ptr + 1), area);
                        ptr--;
                    }
                    maxRect = Math.max(area, maxRect);
                }
            }
            return maxRect;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}