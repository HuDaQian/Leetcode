//判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。 
//
// 示例 1: 
//
// 输入: 121
//输出: true
// 
//
// 示例 2: 
//
// 输入: -121
//输出: false
//解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
// 
//
// 示例 3: 
//
// 输入: 10
//输出: false
//解释: 从右向左读, 为 01 。因此它不是一个回文数。
// 
//
// 进阶: 
//
// 你能不将整数转为字符串来解决这个问题吗？ 
// Related Topics 数学 
// 👍 1249 👎 0


package com.hudaqian.leetcode.editor.cn;

public class PalindromeNumber {
    public static void main(String[] args) {
        Solution solution = new PalindromeNumber().new Solution();
        System.out.print(Boolean.toString(solution.isPalindrome(1235321)));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isPalindrome(int x) {
            if (x < 0 || (x > 0 && x % 10 == 0)) return false;
            int num = x, div = 1;
            while (num / div >= 10) {
                div *= 10;
            }
            while (num != 0) {
                int left = num / div;
                int right = num % 10;
                if (left != right) return false;
                num = (num - left * div) / 10;
                div /= 100;
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}