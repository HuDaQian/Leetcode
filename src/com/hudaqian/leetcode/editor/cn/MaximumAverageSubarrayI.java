//给定 n 个整数，找出平均数最大且长度为 k 的连续子数组，并输出该最大平均数。 
//
// 
//
// 示例： 
//
// 
//输入：[1,12,-5,-6,50,3], k = 4
//输出：12.75
//解释：最大平均数 (12-5-6+50)/4 = 51/4 = 12.75
// 
//
// 
//
// 提示： 
//
// 
// 1 <= k <= n <= 30,000。 
// 所给数据范围 [-10,000，10,000]。 
// 
// Related Topics 数组 
// 👍 137 👎 0


package com.hudaqian.leetcode.editor.cn;

public class MaximumAverageSubarrayI {
    public static void main(String[] args) {
        Solution solution = new MaximumAverageSubarrayI().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public double findMaxAverage(int[] nums, int k) {
            if (nums == null || nums.length == 0 || k == 0) return 0;
            int sum = 0;
            for (int i = 0; i < k; i++) {
                sum += nums[i];
            }
            int maxNum = sum;
            for (int i = k; i < nums.length; i++) {
                sum -= nums[i - k];
                sum += nums[i];
                maxNum = Math.max(maxNum, sum);
            }
            return (double) maxNum / k;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}