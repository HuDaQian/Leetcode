//给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。 
//
// 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。 
//
// 
//
// 
//
// 示例 1： 
//
// 
//输入：digits = "23"
//输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
// 
//
// 示例 2： 
//
// 
//输入：digits = ""
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：digits = "2"
//输出：["a","b","c"]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= digits.length <= 4 
// digits[i] 是范围 ['2', '9'] 的一个数字。 
// 
// Related Topics 深度优先搜索 递归 字符串 回溯算法 
// 👍 1129 👎 0


package com.hudaqian.leetcode.editor.cn;

import java.util.*;

public class LetterCombinationsOfAPhoneNumber {
    public static void main(String[] args) {
        Solution solution = new LetterCombinationsOfAPhoneNumber().new Solution();
        String digits = "23";
        System.out.print(solution.letterCombinations(digits));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> letterCombinations(String digits) {
            /**
             * 递归解法
             */
            if (digits == null || digits.length() == 0) return new ArrayList<>();
            List<String> tempList = letterCombinations(digits.substring(1));
            char[] letters = getLetters(Integer.parseInt(digits.substring(0, 1)));
            List<String> res = new ArrayList<>();
            for (int i = 0; i < letters.length; i++) {
                StringBuilder sb = new StringBuilder();
                sb.append(letters[i]);
                if (tempList.size() == 0) {
                    res.add(String.valueOf(letters[i]));
                } else {
                    for (int j = 0; j < tempList.size(); j++) {
                        res.add(letters[i] + tempList.get(j));
                    }
                }
            }
            return res;
        }

        private char[] getLetters(int number) {
            if (number <= 1 || number > 9) return new char[0];
            switch (number) {
                case 2: {
                    return new char[]{'a', 'b', 'c'};
                }
                case 3: {
                    return new char[]{'d', 'e', 'f'};
                }
                case 4: {
                    return new char[]{'g', 'h', 'i'};
                }
                case 5: {
                    return new char[]{'j', 'k', 'l'};
                }
                case 6: {
                    return new char[]{'m', 'n', 'o'};
                }
                case 7: {
                    return new char[]{'p', 'q', 'r', 's'};
                }
                case 8: {
                    return new char[]{'t', 'u', 'v'};
                }
                case 9: {
                    return new char[]{'w', 'x', 'y', 'z'};
                }
                default:
                    return new char[0];
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}