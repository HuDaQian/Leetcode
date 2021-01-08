//给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。 
//
// 示例 1: 
//
// 输入: [1,2,3,4,5,6,7] 和 k = 3
//输出: [5,6,7,1,2,3,4]
//解释:
//向右旋转 1 步: [7,1,2,3,4,5,6]
//向右旋转 2 步: [6,7,1,2,3,4,5]
//向右旋转 3 步: [5,6,7,1,2,3,4]
// 
//
// 示例 2: 
//
// 输入: [-1,-100,3,99] 和 k = 2
//输出: [3,99,-1,-100]
//解释: 
//向右旋转 1 步: [99,-1,-100,3]
//向右旋转 2 步: [3,99,-1,-100] 
//
// 说明: 
//
// 
// 尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。 
// 要求使用空间复杂度为 O(1) 的 原地 算法。 
// 
// Related Topics 数组 
// 👍 725 👎 0


package com.hudaqian.leetcode.editor.cn;

import java.util.Arrays;

public class RotateArray {
    public static void main(String[] args) {
        Solution solution = new RotateArray().new Solution();
        int[] nums = {-1,-100,3,99};
        int k = 2;
        solution.rotate(nums, k);
        System.out.print(Arrays.toString(nums));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 暴力法和额外数组法就不写了
         * 第一种是旋转数组法
         */
        public void rotate(int[] nums, int k) {
//            k %= nums.length;
//            int count = 0, n = nums.length;
//            for(int start = 0;count<n; start++) {
//                int current = start;
//                int prev = nums[start];
//                do {
//                    int next = (start + k) % n;
//                    int temp = nums[next];
//                    nums[next] = prev;
//                    prev = temp;
//                    start = next;
//                    count++;
//                } while (current != start);
//            }
            /**
             * 解法2：数组反转
             * 注意这里是向右移动  所以应该先整体翻转 再局部翻转
             */
            int len = nums.length;
            k = k % len;
            reverseNums(nums, 0, len - 1);
            reverseNums(nums, 0, k-1);
            reverseNums(nums, k, len - 1);
        }

        private void reverseNums(int[] nums, int start, int end) {
            int l = start, r = end;
            while (l < r) {
                int temp = nums[l];
                nums[l] = nums[r];
                nums[r] = temp;
                l++;
                r--;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}