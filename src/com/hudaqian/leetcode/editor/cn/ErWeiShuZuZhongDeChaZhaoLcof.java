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

public class ErWeiShuZuZhongDeChaZhaoLcof {
    public static void main(String[] args) {
        Solution solution = new ErWeiShuZuZhongDeChaZhaoLcof().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean findNumberIn2DArray(int[][] matrix, int target) {
            /**
             * 遍历解法
             */
//            if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;
//            int row = 0, col = matrix[0].length - 1;
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
            return false;
            /**
             *  分割矩阵解法
             *  从中间将矩阵分割成四个部分 每个矩阵最小值就是左上顶点 最大值就是右下顶点 来判断target是否在矩阵内
             *  不断分割 最终结果是矩阵空间为0 或者空间为1 找到target
             */

        }

        private int[][] getSubMatrix(int[][] matrix) {
            //  四个矩阵 四个数字分别代表其左上顶点和右下顶点的坐标
            int[][] res = new int[4][4];
            if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return res;
            int m = matrix.length, n = matrix[0].length;
            //  这里把不符合条件的矩阵四角都设定成了-1 实际上不用这么麻烦 有一个-1就表示矩阵无效了
            //  左上矩阵
            int aX = 0, aY = 0;
            int bX = m/2, bY = n/2;
            //  右下矩阵
            int cX = bX+1 >= m ? -1 : bX+1;
            int cY = bY+1 >= n ? -1 : bY+1;
            int dX = cX == -1 ? -1 : m-1;
            int dY = cY == -1 ? -1 : n-1;
            //  左下矩阵
            int eX = cX;
            int eY = eX == -1 ? -1: 0;
            int fX = eX == -1 ? -1 : m-1;
            int fY = fX == -1 ? -1 : bY;
            //  右上矩阵
            int gY = cY;
            int gX = gY == -1 ? -1 : 0;
            int hY = dY;
            int hX = hY == -1 ? -1 : 0;

            int[] leftTop = new int[4];
            leftTop[0] = aX;
            leftTop[1] = aY;
            leftTop[2] = bX;
            leftTop[3] = bY;
            int[] rightBottom = new int[4];
            rightBottom[0] = cX;
            rightBottom[1] = cY;
            rightBottom[2] = dX;
            rightBottom[3] = dY;
            int[] leftBottom = new int[4];
            leftBottom[0] = eX;
            leftBottom[1] = eY;
            leftBottom[2] = fX;
            leftBottom[3] = fY;
            int[] rightTop = new int[4];
            rightTop[0] = gX;
            rightTop[1] = gY;
            rightTop[2] = hX;
            rightTop[3] = hY;

            res[0] = leftTop;
            res[1] = rightBottom;
            res[2] = leftBottom;
            res[3] = rightTop;
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}