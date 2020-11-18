//给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。 
//
// 示例 1: 
//
// 输入: "abcabcbb"
//输出: 3 
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
// 
//
// 示例 2: 
//
// 输入: "bbbbb"
//输出: 1
//解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
// 
//
// 示例 3: 
//
// 输入: "pwwkew"
//输出: 3
//解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
// 
// Related Topics 哈希表 双指针 字符串 Sliding Window 
// 👍 4359 👎 0


package com.hudaqian.leetcode.editor.cn;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        Solution solution = new LongestSubstringWithoutRepeatingCharacters().new Solution();
        String s = "pwwkew";
        int longestSubString = solution.lengthOfLongestSubstring(s);
        System.out.print(String.format("%d", longestSubString) + '\n');

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int lengthOfLongestSubstring(String s) {
            /**
             * 双指针滑动窗口，通过一个boolean的数组来判断是否已经有了字符
             */
            if (s == null || s.length() == 0) return 0;
            int left = 0, right = 0, max = 0;
            int sLength = s.length();
            boolean[] use = new boolean[128];
            while (right < sLength) {
                if (use[s.charAt(right)]) {
                    max = Math.max(max, right - left);
                    while ((left < right) && (s.charAt(left) != s.charAt(right))) {
                        use[s.charAt(left)] = false;
                        left++;
                    }
                    left++;
                    right++;
                } else {
                    use[s.charAt(right)] = true;
                    right++;
                }
            }
            max = Math.max(max, right - left);
            return max;
            /**
             * 双指针2
             */
//            if(s == null || s.length() == 0) return 0;
//            int left = 0,right = 0,max = 0;
//            Set<Character> set = new HashSet<>();
//            int sLength = s.length();
//            while (right < sLength) {
//                if (!set.contains(s.charAt(right))) {
//                    set.add(s.charAt(right));
//                    right++;
//                } else  {
//                    while (set.contains(s.charAt(right))) {
//                        set.remove(s.charAt(left));
//                        left++;
//                    }
//                }
//                max = Math.max(max, right-left);
//            }
//            return max;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}