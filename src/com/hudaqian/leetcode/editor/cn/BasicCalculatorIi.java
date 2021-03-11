//给你一个字符串表达式 s ，请你实现一个基本计算器来计算并返回它的值。 
//
// 整数除法仅保留整数部分。 
//
// 
// 
// 
//
// 示例 1： 
//
// 
//输入：s = "3+2*2"
//输出：7
// 
//
// 示例 2： 
//
// 
//输入：s = " 3/2 "
//输出：1
// 
//
// 示例 3： 
//
// 
//输入：s = " 3+5 / 2 "
//输出：5
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 3 * 105 
// s 由整数和算符 ('+', '-', '*', '/') 组成，中间由一些空格隔开 
// s 表示一个 有效表达式 
// 表达式中的所有整数都是非负整数，且在范围 [0, 231 - 1] 内 
// 题目数据保证答案是一个 32-bit 整数 
// 
// 
// 
// Related Topics 栈 字符串 
// 👍 282 👎 0


package com.hudaqian.leetcode.editor.cn;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class BasicCalculatorIi {
    public static void main(String[] args) {
        Solution solution = new BasicCalculatorIi().new Solution();
        String s = "3/2";
        System.out.print(solution.calculate(s));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int calculate(String s) {
            /**
             * 三指针
             * 一个length为2的数组来保存即将进行的操作
             */
            int ptr = 0;
            int[] tempNums = new int[3];
            Arrays.fill(tempNums, -1);
            char[] temp = new char[2];
            Arrays.fill(temp, ' ');
            char[] chars = s.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                char c = chars[i];
                if (c == ' ') continue;
                if (isNumber(c)) {
                    if (tempNums[ptr] != -1) {
                        tempNums[ptr] *= 10;
                        tempNums[ptr] += Integer.parseInt(String.valueOf(c));
                    } else {
                        tempNums[ptr] = Integer.parseInt(String.valueOf(c));
                    }
                } else {
                    if (ptr == 2) {
                        //  计算
                        getResult(tempNums, temp);
                        ptr = 1;
                    }
                        temp[ptr] = c;
                        ptr++;
                }
            }
            getResult(tempNums, temp);
            getResult(tempNums, temp);
            return tempNums[0];
        }
        private void getResult(int[] nums, char[] chars) {
            //  如果后边的是✖️ ➗ 那么计算后边
            //  否则 计算前面 并且移动位置
            switch (chars[1]) {
                case '*','/':{
                    char prev = chars[0];
                    if (prev == '*' || prev == '/') {
                        int tempNum = 0;
                        if (prev == '*') {
                            tempNum = nums[0] * nums[1];
                        } else {
                            tempNum = nums[0] / nums[1];
                        }
                        nums[0] = tempNum;
                        nums[1] = nums[2];
                        nums[2] = -1;
                        chars[0] = chars[1];
                    } else {
                        char temp = chars[1];
                        int tempNum = 0;
                        if (temp == '*') {
                            tempNum = nums[1] * nums[2];
                        } else {
                            tempNum = nums[1] / nums[2];
                        }
                        nums[1] = tempNum;
                        nums[2] = -1;
                        chars[1] = ' ';
                    }
                }
                    break;
                default: {
                    char temp = chars[0];
                    int tempNum = 0;
                    if (temp == '+') {
                        tempNum = nums[0] + nums[1];
                    } else if (temp == '-') {
                        tempNum = nums[0] - nums[1];
                    } else if (temp == '*') {
                        tempNum = nums[0] * nums[1];
                    } else if (temp == '/') {
                        tempNum = nums[0] / nums[1];
                    } else {
                        tempNum = nums[0];
                    }
                    nums[0] = tempNum;
                    nums[1] = nums[2];
                    nums[2] = -1;
                    chars[0] = chars[1];
                }
                    break;
            }
        }


        private boolean isNumber(char c) {
            Set<Character> set = new HashSet<>();
            set.add('+');
            set.add('-');
            set.add('*');
            set.add('/');
            return !set.contains(c);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}