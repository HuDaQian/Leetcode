//给定一个整数 (32 位有符号整数)，请编写一个函数来判断它是否是 4 的幂次方。 
//
// 示例 1: 
//
// 输入: 16
//输出: true
// 
//
// 示例 2: 
//
// 输入: 5
//输出: false 
//
// 进阶： 
//你能不使用循环或者递归来完成本题吗？ 
// Related Topics 位运算 
// 👍 149 👎 0


package com.hudaqian.leetcode.editor.cn;

public class PowerOfFour {
    public static void main(String[] args) {
        Solution solution = new PowerOfFour().new Solution();
        int num = 2;
        System.out.print(solution.isPowerOfFour(num));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isPowerOfFour(int n) {
            if (n == 0) return false;
            while (n % 4 == 0) n /= 4;
            return n == 1;
//            return (n > 0) && (Math.log(n) / Math.log(2) % 2 == 0);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}