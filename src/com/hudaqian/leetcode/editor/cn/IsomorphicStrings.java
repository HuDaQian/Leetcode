//给定两个字符串 s 和 t，判断它们是否是同构的。 
//
// 如果 s 中的字符可以被替换得到 t ，那么这两个字符串是同构的。 
//
// 所有出现的字符都必须用另一个字符替换，同时保留字符的顺序。两个字符不能映射到同一个字符上，但字符可以映射自己本身。 
//
// 示例 1: 
//
// 输入: s = "egg", t = "add"
//输出: true
// 
//
// 示例 2: 
//
// 输入: s = "foo", t = "bar"
//输出: false 
//
// 示例 3: 
//
// 输入: s = "paper", t = "title"
//输出: true 
//
// 说明: 
//你可以假设 s 和 t 具有相同的长度。 
// Related Topics 哈希表 
// 👍 265 👎 0


package com.hudaqian.leetcode.editor.cn;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IsomorphicStrings {
    public static void main(String[] args) {
        Solution solution = new IsomorphicStrings().new Solution();
        String s = "egg";
        String t = "dda";
        System.out.print(solution.isIsomorphic(s, t));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isIsomorphic(String s, String t) {
            /**
             * 注意题目的意思 ad => ad 结果是true
             */
            if (s == null || t == null || s.length() != t.length()) {
                return false;
            }
            int[] snums = new int[128];
            int[] tnums = new int[128];

            char[] schar = s.toCharArray();
            char[] tchar = t.toCharArray();

            for (int i = 0; i < s.length(); i++) {
                char a = schar[i];
                char b = tchar[i];
                if (snums[a] == 0 && tnums[b] == 0) {
                    snums[a] = b;
                    tnums[b] = a;
                } else {
                    if (snums[a] !=b || tnums[b] != a) {
                        return false;
                    }
                }

            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}