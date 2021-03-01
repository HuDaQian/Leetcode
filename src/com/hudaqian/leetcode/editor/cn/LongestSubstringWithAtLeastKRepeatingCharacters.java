//找到给定字符串（由小写字符组成）中的最长子串 T ， 要求 T 中的每一字符出现次数都不少于 k 。输出 T 的长度。 
//
// 示例 1: 
//
// 
//输入:
//s = "aaabb", k = 3
//
//输出:
//3
//
//最长子串为 "aaa" ，其中 'a' 重复了 3 次。
// 
//
// 示例 2: 
//
// 
//输入:
//s = "ababbc", k = 2
//
//输出:
//5
//
//最长子串为 "ababb" ，其中 'a' 重复了 2 次， 'b' 重复了 3 次。
// 
// Related Topics 递归 分治算法 Sliding Window 
// 👍 296 👎 0


package com.hudaqian.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class LongestSubstringWithAtLeastKRepeatingCharacters {
    public static void main(String[] args) {
        Solution solution = new LongestSubstringWithAtLeastKRepeatingCharacters().new Solution();
        String s = "bbaaacbd";
        int k = 3;
        System.out.print(solution.longestSubstring(s, k));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int longestSubstring(String s, int k) {
            if (s == null || s.length() == 0 || s.length() < k) return 0;
            char[] chars = s.toCharArray();
            return counter(chars, 0, chars.length, k);
        }


        private int counter(char[] charArray, int left, int right, int k) {
            /**
             * 左起为可用数字 右边界为分割字符
             */
            if (right - left < k) return 0;
            int[] records = new int[26];
            for (int i = left; i < right; i++) {
                char c = charArray[i];
                records[c - 'a']++;
            }
            List<Integer> list = new ArrayList<>();
            for (int i = left; i < right; i++) {
                char c = charArray[i];
                if (records[c - 'a'] < k) list.add(i);
            }
            if (list.size() == 0) return right - left;
            int max = 0, ptr = left;
            for (int num : list) {
                max = Math.max(max, counter(charArray, ptr, num, k));
                ptr = num + 1;
            }
            max = Math.max(max, counter(charArray, ptr, right, k));
            return max;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}