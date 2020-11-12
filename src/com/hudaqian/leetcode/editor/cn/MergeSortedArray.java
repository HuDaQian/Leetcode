//给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。 
//
// 
//
// 说明： 
//
// 
// 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。 
// 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。 
// 
//
// 
//
// 示例： 
//
// 
//输入：
//nums1 = [1,2,3,0,0,0], m = 3
//nums2 = [2,5,6],       n = 3
//
//输出：[1,2,2,3,5,6] 
//
// 
//
// 提示： 
//
// 
// -10^9 <= nums1[i], nums2[i] <= 10^9 
// nums1.length == m + n 
// nums2.length == n 
// 
// Related Topics 数组 双指针 
// 👍 684 👎 0


package com.hudaqian.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;

public class MergeSortedArray {
    public static void main(String[] args) {
        Solution solution = new MergeSortedArray().new Solution();
        int[] nums1 = {1, 2, 3, 4, 5, 6, 0, 0, 0, 0, 0};
        int[] nums2 = {2, 3, 4, 5, 7};
        solution.merge(nums1, 6, nums2, 5);
        System.out.print(Arrays.toString(nums1));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void merge(int[] nums1, int m, int[] nums2, int n) {
            /**
             * 解法1：合并然后排序
             */
//            System.arraycopy(nums2, 0, nums1, m, n);
//            Arrays.sort(nums1);
            /**
             * 解法2：双指针从后往前排
             */
            int p=m-1,q=n-1;
            while (p>=0 || q>=0) {
                int num = 0;
                if (p<0) {
                    num = nums2[q];
                    q--;
                } else if (q<0) {
                    num = nums1[p];
                    p--;
                } else {
                    num = Math.max(nums1[p],nums2[q]);
                    if (nums1[p] > nums2[q]){
                        p--;
                    } else {
                        q--;
                    }
                }
                //  元素位置+1 上边已经减一了此处再+1
                nums1[p+q+1+1] = num;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}