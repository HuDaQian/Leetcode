//给定一个非负整数数组，你最初位于数组的第一个位置。 
//
// 数组中的每个元素代表你在该位置可以跳跃的最大长度。 
//
// 判断你是否能够到达最后一个位置。 
//
// 示例 1: 
//
// 输入: [2,3,1,1,4]
//输出: true
//解释: 我们可以先跳 1 步，从位置 0 到达 位置 1, 然后再从位置 1 跳 3 步到达最后一个位置。
// 
//
// 示例 2: 
//
// 输入: [3,2,1,0,4]
//输出: false
//解释: 无论怎样，你总会到达索引为 3 的位置。但该位置的最大跳跃长度是 0 ， 所以你永远不可能到达最后一个位置。
// 
// Related Topics 贪心算法 数组 
// 👍 957 👎 0


    package com.hudaqian.leetcode.editor.cn;

import java.util.Arrays;

public class JumpGame {
        public static void main(String[] args) {
            Solution solution = new JumpGame().new Solution();
            int[] nums = {3,2,1,0,4};
            System.out.print(solution.canJump(nums));
        }
       //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean canJump(int[] nums) {
        /**
         * 思路
         * 维护一个区间来存储可以到达的最大索引和最小索引
         * 直到末级索引处于区间里 或者指针跑出区间
         */
        if (nums == null || nums.length == 0) return false;
        int maxNum = nums[0];
        int index = 0;
        while (index < nums.length) {
            if (index <= maxNum) {
                maxNum = Math.max(nums[index]+index, maxNum);
            } else {
                return false;
            }
            index++;
            if (nums.length-1 <= maxNum) {
                return true;
            }
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

    }