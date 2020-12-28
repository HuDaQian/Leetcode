//给定一个整数数组 prices，其中第 i 个元素代表了第 i 天的股票价格 ；非负整数 fee 代表了交易股票的手续费用。 
//
// 你可以无限次地完成交易，但是你每笔交易都需要付手续费。如果你已经购买了一个股票，在卖出它之前你就不能再继续购买股票了。 
//
// 返回获得利润的最大值。 
//
// 注意：这里的一笔交易指买入持有并卖出股票的整个过程，每笔交易你只需要为支付一次手续费。 
//
// 示例 1: 
//
// 输入: prices = [1, 3, 2, 8, 4, 9], fee = 2
//输出: 8
//解释: 能够达到的最大利润:  
//在此处买入 prices[0] = 1
//在此处卖出 prices[3] = 8
//在此处买入 prices[4] = 4
//在此处卖出 prices[5] = 9
//总利润: ((8 - 1) - 2) + ((9 - 4) - 2) = 8. 
//
// 注意: 
//
// 
// 0 < prices.length <= 50000. 
// 0 < prices[i] < 50000. 
// 0 <= fee < 50000. 
// 
// Related Topics 贪心算法 数组 动态规划 
// 👍 327 👎 0


package com.hudaqian.leetcode.editor.cn;

public class BestTimeToBuyAndSellStockWithTransactionFee {
    public static void main(String[] args) {
        Solution solution = new BestTimeToBuyAndSellStockWithTransactionFee().new Solution();
//        prices = [1, 3, 2, 8, 4, 9], fee = 2
        int[] prices = {1, 3, 2, 8, 4, 9};
        int fee = 2;
        System.out.print(solution.maxProfit(prices, fee));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxProfit(int[] prices, int fee) {
            /**
             * 动态规划
             */
//            if (prices.length == 0) return 0;
//            int[][] dp = new int[2][prices.length];
//            // dp[0][i] 代表第i天不持有股票手里的钱 它有可能从两种状态而来 前一天有今天卖了 和 前一天没有
//            dp[0][0] = 0;
//            // dp[1][i] 代表第i天持有股票手里的钱 它有可能从两种状态而来  前一天有 和前一天没有今天买了
//            dp[1][0] = -prices[0];
//            for (int i = 1; i < prices.length; i++) {
//                dp[0][i] = Math.max(dp[0][i - 1], dp[1][i - 1] + prices[i] - fee);
//                dp[1][i] = Math.max(dp[1][i - 1], dp[0][i - 1] - prices[i]);
//            }
//            return Math.max(dp[0][prices.length - 1], dp[1][prices.length - 1]);
            /**
             * 动态规划 空间优化
             */
            if (prices.length == 0) return 0;
            int[] dp = new int[2];
            dp[1] = -prices[0];
            for (int i = 1; i < prices.length; i++) {
                dp[0] = Math.max(dp[0],dp[1]+prices[i]-fee);
                dp[1] = Math.max(dp[1],dp[0]-prices[i]);
            }
            return Math.max(dp[0],dp[1]);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}