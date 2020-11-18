//给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。 
//
// 示例: 
//
// 输入: [-2,1,-3,4,-1,2,1,-5,4]
//输出: 6
//解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
// 
//
// 进阶: 
//
// 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。 
// Related Topics 数组 分治算法 动态规划 
// 👍 2634 👎 0


package com.hudaqian.leetcode.editor.cn;

public class MaximumSubarray {
    public static void main(String[] args) {
        Solution solution = new MaximumSubarray().new Solution();
        int[] nums = {-2,-1,-3,-4,-1,-2,-1,-5,-4};
        System.out.print(solution.maxSubArray(nums));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxSubArray(int[] nums) {
            /**
             * 暴力法弃用
             */
//            if (nums.length == 0) return 0;
//            int maxSum = nums[0],sum = 0;
//            for (int i=0;i<nums.length;i++) {
//                sum = 0;
//                for (int j=0;j<nums.length-i;j++) {
//                    sum += nums[i+j];
//                    maxSum = Math.max(sum,maxSum);
//                }
//            }
//            return maxSum;
            /**
             * 解法1：动态规划
             * 思路从暴力法出来
             * 设定f[i]表示用第i个元素nums[i]结束的数组的合集
             * 然后 以第i+1元素结束的数组的合集 则为f[i]中每个元素加nums[i+1]
             * 所以 设定pre为f[i]中最大的元素
             * 那么 在f[i+1]中 最大的元素则为pre+nums[i+1] 和 nums[i+1] 这两个数中最大的值
             */
            if (nums == null || nums.length == 0) return 0;
            int pre = 0;
            int max = nums[0];
            for (int num: nums) {
                pre = Math.max(pre+num,num);
                max = Math.max(pre,max);
            }
            return max;
            /**
             * 分治法待补充
             */
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}