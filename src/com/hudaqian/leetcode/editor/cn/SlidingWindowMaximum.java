//给定一个数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。 
//
//
// 返回滑动窗口中的最大值。 
//
// 
//
// 进阶： 
//
// 你能在线性时间复杂度内解决此题吗？ 
//
// 
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
// 
// 1 <= nums.length <= 10^5 
// -10^4 <= nums[i] <= 10^4 
// 1 <= k <= nums.length 
// 
// Related Topics 堆 Sliding Window 
// 👍 661 👎 0


package com.hudaqian.leetcode.editor.cn;

import java.util.Deque;
import java.util.LinkedList;

public class SlidingWindowMaximum {
    public static void main(String[] args) {
        Solution solution = new SlidingWindowMaximum().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] maxSlidingWindow(int[] nums, int k) {
            if (nums.length == 0 || k == 0) return new int[0];
            int[] res = new int[nums.length - k + 1];
            Deque<Integer> queue = new LinkedList<>();
            for (int i = 0; i < k; i++) {
                int num = nums[i];
                QuePushNum(queue, num);
            }
            res[0] = queue.getFirst();
            for (int i = k; i < nums.length; i++) {
                /**
                 * 先入再出
                 */
                int num = nums[i];
                QuePushNum(queue, num);

                if (nums[i - k] == queue.getFirst()) {
                    queue.removeFirst();
                }
                res[i - k + 1] = queue.getFirst();
            }
            return res;
        }

        private void QuePushNum(Deque<Integer> queue, int num) {
            if (!queue.isEmpty()) {
                while (!queue.isEmpty() && num > queue.peekLast()) {
                    queue.removeLast();
                }
                queue.addLast(num);
            } else {
                queue.addLast(num);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}