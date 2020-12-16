//给定一种规律 pattern 和一个字符串 str ，判断 str 是否遵循相同的规律。 
//
// 这里的 遵循 指完全匹配，例如， pattern 里的每个字母和字符串 str 中的每个非空单词之间存在着双向连接的对应规律。 
//
// 示例1: 
//
// 输入: pattern = "abba", str = "dog cat cat dog"
//输出: true 
//
// 示例 2: 
//
// 输入:pattern = "abba", str = "dog cat cat fish"
//输出: false 
//
// 示例 3: 
//
// 输入: pattern = "aaaa", str = "dog cat cat dog"
//输出: false 
//
// 示例 4: 
//
// 输入: pattern = "abba", str = "dog dog dog dog"
//输出: false 
//
// 说明: 
//你可以假设 pattern 只包含小写字母， str 包含了由单个空格分隔的小写字母。 
// Related Topics 哈希表 
// 👍 229 👎 0


package com.hudaqian.leetcode.editor.cn;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class WordPattern {
    public static void main(String[] args) {
        Solution solution = new WordPattern().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean wordPattern(String pattern, String s) {
            /**
             * 两个map解法
             */
            char[] cArr = pattern.toCharArray();
            String[] sArr = s.split(" ");
            if (cArr.length != sArr.length) return false;

            int ptr = 0;
            Map<Character, Integer> map = new HashMap<>();
            int[] charPattern = new int[cArr.length];
            for (int i = 0; i < cArr.length; i++) {
                Character c = cArr[i];
                map.put(c, map.getOrDefault(c, ++ptr));
                charPattern[i] = map.get(c);
            }

            ptr = 0;
            Map<String, Integer> map1 = new HashMap<>();
            int[] strPattern = new int[sArr.length];
            for (int i = 0; i < sArr.length; i++) {
                String str = sArr[i];
                map1.put(str, map1.getOrDefault(str, ++ptr));
                strPattern[i] = map1.get(str);
            }

            ptr = 0;
            while (ptr < charPattern.length) {
                if (charPattern[ptr] != strPattern[ptr]) return false;
                ptr++;
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}