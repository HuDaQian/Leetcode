//给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。 
//
// 你可以假设数组是非空的，并且给定的数组总是存在多数元素。 
//
// 
//
// 示例 1: 
//
// 输入: [3,2,3]
//输出: 3 
//
// 示例 2: 
//
// 输入: [2,2,1,1,1,2,2]
//输出: 2
// 
// Related Topics 位运算 数组 分治算法 
// 👍 805 👎 0


    package com.hudaqian.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class MajorityElement {
        public static void main(String[] args) {
            Solution solution = new MajorityElement().new Solution();
            int[] nums = {3,2,3};
            System.out.print(solution.majorityElement(nums));
        }
       //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int majorityElement(int[] nums) {
        /**
         * 解法1：哈希映射法
         */
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0)+1);
        }
        for (int num : map.keySet()) {
            if (map.get(num) > nums.length/2) {
                return num;
            }
        }
        return -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

    }