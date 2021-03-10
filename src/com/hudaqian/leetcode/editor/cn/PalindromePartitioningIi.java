//给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是回文。 
//
// 返回符合要求的 最少分割次数 。 
//
// 
// 
// 
//
// 示例 1： 
//
// 
//输入：s = "aab"
//输出：1
//解释：只需一次分割就可将 s 分割成 ["aa","b"] 这样两个回文子串。
// 
//
// 示例 2： 
//
// 
//输入：s = "a"
//输出：0
// 
//
// 示例 3： 
//
// 
//输入：s = "ab"
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 2000 
// s 仅由小写英文字母组成 
// 
// 
// 
// Related Topics 动态规划 
// 👍 272 👎 0


package com.hudaqian.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioningIi {
    public static void main(String[] args) {
        Solution solution = new PalindromePartitioningIi().new Solution();

    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minCut(String s) {
            List<List<String>> temp = partition(s);
            int minSize = Integer.MAX_VALUE;
            for (List<String> list : temp) {
                minSize = Math.min(minSize, list.size()-1);
            }
            return minSize;
        }
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