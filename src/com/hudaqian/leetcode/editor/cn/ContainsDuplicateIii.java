//在整数数组 nums 中，是否存在两个下标 i 和 j，使得 nums [i] 和 nums [j] 的差的绝对值小于等于 t ，且满足 i 和 j 的差的
//绝对值也小于等于 ķ 。 
//
// 如果存在则返回 true，不存在返回 false。 
//
// 
//
// 示例 1: 
//
// 输入: nums = [1,2,3,1], k = 3, t = 0
//输出: true 
//
// 示例 2: 
//
// 输入: nums = [1,0,1,1], k = 1, t = 2
//输出: true 
//
// 示例 3: 
//
// 输入: nums = [1,5,9,1,5,9], k = 2, t = 3
//输出: false 
// Related Topics 排序 Ordered Map 
// 👍 261 👎 0


package com.hudaqian.leetcode.editor.cn;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class ContainsDuplicateIii {
    public static void main(String[] args) {
        Solution solution = new ContainsDuplicateIii().new Solution();
        int[] nums = {1, 2};
        int k = 0;
        int t = 1;
        System.out.print(solution.containsNearbyAlmostDuplicate(nums, k, t));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
            /**
             * 暴力法 超时
             */
//            if (nums.length < 2) return false;
//            List<Integer> leftNumber = new ArrayList<>();
//            List<Integer> rightNumber = new ArrayList<>();
//            for (int i = 0; i < nums.length; i++) {
//                int index = 0;
//                int num = nums[i];
//                while (index < leftNumber.size()) {
//                    if (num >= leftNumber.get(index)) {
//                        if (num <= rightNumber.get(index)) {
//                            return true;
//                        }
//                    }
//                    index++;
//                }
//                leftNumber.add(num < (Integer.MIN_VALUE+100) ? Integer.MIN_VALUE : num-t);
//                rightNumber.add(num > (Integer.MAX_VALUE-100) ? Integer.MAX_VALUE : num+t);
//                if (i >= k) {
//                    leftNumber.remove(0);
//                    rightNumber.remove(0);
//                }
//
//            }
//            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}