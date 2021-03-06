//数组的每个索引作为一个阶梯，第 i个阶梯对应着一个非负数的体力花费值 cost[i](索引从0开始)。 
//
// 每当你爬上一个阶梯你都要花费对应的体力花费值，然后你可以选择继续爬一个阶梯或者爬两个阶梯。 
//
// 您需要找到达到楼层顶部的最低花费。在开始时，你可以选择从索引为 0 或 1 的元素作为初始阶梯。 
//
// 示例 1: 
//
// 输入: cost = [10, 15, 20]
//输出: 15
//解释: 最低花费是从cost[1]开始，然后走两步即可到阶梯顶，一共花费15。
// 
//
// 示例 2: 
//
// 输入: cost = [1, 100, 1, 1, 1, 100, 1, 1, 100, 1]
//输出: 6
//解释: 最低花费方式是从cost[0]开始，逐个经过那些1，跳过cost[3]，一共花费6。
// 
//
// 注意： 
//
// 
// cost 的长度将会在 [2, 1000]。 
// 每一个 cost[i] 将会是一个Integer类型，范围为 [0, 999]。 
// 
// Related Topics 数组 动态规划 
// 👍 409 👎 0


    package com.hudaqian.leetcode.editor.cn;
    public class MinCostClimbingStairs {
        public static void main(String[] args) {
            Solution solution = new MinCostClimbingStairs().new Solution();
            int[] cost = {841,462,566,398,243,248,238,650,989,501,54,189,451,179,849,760,689,539,453,450,404,852,707,191};
            System.out.print(solution.minCostClimbingStairs(cost));
        }
       //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minCostClimbingStairs(int[] cost) {
        /**
         * 解法1：动态规划
         */
        int[] dp = new int[cost.length+1];
        dp[0] = 0;
        dp[1] = cost[0];
        for (int i=2;i<=cost.length;i++) {
            dp[i] = Math.min(dp[i-1],dp[i-2]) + cost[i-1];
        }
        return Math.min(dp[cost.length-1],dp[cost.length]);
        /**
         * 解法2：递归
         * 超时
         */
//        return getMinStairs(cost, cost.length+1);
    }
    private int getMinStairs(int[] cost, int k) {
        if (k==0) return 0;
        if (k==1) return cost[0];
        int costOne = 0;
        if (k<=cost.length) {
            costOne = cost[k-1];
        }
        int last1 = getMinStairs(cost,k-1);
        int last2 = getMinStairs(cost,k-2);
        return Math.min(last1,last2)+costOne;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

    }