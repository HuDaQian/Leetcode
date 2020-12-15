//给你一个数组 nums ，数组中有 2n 个元素，按 [x1,x2,...,xn,y1,y2,...,yn] 的格式排列。 
//
// 请你将数组按 [x1,y1,x2,y2,...,xn,yn] 格式重新排列，返回重排后的数组。 
//
// 
//
// 示例 1： 
//
// 输入：nums = [2,5,1,3,4,7], n = 3
//输出：[2,3,5,4,1,7] 
//解释：由于 x1=2, x2=5, x3=1, y1=3, y2=4, y3=7 ，所以答案为 [2,3,5,4,1,7]
// 
//
// 示例 2： 
//
// 输入：nums = [1,2,3,4,4,3,2,1], n = 4
//输出：[1,4,2,3,3,2,4,1]
// 
//
// 示例 3： 
//
// 输入：nums = [1,1,2,2], n = 2
//输出：[1,2,1,2]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 500 
// nums.length == 2n 
// 1 <= nums[i] <= 10^3 
// 
// Related Topics 数组 
// 👍 47 👎 0


package com.hudaqian.leetcode.editor.cn;

import java.util.Arrays;

public class ShuffleTheArray {
    public static void main(String[] args) {
        Solution solution = new ShuffleTheArray().new Solution();
        int[] nums = {1, 2, 3, 4, 5, 6};
        int n = 3;
        System.out.print(Arrays.toString(solution.shuffle(nums, n)));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] shuffle(int[] nums, int n) {
            /**
             * 新建数组解法
             */
//            if (n == 0) return new int[0];
//            int[] res = new int[2 * n];
//            for (int i = 0; i < 2 * n; i++) {
//                int index = i * 2;
//                if (i >= n) {
//                    index = (i-n)*2+1;
//                }
//                res[index] = nums[i];
//            }
//            return res;
            /**
             * 原地排序
             */
            boolean[] status = new boolean[2 * n];
            for (int i = 1; i < 2 * n - 1; i++) {
                if (!status[i]) {
                    int lastIndex = i;
                    int nextIndex = getNextIndex(lastIndex, n);
                    int temp = nums[lastIndex];
                    while (!status[nextIndex]) {
                        int cur = nums[nextIndex];
                        nums[nextIndex] = temp;
                        temp = cur;
                        status[nextIndex] = true;
                        lastIndex = nextIndex;
                        nextIndex = getNextIndex(lastIndex, n);
                    }
                }
            }
            return nums;
        }

        private int getNextIndex(int prev, int n) {
            if (prev >= n) {
                return 2 * (prev - n) + 1;
            } else {
                return 2 * prev;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}