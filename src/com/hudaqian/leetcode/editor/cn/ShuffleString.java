//给你一个字符串 s 和一个 长度相同 的整数数组 indices 。 
//
// 请你重新排列字符串 s ，其中第 i 个字符需要移动到 indices[i] 指示的位置。 
//
// 返回重新排列后的字符串。 
//
// 
//
// 示例 1： 
//
// 
//
// 输入：s = "codeleet", indices = [4,5,6,7,0,2,1,3]
//输出："leetcode"
//解释：如图所示，"codeleet" 重新排列后变为 "leetcode" 。
// 
//
// 示例 2： 
//
// 输入：s = "abc", indices = [0,1,2]
//输出："abc"
//解释：重新排列后，每个字符都还留在原来的位置上。
// 
//
// 示例 3： 
//
// 输入：s = "aiohn", indices = [3,1,4,2,0]
//输出："nihao"
// 
//
// 示例 4： 
//
// 输入：s = "aaiougrt", indices = [4,0,2,6,7,3,1,5]
//输出："arigatou"
// 
//
// 示例 5： 
//
// 输入：s = "art", indices = [1,0,2]
//输出："rat"
// 
//
// 
//
// 提示： 
//
// 
// s.length == indices.length == n 
// 1 <= n <= 100 
// s 仅包含小写英文字母。 
// 0 <= indices[i] < n 
// indices 的所有的值都是唯一的（也就是说，indices 是整数 0 到 n - 1 形成的一组排列）。 
// 
// Related Topics 排序 
// 👍 19 👎 0


package com.hudaqian.leetcode.editor.cn;

import java.util.*;

public class ShuffleString {
    public static void main(String[] args) {
        Solution solution = new ShuffleString().new Solution();
        String s = "abc";
        int[] indices = {0,1,2};
        System.out.print(solution.restoreString(s, indices));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String restoreString(String s, int[] indices) {
            /**
             * 直接填充新数组返回
             */
//            char[] res = new char[s.length()];
//            for (int i = 0; i < indices.length; i++) {
//                res[indices[i]] = s.charAt(i);
//            }
//            return new String(res);
            /**
             * 排序 手写排序规则
             * 不适用于该题目 因为有字符相等的情况出现
             */
//            List<String> list = Arrays.asList(s.split(""));
//            List<String> copyOne = new ArrayList<>(list);
//            copyOne.sort((o1, o2) -> {
//                int a = list.indexOf(o1), b = list.indexOf(o2);
//                System.out.print(list);
//                System.out.print("\n");
//                System.out.print(String.format("o1-->%s,a-->%d,o2-->%s,b-->%d\n",o1,a,o2,b));
//                System.out.print(list);
//                System.out.print("\n");
//                System.out.print("\n");
//                return indices[a] - indices[b];
//            });
//            return String.join("",copyOne);
            /**
             * 解法3：原地调换顺序
             * 思路是 肯定会结成环 那就按环来做 然后用一个布尔数组记录调整状态
             */
            if (s==null || s.length() == 0) return s;
            boolean[] isChange = new boolean[s.length()];
            char[] chars = s.toCharArray();
            for (int i = 0; i < s.length(); i++) {
                //  起始点
                int idx = indices[i];
                char tempChar = chars[i];
                while (!isChange[idx]) {
                    char temp = s.charAt(idx);
                    chars[idx] = tempChar;
                    isChange[idx] = true;
                    tempChar = temp;
                    idx = indices[idx];
                }
            }
            return new String(chars);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}