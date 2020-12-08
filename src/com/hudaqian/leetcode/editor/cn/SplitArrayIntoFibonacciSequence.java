//给定一个数字字符串 S，比如 S = "123456579"，我们可以将它分成斐波那契式的序列 [123, 456, 579]。 
//
// 形式上，斐波那契式序列是一个非负整数列表 F，且满足： 
//
// 
// 0 <= F[i] <= 2^31 - 1，（也就是说，每个整数都符合 32 位有符号整数类型）； 
// F.length >= 3； 
// 对于所有的0 <= i < F.length - 2，都有 F[i] + F[i+1] = F[i+2] 成立。 
// 
//
// 另外，请注意，将字符串拆分成小块时，每个块的数字一定不要以零开头，除非这个块是数字 0 本身。 
//
// 返回从 S 拆分出来的任意一组斐波那契式的序列块，如果不能拆分则返回 []。 
//
// 
//
// 示例 1： 
//
// 输入："123456579"
//输出：[123,456,579]
// 
//
// 示例 2： 
//
// 输入: "11235813"
//输出: [1,1,2,3,5,8,13]
// 
//
// 示例 3： 
//
// 输入: "112358130"
//输出: []
//解释: 这项任务无法完成。
// 
//
// 示例 4： 
//
// 输入："0123"
//输出：[]
//解释：每个块的数字不能以零开头，因此 "01"，"2"，"3" 不是有效答案。
// 
//
// 示例 5： 
//
// 输入: "1101111"
//输出: [110, 1, 111]
//解释: 输出 [11,0,11,11] 也同样被接受。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= S.length <= 200 
// 字符串 S 中只含有数字。 
// 
// Related Topics 贪心算法 字符串 回溯算法 
// 👍 107 👎 0


package com.hudaqian.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class SplitArrayIntoFibonacciSequence {
    public static void main(String[] args) {
        Solution solution = new SplitArrayIntoFibonacciSequence().new Solution();
        String s = "111021";
        System.out.print(solution.splitIntoFibonacci(s));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> splitIntoFibonacci(String S) {
            List<Integer> list = new ArrayList<>();
            backTrack(list, S, S.length(), 0, 0, 0);
            return list;
        }

        /**
         * @param list  用来记录结果
         * @param s     用来传递字符串
         * @param index 用来记录遍历到什么位置了
         * @param sum   用了记录之前两个数字的和
         * @param prev  用来记录之前的数字 和当前数字的和为下一个应该有的数字
         * @return
         */
        private boolean backTrack(List<Integer> list, String s, int len, int index, int sum, int prev) {
            /**
             * 回溯解法
             * 在循环中递归
             * 注意边界判断
             */
            if (index == len) return list.size() >= 3;
            long currlong = 0;
            for (int i = index; i < len; i++) {
                if (i > index && s.charAt(index) == '0') {
                    break;
                }
                currlong = currlong * 10 + (s.charAt(i) - '0');
                if (currlong > Integer.MAX_VALUE) {
                    break;
                }
                int cur = (int) currlong;
                if (list.size() >= 2) {
                    if (cur < sum) {
                        continue;
                    } else if (cur > sum) {
                        break;
                    }
                }
                list.add(cur);
                if (backTrack(list, s, len, i + 1, prev + cur, cur)) {
                    return true;
                } else {
                    list.remove(list.size() - 1);
                }
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}