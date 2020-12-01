//斐波那契数，通常用 F(n) 表示，形成的序列称为斐波那契数列。该数列由 0 和 1 开始，后面的每一项数字都是前面两项数字的和。也就是： 
//
// F(0) = 0,   F(1) = 1
//F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
// 
//
// 给定 N，计算 F(N)。 
//
// 
//
// 示例 1： 
//
// 输入：2
//输出：1
//解释：F(2) = F(1) + F(0) = 1 + 0 = 1.
// 
//
// 示例 2： 
//
// 输入：3
//输出：2
//解释：F(3) = F(2) + F(1) = 1 + 1 = 2.
// 
//
// 示例 3： 
//
// 输入：4
//输出：3
//解释：F(4) = F(3) + F(2) = 2 + 1 = 3.
// 
//
// 
//
// 提示： 
//
// 
// 0 ≤ N ≤ 30 
// 
// Related Topics 数组 
// 👍 177 👎 0


package com.hudaqian.leetcode.editor.cn;

public class FibonacciNumber {
    public static void main(String[] args) {
        Solution solution = new FibonacciNumber().new Solution();
        int N = 10;
        System.out.print(solution.fib(N));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int fib(int N) {
            /**
             * 解法1：递归
             */
//            if (N <= 1){
//                return N;
//            }
//            return fib(N-1) + fib(N-2);
            /**
             * 解法2：迭代
             */
//            if (N <= 1) return N;
//            if (N == 2) return 1;
//            int current = 0,prev1 = 1,prev2 = 1;
//            for (int i = 3; i <= N; i++) {
//                current = prev1 + prev2;
//                prev2 = prev1;
//                prev1 = current;
//            }
//            return current;
            /**
             * 解法3：dp解法
             */
            if (N <= 1) return N;
            int[] dp = new int[N+1];
            dp[1] = 1;
            for (int i=2;i<dp.length;i++) {
                dp[i] = dp[i-1] + dp[i-2];
            }
            return dp[N];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}