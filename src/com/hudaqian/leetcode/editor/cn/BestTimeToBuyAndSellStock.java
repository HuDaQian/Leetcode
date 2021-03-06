//给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。 
//
// 如果你最多只允许完成一笔交易（即买入和卖出一支股票一次），设计一个算法来计算你所能获取的最大利润。 
//
// 注意：你不能在买入股票前卖出股票。 
//
// 
//
// 示例 1: 
//
// 输入: [7,1,5,3,6,4]
//输出: 5
//解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
//     注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。
// 
//
// 示例 2: 
//
// 输入: [7,6,4,3,1]
//输出: 0
//解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
// 
// Related Topics 数组 动态规划 
// 👍 1262 👎 0


    package com.hudaqian.leetcode.editor.cn;
    public class BestTimeToBuyAndSellStock {
        public static void main(String[] args) {
            Solution solution = new BestTimeToBuyAndSellStock().new Solution();
            int[] prices = {5,4,7,8,9,6,3,6,7,8,2,4,5,6,1,9};
            System.out.print(solution.maxProfit(prices));
        }
       //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxProfit(int[] prices) {
        /**
         * 求每一天到区间最小的那一天的prices的差 然后取最大的差
         * 相当于将prices 分割成 n个波谷上升的区间（即开始到第一次最低 然后再到波谷或者连续降低最低值）
         * 举例：5，4，7，8，9，6，3，6，7，8，2，4，5，6，1，9
         * 分割为 [5] [4,7,8,9] [6] [3,6,7,8] [2,4,5,6] [1,9] 比较这几个区间的最大差9-4 8-3 6-2 9-1
         * 然后求各个区间到波谷的差
         */
//        int minPrice = Integer.MAX_VALUE;
//        int maxporfit = 0;
//        for (int i=0;i<prices.length;i++) {
//            if (prices[i] < minPrice) {
//                minPrice = prices[i];
//            } else if (prices[i] - minPrice > maxporfit) {
//                maxporfit = prices[i] - minPrice;
//            }
//        }
//        return maxporfit;
        /**
         * dp解法
         */
        if (prices == null || prices.length == 0) return 0;
        int len = prices.length;
        // profit0 代表第i天未持有股票的最大收益
        // profit1 代表第i天持有股票的最大收益 因为只允许进行一次交易 所以如果要在第i天持有 那么值钱不允许进行交易
        int profit0 = 0, profit1 = - prices[0];
        for (int i = 1; i < len; i++ ) {
            profit0 = Math.max(profit1+prices[i], profit0);
            profit1 = Math.max(profit1, -prices[i]);
        }
        return profit0;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

    }