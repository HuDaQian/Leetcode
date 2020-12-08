//给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和
//。假定每组输入只存在唯一答案。 
//
// 
//
// 示例： 
//
// 输入：nums = [-1,2,1,-4], target = 1
//输出：2
//解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
// 
//
// 
//
// 提示： 
//
// 
// 3 <= nums.length <= 10^3 
// -10^3 <= nums[i] <= 10^3 
// -10^4 <= target <= 10^4 
// 
// Related Topics 数组 双指针 
// 👍 637 👎 0


package com.hudaqian.leetcode.editor.cn;

import java.util.Arrays;

public class ThreeSumClosest {
    public static void main(String[] args) {
        Solution solution = new ThreeSumClosest().new Solution();
        int[] nums = {1,1,-1,-1,3};
        int target = -1;
        System.out.print(solution.threeSumClosest(nums, target));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int threeSumClosest(int[] nums, int target) {
            /**
             * 排序+双指针
             * 因为只用判断最接近的和所以不用做很多判断
             */
            if (nums == null || nums.length < 3) return Integer.MIN_VALUE;
            Arrays.sort(nums);
            long result = Integer.MAX_VALUE;
            for (int i = 0; i < nums.length - 2; i++) {
                int fir = nums[i];
                int left = i + 1, right = nums.length - 1;
                while (left < right) {
                    int sec = nums[left];
                    int thir = nums[right];
                    int sum = fir + sec + thir;
                    if (Math.abs(sum - target) < Math.abs((result - target))) {
                        result = sum;
                    }
                    if (sum > target) {
                        right--;
                    } else {
                        left++;
                    }
                }
            }
            return (int)result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}