//给你一个下标从 0 开始的整数数组 nums 和一个整数 k 。 
//
// 一开始你在下标 0 处。每一步，你最多可以往前跳 k 步，但你不能跳出数组的边界。也就是说，你可以从下标 i 跳到 [i + 1， min(n - 1, 
//i + k)] 包含 两个端点的任意位置。 
//
// 你的目标是到达数组最后一个位置（下标为 n - 1 ），你的 得分 为经过的所有数字之和。 
//
// 请你返回你能得到的 最大得分 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,-1,-2,4,-7,3], k = 2
//输出：7
//解释：你可以选择子序列 [1,-1,4,3] （上面加粗的数字），和为 7 。
// 
//
// 示例 2： 
//
// 
//输入：nums = [10,-5,-2,4,0,3], k = 3
//输出：17
//解释：你可以选择子序列 [10,4,3] （上面加粗数字），和为 17 。
// 
//
// 示例 3： 
//
// 
//输入：nums = [1,-5,-20,4,-1,3,-6,-3], k = 2
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length, k <= 105 
// -104 <= nums[i] <= 104 
// 
// 👍 8 👎 0


package com.hudaqian.leetcode.editor.cn;

import java.util.Comparator;
import java.util.PriorityQueue;

public class JumpGameVi {
    public static void main(String[] args) {
        Solution solution = new JumpGameVi().new Solution();
        int[] nums = {10,-5,-2,4,0,3};
        int k = 3;
        System.out.print(solution.maxResult(nums, k));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxResult(int[] nums, int k) {
            /**
             * 动态规划 超时
             *
             * 增加最大堆用来排列dp[i]的值
             */
            if (nums == null || nums.length == 0) return 0;
            int len = nums.length;
            int[] dp = new int[len];
            dp[0] = nums[0];
            PriorityQueue<int[]> heap = new PriorityQueue<>(new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return o2[0]-o1[0];
                }
            });
            heap.add(new int[]{dp[0],0});
            int[] peek = new int[2];
            for (int i = 1; i < len; i++) {
                while (!heap.isEmpty()) {
                    peek = heap.peek();
                    if (peek[1] < i-k) {
                        heap.poll();
                    } else {
                        break;
                    }
                }
                dp[i] = peek[0] + nums[i];
                heap.add(new int[]{dp[i],i});
            }
            return dp[len - 1];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}