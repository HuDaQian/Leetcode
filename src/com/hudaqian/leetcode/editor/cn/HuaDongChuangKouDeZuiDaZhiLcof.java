//给定一个数组 nums 和滑动窗口的大小 k，请找出所有滑动窗口里的最大值。 
//
// 示例: 
//
// 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
//输出: [3,3,5,5,6,7] 
//解释: 
//
//  滑动窗口的位置                最大值
//---------------               -----
//[1  3  -1] -3  5  3  6  7       3
// 1 [3  -1  -3] 5  3  6  7       3
// 1  3 [-1  -3  5] 3  6  7       5
// 1  3  -1 [-3  5  3] 6  7       5
// 1  3  -1  -3 [5  3  6] 7       6
// 1  3  -1  -3  5 [3  6  7]      7 
//
// 
//
// 提示： 
//
// 你可以假设 k 总是有效的，在输入数组不为空的情况下，1 ≤ k ≤ 输入数组的大小。 
//
// 注意：本题与主站 239 题相同：https://leetcode-cn.com/problems/sliding-window-maximum/ 
// Related Topics 队列 Sliding Window 
// 👍 158 👎 0


package com.hudaqian.leetcode.editor.cn;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class HuaDongChuangKouDeZuiDaZhiLcof {
    public static void main(String[] args) {
        Solution solution = new HuaDongChuangKouDeZuiDaZhiLcof().new Solution();
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        System.out.print(Arrays.toString(solution.maxSlidingWindow(nums, k)));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] maxSlidingWindow(int[] nums, int k) {
            /**
             * 思路是维护一个单调队列
             *
             */
//            if (nums.length == 0 || k == 0) return new int[0];
//            int[] res = new int[nums.length - k + 1];
//            Deque<Integer> queue = new LinkedList<>();
//            int maxNum = 0;
//            for (int i = 0; i < k; i++) {
//                int num = nums[i];
//                boolean isChange = QuePushNum(queue, num);
//                if (isChange) {
//                    maxNum = num;
//                }
//            }
//            res[0] = queue.getFirst();
//            for (int i = k; i < nums.length; i++) {
//                /**
//                 * 先入再出
//                 */
//                int num = nums[i];
//                boolean isChange = QuePushNum(queue, num);
//                if (isChange) {
//                    maxNum = num;
//                } else {
//                    if (nums[i-k] == maxNum) {
//                        queue.removeFirst();
//                    }
//                    maxNum = queue.getFirst();
//                }
//                res[i - k + 1] = queue.getFirst();
//            }
//            return res;
            /**
             * 动态规划解法
             * 做法是先把原数组分成多个块 每个块的长度为k
             * 然后创建两个数组 left 和 right
             * left保存当前数字到当前块的首位数字之间最大的数字
             * right保存当前数字到当前块的末位数字之间最大的数字
             * 滑动窗口 从 i-k 到 i
             * 如果区间和块重合 那么直接取left[i]的值
             * 如果区间和块相交
             * 那么 将区间分为 从i-k到块的末端 和下一个块的前端到i 两个区间
             * 从i-k到末端的最大值是right[i-k]
             * 从下一个块的前端到i的最大值为left[i]
             * 所以 区间最大值为 Math.max(left[i],right[i-k])
             * 或者可以表示为 从 i到i+k-1
             */
            if (nums.length == 0 || k == 0) return new int[0];
            int curLeftNum = nums[0];
            int len = nums.length;
            int[] left = new int[len];
            left[0] = nums[0];
            int[] right = new int[len];
            right[len - 1] = nums[len - 1];
            for (int i = 1; i < nums.length; i++) {
                if (i % k == 0) {
                    left[i] = nums[i];
                } else {
                    left[i] = Math.max(nums[i], left[i - 1]);
                }

                int index = len - i - 1;
                if ((index + 1) % k == 0) {
                    right[index] = nums[index];
                } else {
                    right[index] = Math.max(nums[index], right[index + 1]);
                }
            }
            int[] res = new int[len - k + 1];
            for (int i = 0; i < len - k + 1; i++) {
                if (i % k == 0) {
                    res[i] = left[i + k - 1];
                } else {
                    res[i] = Math.max(left[i + k - 1], right[i]);
                }
            }
            return res;
        }

        private boolean QuePushNum(Deque<Integer> queue, int num) {
            boolean isChange = true;
            if (!queue.isEmpty()) {
                while (!queue.isEmpty() && num > queue.peekLast()) {
                    queue.removeLast();
                }
                if (!queue.isEmpty()) isChange = false;
                queue.addLast(num);
            } else {
                queue.addLast(num);
            }
            return isChange;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}