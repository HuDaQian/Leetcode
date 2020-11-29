//给定一个非空数组，返回此数组中第三大的数。如果不存在，则返回数组中最大的数。要求算法时间复杂度必须是O(n)。 
//
// 示例 1: 
//
// 
//输入: [3, 2, 1]
//
//输出: 1
//
//解释: 第三大的数是 1.
// 
//
// 示例 2: 
//
// 
//输入: [1, 2]
//
//输出: 2
//
//解释: 第三大的数不存在, 所以返回最大的数 2 .
// 
//
// 示例 3: 
//
// 
//输入: [2, 2, 3, 1]
//
//输出: 1
//
//解释: 注意，要求返回第三大的数，是指第三大且唯一出现的数。
//存在两个值为2的数，它们都排第二。
// 
// Related Topics 数组 
// 👍 187 👎 0


package com.hudaqian.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;

public class ThirdMaximumNumber {
    public static void main(String[] args) {
        Solution solution = new ThirdMaximumNumber().new Solution();
        int[] nums = {1, 2, -2147483648};
        System.out.print(solution.thirdMax(nums));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int thirdMax(int[] nums) {
            /**
             * 三个数字代表第一大 第二大 和第三大数字
             */
        long first = Long.MIN_VALUE,second = Long.MIN_VALUE,third = Long.MIN_VALUE;
        for (int num : nums) {
            if (num == first || num == second || num == third) {
                continue;
            }
            if (num > first) {
                third = second;
                second = first;
                first = num;
            } else  if (num > second) {
                third = second;
                second = num;
            } else  if (num > third) {
                third = num;
            }
        }
        return third == Long.MIN_VALUE ? (int)first : (int)third;
            /**
             * 哈希表
             */
//            Arrays.sort(nums);
//            ArrayList<Integer> list = new ArrayList<>();
//            for(int i = 0;i < nums.length;i++){
//                if(!list.contains(nums[i])){
//                    list.add(nums[i]);
//                }
//            }
//            if(list.size() < 3){
//                return list.get(list.size()-1);
//            }
//            return list.get(list.size()-3);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}