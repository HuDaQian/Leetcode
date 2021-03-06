//给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。 
//
// 设计一个算法来计算你所能获取的最大利润。你最多可以完成 两笔 交易。 
//
// 注意: 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。 
//
// 示例 1: 
//
// 输入: [3,3,5,0,0,3,1,4]
//输出: 6
//解释: 在第 4 天（股票价格 = 0）的时候买入，在第 6 天（股票价格 = 3）的时候卖出，这笔交易所能获得利润 = 3-0 = 3 。
//     随后，在第 7 天（股票价格 = 1）的时候买入，在第 8 天 （股票价格 = 4）的时候卖出，这笔交易所能获得利润 = 4-1 = 3 。 
//
// 示例 2: 
//
// 输入: [1,2,3,4,5]
//输出: 4
//解释: 在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。   
//     注意你不能在第 1 天和第 2 天接连购买股票，之后再将它们卖出。   
//     因为这样属于同时参与了多笔交易，你必须在再次购买前出售掉之前的股票。
// 
//
// 示例 3: 
//
// 输入: [7,6,4,3,1] 
//输出: 0 
//解释: 在这个情况下, 没有交易完成, 所以最大利润为 0。 
// Related Topics 数组 动态规划 
// 👍 584 👎 0


package com.hudaqian.leetcode.editor.cn;

public class BestTimeToBuyAndSellStockIii {
    public static void main(String[] args) {
        Solution solution = new BestTimeToBuyAndSellStockIii().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxProfit(int[] prices) {
//            if (prices == null || prices.length == 0) return 0;
//            /**
//             * dp解法
//             */
//            int len = prices.length;
//            //  第一层代表哪一天
//            //  第二层代表最大交易几次 0 1 2
//            //  第三层还是两个状态 持有 和未持有
//            int[][][] dp = new int[len][3][2];
//            dp[0][1][0] = 0;
//            dp[0][1][1] = -prices[0];
//            dp[0][2][0] = 0;
//            dp[0][2][1] = -prices[0];
//            for (int i = 1; i < len; i++) {
////                //  这个是第i天未持有 最大一次交易的最大收益 就是上一天还未持有 或者上一天持有 这一天卖了
////                int temp0 = Math.max(dp[i-1][1][0], dp[i-1][1][1]+prices[i]);
////                //  这个是第i天持有  最大一次交易的最大收益 就是上一天就持有 或者上一天未持有（因为最大一次交易 所以从0中取 就相当于0-price[i]） 这一天买了
////                int temp1 = Math.max(dp[i-1][1][1], dp[i-1][0][0]-prices[i]);
////                //  这个是第i天未持有 最大两次交易的最大收益 就是 上一天还未持有 或者上一天持有 这一天卖了
////                int temp2 = Math.max(dp[i-1][2][0], dp[i-1][2][1]+prices[i]);
////                //  这个是第i天持有 最大两次交易的最大收益  就是 上一天持有 或者上一天没有 这一天买了
////                int temp3 = Math.max(dp[i-1][2][1], dp[i-1][1][0]-prices[i]);
////                dp[i][1][0] = temp0;
////                dp[i][1][1] = temp1;
////                dp[i][2][0] = temp2;
////                dp[i][2][1] = temp3;
//                /**
//                 * 优化一下
//                 */
//                dp[i][2][0] = Math.max(dp[i-1][2][0], dp[i-1][2][1]+prices[i]);
//                dp[i][2][1] = Math.max(dp[i-1][2][1], dp[i-1][1][0]-prices[i]);
//                dp[i][1][0] = Math.max(dp[i-1][1][0], dp[i-1][1][1]+prices[i]);
//                dp[i][1][1] = Math.max(dp[i-1][1][1], dp[i-1][0][0]-prices[i]);
//            }
//            return dp[len-1][2][0];
            /**
             * dp解法 空间优化
             */
            if (prices == null || prices.length == 0) return 0;
            int maxResOne0 = 0, maxResOne1 = -prices[0], maxResTwo0 = 0, maxResTwo1 = -prices[0];
            for (int i = 1; i < prices.length; i++) {
                maxResTwo0 = Math.max(maxResTwo0, maxResTwo1+prices[i]);
                maxResTwo1 = Math.max(maxResTwo1, maxResOne0-prices[i]);
                maxResOne0 = Math.max(maxResOne0, maxResOne1+prices[i]);
                maxResOne1 = Math.max(maxResOne1, -prices[i]);
            }
            return maxResTwo0;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}