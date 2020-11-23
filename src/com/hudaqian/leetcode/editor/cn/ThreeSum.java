//给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复
//的三元组。 
//
// 注意：答案中不可以包含重复的三元组。 
//
// 
//
// 示例： 
//
// 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
//
//满足要求的三元组集合为：
//[
//  [-1, 0, 1],
//  [-1, -1, 2]
//]
// 
// Related Topics 数组 双指针 
// 👍 2762 👎 0


package com.hudaqian.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public static void main(String[] args) {
        Solution solution = new ThreeSum().new Solution();
        int[] nums = {-1, 0, 1, 2, -1, -4};
        System.out.print(solution.threeSum(nums));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            /**
             * 排序+双指针法
             */
            List<List<Integer>> result = new ArrayList<>();
            /**
             * 错误调整
             * 小于三个数字 直接退出
             */
            if (nums.length < 3) return result;
            Arrays.sort(nums);
            int n = nums.length;
            int left, right;
            List<Integer> temp = new ArrayList<>();
            int currentStart = Integer.MIN_VALUE;
            for (int i = 0; i < nums.length - 2; i++) {
                if (currentStart == nums[i]){
                    continue;
                }
                /**
                 * 此处调整一下 如果起始点+后边的两位数字大于0 那么后边的肯定都大于0
                 * 跳出所有循环
                 */
                if (nums[i] + nums[i+1] + nums[i+2] > 0) {
                    break;
                }
                /**
                 * 如果起点+最后的两个数小于0 那么肯定没有符合条件的组合
                 * 跳出本次循环
                 */
                if (nums[i]+nums[n-2]+nums[n-1] < 0) {
                    continue;
                }

                currentStart = nums[i];
                left = i + 1;
                right = n - 1;
                while (left < right) {
                    int firstNum = nums[i];
                    int secondNum = nums[left];
                    int thirdNum = nums[right];
                    int sum = firstNum + secondNum + thirdNum;
                    if (sum > 0) {
                        right--;
                    } else if (sum < 0) {
                        left++;
                    } else {
                        //  同时走 并且记录左右数字 如果再走到这里 比较数字
                        right--;
                        left++;
                        if (temp.size()!=0 && (temp.get(1) == secondNum && temp.get(2) == thirdNum)) {
                            continue;
                        } else {
                            List<Integer> res = new ArrayList<>();
                            //  写进结果
                            res.add(firstNum);
                            res.add(secondNum);
                            res.add(thirdNum);
                            result.add(res);
                            temp.clear();
                            temp.addAll(res);
                        }
                    }
                }
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}