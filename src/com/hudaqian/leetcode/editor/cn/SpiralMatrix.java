//给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。 
//
// 示例 1: 
//
// 输入:
//[
// [ 1, 2, 3 ],
// [ 4, 5, 6 ],
// [ 7, 8, 9 ]
//]
//输出: [1,2,3,6,9,8,7,4,5]
// 
//
// 示例 2: 
//
// 输入:
//[
//  [1, 2, 3, 4],
//  [5, 6, 7, 8],
//  [9,10,11,12]
//]
//输出: [1,2,3,4,8,12,11,10,9,5,6,7]
// 
// Related Topics 数组 
// 👍 563 👎 0


package com.hudaqian.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public static void main(String[] args) {
        Solution solution = new SpiralMatrix().new Solution();
        int[][] matrix = {{1,2,3,4,5,6,7,8,9,10},{11,12,13,14,15,16,17,18,19,20}};
        System.out.print(solution.spiralOrder(matrix).toString());
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> spiralOrder(int[][] matrix) {
            /**
             * 暴力解法
             */
            int n = matrix.length, m = matrix[0].length;
            if (m * n == 0) return new ArrayList<>();
            List<Integer> res = new ArrayList<>();
            int index = 0;
            while (index < m - index && index < n - index) {
                res.addAll(getNums(matrix, index));
                index++;
            }
            return res;
        }

        private List<Integer> getNums(int[][] matrix, int index) {
            int n = matrix.length - 1, m = matrix[0].length - 1;
            List<Integer> temp = new ArrayList<>();
            //  排除特殊情况
            if (m - index < 0 || n - index < 0) return temp;
            if (index == m - index && index == n - index) {
                temp.add(matrix[index][index]);
                return temp;
            }
            if (index == m - index) {
                for (int i = index; i <= n - index; i++) {
                    temp.add(matrix[i][m - index]);
                }
                return temp;
            }
            if (index == n - index) {
                for (int i = index; i <= m - index; i++) {
                    temp.add(matrix[n - index][i]);
                }
                return temp;
            }
            // 根据index确定四个顶点的位置 然后遍历
            int[] pointA = new int[2], pointB = new int[2], pointC = new int[2], pointD = new int[2];
            pointA[0] = index;
            pointA[1] = index;
            pointB[0] = m - index;
            pointB[1] = index;
            pointA[0] = m - index;
            pointA[1] = n - index;
            pointA[0] = index;
            pointA[1] = n - index;
            //  pointA -> pointB
            for (int i = index; i < m - index; i++) {
                temp.add(matrix[index][i]);
            }
            //  pointB -> pointC
            for (int i = index; i < n - index; i++) {
                temp.add(matrix[i][m - index]);
            }
            //  pointC->pointD
            for (int i = m - index; i > index; i--) {
                temp.add(matrix[n - index][i]);
            }
            //  pointD->pointA
            for (int i = n - index; i > index; i--) {
                temp.add(matrix[i][index]);
            }
            return temp;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}