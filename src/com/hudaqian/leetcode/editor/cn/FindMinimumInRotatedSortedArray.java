//假设按照升序排序的数组在预先未知的某个点上进行了旋转。 
//
// ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。 
//
// 请找出其中最小的元素。 
//
// 你可以假设数组中不存在重复元素。 
//
// 示例 1: 
//
// 输入: [3,4,5,1,2]
//输出: 1 
//
// 示例 2: 
//
// 输入: [4,5,6,7,0,1,2]
//输出: 0 
// Related Topics 数组 二分查找 
// 👍 284 👎 0


package com.hudaqian.leetcode.editor.cn;

public class FindMinimumInRotatedSortedArray {
    public static void main(String[] args) {
        Solution solution = new FindMinimumInRotatedSortedArray().new Solution();
        int[] nums = {2, 1};
        System.out.print(solution.findMin(nums));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findMin(int[] nums) {
            if (nums.length == 0) {
                return -1;
            }
            if (nums.length == 1) {
                return nums[0];
            }
            int left = 0, right = nums.length - 1;
            if (nums[right] > nums[left]) {
                return nums[0];
            }
            while (right >= left) {
                int mid = left + (right - left) / 2;
                /**
                 * 将右边的比较放到前面 排除了只有两个元素 并且后边元素比前面元素小的时候造成的数组越界情况
                 * 而前面元素比后边元素大的情况在前面已经排除了
                 * 只需要比较中间元素和数组头元素的大小 就可以确定最小的元素在什么位置了
                 */
                if (nums[mid] > nums[mid + 1]) {
                    return nums[mid + 1];
                }
                if (nums[mid] < nums[mid - 1]) {
                    return nums[mid];
                }
                if (nums[mid] > nums[0]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            return -1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}