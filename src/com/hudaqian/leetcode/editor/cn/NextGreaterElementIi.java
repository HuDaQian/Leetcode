//给定一个循环数组（最后一个元素的下一个元素是数组的第一个元素），输出每个元素的下一个更大元素。数字 x 的下一个更大的元素是按数组遍历顺序，这个数字之后的第
//一个比它更大的数，这意味着你应该循环地搜索它的下一个更大的数。如果不存在，则输出 -1。 
//
// 示例 1: 
//
// 
//输入: [1,2,1]
//输出: [2,-1,2]
//解释: 第一个 1 的下一个更大的数是 2；
//数字 2 找不到下一个更大的数； 
//第二个 1 的下一个最大的数需要循环搜索，结果也是 2。
// 
//
// 注意: 输入数组的长度不会超过 10000。 
// Related Topics 栈 
// 👍 362 👎 0


package com.hudaqian.leetcode.editor.cn;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElementIi {
    public static void main(String[] args) {
        Solution solution = new NextGreaterElementIi().new Solution();
        int[] nums = {1,2,1};
        System.out.print(Arrays.toString(solution.nextGreaterElements(nums)));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] nextGreaterElements(int[] nums) {
            /**
             * 单调栈
             */
            int len = nums.length;
            int[] temp = new int[len*2];
            System.arraycopy(nums,0,temp,0,len);
            System.arraycopy(nums,0,temp,len,len);
            int[] res = new int[len];
            Arrays.fill(res, -1);
            Stack<Integer> stack = new Stack<>();
            for (int i = 0; i < len*2; i++) {
                while (!stack.isEmpty() && temp[stack.peek()] < temp[i]) {
                    int index = stack.pop();
                    if (index < len) {
                        res[index] = temp[i];
                    }
                }
                stack.push(i);
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}