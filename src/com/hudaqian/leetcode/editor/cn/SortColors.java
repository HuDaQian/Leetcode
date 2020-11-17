//给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。 
//
// 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。 
//
// 注意: 
//不能使用代码库中的排序函数来解决这道题。 
//
// 示例: 
//
// 输入: [2,0,2,1,1,0]
//输出: [0,0,1,1,2,2] 
//
// 进阶： 
//
// 
// 一个直观的解决方案是使用计数排序的两趟扫描算法。 
// 首先，迭代计算出0、1 和 2 元素的个数，然后按照0、1、2的排序，重写当前数组。 
// 你能想出一个仅使用常数空间的一趟扫描算法吗？ 
// 
// Related Topics 排序 数组 双指针 
// 👍 702 👎 0


package com.hudaqian.leetcode.editor.cn;

import java.util.Arrays;

public class SortColors {
    public static void main(String[] args) {
        Solution solution = new SortColors().new Solution();
        int[] nums = {2, 2, 1, 1, 0};
        solution.sortColors(nums);
        System.out.print(Arrays.toString(nums));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void sortColors(int[] nums) {
            /**
             * 单指针循环两次
             */
//            if (nums == null || nums.length == 0) {
//                return;
//            }
//            int n = nums.length;
//            int index = 0;
//            for (int i = 0; i < n; i++) {
//                if (nums[i] == 0) {
//                    int current = nums[index];
//                    nums[index] = nums[i];
//                    nums[i] = current;
//                    index++;
//                }
//            }
//            for (int i = index; i < n; i++) {
//                if (nums[i] == 1) {
//                    int current = nums[index];
//                    nums[index] = nums[i];
//                    nums[i] = current;
//                    index++;
//                }
//            }
            /**
             * 双指针解法
             * 慢指针指1 快指针指2
             */
            if (nums == null || nums.length == 0) return;
            int aIndex = 0, bIndex = 0;
            int n = nums.length;
            for (int i = 0; i < n; i++) {
                if (nums[i] == 1) {
                    int current = nums[bIndex];
                    nums[bIndex] = nums[i];
                    nums[i] = current;
                    bIndex++;
                } else if (nums[i] == 0) {
                    int current = nums[aIndex];
                    nums[aIndex] = nums[i];
                    nums[i] = current;
                    if (current == 1) {
                        int bCurrent = nums[bIndex];
                        nums[bIndex] = nums[i];
                        nums[i] = bCurrent;
                    }
                    aIndex++;
                    bIndex++;
                } else {

                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}