//给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。 
//
// 示例 1: 
//
// 输入: s = "anagram", t = "nagaram"
//输出: true
// 
//
// 示例 2: 
//
// 输入: s = "rat", t = "car"
//输出: false 
//
// 说明: 
//你可以假设字符串只包含小写字母。 
//
// 进阶: 
//如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？ 
// Related Topics 排序 哈希表 
// 👍 272 👎 0


package com.hudaqian.leetcode.editor.cn;

import java.util.Arrays;
import java.util.HashMap;

public class ValidAnagram {
    public static void main(String[] args) {
        Solution solution = new ValidAnagram().new Solution();
        String s = "aacc";
        String t = "ccac";
        System.out.print(solution.isAnagram(s, t));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isAnagram(String s, String t) {
            if (s.length() != t.length()) {
                return false;
            }
            /**
             * 两个字符串相等也算字母异位词
             */
//        if (s.equals(t)) {
//            return false;
//        }
//        char[] schar = s.toCharArray();
//        char[] tchar = t.toCharArray();
//        Arrays.sort(schar);
//        Arrays.sort(tchar);
//        return Arrays.equals(schar, tchar);
            /**
             * hashmap 有点慢
             */
//            HashMap<Character, Integer> map = new HashMap<>();
//            for (int i = 0; i < s.length(); i++) {
//                Character c = s.charAt(i);
//                map.put(c, map.getOrDefault(c, 0) + 1);
//            }
//            for (int i = 0; i < t.length(); i++) {
//                Character c = t.charAt(i);
//                map.put(c,map.getOrDefault(c,0)-1);
//                if (map.get(c) < 0) {
//                    return false;
//                }
//            }
//            return true;
            /**
             * 数组统计 如果有unicode字符的话 则需要使用大的hash表
             */
            int[] num = new int[26];
            for (int i = 0; i < s.length(); i++) {
                char schar = s.charAt(i);
                num[schar - 'a']++;
            }
            for (int i = 0; i < t.length(); i++) {
                char tchar = t.charAt(i);
                num[tchar - 'a']--;
                if (num[tchar-'a'] < 0) {
                    return false;
                }
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}