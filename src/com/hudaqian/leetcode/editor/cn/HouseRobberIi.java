//你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都 围成一圈 ，这意味着第一个房屋和最后一个房屋是紧挨着的。同时，相邻的
//房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警 。 
//
// 给定一个代表每个房屋存放金额的非负整数数组，计算你 在不触动警报装置的情况下 ，能够偷窃到的最高金额。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [2,3,2]
//输出：3
//解释：你不能先偷窃 1 号房屋（金额 = 2），然后偷窃 3 号房屋（金额 = 2）, 因为他们是相邻的。
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3,1]
//输出：4
//解释：你可以先偷窃 1 号房屋（金额 = 1），然后偷窃 3 号房屋（金额 = 3）。
//     偷窃到的最高金额 = 1 + 3 = 4 。 
//
// 示例 3： 
//
// 
//输入：nums = [0]
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 100 
// 0 <= nums[i] <= 1000 
// 
// Related Topics 动态规划 
// 👍 435 👎 0


package com.hudaqian.leetcode.editor.cn;

public class HouseRobberIi {
    public static void main(String[] args) {
        Solution solution = new HouseRobberIi().new Solution();
        int[] nums = {4, 1, 2, 7, 5, 3, 1};
        System.out.print(solution.rob(nums));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int rob(int[] nums) {
            /**
             * 要想取到最大值  第一间和最后一间必须取一个偷
             * 所以 思路是 先计算偷第一间的最大值  然后再计算不偷第一间偷最后一间的最大值 然后比较一下
             */
            if (nums == null || nums.length == 0) return 0;
            if (nums.length < 2) return nums[0];
            int len = nums.length;
            int[] dp1 = new int[len];
            dp1[0] = nums[0];
            dp1[1] = dp1[0];
            int[] dp2 = new int[len];
            dp2[0] = 0;
            dp2[1] = nums[1];
            /**
             * 偷了第一间 就不能偷最后一间
             */
            for (int i = 2; i < len - 1; i++) {
                dp1[i] = Math.max(dp1[i - 2] + nums[i], dp1[i - 1]);
                dp2[i] = Math.max(dp2[i - 2] + nums[i], dp2[i - 1]);
            }
            dp1[len - 1] = dp1[len - 2];
            dp2[len - 1] = Math.max(dp2[len - 2] + nums[len - 1], dp2[len - 1]);
            return Math.max(dp1[len - 1], dp2[len - 1]);
//            return Math.max(myRob(nums,0,len-1),myRob(nums,1,len));
        }

        private int myRob(int[] nums, int s, int e) {
            if (e-s == 0) return 0;
            int res = nums[s], prev = 0;
            for (int i = s+1; i < e; i++) {
                int temp = res;
                res = Math.max(res, prev + nums[i]);
                prev = temp;
            }
            return Math.max(res, prev);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}