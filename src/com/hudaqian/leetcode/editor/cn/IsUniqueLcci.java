//实现一个算法，确定一个字符串 s 的所有字符是否全都不同。 
//
// 示例 1： 
//
// 输入: s = "leetcode"
//输出: false 
// 
//
// 示例 2： 
//
// 输入: s = "abc"
//输出: true
// 
//
// 限制： 
// 
// 0 <= len(s) <= 100 
// 如果你不使用额外的数据结构，会很加分。 
// 
// Related Topics 数组 
// 👍 65 👎 0


    package com.hudaqian.leetcode.editor.cn;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class IsUniqueLcci {
        public static void main(String[] args) {
            Solution solution = new IsUniqueLcci().new Solution();
            String str = "abc";
            System.out.print(solution.isUnique(str));
        }
       //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isUnique(String astr) {
        /**
         * 不使用额外的数据结构
         * lastIndexOf
         */
//        for (int i = 0; i < astr.length()-1; i++) {
//            if (astr.indexOf(astr.charAt(i)) != astr.lastIndexOf(astr.charAt(i))) {
//                return false;
//            }
//        }
//        return true;
        /**
         * indexOf
         */
//        for (int i = 0; i < astr.length() - 1; i++) {
//            if (astr.indexOf(astr.charAt(i),i+1) != -1){
//                return false;
//            }
//        }
//        return true;
        /**
         * set
         */
//        Set<Character> set = new HashSet<>();
//        for (int i = 0; i < astr.length(); i++) {
//            if (!set.add(astr.charAt(i))) {
//                return false;
//            }
//        }
//        return true;
        /**
         * 数组
         */
        boolean[] arr = new boolean[53];
        for (int i = 0; i < astr.length(); i++) {
            char c = astr.charAt(i);
            int index = -1;
            if (c >= 'a' && c <= 'z') {
                index = c - 'a';
            } else if (c >= 'A' && c<= 'Z') {
                index = 26 + c - 'A';
            } else {
                index = 52;
            }
            if (arr[index]) {
                return false;
            } else {
                arr[index] = true;
            }
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

    }