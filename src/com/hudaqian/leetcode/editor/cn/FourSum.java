//给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c +
// d 的值与 target 相等？找出所有满足条件且不重复的四元组。 
//
// 注意： 
//
// 答案中不可以包含重复的四元组。 
//
// 示例： 
//
// 给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0。
//
//满足要求的四元组集合为：
//[
//  [-1,  0, 0, 1],
//  [-2, -1, 1, 2],
//  [-2,  0, 0, 2]
//]
// 
// Related Topics 数组 哈希表 双指针 
// 👍 676 👎 0


package com.hudaqian.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {
    public static void main(String[] args) {
        Solution solution = new FourSum().new Solution();
        int[] nums = {-5,5,4,-3,0,0,4,-2};
        int target = 4;
        System.out.print(solution.fourSum(nums, target).toString());
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> fourSum(int[] nums, int target) {
            /**
             * 排序+双指针法
             */
            List<List<Integer>> result = new ArrayList<>();
            /**
             * 少于四个数字 直接退出
             */
            if (nums.length < 4) return result;
            Arrays.sort(nums);
            int n = nums.length;
            int left, right;
            List<Integer> temp = new ArrayList<>();
            int currentStart = Integer.MIN_VALUE;
            int currentSecond;
            for (int i = 0; i < n - 3; i++) {
                //  和前面一样的数的话 跳过遍历
                if (currentStart == nums[i]) {
                    continue;
                }
                //  从第i个数开始 如果连续四个数字加起来大于target 那么后边肯定不会出现合适的情况
                //  直接跳出所有循环
                if (nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target) {
                    break;
                }
                //  第i个数和最后三个数字加起来小于target 那么从i开始肯定没有符合的情况
                if (nums[i] + nums[n - 3] + nums[n - 2] + nums[n - 1] < target) {
                    continue;
                }
                currentStart = nums[i];
                currentSecond = Integer.MIN_VALUE;
                for (int j = i+1; j < n - 2; j++) {
                    //  如果和刚才遍历的数字相同 那么跳出本次循环
                    if (currentSecond == nums[j]) {
                        continue;
                    }
                    if (nums[i] + nums[j] + nums[j + 1] + nums[j + 2] > target) {
                        break;
                    }
                    if (nums[i] + nums[j] + nums[n - 2] + nums[n - 1] < target) {
                        continue;
                    }
                    currentSecond = nums[j];
                    left = j + 1;
                    right = n - 1;
                    /**
                     * 解释一下 为什么三数之和这里不需要clear
                     * 三数之和 已经用currentStart判断了前面的数字不同
                     * 所以后续的两个数字相同的话 和肯定不同
                     * 但是这里 前面是两个数
                     * 既然用了currentStart 和currentSecond记录了 可以保证前两个数字变化了
                     * 所以这里clear 最后就不用比较temp的前两个数字了
                     * 直接比较后边两位就行了
                     */
                    temp.clear();
                    while (left < right) {
                        int thirdNumber = nums[left];
                        int forthNumber = nums[right];
                        int sum = currentStart + currentSecond + thirdNumber + forthNumber;
                        if (sum < target) {
                            left++;
                        } else if (sum > target) {
                            right--;
                        } else {
                            //  同时走 并且记录左右数字 如果再走到这里 比较数字
                            left++;
                            right--;
                            //相等的话 和temp比一下
                            if (temp.size() != 0 && (temp.get(2) == thirdNumber && temp.get(3) == forthNumber)) {
                                continue;
                            } else {
                                List<Integer> res = new ArrayList<>();
                                res.add(currentStart);
                                res.add(currentSecond);
                                res.add(thirdNumber);
                                res.add(forthNumber);
                                result.add(res);
                                temp.clear();
                                temp.addAll(res);
                            }
                        }
                    }
                }
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}