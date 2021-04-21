//一条包含字母 A-Z 的消息通过以下映射进行了 编码 ： 
//
// 
//'A' -> 1
//'B' -> 2
//...
//'Z' -> 26
// 
//
// 要 解码 已编码的消息，所有数字必须基于上述映射的方法，反向映射回字母（可能有多种方法）。例如，"11106" 可以映射为： 
//
// 
// "AAJF" ，将消息分组为 (1 1 10 6) 
// "KJF" ，将消息分组为 (11 10 6) 
// 
//
// 注意，消息不能分组为 (1 11 06) ，因为 "06" 不能映射为 "F" ，这是由于 "6" 和 "06" 在映射中并不等价。 
//
// 给你一个只含数字的 非空 字符串 s ，请计算并返回 解码 方法的 总数 。 
//
// 题目数据保证答案肯定是一个 32 位 的整数。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "12"
//输出：2
//解释：它可以解码为 "AB"（1 2）或者 "L"（12）。
// 
//
// 示例 2： 
//
// 
//输入：s = "226"
//输出：3
//解释：它可以解码为 "BZ" (2 26), "VF" (22 6), 或者 "BBF" (2 2 6) 。
// 
//
// 示例 3： 
//
// 
//输入：s = "0"
//输出：0
//解释：没有字符映射到以 0 开头的数字。
//含有 0 的有效映射是 'J' -> "10" 和 'T'-> "20" 。
//由于没有字符，因此没有有效的方法对此进行解码，因为所有数字都需要映射。
// 
//
// 示例 4： 
//
// 
//输入：s = "06"
//输出：0
//解释："06" 不能映射到 "F" ，因为字符串含有前导 0（"6" 和 "06" 在映射中并不等价）。 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 100 
// s 只包含数字，并且可能包含前导零。 
// 
// Related Topics 字符串 动态规划 
// 👍 697 👎 0


package com.hudaqian.leetcode.editor.cn;

public class DecodeWays {
    public static void main(String[] args) {
        Solution solution = new DecodeWays().new Solution();
        String s = "2101";
        System.out.print(solution.numDecodings(s));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numDecodings(String s) {
            //  动态规划来做 对于以第n位结尾的前边的字符串来说 等于以第n-1位的 和n-2位的和 除非第n-1位上的字符大于2或者等于0 或者第n位为0
            //  根据题目的描述 不会出现连续两个0的情况
            //   如果第n-1位大于2或者等于0 那么以第n位结尾的情况跟前面一样
            //  第n位为0 那么它只能跟前面的 如果前面也是0 或者大于2 那么直接为0
//            char[] chars = s.toCharArray();
//            if (s == null || s.length() == 0 || chars[0] == '0') return 0;
//            int len = chars.length;
//            int[] dp = new int[len+1];
//            dp[0] = 1;
//            dp[1] = 1;
//            for (int i = 1; i < len; i++) {
//                int cur = chars[i] - '0';
//                int prev = chars[i-1] - '0';
//                if (cur == 0) {
//                    if (prev == 0 || prev > 2) {
//                        return 0;
//                    } else {
//                        dp[i+1] = dp[i-1];
//                    }
//                } else {
//                    if (prev == 0 || prev > 2 || (prev == 2 && cur > 6)) {
//                        dp[i+1] = dp[i];
//                    } else {
//                        dp[i+1] = dp[i] + dp[i-1];
//                    }
//                }
//            }
//            return dp[len];
            /**
             * 解法2 动态规划的空间压缩
             */
            char[] chars = s.toCharArray();
            if (s == null || s.length() == 0 || chars[0] == '0') return 0;
            int len = chars.length;
            int prev = 1;
            int current = 1;
            int result = 1;
            for (int i = 1; i < len; i++) {
                int prevNum = chars[i-1] - '0';
                int currNum = chars[i] - '0';
                if (currNum == 0) {
                    if (prevNum == 0 || prevNum > 2) {
                        return 0;
                    } else {
                        result = prev;
                    }
                } else {
                    if (prevNum == 0 || prevNum > 2 || (prevNum == 2 && currNum > 6)) {
                        result = current;
                    } else {
                        result = current + prev;
                    }
                }
                prev = current;
                current = result;
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}