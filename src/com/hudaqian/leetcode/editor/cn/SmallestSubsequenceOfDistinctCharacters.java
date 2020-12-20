//返回字符串 text 中按字典序排列最小的子序列，该子序列包含 text 中所有不同字符一次。 
//
// 
//
// 示例 1： 
//
// 输入："cdadabcc"
//输出："adbc"
// 
//
// 示例 2： 
//
// 输入："abcd"
//输出："abcd"
// 
//
// 示例 3： 
//
// 输入："ecbacba"
//输出："eacb"
// 
//
// 示例 4： 
//
// 输入："leetcode"
//输出："letcod"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= text.length <= 1000 
// text 由小写英文字母组成 
// 
//
// 
//
// 注意：本题目与 316 https://leetcode-cn.com/problems/remove-duplicate-letters/ 相同 
// Related Topics 栈 贪心算法 字符串 
// 👍 73 👎 0


package com.hudaqian.leetcode.editor.cn;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class SmallestSubsequenceOfDistinctCharacters {
    public static void main(String[] args) {
        Solution solution = new SmallestSubsequenceOfDistinctCharacters().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String smallestSubsequence(String s) {
            char[] chars = s.toCharArray();
            LinkedList<Character> queue = new LinkedList<>();
            int[] indexs = new int[26];
            for (int i = 0; i < chars.length; i++) {
                char c = chars[i];
                indexs[c - 'a'] = i + 1;
            }
            Set<Character> set = new HashSet<>();
            for (int i = 0; i < chars.length; i++) {
                char c = chars[i];
                if (set.add(c)) {
                    while (!queue.isEmpty()) {
                        char temp = queue.getLast();
                        if (temp > c && indexs[temp - 'a'] > i) {
                            set.remove(temp);
                            queue.removeLast();
                        } else break;
                    }
                    queue.add(c);
                }
            }
            StringBuilder sb = new StringBuilder();
            for (char c : queue) {
                sb.append(c);
            }
            return sb.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}