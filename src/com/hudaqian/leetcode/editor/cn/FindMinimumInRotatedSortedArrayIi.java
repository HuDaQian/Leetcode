//假设按照升序排序的数组在预先未知的某个点上进行了旋转。 
//
// ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。 
//
// 请找出其中最小的元素。 
//
// 注意数组中可能存在重复的元素。 
//
// 示例 1： 
//
// 输入: [1,3,5]
//输出: 1 
//
// 示例 2： 
//
// 输入: [2,2,2,0,1]
//输出: 0 
//
// 说明： 
//
// 
// 这道题是 寻找旋转排序数组中的最小值 的延伸题目。 
// 允许重复会影响算法的时间复杂度吗？会如何影响，为什么？ 
// 
// Related Topics 数组 二分查找 
// 👍 204 👎 0


package com.hudaqian.leetcode.editor.cn;

import java.util.Arrays;
import java.util.List;

public class FindMinimumInRotatedSortedArrayIi {
    public static void main(String[] args) {
        Solution solution = new FindMinimumInRotatedSortedArrayIi().new Solution();
        int[] nums = {2, 2, 2, 0, 1};
        System.out.print(solution.findMin(nums));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findMin(int[] nums) {
            /**
             * 排序解法 不符合题目要求
             */
//            int[] newNums = new int[nums.length];
//            System.arraycopy(nums, 0, newNums, 0, nums.length);
//            Arrays.sort(newNums);
//            return newNums[0];
            /**
             * 线性搜索 不符合题目要求
             */
            if (nums.length < 2) return nums[0];
            for (int i=0;i<nums.length-1;i++) {
                if (nums[i+1] < nums[i]) {
                    return nums[i+1];
                }
            }
            return nums[0];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}