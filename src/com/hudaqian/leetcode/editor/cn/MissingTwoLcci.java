//给定一个数组，包含从 1 到 N 所有的整数，但其中缺了两个数字。你能在 O(N) 时间内只用 O(1) 的空间找到它们吗？ 
//
// 以任意顺序返回这两个数字均可。 
//
// 示例 1: 
//
// 输入: [1]
//输出: [2,3] 
//
// 示例 2: 
//
// 输入: [2,3]
//输出: [1,4] 
//
// 提示： 
//
// 
// nums.length <= 30000 
// 
// Related Topics 数组 数学 
// 👍 27 👎 0


package com.hudaqian.leetcode.editor.cn;

import java.util.Arrays;

public class MissingTwoLcci {
    public static void main(String[] args) {
        Solution solution = new MissingTwoLcci().new Solution();
        int[] nums = {1, 2, 3, 4, 6, 7, 9, 10};
        System.out.print(Arrays.toString(solution.missingTwo(nums)));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] missingTwo(int[] nums) {
            /**
             * 遍历 不符合进阶做法
             */
//            int[] temp = new int[nums.length + 2];
//            for (int num : nums) {
//                temp[num - 1]++;
//            }
//            int[] res = new int[2];
//            int index = 0;
//            for (int i = 0; i < temp.length; i++) {
//                if (temp[i] == 0) res[index++] = i + 1;
//            }
//            return res;
            /**
             * 转化为求和问题
             */
            int sum = 0;
            for (int num : nums) {
                sum += num;
            }
            int len = nums.length + 2;
            int missSum = (1 + len)* len / 2  - sum;
            int average = missSum / 2;
            int tempSum = 0;
            for (int num : nums) {
                if (num <= average) {
                    tempSum += num;
                }
            }
            int[] res = new int[2];
            res[0] = (1 + average)* average / 2  - tempSum;
            res[1] = missSum - res[0];
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}