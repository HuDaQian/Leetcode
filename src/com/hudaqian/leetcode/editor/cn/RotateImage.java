//给定一个 n × n 的二维矩阵表示一个图像。 
//
// 将图像顺时针旋转 90 度。 
//
// 说明： 
//
// 你必须在原地旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要使用另一个矩阵来旋转图像。 
//
// 示例 1: 
//
// 给定 matrix = 
//[
//  [1,2,3],
//  [4,5,6],
//  [7,8,9]
//],
//
//原地旋转输入矩阵，使其变为:
//[
//  [7,4,1],
//  [8,5,2],
//  [9,6,3]
//]
// 
//
// 示例 2: 
//
// 给定 matrix =
//[
//  [ 5, 1, 9,11],
//  [ 2, 4, 8,10],
//  [13, 3, 6, 7],
//  [15,14,12,16]
//], 
//
//原地旋转输入矩阵，使其变为:
//[
//  [15,13, 2, 5],
//  [14, 3, 4, 1],
//  [12, 6, 8, 9],
//  [16, 7,10,11]
//]
// 
// Related Topics 数组 
// 👍 625 👎 0


package com.hudaqian.leetcode.editor.cn;

public class RotateImage {
    public static void main(String[] args) {
        /**
         * 见面试题：旋转矩阵
         */
        RotateMatrixLcci.Solution solution = new RotateMatrixLcci().new Solution();
        int[][] matrix = {{5, 1, 9, 11}, {2, 4, 8, 10}, {13, 3, 6, 7}, {15, 14, 12, 16}};
        solution.rotate(matrix);
        System.out.print(matrix);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void rotate(int[][] matrix) {
            int length = matrix.length;
            /**
             * 解法1：转轴+反转
             */
//            /**
//             * x y轴替换
//             */
//            for (int i = 0; i < length; i++) {
//                for (int j = i; j < length; j++) {
//                    int temp = matrix[i][j];
//                    matrix[i][j] = matrix[j][i];
//                    matrix[j][i] = temp;
//                }
//            }
//            /**
//             * 横向反转
//             */
//            for (int i = 0; i < length; i++) {
//                for (int j = 0; j < length/2; j++) {
//                    int temp = matrix[i][j];
//                    matrix[i][j] = matrix[i][length - j - 1];
//                    matrix[i][length - j - 1] = temp;
//                }
//            }
            /**
             * 解法2：外圈到内圈 四格旋转
             *
             * i表示层数
             * j表示每层旋转的次数 从第i格子开始到距离边界i个格子结束
             *
             * 0,0
             * 0,length-1
             * length-1,length-1
             * length-1,0
             *
             * 0,j
             * j,length-1
             * length-1,length-1-j
             * length-1-j,0
             *
             * i,j
             * j,length-1-i
             * length-1-i,length-1-j
             * length-1-j,i
             */
            for (int i = 0; i < (length + 1) / 2; i++) {
                for (int j = i; j < (length - i - 1); j++) {
                    int temp = matrix[i][j];
                    matrix[i][j] = matrix[length - 1 - j][i];
                    matrix[length - 1 - j][i] = matrix[length - i - 1][length - j - 1];
                    matrix[length - i - 1][length - j - 1] = matrix[j][length - 1 - i];
                    matrix[j][length - 1 - i] = temp;
                }
            }
            /**
             * 5,1,9,11
             * 2,4,8,10
             * 13,3,6,7
             * 15,14,12,16
             *
             * 15,1,9,5
             * 2,4,8,10
             * 13,3,6,7
             * 16,14,12,11
             *
             * 15,13,2,5
             * 14,6,3,1
             * 12,8,4,9
             * 16,7,10,11
             *
             * 15,13,9,5
             * 14,3,4,1
             * 12,6,8,9
             * 16,7,10,11
             */
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}