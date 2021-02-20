//给定一个非空且只包含非负数的整数数组 nums，数组的度的定义是指数组里任一元素出现频数的最大值。 
//
// 你的任务是在 nums 中找到与 nums 拥有相同大小的度的最短连续子数组，返回其长度。 
//
// 
//
// 示例 1： 
//
// 
//输入：[1, 2, 2, 3, 1]
//输出：2
//解释：
//输入数组的度是2，因为元素1和2的出现频数最大，均为2.
//连续子数组里面拥有相同度的有如下所示:
//[1, 2, 2, 3, 1], [1, 2, 2, 3], [2, 2, 3, 1], [1, 2, 2], [2, 2, 3], [2, 2]
//最短连续子数组[2, 2]的长度为2，所以返回2.
// 
//
// 示例 2： 
//
// 
//输入：[1,2,2,3,1,4,2]
//输出：6
// 
//
// 
//
// 提示： 
//
// 
// nums.length 在1到 50,000 区间范围内。 
// nums[i] 是一个在 0 到 49,999 范围内的整数。 
// 
// Related Topics 数组 
// 👍 228 👎 0


package com.hudaqian.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class DegreeOfAnArray {
    public static void main(String[] args) {
        Solution solution = new DegreeOfAnArray().new Solution();
        int[] nums = {1,2,2,3,1,4,2};
        System.out.print(solution.findShortestSubArray(nums));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findShortestSubArray(int[] nums) {
            /**
             * 滑动窗口解法
             */
//            if (nums == null || nums.length == 0) return -1;
//            // 先计算数组的度
//            int len = nums.length;
//            Map<Integer, Integer> map = new HashMap<>();
//            for (int i = 0; i < len; i++) {
//                int number = nums[i];
//                map.put(number, map.getOrDefault(number, 0) + 1);
//            }
//            int max = 0;
//            for (int num : map.keySet()) {
//                max = Math.max(max, map.get(num));
//            }
//            int left = 0, right = 0, res = Integer.MAX_VALUE;
//            Map<Integer, Integer> tempMap = new HashMap<>();
//            while (right < len) {
//                int rightNumber = nums[right];
//                tempMap.put(rightNumber, tempMap.getOrDefault(rightNumber, 0) + 1);
//                if (tempMap.get(rightNumber) == max) {
//                    while (left <= right) {
//                        int leftNumber = nums[left];
//                        tempMap.put(leftNumber, tempMap.get(leftNumber) - 1);
//                        res = Math.min(res, right - left + 1);
//                        if (leftNumber == rightNumber) {
//                            break;
//                        }
//                        left++;
//                    }
//                }
//                right++;
//            }
//            return res;
            /**
             * 哈希表直接记录这个数字第一次出现和最后一次出现的索引
             * 当然也可以只用map统计度 然后通过数组查找来计算最小的子数组长度
             */
            Map<Integer, int[]> map = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                int num = nums[i];
                if (map.containsKey(num)) {
                    map.get(num)[0]++;
                    map.get(num)[2] = i;
                } else {
                    map.put(num, new int[]{1, i, i});
                }
            }
            int max = Integer.MIN_VALUE, res = Integer.MAX_VALUE;
            for (int num : map.keySet()) {
                int[] temp = map.get(num);
                if (max <= temp[0]) {
                    res = max < temp[0] ? temp[2] - temp[1] + 1 : Math.min(temp[2] - temp[1] + 1, res);
                    max = temp[0];
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}