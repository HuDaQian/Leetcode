//给你一个 m x n 的矩阵 matrix 。如果这个矩阵是托普利茨矩阵，返回 true ；否则，返回 false 。 
//
// 如果矩阵上每一条由左上到右下的对角线上的元素都相同，那么这个矩阵是 托普利茨矩阵 。 
//
// 
//
// 示例 1： 
//
// 
//输入：matrix = [[1,2,3,4],[5,1,2,3],[9,5,1,2]]
//输出：true
//解释：
//在上述矩阵中, 其对角线为: 
//"[9]", "[5, 5]", "[1, 1, 1]", "[2, 2, 2]", "[3, 3]", "[4]"。 
//各条对角线上的所有元素均相同, 因此答案是 True 。
// 
//
// 示例 2： 
//
// 
//输入：matrix = [[1,2],[2,2]]
//输出：false
//解释：
//对角线 "[1, 2]" 上的元素不同。 
//
// 
//
// 提示： 
//
// 
// m == matrix.length 
// n == matrix[i].length 
// 1 <= m, n <= 20 
// 0 <= matrix[i][j] <= 99 
// 
//
// 
//
// 进阶： 
//
// 
// 如果矩阵存储在磁盘上，并且内存有限，以至于一次最多只能将矩阵的一行加载到内存中，该怎么办？ 
// 如果矩阵太大，以至于一次只能将不完整的一行加载到内存中，该怎么办？ 
// 
// Related Topics 数组 
// 👍 172 👎 0


package com.hudaqian.leetcode.editor.cn;

public class ToeplitzMatrix {
    public static void main(String[] args) {
        Solution solution = new ToeplitzMatrix().new Solution();
        int[][] matrix = {{1, 2}, {2, 2}};
        System.out.print(solution.isToeplitzMatrix(matrix));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isToeplitzMatrix(int[][] matrix) {
            /**
             * 模拟遍历
             * 从(m-1,0) 到 (0，n-1)
             */
//            if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;
            int m = matrix.length, n = matrix[0].length;
            for (int i = 0; i < m + n - 1; i++) {
                int section = i > m - 1 ? 0 : m - 1 - i;
                int row = i > m - 1 ? i - m : 0;

                int x = section, y = row;
                while (x <= m - 1 && y <= n - 1) {
                    if ((matrix[x][y] ^ matrix[section][row]) != 0) {
                        return false;
                    }
                    x++;
                    y++;
                }
            }
            return true;
            /**
             * 直接遍历
             */
//            if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;
//            int m = matrix.length, n = matrix[0].length;
//            for (int i = 1; i < m; i++) {
//                for (int j = 1; j < n; j++) {
//                    if ((matrix[i][j] ^ matrix[i-1][j-1]) != 0) return false;
//                }
//            }
//            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}