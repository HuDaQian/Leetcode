//给定两个由小写字母构成的字符串 A 和 B ，只要我们可以通过交换 A 中的两个字母得到与 B 相等的结果，就返回 true ；否则返回 false 。 
//
// 交换字母的定义是取两个下标 i 和 j （下标从 0 开始），只要 i!=j 就交换 A[i] 和 A[j] 处的字符。例如，在 "abcd" 中交换下标
// 0 和下标 2 的元素可以生成 "cbad" 。 
//
// 
//
// 示例 1： 
//
// 
//输入： A = "ab", B = "ba"
//输出： true
//解释： 你可以交换 A[0] = 'a' 和 A[1] = 'b' 生成 "ba"，此时 A 和 B 相等。 
//
// 示例 2： 
//
// 
//输入： A = "ab", B = "ab"
//输出： false
//解释： 你只能交换 A[0] = 'a' 和 A[1] = 'b' 生成 "ba"，此时 A 和 B 不相等。
// 
//
// 示例 3: 
//
// 
//输入： A = "aa", B = "aa"
//输出： true
//解释： 你可以交换 A[0] = 'a' 和 A[1] = 'a' 生成 "aa"，此时 A 和 B 相等。 
//
// 示例 4： 
//
// 
//输入： A = "aaaaaaabc", B = "aaaaaaacb"
//输出： true
// 
//
// 示例 5： 
//
// 
//输入： A = "", B = "aa"
//输出： false
// 
//
// 
//
// 提示： 
//
// 
// 0 <= A.length <= 20000 
// 0 <= B.length <= 20000 
// A 和 B 仅由小写字母构成。 
// 
// Related Topics 字符串 
// 👍 120 👎 0


package com.hudaqian.leetcode.editor.cn;

import java.util.Arrays;

public class BuddyStrings {
    public static void main(String[] args) {
        Solution solution = new BuddyStrings().new Solution();
        String A = "aa";
        String B = "aa";
        System.out.print(solution.buddyStrings(A, B));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean buddyStrings(String A, String B) {
            /**
             * 记录下题目规则
             * A==B 那么判断字符串里是否有重复字符
             * A!=B 那么判断是否只有两个不同的字符
             *  如果只有两个不同的字符 看是否在对称位置 满足可交换的条件
             */
            if (A.equals(B) && !isUnique(A)) return true;
            if (A.length() != B.length()) return false;
            int first = -1,second = -1;
            for (int i = 0; i < A.length(); i++) {
                if (A.charAt(i) != B.charAt(i)) {
                    if (first == -1) {
                        first = i;
                    } else if (second == -1) {
                        second = i;
                    } else {
                        return false;
                    }
                }
            }
            return second != -1 && (A.charAt(first) == B.charAt(second) && A.charAt(second) == B.charAt(first));
        }

        private boolean isUnique(String astr) {
            /**
             * indexOf
             */
            for (int i = 0; i < astr.length() - 1; i++) {
                if (astr.indexOf(astr.charAt(i), i + 1) != -1) {
                    return false;
                }
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}