//给你一个字符串 s ，请你去除字符串中重复的字母，使得每个字母只出现一次。需保证 返回结果的字典序最小（要求不能打乱其他字符的相对位置）。 
//
// 注意：该题与 1081 https://leetcode-cn.com/problems/smallest-subsequence-of-distinct
//-characters 相同 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "bcabc"
//输出："abc"
// 
//
// 示例 2： 
//
// 
//输入：s = "cbacdcbc"
//输出："acdb" 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 104 
// s 由小写英文字母组成 
// 
// Related Topics 栈 贪心算法 字符串 
// 👍 361 👎 0


package com.hudaqian.leetcode.editor.cn;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class RemoveDuplicateLetters {
    public static void main(String[] args) {
        Solution solution = new RemoveDuplicateLetters().new Solution();
        String s = "cbacdcbc";
        System.out.print(solution.removeDuplicateLetters(s));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String removeDuplicateLetters(String s) {
            char[] chars = s.toCharArray();
            LinkedList<Character> queue = new LinkedList<>();
            int[] indexs = new int[26];
            for (int i = 0; i < chars.length; i++) {
                char c = chars[i];
                indexs[c - 'a'] = i + 1;
            }
            Set<Character> set = new HashSet<>();
            for (int i = 0; i < chars.length; i++) {
                char c = chars[i];
                if (set.add(c)) {
                    while (!queue.isEmpty()) {
                        char temp = queue.getLast();
                        if (temp > c && indexs[temp - 'a'] > i) {
                            set.remove(temp);
                            queue.removeLast();
                        } else break;
                    }
                    queue.add(c);
                }
            }
            StringBuilder sb = new StringBuilder();
            for (char c : queue) {
                sb.append(c);
            }
            return sb.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}