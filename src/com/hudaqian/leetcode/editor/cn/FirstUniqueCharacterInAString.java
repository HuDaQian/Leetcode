//给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。 
//
// 
//
// 示例： 
//
// s = "leetcode"
//返回 0
//
//s = "loveleetcode"
//返回 2
// 
//
// 
//
// 提示：你可以假定该字符串只包含小写字母。 
// Related Topics 哈希表 字符串 
// 👍 283 👎 0


    package com.hudaqian.leetcode.editor.cn;

import java.util.HashMap;

public class FirstUniqueCharacterInAString {
        public static void main(String[] args) {
            Solution solution = new FirstUniqueCharacterInAString().new Solution();
            String s = "loveleetcode";
            System.out.print(solution.firstUniqChar(s));
        }
       //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int firstUniqChar(String s) {
//        /**
//         * map写法
//         */
//        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
//        for (int i=0;i<s.length();i++) {
//            Character c = s.charAt(i);
//            map.put(c,map.getOrDefault(c,0)+1);
//        }
//        for (int i = 0; i < s.length(); i++) {
//            Character c = s.charAt(i);
//            if (map.get(c) == 1) {
//                return i;
//            }
//        }
//        /**
//         * 没有唯一值
//         */
//        return -1;
        /**
         * 数组写法
         */
    }
}
//leetcode submit region end(Prohibit modification and deletion)

    }