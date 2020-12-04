//给你一个按升序排序的整数数组 num（可能包含重复数字），请你将它们分割成一个或多个子序列，其中每个子序列都由连续整数组成且长度至少为 3 。 
//
// 如果可以完成上述分割，则返回 true ；否则，返回 false 。 
//
// 
//
// 示例 1： 
//
// 输入: [1,2,3,3,4,5]
//输出: True
//解释:
//你可以分割出这样两个连续子序列 : 
//1, 2, 3
//3, 4, 5
// 
//
// 
//
// 示例 2： 
//
// 输入: [1,2,3,3,4,4,5,5]
//输出: True
//解释:
//你可以分割出这样两个连续子序列 : 
//1, 2, 3, 4, 5
//3, 4, 5
// 
//
// 
//
// 示例 3： 
//
// 输入: [1,2,3,4,4,5]
//输出: False
// 
//
// 
//
// 提示： 
//
// 
// 输入的数组长度范围为 [1, 10000] 
// 
//
// 
// Related Topics 堆 贪心算法 
// 👍 149 👎 0


package com.hudaqian.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class SplitArrayIntoConsecutiveSubsequences {
    public static void main(String[] args) {
        Solution solution = new SplitArrayIntoConsecutiveSubsequences().new Solution();
        int[] nums = {1,2,3,3,4,4,5,5};
        System.out.print(solution.isPossible(nums));

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isPossible(int[] nums) {
            /**
             * 思路：斗地主连牌逻辑
             * 三张起 全部连出去结束
             * 维护一个二维数组 碰到重复数字就将其插入新数组
             * 碰到不连续数字就遍历已经处理好的数组
             * 碰到连续数字的时候 从新数组开始添加
             * 再维护一个一维数组 来记录二维数组中每个数组数字的个数
             */
            if (nums == null || nums.length < 3) return false;
////            int[][] sequences = new int[nums.length][nums.length];
//            //  数组超出内存限制  使用List对象
//            List<List<Integer>> sequences = new ArrayList<>();
//            int[] lengths = new int[nums.length];
//            //  index表示当前填充到第几个数组
//            //  优化一下 如果中间出现断层 那么直接判断
//            int tempNum = nums[0];
//            int index = -1;
//            for (int i = 0; i < nums.length; i++) {
//                int num = nums[i];
//                if (num > tempNum + 1 && !checkSequencesStatus(lengths)) {
//                    return false;
//                }
//                tempNum = num;
//
//                //  判断是否需要新起数组
//                boolean isNew = true;
//                for (int j = index; j >= 0; j--) {
//                    int len = lengths[j];
//                    if (len != 0) {
//                        //  查最后一位
//                        int lastNum = sequences.get(j).get(len - 1);
//                        if (num == lastNum + 1) {
//                            isNew = false;
//                            sequences.get(j).add(num);
//                            lengths[j]++;
//                            break;
//                        }
//                    }
//                }
//                //  填充新数组 同时检查旧的数组
//                if (isNew) {
//                    index++;
//                    sequences.add(new ArrayList<>());
//                    sequences.get(index).add(num);
//                    lengths[index] = 1;
//                }
//            }
//            return checkSequencesStatus(lengths);
            /**
             * 贪心+动态规划解法
             */
            int len = nums.length;
            int dp1 = 0; // 末尾为该数字 长度为1的子序列
            int dp2 = 0; // 末尾为该数字 长度为2的子序列
            int dp3 = 0; // 末尾为该数字 长度>=3的子序列
            int index = 0;
            while (index < len) {
                int start = index;
                int num = nums[start];
                while (index < len && nums[index] == num) {
                    index++;
                }
                int count = index - start;
                if (start > 0 && num != nums[start - 1]+1) {
                    //  数字断层
                    if (dp1 + dp2 > 0) {
                        return false;
                    } else {
                        dp1 = count;
                        dp2 = 0;
                        dp3 = 0;
                    }
                } else {
                    if (dp1 + dp2 > count) return false;
                    int left = count - dp1 - dp2;
                    if (left > dp3) {
                        int temp = dp3;
                        dp3 += dp2;
                        dp2 = dp1;
                        dp1 = left - temp;
                    } else {
                        dp3 = dp2 + left;
                        dp2 = dp1;
                        dp1 = 0;
                    }
                }
            }
            return dp1 + dp2 == 0;
        }

        private boolean checkSequencesStatus(int[] lengths) {
            for (int num : lengths) {
                if (num == 0) return true;
                if (num < 3) return false;
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}