//给定一个正整数 N，试求有多少组连续正整数满足所有数字之和为 N? 
//
// 示例 1: 
//
// 
//输入: 5
//输出: 2
//解释: 5 = 5 = 2 + 3，共有两组连续整数([5],[2,3])求和后为 5。 
//
// 示例 2: 
//
// 
//输入: 9
//输出: 3
//解释: 9 = 9 = 4 + 5 = 2 + 3 + 4 
//
// 示例 3: 
//
// 
//输入: 15
//输出: 4
//解释: 15 = 15 = 8 + 7 = 4 + 5 + 6 = 1 + 2 + 3 + 4 + 5 
//
// 说明: 1 <= N <= 10 ^ 9 
// Related Topics 数学 
// 👍 87 👎 0


package com.hudaqian.leetcode.editor.cn;

public class ConsecutiveNumbersSum {
    public static void main(String[] args) {
        Solution solution = new ConsecutiveNumbersSum().new Solution();
        int N = 642518052;
        System.out.print(solution.consecutiveNumbersSum(N));
        // 15 | 7 8 | 4 5 6 | 1 2 3 4 5
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int consecutiveNumbersSum(int N) {
            /**
             * 递归 栈溢出
             */
//            int res = countNum(N, 1);
//            return res;
            /**
             * 循环 超时
             */
            int index = 1;
            int result = 0;
            while (getIndexStatus(N, index)) {
                int mid = N / index;
                int start = mid - index / 2;
                int count = 0;
                for (int i = 0; i < index; i++) {
                    count += start++;
                }
                if (count == N || count == N - index) result++;
                index++;
            }
            return result;
        }
        private boolean getIndexStatus(int N, int index) {
            if (index%2 == 0) {
                if (N/index - index/2 +1 <= 0) {
                    return false;
                }
            } else {
                if (N/index - index/2 <= 0) {
                    return false;
                }
            }
            return true;
        }

        private int countNum(int N, int index) {
            if (index%2 == 0) {
                if (N/index - index/2 +1 <= 0) {
                    return 0;
                }
            } else {
                if (N/index - index/2 <= 0) {
                    return 0;
                }
            }
            int next = countNum(N, index + 1);
            int mid = N / index;
            int start = mid - index / 2;
            int count = 0;
            for (int i = 0; i < index; i++) {
                count += start++;
            }
            if (count == N || count == N - index) return next+1;
            return next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}