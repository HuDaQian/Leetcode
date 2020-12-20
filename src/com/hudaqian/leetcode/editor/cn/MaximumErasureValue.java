//给你一个正整数数组 nums ，请你从中删除一个含有 若干不同元素 的子数组。删除子数组的 得分 就是子数组各元素之 和 。 
//
// 返回 只删除一个 子数组可获得的 最大得分 。 
//
// 如果数组 b 是数组 a 的一个连续子序列，即如果它等于 a[l],a[l+1],...,a[r] ，那么它就是 a 的一个子数组。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [4,2,4,5,6]
//输出：17
//解释：最优子数组是 [2,4,5,6]
// 
//
// 示例 2： 
//
// 
//输入：nums = [5,2,1,2,5,2,1,2,5]
//输出：8
//解释：最优子数组是 [5,2,1] 或 [1,2,5]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 105 
// 1 <= nums[i] <= 104 
// 
// Related Topics 双指针 
// 👍 4 👎 0


package com.hudaqian.leetcode.editor.cn;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MaximumErasureValue {
    public static void main(String[] args) {
        Solution solution = new MaximumErasureValue().new Solution();
        int[] nums = {187, 470, 25, 436, 538, 809, 441, 167, 477, 110, 275, 133, 666, 345, 411, 459, 490, 266, 987, 965, 429, 166, 809, 340, 467, 318, 125, 165, 809, 610, 31, 585, 970, 306, 42, 189, 169, 743, 78, 810, 70, 382, 367, 490, 787, 670, 476, 278, 775, 673, 299, 19, 893, 817, 971, 458, 409, 886, 434};
//        int[] nums = {4,2,4,5,6};
        System.out.print(solution.maximumUniqueSubarray(nums));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maximumUniqueSubarray(int[] nums) {
            /**
             * set Or map
             */
//            int sum = 0, res = sum, start = 0;
//            Set<Integer> set = new HashSet<>();
//            for (int i = 0; i < nums.length; i++) {
//                int num = nums[i];
//                if (!set.add(num)) {
//                    while (nums[start] != nums[i]) {
//                        set.remove(nums[start]);
//                        sum -= nums[start];
//                        start++;
//                    }
//                    sum -= nums[start];
//                    start++;
//                }
//                sum += num;
//                res = Math.max(res, sum);
//            }
//            return res;
            /**
             * 数组解法
             */
            int maxNumber = Integer.MIN_VALUE;
            for (int num : nums) {
                maxNumber = Math.max(maxNumber, num);
            }
            int[] temp = new int[maxNumber + 1];
            int sum = 0, start = 0, res = sum;
            for (int i = 0; i < nums.length; i++) {
                int num = nums[i];
                int endIndex = temp[num];
                if (endIndex != 0) {
                    for (int j = start; j < endIndex; j++) {
                        sum -= nums[j];
                        temp[nums[j]] = 0;
                    }
                    start = endIndex;
                }
                temp[num] = i + 1;
                sum += num;
                res = Math.max(res, sum);
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}