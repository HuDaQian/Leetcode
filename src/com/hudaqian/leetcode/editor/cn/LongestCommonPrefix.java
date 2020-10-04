//编写一个函数来查找字符串数组中的最长公共前缀。 
//
// 如果不存在公共前缀，返回空字符串 ""。 
//
// 示例 1: 
//
// 输入: ["flower","flow","flight"]
//输出: "fl"
// 
//
// 示例 2: 
//
// 输入: ["dog","racecar","car"]
//输出: ""
//解释: 输入不存在公共前缀。
// 
//
// 说明: 
//
// 所有输入只包含小写字母 a-z 。 
// Related Topics 字符串 
// 👍 1283 👎 0


package com.hudaqian.leetcode.editor.cn;
public class LongestCommonPrefix {
    public static void main(String[] args) {
        Solution solution = new LongestCommonPrefix().new Solution();
        String[] strs = new String[3];
        strs[0] = "flower";
        strs[1] = "flow";
        strs[2] = "fake";
        System.out.print(solution.longestCommonPrefix(strs));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String longestCommonPrefix(String[] strs) {
            if (strs == null || strs.length == 0) return "";
            int minLen = Integer.MAX_VALUE;
            for (String str:strs) {
                minLen = Math.min(minLen, str.length());
            }
            int left = 0,right = minLen;
            while (left <= right) {
                int middle = (left + right) /2;
                if (isCommonPrefix(strs, middle)) {
                    left = middle + 1;
                } else {
                    right = middle - 1;
                }
            }
            return strs[0].substring(0, (left + right)/2);
        }
        public boolean isCommonPrefix(String[] strs, int sub) {
            String prefixStr = strs[0].substring(0, sub);
            for (int i=1; i<strs.length; i++) {
                if (!strs[i].startsWith(prefixStr)) {
                    return false;
                }
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}