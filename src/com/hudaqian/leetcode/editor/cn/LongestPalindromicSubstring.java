//给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。 
//
// 示例 1： 
//
// 输入: "babad"
//输出: "bab"
//注意: "aba" 也是一个有效答案。
// 
//
// 示例 2： 
//
// 输入: "cbbd"
//输出: "bb"
// 
// Related Topics 字符串 动态规划 
// 👍 2716 👎 0


package com.hudaqian.leetcode.editor.cn;

public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        Solution solution = new LongestPalindromicSubstring().new Solution();
        String s = "daddwadaswswasdfghjkjhgfdsa";
        System.out.print(solution.longestPalindrome(s) + '\n');
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String longestPalindrome(String s) {
            /**
             * 动态规划
             * 中心扩散方法待补充
             */
            if (s == null || s.length() == 0) return "";
            int len = s.length();
            boolean[][] isPalindrom = new boolean[len + 1][len + 1];
            String maxStr = "";
            for (int j = 0; j < len + 1; j++) {
                for (int i = j; i >= 0; i--) {
                    if (i == j || i == j - 1) {
                        isPalindrom[i][j] = true;
                    } else if (s.charAt(i) == s.charAt(j - 1) && isPalindrom[i + 1][j - 1]) {
                        isPalindrom[i][j] = true;
                    }
                    if (isPalindrom[i][j] && maxStr.length() < j - 1) {
                        maxStr = s.substring(i, j);
                    }
                }
            }
            return maxStr;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}