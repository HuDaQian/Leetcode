//给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。 
//
// 说明： 
//
// 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？ 
//
// 示例 1: 
//
// 输入: [2,2,1]
//输出: 1
// 
//
// 示例 2: 
//
// 输入: [4,1,2,1,2]
//输出: 4 
// Related Topics 位运算 哈希表 
// 👍 1565 👎 0


package com.hudaqian.leetcode.editor.cn;

import java.util.Arrays;

public class SingleNumber {
    public static void main(String[] args) {
        Solution solution = new SingleNumber().new Solution();
        int[] nums = {1, 2, 3, 4, 1, 2, 3};
        System.out.print(solution.singleNumber(nums));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int singleNumber(int[] nums) {
            /**
             * 解法1：排序 待修改
             */
//            Arrays.sort(nums);
//            for (int i = 0; i < nums.length; i+=2) {
//                if (i == nums.length - 1 || nums[i] != nums[i + 1]) {
//                    return nums[i];
//                }
//            }
//            return -1;
            /**
             * 解法2：异或
             */
            int ans = 0;
            for (int num : nums) {
                ans = ans ^ num;
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}