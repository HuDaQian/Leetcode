//给定两个数组，编写一个函数来计算它们的交集。 
//
// 
//
// 示例 1： 
//
// 输入：nums1 = [1,2,2,1], nums2 = [2,2]
//输出：[2,2]
// 
//
// 示例 2: 
//
// 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
//输出：[4,9] 
//
// 
//
// 说明： 
//
// 
// 输出结果中每个元素出现的次数，应与元素在两个数组中出现次数的最小值一致。 
// 我们可以不考虑输出结果的顺序。 
// 
//
// 进阶： 
//
// 
// 如果给定的数组已经排好序呢？你将如何优化你的算法？ 
// 如果 nums1 的大小比 nums2 小很多，哪种方法更优？ 
// 如果 nums2 的元素存储在磁盘上，内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？ 
// 
// Related Topics 排序 哈希表 双指针 二分查找 
// 👍 413 👎 0


package com.hudaqian.leetcode.editor.cn;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class IntersectionOfTwoArraysIi {
    public static void main(String[] args) {
        Solution solution = new IntersectionOfTwoArraysIi().new Solution();
        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};
        int[] res = solution.intersect(nums1, nums2);
        System.out.print("=========================================");
        for (int num : res) {
            System.out.print(num);
        }
        System.out.print("=========================================\n");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] intersect(int[] nums1, int[] nums2) {
            /**
             * 解法1：双指针解法
             */
//            Arrays.sort(nums1);
//            Arrays.sort(nums2);
//            int i = 0, j = 0, count = 0;
//            int[] res = new int[Math.min(nums1.length, nums2.length)];
//            while (i < nums1.length && j < nums2.length) {
//                if (nums1[i] == nums2[j]) {
//                    res[count] = nums1[i];
//                    count++;
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
             * 解法2：哈希map解法
             */
            if (nums1.length > nums2.length) {
                return intersect(nums2, nums1);
            }
            Map<Integer, Integer> map = new HashMap<>();
            for (int num : nums1) {
                map.put(num, map.getOrDefault(num, 0) + 1);
            }
            int[] res = new int[nums1.length];
            int count = 0;
            for (int num : nums2) {
                int number = map.getOrDefault(num, 0);
                if (number > 0) {
                    res[count] = num;
                    number--;
                    count++;
                    if (number == 0) {
                        map.remove(num);
                    } else {
                        map.put(num, number);
                    }
                }
            }
            return Arrays.copyOfRange(res, 0, count);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}