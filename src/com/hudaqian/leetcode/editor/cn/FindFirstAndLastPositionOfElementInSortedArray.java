//给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。 
//
// 你的算法时间复杂度必须是 O(log n) 级别。 
//
// 如果数组中不存在目标值，返回 [-1, -1]。 
//
// 示例 1: 
//
// 输入: nums = [5,7,7,8,8,10], target = 8
//输出: [3,4] 
//
// 示例 2: 
//
// 输入: nums = [5,7,7,8,8,10], target = 6
//输出: [-1,-1] 
// Related Topics 数组 二分查找 
// 👍 669 👎 0


package com.hudaqian.leetcode.editor.cn;

import java.util.Arrays;

public class FindFirstAndLastPositionOfElementInSortedArray {
    public static void main(String[] args) {
        Solution solution = new FindFirstAndLastPositionOfElementInSortedArray().new Solution();
        int[] nums = {5, 7, 7, 8, 8, 10};
        System.out.print(Arrays.toString(solution.searchRange(nums, 8)));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] searchRange(int[] nums, int target) {
            /**
             * 解法1：线性扫描
             */
//        int[] res = new int[2];
//        Arrays.fill(res,-1);
//        boolean isSearched = false;
//        for (int i = 0; i < nums.length; i++) {
//            if (isSearched) {
//                /**
//                 * 搜索到了的时候
//                 */
//                if (nums[i] != target) {
//                    res[1] = i-1;
//                    isSearched = false;
//                    break;
//                }
//            } else  {
//                /**
//                 * 未搜索到的时候
//                 */
//                if (nums[i] == target) {
//                    res[0] = i;
//                    isSearched = true;
//                }
//            }
//        }
//        if (isSearched) {
//            res[1] = nums.length-1;
//        }
//        return res;
            /**
             * 二分查找 思路是查一下左边 再查一下右边
             */
            int[] res = new int[2];
            Arrays.fill(res, -1);
            int leftIndex = GetTargetIndex(nums, target, true);
            if (leftIndex == nums.length || nums[leftIndex] != target) return res;
            res[0] = leftIndex;
            res[1] = GetTargetIndex(nums, target, false) - 1;
            return res;
        }

        private int GetTargetIndex(int[] nums, int target, boolean isLeft) {
            int left = 0, right = nums.length;
            while (left < right) {
                int mid = left + (right - left) / 2;
                int midNum = nums[mid];
                if (midNum > target || (isLeft && midNum == target)) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            return left;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}