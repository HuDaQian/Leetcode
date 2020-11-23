//给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。 
//
// 示例: 
//
// 输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
//输出:
//[
//  ["ate","eat","tea"],
//  ["nat","tan"],
//  ["bat"]
//] 
//
// 说明： 
//
// 
// 所有输入均为小写字母。 
// 不考虑答案输出的顺序。 
// 
// Related Topics 哈希表 字符串 
// 👍 525 👎 0


package com.hudaqian.leetcode.editor.cn;

import java.util.*;

public class GroupAnagrams {
    public static void main(String[] args) {
        Solution solution = new GroupAnagrams().new Solution();
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.print(solution.groupAnagrams(strs));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<String>> groupAnagrams(String[] strs) {
            //  排序 然后维护一个 String ： List 的Map就可以了
//            Map<String, List<String>> map = new HashMap<>();
//            for (String str:strs) {
//                char[] chars = str.toCharArray();
//                Arrays.sort(chars);
//                String key = String.copyValueOf(chars);
//                if (!map.containsKey(key)) {
//                    map.put(key, new ArrayList<>());
//                }
//                map.get(key).add(str);
//            }
//            return new ArrayList<>(map.values());
            /**
             * 解法2 用一个字符+数字的字符串 a1b2... 来表示key
             */
            Map<String, List<String>> map = new HashMap<>();
            int[] count = new int[26];
            for (String s : strs) {
                Arrays.fill(count, 0);
                for (char c : s.toCharArray()) count[c - 'a']++;

                StringBuilder sb = new StringBuilder("");
                for (int i = 0; i < 26; i++) {
                    sb.append('#');
                    sb.append(count[i]);
                }
                String key = sb.toString();

                if (!map.containsKey(key)) {
                    map.put(key, new ArrayList<>());
                }
                map.get(key).add(s);
            }
            return new ArrayList<>(map.values());
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}