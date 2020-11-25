//实现 pow(x, n) ，即计算 x 的 n 次幂函数。 
//
// 示例 1: 
//
// 输入: 2.00000, 10
//输出: 1024.00000
// 
//
// 示例 2: 
//
// 输入: 2.10000, 3
//输出: 9.26100
// 
//
// 示例 3: 
//
// 输入: 2.00000, -2
//输出: 0.25000
//解释: 2-2 = 1/22 = 1/4 = 0.25 
//
// 说明: 
//
// 
// -100.0 < x < 100.0 
// n 是 32 位有符号整数，其数值范围是 [−231, 231 − 1] 。 
// 
// Related Topics 数学 二分查找 
// 👍 548 👎 0


package com.hudaqian.leetcode.editor.cn;

public class PowxN {
    public static void main(String[] args) {
        Solution solution = new PowxN().new Solution();
        double x = 2.1;
        int n = 3;
        System.out.print(solution.myPow(x, n));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public double myPow(double x, int n) {
            /**
             * 解法1：递归
             */
//        long ln = n;
//        return QuickMul(x,ln);
            /**
             * 解法2：迭代
             */
            long ln = n;
            return ln >= 0 ? QuickMul2(x, ln) : 1.0 / QuickMul2(x, -ln);
        }

        private double QuickMul2(double x, long n) {
            double temp = x;
            double ans = 1.0;
            while (n > 0) {
                if (n%2 != 0) {
                    ans *= temp;
                }
                temp *= temp;
                n /= 2;
            }
            return ans;
        }

        private double QuickMul(double x, long n) {
            /**
             * 递归解法的方法
             */
            if (n == 0) {
                return 1.0;
            }
            double y = QuickMul(x, n / 2);
            return n / 2 == 0 ? y * y : y * y * x;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}