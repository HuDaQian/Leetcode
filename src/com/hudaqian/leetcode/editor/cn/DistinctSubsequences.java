//给定一个字符串 s 和一个字符串 t ，计算在 s 的子序列中 t 出现的个数。 
//
// 字符串的一个 子序列 是指，通过删除一些（也可以不删除）字符且不干扰剩余字符相对位置所组成的新字符串。（例如，"ACE" 是 "ABCDE" 的一个子序列
//，而 "AEC" 不是） 
//
// 题目数据保证答案符合 32 位带符号整数范围。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "rabbbit", t = "rabbit"
//输出：3
//解释：
//如下图所示, 有 3 种可以从 s 中得到 "rabbit" 的方案。
//(上箭头符号 ^ 表示选取的字母)
//rabbbit
//^^^^ ^^
//rabbbit
//^^ ^^^^
//rabbbit
//^^^ ^^^
// 
//
// 示例 2： 
//
// 
//输入：s = "babgbag", t = "bag"
//输出：5
//解释：
//如下图所示, 有 5 种可以从 s 中得到 "bag" 的方案。 
//(上箭头符号 ^ 表示选取的字母)
//babgbag
//^^ ^
//babgbag
//^^    ^
//babgbag
//^    ^^
//babgbag
//  ^  ^^
//babgbag
//    ^^^ 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length, t.length <= 1000 
// s 和 t 由英文字母组成 
// 
// Related Topics 字符串 动态规划 
// 👍 454 👎 0


package com.hudaqian.leetcode.editor.cn;

import java.util.Arrays;

public class DistinctSubsequences {
    public static void main(String[] args) {
        Solution solution = new DistinctSubsequences().new Solution();
        String s = "rabbbit", t = "rabbit";
        System.out.print(solution.numDistinct(s,t));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numDistinct(String s, String t) {
            int m = s.length(), n = t.length();
            char[] sChars = s.toCharArray(), tChars = t.toCharArray();
            if (m < n) return 0;
            int[][] dp = new int[m+1][n+1];
            for (int i = 0; i < n; i++) {
                dp[m][i] = 0;
            }
            for (int i = 0; i <= m; i++) {
                dp[i][n] = 1;
            }
            for (int i = m-1; i >= 0; i--) {
                for (int j = n-1; j >= 0; j--) {
                    if (sChars[i] != tChars[j]) {
                        dp[i][j] = dp[i+1][j];
                    } else {
                        dp[i][j] = dp[i+1][j] + dp[i+1][j+1];
                    }
                }
            }
            return dp[0][0];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}