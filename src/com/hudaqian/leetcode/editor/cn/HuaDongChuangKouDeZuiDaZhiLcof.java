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
        int[] nums = {5,5,5,5,5,5,4,4,4,4};
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
            if (nums.length == 0 || k == 0) return new int[0];
            int[] res = new int[nums.length - k + 1];
            Deque<Integer> queue = new LinkedList<>();
            int maxNum = 0;
            for (int i = 0; i < k; i++) {
                int num = nums[i];
                boolean isChange = QuePushNum(queue, num);
                if (isChange) {
                    maxNum = num;
                }
            }
            res[0] = queue.getFirst();
            for (int i = k; i < nums.length; i++) {
                /**
                 * 先入再出
                 */
                int num = nums[i];
                boolean isChange = QuePushNum(queue, num);
                if (isChange) {
                    maxNum = num;
                } else {
                    if (nums[i-k] == maxNum) {
                        queue.removeFirst();
                    }
                    maxNum = queue.getFirst();
                }
                res[i - k + 1] = queue.getFirst();
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