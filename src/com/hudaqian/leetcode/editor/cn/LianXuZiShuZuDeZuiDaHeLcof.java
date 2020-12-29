//输入一个整型数组，数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。 
//
// 要求时间复杂度为O(n)。 
//
// 
//
// 示例1: 
//
// 输入: nums = [-2,1,-3,4,-1,2,1,-5,4]
//输出: 6
//解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。 
//
// 
//
// 提示： 
//
// 
// 1 <= arr.length <= 10^5 
// -100 <= arr[i] <= 100 
// 
//
// 注意：本题与主站 53 题相同：https://leetcode-cn.com/problems/maximum-subarray/ 
//
// 
// Related Topics 分治算法 动态规划 
// 👍 185 👎 0


package com.hudaqian.leetcode.editor.cn;

public class LianXuZiShuZuDeZuiDaHeLcof {
    public static void main(String[] args) {
        Solution solution = new LianXuZiShuZuDeZuiDaHeLcof().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxSubArray(int[] nums) {
            /**
             * dp解法
             * 这里是空间优化以后的写法
             * prevMax 代表的是以当前数字结尾的最大子数组的和
             * max 代表到当前数字为止 其最大子数组的和
             */
            if (nums == null || nums.length == 0) return 0;
            int len = nums.length;
            int prevMax = nums[0];
            int max = nums[0];
            for (int i = 1; i < len; i++) {
                prevMax = Math.max(prevMax + nums[i], nums[i]);
                max = Math.max(max, prevMax);
            }
            return max;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}