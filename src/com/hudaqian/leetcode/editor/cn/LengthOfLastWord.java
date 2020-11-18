//给定一个仅包含大小写字母和空格 ' ' 的字符串 s，返回其最后一个单词的长度。如果字符串从左向右滚动显示，那么最后一个单词就是最后出现的单词。 
//
// 如果不存在最后一个单词，请返回 0 。 
//
// 说明：一个单词是指仅由字母组成、不包含任何空格字符的 最大子字符串。 
//
// 
//
// 示例: 
//
// 输入: "Hello World"
//输出: 5
// 
// Related Topics 字符串 
// 👍 257 👎 0


package com.hudaqian.leetcode.editor.cn;

public class LengthOfLastWord {
    public static void main(String[] args) {
        Solution solution = new LengthOfLastWord().new Solution();
        String s = " ";
        System.out.print(solution.lengthOfLastWord(s));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int lengthOfLastWord(String s) {
            /**
             * 解法1 指针
             */
//            if (s == null || s.length() == 0) return 0;
//            int start = 0, end = s.length() - 1;
//            while (s.charAt(end) == ' ' && end > 0) end--;
//            start = end;
//            while (s.charAt(end) != ' ' && end > 0) end--;
//            return start - end;
            /**
             * 解法2 字符串分割
             */
            String[] strs = s.split(" ");
            return strs.length == 0 ? 0 : strs[strs.length-1].length();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}