//给你一个仅由大写英文字母组成的字符串，你可以将任意位置上的字符替换成另外的字符，总共可最多替换 k 次。在执行上述操作后，找到包含重复字母的最长子串的长度。
// 
//
// 注意：字符串长度 和 k 不会超过 104。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "ABAB", k = 2
//输出：4
//解释：用两个'A'替换为两个'B',反之亦然。
// 
//
// 示例 2： 
//
// 
//输入：s = "AABABBA", k = 1
//输出：4
//解释：
//将中间的一个'A'替换为'B',字符串变为 "AABBBBA"。
//子串 "BBBB" 有最长重复字母, 答案为 4。
// 
// Related Topics 双指针 Sliding Window 
// 👍 248 👎 0


package com.hudaqian.leetcode.editor.cn;

public class LongestRepeatingCharacterReplacement {
    public static void main(String[] args) {
        Solution solution = new LongestRepeatingCharacterReplacement().new Solution();
        String s = "ABAA";
        int k = 0;
        System.out.print(solution.characterReplacement(s, k));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int characterReplacement(String s, int k) {
            /**
             * 双指针解法
             */
            int len = s.length();
            if (len < 2) return len;
            int left = 0, right = 0, maxCount = 0, res = 0;
            int[] charNums = new int[26];
            char[] chars = s.toCharArray();
            while (right < len) {
                charNums[chars[right] - 'A']++;
                maxCount = Math.max(maxCount, charNums[chars[right] - 'A']);
                right++;

                if (right - left > maxCount + k) {
                    // 说明此时 k 不够用
                    // 把其它不是最多出现的字符替换以后，都不能填满这个滑动的窗口，这个时候须要考虑左边界向右移动
                    // 移出滑动窗口的时候，频数数组须要相应地做减法
                    charNums[chars[left] - 'A']--;
                    left++;
                }
                res = Math.max(res, right-left);
            }
            return res;

//            /**
//             * curNumber 代表当前可以填充的数字
//             * ptr 代表活动指针
//             * len 代表字符数组长度
//             * res 代表最大连续长度
//             * temp 代表当前字符起始位置
//             * next 代表下一个字符起始位置
//             */
//            if (s == null || s.length() == 0) return 0;
//            char[] chars = s.toCharArray();
//            int curNumber = k, len = s.length();
//            char c = chars[0];
//            int res = 0;
//            int temp = 0, ptr = 0, next = 0;
//            while (ptr < len) {
//                if (chars[ptr] == c) {
//
//                } else {
//                    if (next == temp) {
//                        next = ptr;
//                    }
//                    if (curNumber > 0) {
//                        curNumber--;
//                    } else {
//                        res = Math.max(res, ptr - temp);
//                        curNumber = k;
//                        c = chars[next];
//                        temp = next;
//                        ptr = next;
//                    }
//                }
//                ptr++;
//            }
//            //  尾部处理
//            int lastLen = Math.min((ptr - temp + curNumber), len);
//            res = Math.max(res, lastLen);
//            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}