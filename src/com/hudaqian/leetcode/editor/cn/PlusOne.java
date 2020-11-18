//给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。 
//
// 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。 
//
// 你可以假设除了整数 0 之外，这个整数不会以零开头。 
//
// 示例 1: 
//
// 输入: [1,2,3]
//输出: [1,2,4]
//解释: 输入数组表示数字 123。
// 
//
// 示例 2: 
//
// 输入: [4,3,2,1]
//输出: [4,3,2,2]
//解释: 输入数组表示数字 4321。
// 
// Related Topics 数组 
// 👍 572 👎 0


    package com.hudaqian.leetcode.editor.cn;

import java.util.Arrays;

public class PlusOne {
        public static void main(String[] args) {
            Solution solution = new PlusOne().new Solution();
            int[] num = {1,2,3,4,5,6,7,8,9};
            System.out.print(solution.plusOne(num));
        }
       //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] plusOne(int[] digits) {
        /**
         * 倒着遍历
         * 求除10余数 如果为0 那么数字加1已经超过10 继续遍历直到不为0，如果遍历到了首部依旧为0 那么新建一个长度大于1的数组 然后设定首位为1就好了
         */
        int length = digits.length;
        for (int i = length-1; i >= 0; i--) {
            int num = digits[i];
            num++;
            num %= 10;
            digits[i] = num;
            if (num != 0) {
                return digits;
            }
        }
        int[] res = new int[length+1];
        res[0] = 1;
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

    }