//给你两个整数数组 nums 和 index。你需要按照以下规则创建目标数组： 
//
// 
// 目标数组 target 最初为空。 
// 按从左到右的顺序依次读取 nums[i] 和 index[i]，在 target 数组中的下标 index[i] 处插入值 nums[i] 。 
// 重复上一步，直到在 nums 和 index 中都没有要读取的元素。 
// 
//
// 请你返回目标数组。 
//
// 题目保证数字插入位置总是存在。 
//
// 
//
// 示例 1： 
//
// 输入：nums = [0,1,2,3,4], index = [0,1,2,2,1]
//输出：[0,4,1,3,2]
//解释：
//nums       index     target
//0            0        [0]
//1            1        [0,1]
//2            2        [0,1,2]
//3            2        [0,1,3,2]
//4            1        [0,4,1,3,2]
// 
//
// 示例 2： 
//
// 输入：nums = [1,2,3,4,0], index = [0,1,2,3,0]
//输出：[0,1,2,3,4]
//解释：
//nums       index     target
//1            0        [1]
//2            1        [1,2]
//3            2        [1,2,3]
//4            3        [1,2,3,4]
//0            0        [0,1,2,3,4]
// 
//
// 示例 3： 
//
// 输入：nums = [1], index = [0]
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length, index.length <= 100 
// nums.length == index.length 
// 0 <= nums[i] <= 100 
// 0 <= index[i] <= i 
// 
// Related Topics 数组 
// 👍 27 👎 0


package com.hudaqian.leetcode.editor.cn;

import java.util.*;

public class CreateTargetArrayInTheGivenOrder {
    public static void main(String[] args) {
        Solution solution = new CreateTargetArrayInTheGivenOrder().new Solution();
        int[] nums = {0,1,2,3,4};
        int[] index = {0,1,2,2,1};
        System.out.print(Arrays.toString(solution.createTargetArray(nums, index)));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] createTargetArray(int[] nums, int[] index) {
            /**
             * 按照题目的意思是 如果index数组后边的元素出现了前面出现过的元素 那么前面出现过的元素向后挪动
             * 所以需要处理一下index数组 使其不包含重复数字
             * 从前向后遍历 如果已经处理好的数字 大于当前数字的都加1
             * 因为题目保证了数字插入位置总是存在 所以不用考虑加1之后再和前面重复的情况
             */
//            int[] res = new int[index.length];
//            Set<Integer> set = new HashSet<>();
//            for (int i = 0; i < index.length; i++) {
//                int num = index[i];
//                if (set.contains(num)) {
//                    set.clear();
//                    for (int j = 0; j < i; j++) {
//                        int temp = index[j];
//                        if (temp >= num) {
//                            index[j] = ++temp;
//                        }
//                        set.add(temp);
//                    }
//                }
//                set.add(num);
//            }
//            for (int i = 0; i < res.length; i++) {
//                res[index[i]] = nums[i];
//            }
//            return res;
            /**
             * 使用数组来代替哈希表
             */
//            int[] count = new int[index.length];
//            for (int i = 0; i < index.length; i++) {
//                if (count[index[i]] != 0) {
//                    for (int j = 0; j < i; j++) {
//                        if (index[j] >= index[i]) {
//                            count[index[j]]--;
//                        }
//                    }
//                    for (int j = 0; j < i; j++) {
//                        if (index[j] >= index[i]) {
//                            index[j]++;
//                            count[index[j]]++;
//                        }
//                    }
//                }
//                count[index[i]]++;
//            }
            /**
             * 直接双数组不判断
             */
            if (index == null || index.length < 1) return new int[0];
            for (int i = 0; i < index.length; i++) {
                for (int j = 0; j <i; j++) {
                    if (index[j] >= index[i]) index[j]++;
                }
            }
            int[] res = new int[index.length];
            for (int i = 0; i < res.length; i++) {
                res[index[i]] = nums[i];
            }
            return res;
            /**
             * 双栈 副栈负责处理主栈暂时抛出的数字
             */
//            Stack<Integer> queue = new Stack<>();
//            Stack<Integer> temp = new Stack<>();
//            for (int i = 0; i < index.length; i++) {
//                if (index[i] >= queue.size()) {
//                    queue.push(index[i]);
//                } else {
//                    while (!queue.empty()) {
//                        temp.push(queue.pop());
//                    }
//                    while (!temp.empty()) {
//                        int num = temp.pop();
//                        queue.push(num >= index[i] ? num + 1 : num);
//                    }
//                    queue.push(index[i]);
//                }
//            }
//            int[] res = new int[index.length];
//            for (int i = res.length-1; i >=0; i--) {
//                res[queue.pop()] = nums[i];
//            }
//            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}