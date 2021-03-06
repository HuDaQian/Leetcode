//给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。 
//
// 示例 1: 
//
// 输入: 123
//输出: 321
// 
//
// 示例 2: 
//
// 输入: -123
//输出: -321
// 
//
// 示例 3: 
//
// 输入: 120
//输出: 21
// 
//
// 注意: 
//
// 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231, 231 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。 
// Related Topics 数学 
// 👍 2206 👎 0


package com.hudaqian.leetcode.editor.cn;

public class ReverseInteger {
    public static void main(String[] args) {
        Solution solution = new ReverseInteger().new Solution();
        System.out.print(String.format("%d", solution.reverse(321)));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int reverse(int x) {
            /**
             * rev来倒着记录数字
             * x逐步除10得余数加到rev后边
             * 当newRev倒转计算不等于rev得时候 数据溢出 返回0
             */
            int rev = 0;
            while (x != 0) {
                int newRev = rev * 10 + x % 10;
                if ((newRev - x % 10) / 10 != rev) return 0;
                rev = newRev;
                x /= 10;
            }
            return rev;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}