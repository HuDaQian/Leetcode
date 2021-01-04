//在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个高效的函数，输入这样的一个二维数组和一个
//整数，判断数组中是否含有该整数。 
//
// 
//
// 示例: 
//
// 现有矩阵 matrix 如下： 
//
// 
//[
//  [1,   4,  7, 11, 15],
//  [2,   5,  8, 12, 19],
//  [3,   6,  9, 16, 22],
//  [10, 13, 14, 17, 24],
//  [18, 21, 23, 26, 30]
//]
//
//
// 给定 target = 5，返回 true。 
//
// 给定 target = 20，返回 false。 
//
// 
//
// 限制： 
//
// 0 <= n <= 1000 
//
// 0 <= m <= 1000 
//
// 
//
// 注意：本题与主站 240 题相同：https://leetcode-cn.com/problems/search-a-2d-matrix-ii/ 
// Related Topics 数组 双指针 
// 👍 193 👎 0


package com.hudaqian.leetcode.editor.cn;

import java.util.Arrays;

public class ErWeiShuZuZhongDeChaZhaoLcof {
    public static void main(String[] args) {
        Solution solution = new ErWeiShuZuZhongDeChaZhaoLcof().new Solution();
        int[][] matrix = {{1,2,3,4,5},{6,7,8,9,10},{11,12,13,14,15},{16,17,18,19,20},{21,22,23,24,25}};
        int target = 5;
        System.out.print(solution.findNumberIn2DArray(matrix, target));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean findNumberIn2DArray(int[][] matrix, int target) {
            /**
             * 遍历解法
             */
            if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;
            int row = 0, col = matrix[0].length - 1;
//            int m = matrix.length;
//            while (row < m && col >= 0) {
//                int num = matrix[row][col];
//                if (num == target) {
//                    return true;
//                } else if (num < target) {
//                    row++;
//                } else {
//                    col--;
//                }
//            }
//            return false;
            /**
             *  分割矩阵解法
             *  从中间将矩阵分割成四个部分 每个矩阵最小值就是左上顶点 最大值就是右下顶点 来判断target是否在矩阵内
             *  不断分割 最终结果是矩阵空间为0 或者空间为1 找到target
             */
            int[] points = new int[4];
            points[0] = 0;
            points[1] = 0;
            points[2] = matrix.length-1;
            points[3] = matrix[0].length-1;
            return findNumberIn2DArray(matrix, target, points);
        }
        private boolean findNumberIn2DArray(int[][] matrix, int target, int[] points) {
            boolean res = false;
            int[][] temp = getSubMatrix(matrix, points);
            for (int i = 0; i < 4; i++) {
                int[] checked = temp[i];
                int checkNum = checkMatrixSubTarget(matrix, target, checked);
                if (checkNum == 2) {
                    return true;
                }
                if (checkNum == 1) {
                    res = findNumberIn2DArray(matrix, target, checked) || res;
                }
            }
            return res;
        }


        private int checkMatrixSubTarget(int[][] matrix, int target, int[] points) {
            /**
             * -1 oneBoxNoHaveNumber
             * 0 noNumber
             * 1 haveNumber
             * 2 oneBoxHaveNumber
             */
            for (int i = 0; i < 4; i++) {
                if (points[i] == -1) {
                    return -1;
                }
            }
            int min = matrix[points[0]][points[1]];
            int max = matrix[points[2]][points[3]];
            if (points[0] == points[2] && points[1] == points[3]) {
                if (target == min) {
                    return 2;
                } else {
                    return -1;
                }
            } else {
                if (target >= min && target <= max) {
                    return 1;
                } else {
                    return 0;
                }
            }
        }

        private int[][] getSubMatrix(int[][] matrix, int[] points) {
            //  四个矩阵 四个数字分别代表其左上顶点和右下顶点的坐标
            int[][] res = new int[4][4];
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    res[i][j] = -1;
                }
            }
            if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return res;
            int sx = points[0], sy = points[1], ex = points[2], ey = points[3];
            int m = ex-sx, n = ey-sy;
            //  这里把不符合条件的矩阵四角都设定成了-1 实际上不用这么麻烦 有一个-1就表示矩阵无效了
            //  左上矩阵
            int aX = 0, aY = 0;
            int bX = m/2, bY = n/2;
            //  右下矩阵
            int cX = bX+1 > m ? -1 : bX+1;
            int cY = bY+1 > n ? -1 : bY+1;
            int dX = cX == -1 ? -1 : m;
            int dY = cY == -1 ? -1 : n;
            //  左下矩阵
            int eX = cX;
            int eY = eX == -1 ? -1: 0;
            int fX = eX == -1 ? -1 : m;
            int fY = fX == -1 ? -1 : bY;
            //  右上矩阵
            int gY = cY;
            int gX = gY == -1 ? -1 : 0;
            int hY = dY;
            int hX = hY == -1 ? -1 : bX;

            int[] leftTop = new int[4];
            leftTop[0] = aX+sx;
            leftTop[1] = aY+sy;
            leftTop[2] = bX+sx;
            leftTop[3] = bY+sy;
            int[] rightBottom = new int[4];
            rightBottom[0] = cX+sx;
            rightBottom[1] = cY+sy;
            rightBottom[2] = dX+sx;
            rightBottom[3] = dY+sy;
            int[] leftBottom = new int[4];
            leftBottom[0] = eX+sx;
            leftBottom[1] = eY+sy;
            leftBottom[2] = fX+sx;
            leftBottom[3] = fY+sy;
            int[] rightTop = new int[4];
            rightTop[0] = gX+sx;
            rightTop[1] = gY+sy;
            rightTop[2] = hX+sx;
            rightTop[3] = hY+sy;

            res[0] = leftTop;
            res[1] = rightBottom;
            res[2] = leftBottom;
            res[3] = rightTop;
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}