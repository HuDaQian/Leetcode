//给定两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的排列。 
//
// 换句话说，第一个字符串的排列之一是第二个字符串的子串。 
//
// 示例1: 
//
// 
//输入: s1 = "ab" s2 = "eidbaooo"
//输出: True
//解释: s2 包含 s1 的排列之一 ("ba").
// 
//
// 
//
// 示例2: 
//
// 
//输入: s1= "ab" s2 = "eidboaoo"
//输出: False
// 
//
// 
//
// 注意： 
//
// 
// 输入的字符串只包含小写字母 
// 两个字符串的长度都在 [1, 10,000] 之间 
// 
// Related Topics 双指针 Sliding Window 
// 👍 256 👎 0


package com.hudaqian.leetcode.editor.cn;

import java.util.Arrays;

public class PermutationInString {
    public static void main(String[] args) {
        Solution solution = new PermutationInString().new Solution();
        String s1 = "ab", s2 = "eidbbaoo";
        System.out.print(solution.checkInclusion(s1, s2));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean checkInclusion(String s1, String s2) {
            int n = s1.length(), m = s2.length();
            if (n > m) {
                return false;
            }
            int[] cnt1 = new int[26];
            int[] cnt2 = new int[26];
            for (int i = 0; i < n; ++i) {
                ++cnt1[s1.charAt(i) - 'a'];
                ++cnt2[s2.charAt(i) - 'a'];
            }
            if (Arrays.equals(cnt1, cnt2)) {
                return true;
            }
            for (int i = n; i < m; ++i) {
                ++cnt2[s2.charAt(i) - 'a'];
                --cnt2[s2.charAt(i - n) - 'a'];
                if (Arrays.equals(cnt1, cnt2)) {
                    return true;
                }
            }
            return false;
//            char[] char1 = s1.toCharArray();
//            char[] char2 = s2.toCharArray();
//            int[] s1s = new int[26];
//            int len = s1.length();
//            Arrays.fill(s1s, -1);
//            for (int i = 0; i < len; i++) {
//                s1s[char1[i] - 'a']++;
//            }
//            int l = 0, r = 0;
//            int[] s2s = Arrays.copyOf(s1s, 26);
//            while (r < char2.length) {
//                char c = char2[r];
//                if (s1s[c-'a'] != -1) {
//                    if (s2s[c-'a'] == -1) {
//                        while (l < r) {
//                            char temp = char2[l];
//                            s2s[temp - 'a']++;
//                            l++;
//                            if (temp == c) {
//                                break;
//                            }
//                        }
//                        s2s[c-'a']--;
//                    }
//                    if (r-l+1 == len) {
//                        return true;
//                    }
//                    r++;
//                } else {
//                    r++;
//                    l=r;
//                    s2s = Arrays.copyOf(s1s, 26);
//                }
//            }
//            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}