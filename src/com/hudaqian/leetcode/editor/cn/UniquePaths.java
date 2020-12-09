//一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。 
//
// 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。 
//
// 问总共有多少条不同的路径？ 
//
// 
//
// 例如，上图是一个7 x 3 的网格。有多少可能的路径？ 
//
// 
//
// 示例 1: 
//
// 输入: m = 3, n = 2
//输出: 3
//解释:
//从左上角开始，总共有 3 条路径可以到达右下角。
//1. 向右 -> 向右 -> 向下
//2. 向右 -> 向下 -> 向右
//3. 向下 -> 向右 -> 向右
// 
//
// 示例 2: 
//
// 输入: m = 7, n = 3
//输出: 28 
//
// 
//
// 提示： 
//
// 
// 1 <= m, n <= 100 
// 题目数据保证答案小于等于 2 * 10 ^ 9 
// 
// Related Topics 数组 动态规划 
// 👍 781 👎 0


package com.hudaqian.leetcode.editor.cn;

public class UniquePaths {
    public static void main(String[] args) {
        Solution solution = new UniquePaths().new Solution();
        int m = 3, n = 2;
        System.out.print(solution.uniquePaths(m, n));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int uniquePaths(int m, int n) {
            /**
             * 解法1 数学法 总共要走m+n-2次 m-1次向右走 n-1次向下走
             * 所以 从m+n-2中找出m-1的情况即可
             * 也就是 C(m-1)(m+n-2)
             * 或者说 C(n-1)(m+n-2)
             */
            // 优化一下 m和n 谁小 用谁来计算
//            if (m > n) return uniquePaths(n, m);
//            long ans = 1;
//            //  注意这里 是从1开始 到n
//            for (int i = m, j = 1; j < n; j++, i++) {
//                ans = ans * i / j;
//            }
//            return (int)ans;
            /**
             * 解法2：动态规划
             * 使用f(x,y) 来代表到第x，y的格子需要多少步
             * 边界：所有边界值定位1
             */
            int[][] dp = new int[m][n];
            for (int i = 0; i < m; i++) {
                dp[i][0] = 1;
            }
            for (int i = 0; i < n; i++) {
                dp[0][i] = 1;
            }
            for (int i = 1; i < m; i++) {
                for (int j = 1; j < n; j++) {
                    dp[i][j] = dp[i-1][j] + dp [i][j-1];
                }
            }
            return dp[m-1][n-1];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}