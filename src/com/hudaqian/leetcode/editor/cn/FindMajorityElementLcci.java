//数组中占比超过一半的元素称之为主要元素。给定一个整数数组，找到它的主要元素。若没有，返回-1。 
//
// 示例 1： 
//
// 输入：[1,2,5,9,5,9,5,5,5]
//输出：5 
//
// 
//
// 示例 2： 
//
// 输入：[3,2]
//输出：-1 
//
// 
//
// 示例 3： 
//
// 输入：[2,2,1,1,1,2,2]
//输出：2 
//
// 
//
// 说明： 
//你有办法在时间复杂度为 O(N)，空间复杂度为 O(1) 内完成吗？ 
// Related Topics 位运算 数组 分治算法 
// 👍 46 👎 0


package com.hudaqian.leetcode.editor.cn;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FindMajorityElementLcci {
    public static void main(String[] args) {
        Solution solution = new FindMajorityElementLcci().new Solution();
        int[] nums = {2,2,1,1,1,2,2};
        System.out.print(solution.majorityElement(nums));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int majorityElement(int[] nums) {
            /**
             * 排序 然后查找前后范围
             */
//            Arrays.sort(nums);
//            int left = nums.length / 2, right = nums.length / 2;
//            int num = nums[left];
//            while (nums[left] == num && left > 0) left--;
//            while (nums[right] == num && right < nums.length-1) right++;
//            if (right - left + 1 - (nums[left] == num ? 0 : 1)- (nums[right] == num ? 0 : 1) > nums.length / 2) return num;
//            return -1;
            /**
             * 哈希映射
             */
            Map<Integer, Integer> map = new HashMap<>();
            for (int num:nums) {
                map.put(num, map.getOrDefault(num,0)+1);
            }
            for (int num :map.keySet()) {
                if (map.get(num) > nums.length/2) return num;
            }
            return -1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}