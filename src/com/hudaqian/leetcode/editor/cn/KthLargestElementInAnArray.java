//在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。 
//
// 示例 1: 
//
// 输入: [3,2,1,5,6,4] 和 k = 2
//输出: 5
// 
//
// 示例 2: 
//
// 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
//输出: 4 
//
// 说明: 
//
// 你可以假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度。 
// Related Topics 堆 分治算法 
// 👍 787 👎 0


package com.hudaqian.leetcode.editor.cn;

import java.util.*;

public class KthLargestElementInAnArray {
    public static void main(String[] args) {
        Solution solution = new KthLargestElementInAnArray().new Solution();
        int[] nums = {3,2,3,1,2,4,5,5,6};
        System.out.print(String.format("%d",solution.findKthLargest(nums,4)));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findKthLargest(int[] nums, int k) {
            /**
             * 解法待修改
             */
            if (nums == null || nums.length == 0) return -1;
            Arrays.sort(nums);
            return nums[nums.length-k];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}