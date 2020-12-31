//找出数组中重复的数字。 
//
// 
//在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请
//找出数组中任意一个重复的数字。 
//
// 示例 1： 
//
// 输入：
//[2, 3, 1, 0, 2, 5, 3]
//输出：2 或 3 
// 
//
// 
//
// 限制： 
//
// 2 <= n <= 100000 
// Related Topics 数组 哈希表 
// 👍 239 👎 0


package com.hudaqian.leetcode.editor.cn;

import java.util.HashSet;
import java.util.Set;

public class ShuZuZhongZhongFuDeShuZiLcof {
    public static void main(String[] args) {
        Solution solution = new ShuZuZhongZhongFuDeShuZiLcof().new Solution();
        int[] nums = {2, 3, 1, 0, 2, 5, 3};
        System.out.print(solution.findRepeatNumber(nums));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findRepeatNumber(int[] nums) {
            /**
             * 哈希表
             */
//            Set<Integer> set = new HashSet<>();
//            for (int num : nums) {
//                if (!set.add(num)) {
//                    return num;
//                }
//            }
//            return -1;
            /**
             * 数组
             * 题目有隐藏条件 num 在0-n之间
             */
            int len = nums.length;
            int[] res = new int[len];
            for (int num :nums) {
                if (res[num] != 0) {
                    return num;
                }
                res[num] = 1;
            }
            return -1;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)
}