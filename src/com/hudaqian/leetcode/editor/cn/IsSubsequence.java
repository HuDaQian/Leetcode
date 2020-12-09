//给定字符串 s 和 t ，判断 s 是否为 t 的子序列。 
//
// 字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。（例如，"ace"是"abcde"的一个子序列，而"ae
//c"不是）。 
//
// 进阶： 
//
// 如果有大量输入的 S，称作 S1, S2, ... , Sk 其中 k >= 10亿，你需要依次检查它们是否为 T 的子序列。在这种情况下，你会怎样改变代
//码？ 
//
// 致谢： 
//
// 特别感谢 @pbrother 添加此问题并且创建所有测试用例。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "abc", t = "ahbgdc"
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：s = "axc", t = "ahbgdc"
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length <= 100 
// 0 <= t.length <= 10^4 
// 两个字符串都只由小写字符组成。 
// 
// Related Topics 贪心算法 二分查找 动态规划 
// 👍 366 👎 0


package com.hudaqian.leetcode.editor.cn;

public class IsSubsequence {
    public static void main(String[] args) {
        Solution solution = new IsSubsequence().new Solution();
        String s = "axc";
        String t = "ahbgdc";
        System.out.print(solution.isSubsequence(s, t));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isSubsequence(String s, String t) {
            /**
             * 双指针解法
             * 时间复杂度为O（n） 只跟t的长度有关
             * 所以无论t多长 都没有问题
             */
//            if (s == null || s.equals("")) return true;
//            int slowIndex = 0, fastIndex = 0;
//            char c = s.charAt(slowIndex);
//            while (fastIndex < t.length()) {
//                if (t.charAt(fastIndex) == c) {
//                    slowIndex++;
//                    if (slowIndex == s.length()) {
//                        return true;
//                    } else {
//                        c = s.charAt(slowIndex);
//                    }
//                }
//                fastIndex++;
//            }
//            return false;
            /**
             * 双指针优化一下
             */
//            int m = s.length(), n = t.length();
//            int slowIndex = 0, fastIndex = 0;
//            while (slowIndex < m && fastIndex < n) {
//                if (t.charAt(fastIndex) == s.charAt(slowIndex)) {
//                    slowIndex++;
//                }
//                fastIndex++;
//            }
//            return slowIndex == m;
            /**
             * 优化成数组
             */
            int m = s.length(), n = t.length();
            int slowIndex = 0, fastIndex = 0;
            char[] mChars = s.toCharArray();
            char[] nChars = t.toCharArray();
            while (slowIndex < m && fastIndex < n) {
                if (mChars[slowIndex] == nChars[fastIndex]) {
                    slowIndex++;
                }
                fastIndex++;
            }
            return slowIndex == m;
            /**
             * 动态规划解法
             */
//            int m = s.length(), n = t.length();
//            int[][] dp = new int[n+1][26];
//            //  最后一排全部调整成最大值
//            for (int i = 0; i < 26; i++) {
//                dp[n][i] = n;
//            }
//            char[] tChars = t.toCharArray();
//            for (int i = n-1; i >=0 ; i--) {
//                for (int j = 0; j < 26; j++) {
//                    if (tChars[i] == 'a'+j) {
//                        dp[i][j] = i;
//                    } else {
//                        dp[i][j] = dp[i+1][j];
//                    }
//                }
//            }
//            int add = 0;
//            char[] sChars = s.toCharArray();
//            for (int i = 0; i < m; i++) {
//                if (dp[add][sChars[i]-'a'] == n) return false;
//                add = dp[add][sChars[i]-'a']+1;
//            }
//            return true;
            
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}