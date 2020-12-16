//给你一个 m * n 的整数矩阵 mat ，请你将同一条对角线上的元素（从左上到右下）按升序排序后，返回排好序的矩阵。 
//
// 
//
// 示例 1： 
//
// 
//
// 输入：mat = [[3,3,1,1],[2,2,1,2],[1,1,1,2]]
//输出：[[1,1,1,1],[1,2,2,2],[1,2,3,3]]
// 
//
// 
//
// 提示： 
//
// 
// m == mat.length 
// n == mat[i].length 
// 1 <= m, n <= 100 
// 1 <= mat[i][j] <= 100 
// 
// Related Topics 排序 数组 
// 👍 27 👎 0


package com.hudaqian.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SortTheMatrixDiagonally {
    public static void main(String[] args) {
        Solution solution = new SortTheMatrixDiagonally().new Solution();
        int[][] mat = {{3,3,1,1},{2,2,1,2},{1,1,1,2}};
        System.out.print(Arrays.toString(solution.diagonalSort(mat)));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[][] diagonalSort(int[][] mat) {
            /**
             * 暴力解法
             * 3 3 1 1
             * 2 2 1 2
             * 1 1 1 2
             */
            if (mat.length == 0 || mat[0].length == 0) return mat;
            int n = mat.length - 1, m = mat[0].length - 1;
            for (int i = 1; i < m+n; i++) {
                //  上顶点
                int[] pointA = new int[2];
                pointA[0] = m - i > 0 ? m - i : 0;
                pointA[1] = m - i > 0 ? 0 : i - m;
                int[] pointB = new int[2];
                pointB[0] = n - i > 0 ? m : n+m-i;
                pointB[1] = n - i > 0 ? i : n;
                List<Integer> list = new ArrayList<>();
                for (int j = 0; j <= pointB[0] - pointA[0]; j++) {
                    int p = pointA[0],q = pointA[1];
                    list.add(mat[q+j][p+j]);
                }
                Collections.sort(list);
                for (int j = 0; j <= pointB[0] - pointA[0]; j++) {
                    int p = pointA[0],q = pointA[1];
                    mat[q+j][p+j] = list.get(j);
                }
            }
            return mat;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}