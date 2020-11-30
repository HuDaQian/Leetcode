//给定两个大小为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的中位数。
//
// 进阶：你能设计一个时间复杂度为 O(log (m+n)) 的算法解决此问题吗？
//
//
//
// 示例 1：
//
// 输入：nums1 = [1,3], nums2 = [2]
//输出：2.00000
//解释：合并数组 = [1,2,3] ，中位数 2
//
//
// 示例 2：
//
// 输入：nums1 = [1,2], nums2 = [3,4]
//输出：2.50000
//解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
//
//
// 示例 3：
//
// 输入：nums1 = [0,0], nums2 = [0,0]
//输出：0.00000
//
//
// 示例 4：
//
// 输入：nums1 = [], nums2 = [1]
//输出：1.00000
//
//
// 示例 5：
//
// 输入：nums1 = [2], nums2 = []
//输出：2.00000
//
//
//
//
// 提示：
//
//
// nums1.length == m
// nums2.length == n
// 0 <= m <= 1000
// 0 <= n <= 1000
// 1 <= m + n <= 2000
// -106 <= nums1[i], nums2[i] <= 106
//
// Related Topics 数组 二分查找 分治算法
// 👍 3445 👎 0


package com.hudaqian.leetcode.editor.cn;

import java.util.Arrays;

public class MedianOfTwoSortedArrays {
    public static void main(String[] args) {
        Solution solution = new MedianOfTwoSortedArrays().new Solution();
        int[] nums1 = {1, 2, 3};
        int[] nums2 = {2, 3, 4};
        System.out.print(solution.findMedianSortedArrays(nums1, nums2));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            /**
             * 解法1：组合成一个数组 然后取中位数
             */
//            int count1 = nums1.length;
//            int count2 = nums2.length;
//            int[] newNums = new int[count1 + count2];
//            System.arraycopy(nums1, 0, newNums, 0, count1);
//            System.arraycopy(nums2, 0, newNums, count1, count2);
//            Arrays.sort(newNums);
//            int allCount = count1 + count2;
//            int index = (allCount-1) / 2;
//            double result = 0;
//            if (allCount == 0) return result;
//            if (allCount % 2 == 1) {
//                return newNums[index];
//            } else {
//                return ((double) newNums[index] + (double) newNums[index + 1]) / 2;
//            }
            /**
             * 解法2：双指针查找
             * 维护两个指针直到查找到中位数
             */
//            int index1 = 0, index2 = 0;
//            int count1 = nums1.length;
//            int count2 = nums2.length;
//            int allCount = count1 + count2;
//            int index = (allCount - 1) / 2;
//            while (index > 0) {
//                if (index1 <= count1 - 1 && index2 <= count2 - 1) {
//                    if (nums1[index1] < nums2[index2]) {
//                        index1++;
//                    } else {
//                        index2++;
//                    }
//                } else {
//                    if (index1 == count1) {
//                        index2++;
//                    } else {
//                        index1++;
//                    }
//                }
//                index--;
//            }
//            if (allCount % 2 != 0) {
//                if (index1 == count1) {
//                    return nums2[index2];
//                } else if (index2 == count2) {
//                    return nums1[index1];
//                } else {
//                    return Math.min(nums1[index1], nums2[index2]);
//                }
//            } else {
//                /**
//                 * 再往后查一位
//                 */
//                int left = 0, right = 0;
//                if (index1 == count1) {
//                    left = nums2[index2];
//                    right = nums2[index2 + 1];
//                } else if (index2 == count2) {
//                    left = nums1[index1];
//                    right = nums1[index1 + 1];
//                } else {
//                    if (nums1[index1] < nums2[index2]) {
//                        left = nums1[index1];
//                        right = (index1 == count1 - 1) ? (nums2[index2]) : (Math.min(nums1[index1 + 1], nums2[index2]));
//                    } else {
//                        left = nums2[index2];
//                        right = (index2 == count2 - 1) ? (nums1[index1]) : (Math.min(nums1[index1], nums2[index2 + 1]));
//                    }
//                }
//                return ((double) left + (double) right) / 2;
//            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}