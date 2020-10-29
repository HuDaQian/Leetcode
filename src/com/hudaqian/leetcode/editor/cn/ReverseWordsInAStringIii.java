//给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。 
//
// 
//
// 示例： 
//
// 输入："Let's take LeetCode contest"
//输出："s'teL ekat edoCteeL tsetnoc"
// 
//
// 
//
// 提示： 
//
// 
// 在字符串中，每个单词由单个空格分隔，并且字符串中不会有任何额外的空格。 
// 
// Related Topics 字符串 
// 👍 251 👎 0


package com.hudaqian.leetcode.editor.cn;

import java.util.List;

public class ReverseWordsInAStringIii {
    public static void main(String[] args) {
        Solution solution = new ReverseWordsInAStringIii().new Solution();
        System.out.print(solution.reverseWords("How are you !"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String reverseWords(String s) {
            String[] list = s.split(" ");
            String[] resultList = new String[list.length];
            for (int i=0;i<list.length;i++) {
                String str = list[i];
                resultList[i] = reverseString(str);
            }
            return String.join(" ", resultList);
        }
        public String reverseString(String s) {
            int i=0,j=s.length()-1;
            char[] r = new char[s.length()];
            while (i<s.length()) {
                char tempChar = s.charAt(i);
                r[j] = tempChar;
                i++;
                j--;
            }
            return new String(r);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}