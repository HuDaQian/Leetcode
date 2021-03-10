//给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是 回文串 。返回 s 所有可能的分割方案。 
//
// 回文串 是正着读和反着读都一样的字符串。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "aab"
//输出：[["a","a","b"],["aa","b"]]
// 
//
// 示例 2： 
//
// 
//输入：s = "a"
//输出：[["a"]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 16 
// s 仅由小写英文字母组成 
// 
// Related Topics 深度优先搜索 动态规划 回溯算法 
// 👍 615 👎 0


package com.hudaqian.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {
    public static void main(String[] args) {
        Solution solution = new PalindromePartitioning().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<List<String>> res;
        List<String> path;
        boolean[][] dp;
        public List<List<String>> partition(String s) {

            int len = s.length();
            this.res = new ArrayList<>();
            this.path = new ArrayList<>();
            this.dp = new boolean[len][len];

            dfs(s, 0);
            return res;
        }

        public void dfs(String s, int i) {
            int len = s.length();
            if(i == len) {
                res.add(new ArrayList<>(path));
                return;
            }
            for(int j = i; j < len; j++) {
                if(isPalindrome(s, i, j)) {
                    path.add(s.substring(i, j + 1));
                    dfs(s, j + 1);
                    path.remove(path.size() - 1);
                }
            }

        }

        public boolean isPalindrome(String s, int i, int j) {
            while(i < j) {
                if(s.charAt(i) != s.charAt(j))
                    return false;
                i++;
                j--;
            }
            return true;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}