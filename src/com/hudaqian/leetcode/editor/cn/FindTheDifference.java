//给定两个字符串 s 和 t，它们只包含小写字母。 
//
// 字符串 t 由字符串 s 随机重排，然后在随机位置添加一个字母。 
//
// 请找出在 t 中被添加的字母。 
//
// 
//
// 示例 1： 
//
// 输入：s = "abcd", t = "abcde"
//输出："e"
//解释：'e' 是那个被添加的字母。
// 
//
// 示例 2： 
//
// 输入：s = "", t = "y"
//输出："y"
// 
//
// 示例 3： 
//
// 输入：s = "a", t = "aa"
//输出："a"
// 
//
// 示例 4： 
//
// 输入：s = "ae", t = "aea"
//输出："a"
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length <= 1000 
// t.length == s.length + 1 
// s 和 t 只包含小写字母 
// 
// Related Topics 位运算 哈希表 
// 👍 188 👎 0


package com.hudaqian.leetcode.editor.cn;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FindTheDifference {
    public static void main(String[] args) {
        Solution solution = new FindTheDifference().new Solution();
        String s = "abvd";
        String t = "abvde";
        System.out.print(solution.findTheDifference(s, t));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public char findTheDifference(String s, String t) {
            //  计数解法 1ms
            //  如果用charAt的话 4ms
            int[] chars = new int[26];
            char[] sChars = s.toCharArray();
            char[] tChars = t.toCharArray();
            for (int i = 0; i < sChars.length; i++) {
                chars[sChars[i] - 'a']++;
            }
            for (int i = 0; i < tChars.length; i++) {
                chars[tChars[i] - 'a']--;
                if (chars[tChars[i]-'a'] < 0) return tChars[i];
            }
            return ' ';
            //  哈希映射 16ms
//            Map<Character, Integer> map = new HashMap<>();
//            char[] sChars = s.toCharArray();
//            char[] tChars = t.toCharArray();
//            for (int i = 0; i < sChars.length; i++) {
//                char c = sChars[i];
//                map.put(c, map.getOrDefault(c,0)+1);
//            }
//            for (int i = 0; i < tChars.length; i++) {
//                char c = tChars[i];
//                if (map.getOrDefault(c,0) == 0) return c;
//                map.put(c, map.getOrDefault(c,0)-1);
//            }
//            return ' ';
            /**
             *  位运算
             *  异或 1ms
             */
//            char[] sChars = s.toCharArray();
//            char[] tChars = t.toCharArray();
//            int temp = 0;
//            for (char c : sChars) {
//                temp ^= c;
//            }
//            for (char c : tChars) {
//                temp ^= c;
//            }
//            return (char) temp;
            /**
             * 排序解法 3ms 有快排的情况下
             */
//            char[] sChars = s.toCharArray();
//            char[] tChars = t.toCharArray();
//            Arrays.sort(sChars);
//            Arrays.sort(tChars);
//            for (int i = 0; i < sChars.length; i++) {
//                if (sChars[i] != tChars[i]) return tChars[i];
//            }
//            return tChars[tChars.length-1];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}