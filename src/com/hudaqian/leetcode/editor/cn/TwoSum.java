//给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。 
//
// 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。 
//
// 
//
// 示例: 
//
// 给定 nums = [2, 7, 11, 15], target = 9
//
//因为 nums[0] + nums[1] = 2 + 7 = 9
//所以返回 [0, 1]
// 
// Related Topics 数组 哈希表 
// 👍 9190 👎 0


package com.hudaqian.leetcode.editor.cn;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static void main(String[] args) {
        Solution solution = new TwoSum().new Solution();
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] result = solution.twoSum(nums, target);
        System.out.print(Arrays.toString(result) + '\n');
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] twoSum(int[] nums, int target) {
            /**
             * hashmap记录已经出现过的数字
             */
            int[] result = new int[2];
            if (nums == null || nums.length < 2) return result;
            Map<Integer, Integer> map = new HashMap<Integer, Integer>();
            for (int i = 0; i < nums.length; i++) {
                int num = nums[i];
                int value = target - num;
                if (map.containsKey(value)) {
                    result[0] = i;
                    result[1] = map.get(value);
                    return result;
                } else map.put(num, i);
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}