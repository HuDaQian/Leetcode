//集合 S 包含从1到 n 的整数。不幸的是，因为数据错误，导致集合里面某一个元素复制了成了集合里面的另外一个元素的值，导致集合丢失了一个整数并且有一个元素重
//复。 
//
// 给定一个数组 nums 代表了集合 S 发生错误后的结果。你的任务是首先寻找到重复出现的整数，再找到丢失的整数，将它们以数组的形式返回。 
//
// 示例 1: 
//
// 
//输入: nums = [1,2,2,4]
//输出: [2,3]
// 
//
// 注意: 
//
// 
// 给定数组的长度范围是 [2, 10000]。 
// 给定的数组是无序的。 
// 
// Related Topics 哈希表 数学 
// 👍 138 👎 0


package com.hudaqian.leetcode.editor.cn;

import java.util.*;
import java.util.stream.Collectors;

public class SetMismatch {
    public static void main(String[] args) {
        Solution solution = new SetMismatch().new Solution();
        int[] nums = {1,5,3,2,2,7,6,4,8,9};
        System.out.print(Arrays.toString(solution.findErrorNums(nums)));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] findErrorNums(int[] nums) {
            /**
             * 排序
             */
//            Arrays.sort(nums);
//            int[] res = new int[2];
//            if (nums[0] != 1) res[1] = 1;
//            if (nums[nums.length-1] != nums.length) res[1] = nums.length;
//            for (int i = 1; i < nums.length; i++) {
//                if (res[0] != 0 && res[1] != 0) return res;
//                if (nums[i] == nums[i - 1]) {
//                    res[0] = nums[i];
//                    continue;
//                }
//                if (nums[i] != nums[i - 1] + 1) res[1] = nums[i - 1] + 1;
//            }
//            return res;
            /**
             * 哈希映射
             */
//            Map<Integer,Integer> map = new HashMap<>();
//            int len = nums.length;
//            int sum = len * (1 + len)/2;
//            int[] res = new int[2];
//            for (int num : nums) {
//                sum-=num;
//                map.put(num, map.getOrDefault(num,0)+1);
//                if (map.get(num) == 2) {
//                    sum+=num;
//                    res[0] = num;
//                }
//            }
//            res[1] = sum;
//            return res;
            /**
             * 额外数组
             */
            int len = nums.length;
            int sum = len * (1 + len)/2;
            int[] temp = new int[len+1];
            int[] res = new int[2];
            for (int num: nums) {
                if (temp[num] > 0) {
                    res[0] = num;
                } else {
                    sum -= num;
                    temp[num] = 1;
                }
            }
            res[1] = sum;
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}