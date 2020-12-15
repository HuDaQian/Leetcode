//给定一个非负整数 N，找出小于或等于 N 的最大的整数，同时这个整数需要满足其各个位数上的数字是单调递增。 
//
// （当且仅当每个相邻位数上的数字 x 和 y 满足 x <= y 时，我们称这个整数是单调递增的。） 
//
// 示例 1: 
//
// 输入: N = 10
//输出: 9
// 
//
// 示例 2: 
//
// 输入: N = 1234
//输出: 1234
// 
//
// 示例 3: 
//
// 输入: N = 332
//输出: 299
// 
//
// 说明: N 是在 [0, 10^9] 范围内的一个整数。 
// Related Topics 贪心算法 
// 👍 92 👎 0


package com.hudaqian.leetcode.editor.cn;

public class MonotoneIncreasingDigits {
    public static void main(String[] args) {
        Solution solution = new MonotoneIncreasingDigits().new Solution();
        int N = 120;
        System.out.print(solution.monotoneIncreasingDigits(N));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int monotoneIncreasingDigits(int N) {
            /**
             * 贪心解法
             * 思路是依次比较当前位和下一位的数字 如果当前位的数字大于下一位的数字 那么当前位减1 后边的数都变成9
             * 注意在第一次循环中符合条件的直接跳出
             * 因为不确定减1以后会不会比前一位小 所以要再次从后往前判断
             * 最后index指定的最后一个不变成9的位置
             */
            char[] nums = Integer.toString(N).toCharArray();
            int index = 0;
            while (index < nums.length-1 && nums[index] <= nums[index + 1]) {
                index++;
            }
            if (index == nums.length-1) return N;

            nums[index]--;
            for (int i = index + 1; i < nums.length; i++) {
                nums[i] = '9';
            }

            while (index > 0){
                if (nums[index-1] > nums[index]) {
                    nums[index-1]--;
                    nums[index] = '9';
                }
                index--;
            }
            return Integer.parseInt(new String(nums));
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}