//给定两个数组，编写一个函数来计算它们的交集。 
//
// 
//
// 示例 1： 
//
// 输入：nums1 = [1,2,2,1], nums2 = [2,2]
//输出：[2]
// 
//
// 示例 2： 
//
// 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
//输出：[9,4] 
//
// 
//
// 说明： 
//
// 
// 输出结果中的每个元素一定是唯一的。 
// 我们可以不考虑输出结果的顺序。 
// 
// Related Topics 排序 哈希表 双指针 二分查找 
// 👍 282 👎 0


package com.hudaqian.leetcode.editor.cn;

import java.util.*;

public class IntersectionOfTwoArrays {
    public static void main(String[] args) {
        Solution solution = new IntersectionOfTwoArrays().new Solution();
        int[] nums1 = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] nums2 = {7, 6, 5, 4, 3};
        int[] res = solution.intersection(nums1, nums2);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] intersection(int[] nums1, int[] nums2) {
            /**
             * 解法1：排序
             */
//            Arrays.sort(nums1);
//            Arrays.sort(nums2);
//            int i = 0, j = 0, count = 0;
//            int[] res = new int[Math.min(nums1.length, nums2.length)];
//            while (i < nums1.length && j < nums2.length) {
//                if (nums1[i] == nums2[j]) {
//                    if (count == 0 || res[count - 1] != nums1[i]) {
//                        res[count] = nums1[i];
//                        count++;
//                    }
//                    i++;
//                    j++;
//                } else if (nums1[i] < nums2[j]) {
//                    i++;
//                } else {
//                    j++;
//                }
//            }
//            return Arrays.copyOfRange(res, 0, count);

            /**
             * 解法2：哈希集合解法
             */
            Set<Integer> set1 = new HashSet<>();
            Set<Integer> set2 = new HashSet<>();
            for (int num : nums1) {
                set1.add(num);
            }
            for (int num : nums2) {
                set2.add(num);
            }
            return getIntersection(set1, set2);
        }

        private int[] getIntersection(Set<Integer> set1, Set<Integer> set2) {
            if (set1.size() > set2.size()) {
                return getIntersection(set2, set1);
            }
            int[] res = new int[set1.size()];
            int count = 0;
            for (Integer num : set1) {
                if (set2.contains(num)) {
                    res[count] = num;
                    count++;
                }
            }
            return Arrays.copyOfRange(res, 0, count);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}