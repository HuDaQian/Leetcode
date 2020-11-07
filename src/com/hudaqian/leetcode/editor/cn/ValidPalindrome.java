//给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。 
//
// 说明：本题中，我们将空字符串定义为有效的回文串。 
//
// 示例 1: 
//
// 输入: "A man, a plan, a canal: Panama"
//输出: true
// 
//
// 示例 2: 
//
// 输入: "race a car"
//输出: false
// 
// Related Topics 双指针 字符串 
// 👍 288 👎 0


package com.hudaqian.leetcode.editor.cn;

public class ValidPalindrome {
    public static void main(String[] args) {
        Solution solution = new ValidPalindrome().new Solution();
        String s = "acsaasca";
        System.out.print(solution.isPalindrome(s));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isPalindrome(String s) {
            /**
             * 去除多余字符串
             */
            StringBuffer sgood = new StringBuffer();
            int length = s.length();
            for (int i = 0; i < length; i++) {
                char ch = s.charAt(i);
                if (Character.isLetterOrDigit(ch)) {
                    sgood.append(Character.toLowerCase(ch));
                }
            }
            s = sgood.toString();
            /**
             * 解法1：双指针解法
             */
            int i = 0, j = s.length() - 1;
            while (i < j) {
                char ichar = s.charAt(i);
                char jchar = s.charAt(j);
                if (ichar != jchar) {
                    return false;
                }
                i++;
                j--;
            }
            return true;
            /**
             * 解法2：全部反转
             */
//            StringBuffer sgood_rev = new StringBuffer(sgood).reverse();
//            return sgood.toString().equals(sgood_rev.toString());
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}