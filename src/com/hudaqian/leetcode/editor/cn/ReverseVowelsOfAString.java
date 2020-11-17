//编写一个函数，以字符串作为输入，反转该字符串中的元音字母。 
//
// 
//
// 示例 1： 
//
// 输入："hello"
//输出："holle"
// 
//
// 示例 2： 
//
// 输入："leetcode"
//输出："leotcede" 
//
// 
//
// 提示： 
//
// 
// 元音字母不包含字母 "y" 。 
// 
// Related Topics 双指针 字符串 
// 👍 124 👎 0


    package com.hudaqian.leetcode.editor.cn;
    public class ReverseVowelsOfAString {
        public static void main(String[] args) {
            Solution solution = new ReverseVowelsOfAString().new Solution();
            String s = "hello";
            System.out.print(solution.reverseVowels(s));
        }
       //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String reverseVowels(String s) {
        char[] chars = s.toCharArray();
        int i=0,j=chars.length-1;
        while (i<j) {
            if (!isVowel(chars[i])) {
                i++;
                continue;
            }
            if (!isVowel(chars[j])) {
                j--;
                continue;
            }
            char temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;
            i++;
            j--;
        }
        return new String(chars);
    }
    private boolean isVowel(char c) {
        switch (c){
            case 'a':
            case 'e':
            case 'i':
            case 'o':
            case 'u':
            case 'A':
            case 'E':
            case 'I':
            case 'O':
            case 'U':
                return true;
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

    }