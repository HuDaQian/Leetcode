//给定一个矩阵 A， 返回 A 的转置矩阵。 
//
// 矩阵的转置是指将矩阵的主对角线翻转，交换矩阵的行索引与列索引。 
//
// 
//
// 示例 1： 
//
// 输入：[[1,2,3],[4,5,6],[7,8,9]]
//输出：[[1,4,7],[2,5,8],[3,6,9]]
// 
//
// 示例 2： 
//
// 输入：[[1,2,3],[4,5,6]]
//输出：[[1,4],[2,5],[3,6]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= A.length <= 1000 
// 1 <= A[0].length <= 1000 
// 
// Related Topics 数组 
// 👍 128 👎 0


package com.hudaqian.leetcode.editor.cn;

import java.util.Arrays;

public class TransposeMatrix {
    public static void main(String[] args) {
        Solution solution = new TransposeMatrix().new Solution();
        int[][] nums = {{1,2,3},{4,5,6},{7,8,9}};
        System.out.print(solution.transpose(nums));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[][] transpose(int[][] A) {
            int len = A.length;
            if (len == 0) return A;
            int width = A[0].length;
            int[][] res = new int[width][len];
            for (int r = 0; r < len; r++) {
                for (int c = 0; c < width; c++) {
                    res[c][r] = A[r][c];
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}