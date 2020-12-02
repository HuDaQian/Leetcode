//给定长度分别为 m 和 n 的两个数组，其元素由 0-9 构成，表示两个自然数各位上的数字。现在从这两个数组中选出 k (k <= m + n) 个数字拼接
//成一个新的数，要求从同一个数组中取出的数字保持其在原数组中的相对顺序。 
//
// 求满足该条件的最大数。结果返回一个表示该最大数的长度为 k 的数组。 
//
// 说明: 请尽可能地优化你算法的时间和空间复杂度。 
//
// 示例 1: 
//
// 输入:
//nums1 = [3, 4, 6, 5]
//nums2 = [9, 1, 2, 5, 8, 3]
//k = 5
//输出:
//[9, 8, 6, 5, 3] 
//
// 示例 2: 
//
// 输入:
//nums1 = [6, 7]
//nums2 = [6, 0, 4]
//k = 5
//输出:
//[6, 7, 6, 0, 4] 
//
// 示例 3: 
//
// 输入:
//nums1 = [3, 9]
//nums2 = [8, 9]
//k = 3
//输出:
//[9, 8, 9] 
// Related Topics 贪心算法 动态规划 
// 👍 201 👎 0


package com.hudaqian.leetcode.editor.cn;

import java.util.Arrays;

public class CreateMaximumNumber {
    public static void main(String[] args) {
        Solution solution = new CreateMaximumNumber().new Solution();
        int[] nums1 = {3, 4, 6, 5};
        int[] nums2 = {9, 1, 2, 5, 8, 3};
        int k = 5;
        System.out.print(Arrays.toString(solution.maxNumber(nums1, nums2, k)));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] maxNumber(int[] nums1, int[] nums2, int k) {
            /**
             * 思路是暴力解法+最大子序列
             * 所以 加三个方法  一个求最大子序列  一个合并两个序列  一个比较两个已经合并好的序列
             */
            int m = nums1.length, n = nums2.length;
            int[] maxSubsequence = new int[k];
            int start = Math.max(0, k - n), end = Math.min(k, m);
            for (int i = start; i <= end; i++) {
                int[] subsequence1 = maxSubsequence(nums1, i);
                int[] subsequence2 = maxSubsequence(nums2, k - i);
                int[] res = merge(subsequence1, subsequence2);
                if (compare(maxSubsequence, 0, res, 0) < 0) {
                    System.arraycopy(res, 0, maxSubsequence, 0, k);
                }
            }
            return maxSubsequence;
        }

        private int[] maxSubsequence(int[] nums, int k) {
            int length = nums.length;
            int[] stack = new int[k];
            int top = -1;
            int remain = length - k;
            for (int i = 0; i < length; i++) {
                int num = nums[i];
                while (top >= 0 && stack[top] < num && remain > 0) {
                    top--;
                    remain--;
                }
                if (top < k - 1) {
                    stack[++top] = num;
                } else {
                    remain--;
                }
            }
            return stack;
        }

        private int[] merge(int[] nums1, int[] nums2) {
            int m = nums1.length, n = nums2.length;
            if (m == 0) return nums2;
            if (n == 0) return nums1;
            int maxLength = m + n;
            int[] merged = new int[maxLength];
            int index1 = 0, index2 = 0;
            for (int i = 0; i < maxLength; i++) {
                if (compare(nums1, index1, nums2, index2) > 0) {
                    merged[i] = nums1[index1++];
                } else {
                    merged[i] = nums2[index2++];
                }
            }
            return merged;
        }

        private int compare(int[] nums1, int index1, int[] nums2, int index2) {
            int m = nums1.length, n = nums2.length;
            while (index1 < nums1.length && index2 < nums2.length) {
                int num1 = nums1[index1], num2 = nums2[index2];
                if (num1 != num2) {
                    return num1 - num2;
                }
                index1++;
                index2++;
            }
            return (m - index1) - (n - index2);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}