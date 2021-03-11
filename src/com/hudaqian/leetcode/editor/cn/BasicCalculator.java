//实现一个基本的计算器来计算一个简单的字符串表达式 s 的值。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "1 + 1"
//输出：2
// 
//
// 示例 2： 
//
// 
//输入：s = " 2-1 + 2 "
//输出：3
// 
//
// 示例 3： 
//
// 
//输入：s = "(1+(4+5+2)-3)+(6+8)"
//输出：23
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 3 * 105 
// s 由数字、'+'、'-'、'('、')'、和 ' ' 组成 
// s 表示一个有效的表达式 
// 
// Related Topics 栈 数学 
// 👍 473 👎 0


    package com.hudaqian.leetcode.editor.cn;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class BasicCalculator {
        public static void main(String[] args) {
            Solution solution = new BasicCalculator().new Solution();

        }
       //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int calculate(String s) {
        Stack<Integer> ops = new Stack<>();
            ops.push(1);
            int sign = 1;

            int ret = 0;
            int n = s.length();
            int i = 0;
            while (i < n) {
                if (s.charAt(i) == ' ') {
                    i++;
                } else if (s.charAt(i) == '+') {
                    sign = ops.peek();
                    i++;
                } else if (s.charAt(i) == '-') {
                    sign = -ops.peek();
                    i++;
                } else if (s.charAt(i) == '(') {
                    ops.push(sign);
                    i++;
                } else if (s.charAt(i) == ')') {
                    ops.pop();
                    i++;
                } else {
                    long num = 0;
                    while (i < n && Character.isDigit(s.charAt(i))) {
                        num = num * 10 + s.charAt(i) - '0';
                        i++;
                    }
                    ret += sign * num;
                }
            }
            return ret;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

    }