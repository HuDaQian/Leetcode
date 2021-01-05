//给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。 
//
// 有效字符串需满足： 
//
// 
// 左括号必须用相同类型的右括号闭合。 
// 左括号必须以正确的顺序闭合。 
// 
//
// 注意空字符串可被认为是有效字符串。 
//
// 示例 1: 
//
// 输入: "()"
//输出: true
// 
//
// 示例 2: 
//
// 输入: "()[]{}"
//输出: true
// 
//
// 示例 3: 
//
// 输入: "(]"
//输出: false
// 
//
// 示例 4: 
//
// 输入: "([)]"
//输出: false
// 
//
// 示例 5: 
//
// 输入: "{[]}"
//输出: true 
// Related Topics 栈 字符串 
// 👍 1886 👎 0


package com.hudaqian.leetcode.editor.cn;

import java.util.Stack;

public class ValidParentheses {
    public static void main(String[] args) {
        Solution solution = new ValidParentheses().new Solution();
        System.out.print(solution.isValid("()"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isValid(String s) {
            /**
             * 使用栈来保存最后的括号 来判断
             */
            Stack<Character> mark = new Stack<>();
            int len = s.length();
            for (int i = 0; i < len; i++) {
                char tempChar = s.charAt(i);
                if (isLeft(tempChar)) {
                    mark.push(tempChar);
                } else {
                    if (mark.isEmpty()) {
                        return false;
                    }
                    char lastChar = mark.pop();
                    if (lastChar == '(' && tempChar != ')') return false;
                    if (lastChar == '{' && tempChar != '}') return false;
                    if (lastChar == '[' && tempChar != ']') return false;
                }
            }
            if (!mark.isEmpty()) {
                return false;
            }
            return true;
        }

        public boolean isLeft(Character c) {
            return c == '{' || c == '[' || c == '(';
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}