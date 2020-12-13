//给定一个整数数组，判断是否存在重复元素。 
//
// 如果任意一值在数组中出现至少两次，函数返回 true 。如果数组中每个元素都不相同，则返回 false 。 
//
// 
//
// 示例 1: 
//
// 输入: [1,2,3,1]
//输出: true 
//
// 示例 2: 
//
// 输入: [1,2,3,4]
//输出: false 
//
// 示例 3: 
//
// 输入: [1,1,1,3,3,4,3,2,4,2]
//输出: true 
// Related Topics 数组 哈希表 
// 👍 305 👎 0


package com.hudaqian.leetcode.editor.cn;

import java.util.*;

public class ContainsDuplicate {
    public static void main(String[] args) {
        Solution solution = new ContainsDuplicate().new Solution();
        int[] nums = {1, 2, 3, 1};
        System.out.print(solution.containsDuplicate(nums));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean containsDuplicate(int[] nums) {
            /**
             * 解法1：排序并依次判断前后两个数是否相等
             */
        int[] copyNums = nums.clone();
        Arrays.sort(copyNums);
        for (int i = 0; i < copyNums.length-1; i++) {
            if (copyNums[i] == copyNums[i+1]) {
                return true;
            }
        }
        return false;
            /**
             * 解法2：set
             */
//            Set<Integer> set = new HashSet<>();
//            for (int i : nums) {
//                if (!set.add(i)) {
//                    return true;
//                }
//            }
//            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}