//数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。 
//
// 
//
// 示例： 
//
// 输入：n = 3
//输出：[
//       "((()))",
//       "(()())",
//       "(())()",
//       "()(())",
//       "()()()"
//     ]
// 
// Related Topics 字符串 回溯算法 
// 👍 1514 👎 0


package com.hudaqian.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GenerateParentheses {
    public static void main(String[] args) {
        Solution solution = new GenerateParentheses().new Solution();
        int n = 3;
        System.out.print(solution.generateParenthesis(n));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> generateParenthesis(int n) {
//            /**
//             * 动态规划解法
//             * 对于第i组括号来说
//             * 前i-1组括号 要么在这个括号里面  要么在这个括号外边
//             * 也就是说 假设 p+q = i-1 p、q大于等于0
//             * "(" + i=p的时候的排列 + ")" + i=q的时候的排列
//             * 我们可以在计算过程中将其存储一下减少计算量
//             */
//            if (n == 0) return new ArrayList<>();
//            Map<Integer, List<String>> map = new HashMap<>();
//
//            map.put(0, new ArrayList<>());
//
//            List<String> list = new ArrayList<>();
//            list.add("()");
//            map.put(1, list);
//
//            for (int i = 2; i <= n; i++) {
//                List<String> tempList = new ArrayList<>();
//                for (int j = 0; j < i; j++) {
//                    List<String> pList = map.get(j);
//                    List<String> qList = map.get(i - j - 1);
//                    if (pList.size() == 0) {
//                        for (String str : qList) {
//                            tempList.add("(" + ")" + str);
//                        }
//                    } else if (qList.size() == 0) {
//                        for (String str : pList) {
//                            tempList.add("(" + str + ")");
//                        }
//                    } else {
//                        for (String aStr : pList) {
//                            for (String bStr : qList) {
//                                tempList.add("(" + aStr + ")" + bStr);
//                            }
//                        }
//                    }
//                }
//                map.put(i, tempList);
//            }
//            return map.get(n);
            /**
             * 回溯解法
             */
            List<String> ans = new ArrayList<String>();
            backtrack(ans, new StringBuilder(), 0, 0, n);
            return ans;
        }

        private void backtrack(List<String> ans, StringBuilder cur, int open, int close, int max) {
            if (cur.length() == max * 2) {
                ans.add(cur.toString());
                return;
            }
            if (open < max) {
                cur.append('(');
                backtrack(ans, cur, open + 1, close, max);
                cur.deleteCharAt(cur.length() - 1);
            }
            if (close < open) {
                cur.append(')');
                backtrack(ans, cur, open, close + 1, max);
                cur.deleteCharAt(cur.length() - 1);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}