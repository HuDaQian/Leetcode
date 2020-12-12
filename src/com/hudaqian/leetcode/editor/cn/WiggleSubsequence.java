//如果连续数字之间的差严格地在正数和负数之间交替，则数字序列称为摆动序列。第一个差（如果存在的话）可能是正数或负数。少于两个元素的序列也是摆动序列。 
//
// 例如， [1,7,4,9,2,5] 是一个摆动序列，因为差值 (6,-3,5,-7,3) 是正负交替出现的。相反, [1,4,7,2,5] 和 [1,7,
//4,5,5] 不是摆动序列，第一个序列是因为它的前两个差值都是正数，第二个序列是因为它的最后一个差值为零。 
//
// 给定一个整数序列，返回作为摆动序列的最长子序列的长度。 通过从原始序列中删除一些（也可以不删除）元素来获得子序列，剩下的元素保持其原始顺序。 
//
// 示例 1: 
//
// 输入: [1,7,4,9,2,5]
//输出: 6 
//解释: 整个序列均为摆动序列。
// 
//
// 示例 2: 
//
// 输入: [1,17,5,10,13,15,10,5,16,8]
//输出: 7
//解释: 这个序列包含几个长度为 7 摆动序列，其中一个可为[1,17,10,13,10,16,8]。 
//
// 示例 3: 
//
// 输入: [1,2,3,4,5,6,7,8,9]
//输出: 2 
//
// 进阶: 
//你能否用 O(n) 时间复杂度完成此题? 
// Related Topics 贪心算法 动态规划 
// 👍 327 👎 0


package com.hudaqian.leetcode.editor.cn;

public class WiggleSubsequence {
    public static void main(String[] args) {
        Solution solution = new WiggleSubsequence().new Solution();
        int[] nums = {1, 7, 4, 9, 2, 5};
        System.out.print(solution.wiggleMaxLength(nums));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int wiggleMaxLength(int[] nums) {
            /**
             * 贪心+模拟
             */
//            if (nums == null) return 0;
//            if (nums.length < 2) return nums.length;
////            if (nums.length == 2) return (nums[1] == nums[0] ? 1 : 2);
//            int[] res = new int[nums.length - 1];
//            //  判断是增还是减
//            boolean isAllZero = true;
//            for (int i = 1; i < nums.length; i++) {
//                int cur = nums[i] - nums[i - 1];
//                res[i - 1] = cur == 0 ? 0 : cur == Math.abs(cur) ? 1 : -1;
//                if (res[i - 1] != 0) isAllZero = false;
//            }
//            if (isAllZero) return 1;
//            int count = 2, ver = res[0];
//            for (int i = 1; i < res.length; i++) {
//                //  这里针对方向的判断 要注意一下
//                int temp = res[i];
//                if (temp != 0) {
//                    if (ver == 0) {
//                        ver = temp;
//                    } else {
//                        if (temp * ver == 1) {
//                            //  同向
//                        } else if (temp * ver == -1) {
//                            // 反向
//                            ver = temp;
//                            count++;
//                        }
//                    }
//                }
//            }
//            return count;
            /**
             * 动态规划
             */
//            int len = nums.length;
//            if (len < 2) return len;
//            int up = 1, down = 1;
//            for (int i = 1; i < len; i++) {
//                if (nums[i] > nums[i - 1]) {
//                    up = Math.max(up, down + 1);
//                } else if (nums[i] < nums[i - 1]) {
//                    down = Math.max(down, up + 1);
//                }
//            }
//            return Math.max(up, down);
            /**
             * 贪心解法优化
             */
            int len = nums.length;
            if (len < 2) return len;
            int prediff = nums[1] - nums[0];
            int res = prediff == 0 ? 1 : 2;
            for (int i = 2; i < len; i++) {
                int diff = nums[i] - nums[i - 1];
                if ((diff > 0 && prediff <= 0) || (diff < 0 && prediff >= 0)) {
                    res++;
                    prediff = diff;
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}