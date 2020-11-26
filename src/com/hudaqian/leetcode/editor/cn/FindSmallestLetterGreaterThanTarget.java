//给你一个排序后的字符列表 letters ，列表中只包含小写英文字母。另给出一个目标字母 target，请你寻找在这一有序列表里比目标字母大的最小字母。 
//
// 在比较时，字母是依序循环出现的。举个例子： 
//
// 
// 如果目标字母 target = 'z' 并且字符列表为 letters = ['a', 'b']，则答案返回 'a' 
// 
//
// 
//
// 示例： 
//
// 输入:
//letters = ["c", "f", "j"]
//target = "a"
//输出: "c"
//
//输入:
//letters = ["c", "f", "j"]
//target = "c"
//输出: "f"
//
//输入:
//letters = ["c", "f", "j"]
//target = "d"
//输出: "f"
//
//输入:
//letters = ["c", "f", "j"]
//target = "g"
//输出: "j"
//
//输入:
//letters = ["c", "f", "j"]
//target = "j"
//输出: "c"
//
//输入:
//letters = ["c", "f", "j"]
//target = "k"
//输出: "c"
// 
//
// 
//
// 提示： 
//
// 
// letters长度范围在[2, 10000]区间内。 
// letters 仅由小写字母组成，最少包含两个不同的字母。 
// 目标字母target 是一个小写字母。 
// 
// Related Topics 二分查找 
// 👍 103 👎 0


package com.hudaqian.leetcode.editor.cn;

public class FindSmallestLetterGreaterThanTarget {
    public static void main(String[] args) {
        Solution solution = new FindSmallestLetterGreaterThanTarget().new Solution();
        char[] letters = {'a', 'b', 'c', 'd', 'e'};
        char target = 'z';
        System.out.print(solution.nextGreatestLetter(letters, target));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public char nextGreatestLetter(char[] letters, char target) {
            /**
             * 线性搜索
             */
//            int minValue = Integer.MAX_VALUE;
//            int minIndex = -1;
//            for (int i = 0; i < letters.length; i++) {
//                Character c = letters[i];
//                int value = (c-target) <= 0 ? (26+c-target) : (c-target);
//                if (minValue > value) {
//                    minIndex = i;
//                    minValue = value;
//                }
//            }
//            return letters[minIndex];
            /**
             * 线性搜索 最优
             */
            for (Character c : letters) {
                if (c > target) return c;
            }
            return letters[0];
            /**
             * 线性搜索 改
             */
//            boolean[] chars = new boolean[26];
//            for (Character c : letters) {
//                chars[c-'a'] = true;
//            }
//            while (true) {
//                target ++;
//                if (target > 'z') target = 'a';
//                if (chars[target-'a']) return target;
//            }
            /**
             * 二分法
             */
//            int lo = 0, hi = letters.length;
//            while (lo < hi) {
//                int mi = lo + (hi - lo) / 2;
//                if (letters[mi] <= target) lo = mi + 1;
//                else hi = mi;
//            }
//            return letters[lo % letters.length];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}