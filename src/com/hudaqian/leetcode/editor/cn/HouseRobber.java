//你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上
//被小偷闯入，系统会自动报警。 
//
// 给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。 
//
// 
//
// 示例 1： 
//
// 输入：[1,2,3,1]
//输出：4
//解释：偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
//     偷窃到的最高金额 = 1 + 3 = 4 。 
//
// 示例 2： 
//
// 输入：[2,7,9,3,1]
//输出：12
//解释：偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
//     偷窃到的最高金额 = 2 + 9 + 1 = 12 。
// 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 100 
// 0 <= nums[i] <= 400 
// 
// Related Topics 动态规划 
// 👍 1165 👎 0


package com.hudaqian.leetcode.editor.cn;

import java.util.Map;

public class HouseRobber {
    public static void main(String[] args) {
        Solution solution = new HouseRobber().new Solution();
        int[] nums = {1, 2, 3, 1};
        System.out.print(solution.rob(nums));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int rob(int[] nums) {
            /**
             * 解法1：两个数字 来保存偷或者不偷的最大值
             */
//            if (nums == null || nums.length == 0) return 0;
//            int evenNumber = 0, oddNumber = 0, index = 0;
//            while (index < nums.length) {
//                int currentNumber = nums[index];
//                if (index % 2 == 0) {
//                    evenNumber += currentNumber;
//                    evenNumber = Math.max(evenNumber, oddNumber);
//                } else  {
//                    oddNumber += currentNumber;
//                    oddNumber = Math.max(evenNumber, oddNumber);
//                }
//                index++;
//            }
//            return Math.max(oddNumber, evenNumber);
            /**
             * 解法2：动态规划
             */
//            if (nums == null || nums.length == 0) return 0;
//            int[] dp = new int[nums.length+1];
//            dp[1] = nums[0];
//            for (int i = 2; i < nums.length+1; i++) {
//                dp[i] = Math.max(dp[i-2]+nums[i-1], dp[i-1]);
//            }
//            return dp[nums.length];
            /**
             * 解法2的空间优化 集合了解法1和动态规划的特性
             */
//            int numsLength = nums.length;
//            if (numsLength == 1) return nums[0];
//            //  前面数字记录不偷本元素的记录 后边记录偷本元素的记录
//            int prev = 0, current = nums[0];
//            for (int i = 1; i < numsLength; i++) {
//                int temp = current;
//                current = Math.max(prev + nums[i], current);
//                prev = temp;
//            }
//            return Math.max(prev, current);
//            /**
//             * 2020-12-21
//             */
//            if (nums == null || nums.length == 0) return 0;
//            int len = nums.length;
////            int[] dp = new int[len+1];
////            dp[0] = 0;
////            dp[1] = nums[0];
////            for (int i = 1; i < len; i++) {
////                dp[i+1] = Math.max(dp[i],dp[i-1]+nums[i]);
////            }
////            return dp[len];
//            int res = nums[0], prev = 0;
//            for (int i = 1; i < len; i++) {
//                int temp = res;
//                res = Math.max(res, prev + nums[i]);
//                prev = temp;
//            }
//            return Math.max(res, prev);
            /**
             * 2021-4-15 复习动态规划
             */
//            if (nums == null || nums.length == 0) return 0;
//            int len = nums.length;
//            int[] dp = new int[len+1];
//            dp[0] = 0;
//            dp[1] = nums[0];
//            for (int i = 1; i < len; i++) {
//                dp[i+1] = Math.max(dp[i-1]+nums[i], dp[i]);
//            }
//            return dp[len];
            //  动态规划的空间压缩
            if (nums == null || nums.length == 0) return 0;
            int len = nums.length;
            int prev = 0, index = 0, current = nums[index];
            while (++index < len) {
                int tmp = current;
                current = Math.max(prev + nums[index], current);
                prev = tmp;
            }
            return Math.max(prev, current);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}