//给定一个二进制数组， 计算其中最大连续1的个数。 
//
// 示例 1: 
//
// 
//输入: [1,1,0,1,1,1]
//输出: 3
//解释: 开头的两位和最后的三位都是连续1，所以最大连续1的个数是 3.
// 
//
// 注意： 
//
// 
// 输入的数组只包含 0 和1。 
// 输入数组的长度是正整数，且不超过 10,000。 
// 
// Related Topics 数组 
// 👍 141 👎 0


    package com.hudaqian.leetcode.editor.cn;
    public class MaxConsecutiveOnes {
        public static void main(String[] args) {
            Solution solution = new MaxConsecutiveOnes().new Solution();
            int[] nums = {1,1,1,0,1,1,0,1,1,0,1,1,1,1,1};
            System.out.print(solution.findMaxConsecutiveOnes(nums));
        }
       //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int numsLength = nums.length;
        int count = 0,max = 0;
        for (int i = 0; i < numsLength; i++) {
            if (nums[i] == 1) {
                count++;
            } else {
                /**
                 * 这里统计比count数值改变统计要少一些计算
                 */
                max = Math.max(max, count);
                count = 0;
            }
        }
        max = Math.max(max, count);
        return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

    }