//峰值元素是指其值大于左右相邻值的元素。 
//
// 给定一个输入数组 nums，其中 nums[i] ≠ nums[i+1]，找到峰值元素并返回其索引。 
//
// 数组可能包含多个峰值，在这种情况下，返回任何一个峰值所在位置即可。 
//
// 你可以假设 nums[-1] = nums[n] = -∞。 
//
// 示例 1: 
//
// 输入: nums = [1,2,3,1]
//输出: 2
//解释: 3 是峰值元素，你的函数应该返回其索引 2。 
//
// 示例 2: 
//
// 输入: nums = [1,2,1,3,5,6,4]
//输出: 1 或 5 
//解释: 你的函数可以返回索引 1，其峰值元素为 2；
//     或者返回索引 5， 其峰值元素为 6。
// 
//
// 说明: 
//
// 你的解法应该是 O(logN) 时间复杂度的。 
// Related Topics 数组 二分查找 
// 👍 330 👎 0


package com.hudaqian.leetcode.editor.cn;

public class FindPeakElement {
    public static void main(String[] args) {
        Solution solution = new FindPeakElement().new Solution();
        int[] nums = {1, 2, 3, 4, 1};
        System.out.print(solution.findPeakElement(nums));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findPeakElement(int[] nums) {
            /**
             *  解法1：直接查找 不符合题目要求
             */
//            for (int i=0;i<nums.length-1;i++) {
//                if (nums[i] > nums[i+1]){
//                    return i;
//                }
//            }
//            return nums.length-1;
            /**
             * 解法2：迭代二分查找
             */
//            int left = 0, right = nums.length - 1;
//            if (left < right) {
//                int mid = left + (right - left) / 2;
//                if (nums[mid] > nums[mid + 1]) {
//                    return mid;
//                } else {
//                    left = mid + 1;
//                }
//            }
//            return left;
            /**
             * 解法3：递归二分查找
             */
            return search(nums, 0, nums.length - 1);
        }

        private int search(int[] nums, int left, int right) {
            if (left == right) return left;
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[mid + 1]) {
                return search(nums, left, mid);
            }
            return search(nums, mid + 1, right);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}