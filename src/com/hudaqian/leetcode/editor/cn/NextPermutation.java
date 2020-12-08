//实现获取 下一个排列 的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。 
//
// 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。 
//
// 必须 原地 修改，只允许使用额外常数空间。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3]
//输出：[1,3,2]
// 
//
// 示例 2： 
//
// 
//输入：nums = [3,2,1]
//输出：[1,2,3]
// 
//
// 示例 3： 
//
// 
//输入：nums = [1,1,5]
//输出：[1,5,1]
// 
//
// 示例 4： 
//
// 
//输入：nums = [1]
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 100 
// 0 <= nums[i] <= 100 
// 
// Related Topics 数组 
// 👍 863 👎 0


package com.hudaqian.leetcode.editor.cn;

import java.util.Arrays;

public class NextPermutation {
    public static void main(String[] args) {
        Solution solution = new NextPermutation().new Solution();
        int[] nums = {3, 2, 1};
        solution.nextPermutation(nums);
        System.out.print(Arrays.toString(nums));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void nextPermutation(int[] nums) {
            /**
             * 倒着找 符合条件的组合
             * 先找到 递增数列不符合条件的数字 为待调整数字
             * 然后再 从之后的数字中找可交换数字
             * 然后 交换两个数字
             * 然后反转后边的数组即可
             */
            if (nums == null || nums.length < 2) return;
            int len = nums.length;
            int fir = len - 2;
            while (fir >= 0 && nums[fir] >= nums[fir + 1]) {
                fir--;
            }
            if (fir >= 0) {
                int sec = len - 1;
                while (sec > fir && nums[sec] <= nums[fir]) {
                    sec--;
                }
                if (sec > fir) {
                    change(nums, fir, sec);
                    reverse(nums, fir + 1, len - 1);
                    return;
                }
            }
            reverse(nums, 0, len - 1);
        }

        private void change(int[] nums, int fir, int sec) {
            int temp = nums[fir];
            nums[fir] = nums[sec];
            nums[sec] = temp;
        }

        private void reverse(int[] nums, int start, int end) {
            int left = start, right = end;
            while (left < right) {
                change(nums, left, right);
                left++;
                right--;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}