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

public class MedianOfTwoSortedArrays {
    public static void main(String[] args) {
        Solution solution = new MedianOfTwoSortedArrays().new Solution();
        int[] nums1 = {1,2,3};
        int[] nums2 = {2,3,4};
        System.out.print(solution.findMedianSortedArrays(nums1,nums2));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            int m = nums1.length, n = nums2.length;
            if (m == 0 || n == 0) return GetMidNumber(m / 2 + n / 2, (m + 1) / 2 + (n + 1) / 2 -1);
            int nums1Index = 0, nums2Index = 0;
            boolean isNums1 = true;
            while (nums1Index + nums2Index <= (m + n) / 2) {
                if (nums1[nums1Index] > nums2[nums2Index]) {
                    isNums1 = false;
                    nums2Index++;
                } else  {
                    isNums1 = true;
                    nums1Index++;
                }
            }
            int left = isNums1?nums1[nums1Index] : nums2[nums2Index];
            int right = 0;
            if (isNums1) {
                if (nums1Index == nums1.length) {
                    right = nums2[nums2Index];
                } else {
                    right = Math.min(nums1[nums1Index+1],nums2[nums2Index]);
                }
            } else  {
                if (nums2Index == nums2.length) {
                    right = nums1[nums1Index];
                } else {
                    right = Math.min(nums2[nums2Index+1],nums1[nums1Index]);
                }
            }
            return GetMidNumber(left, right);
        }

        private double GetMidNumber(int left, int right) {
            return left + (double) (right - left) / 2;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}