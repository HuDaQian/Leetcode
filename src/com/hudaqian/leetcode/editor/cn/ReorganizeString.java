//给定一个字符串S，检查是否能重新排布其中的字母，使得两相邻的字符不同。 
//
// 若可行，输出任意可行的结果。若不可行，返回空字符串。 
//
// 示例 1: 
//
// 
//输入: S = "aab"
//输出: "aba"
// 
//
// 示例 2: 
//
// 
//输入: S = "aaab"
//输出: ""
// 
//
// 注意: 
//
// 
// S 只包含小写字母并且长度在[1, 500]区间内。 
// 
// Related Topics 堆 贪心算法 排序 字符串 
// 👍 256 👎 0


package com.hudaqian.leetcode.editor.cn;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ReorganizeString {
    public static void main(String[] args) {
        Solution solution = new ReorganizeString().new Solution();
        String s= "aab";
        System.out.print(solution.reorganizeString(s));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String reorganizeString(String S) {
            if (S.length() < 2) return S;
            char[] chars = new char[26];
            int len = S.length();
            int maxCount = 0;
            for (char c : S.toCharArray()) {
                chars[c-'a']++;
                maxCount = Math.max(maxCount, chars[c-'a']);
            }
            if (maxCount > (S.length()+1)/2) return "";
            char[] res = new char[len];
            int evenIndex =0,oddIndex = 1;
            int halfLen = len/2;
            for (int i=0;i<chars.length;i++) {
                char c = (char)('a'+i);
                //  注意这里的逻辑
                while (chars[i] >0 && chars[i]<=halfLen && oddIndex<len) {
                    res[oddIndex] = c;
                    chars[i]--;
                    oddIndex+=2;
                }
                while (chars[i] >0) {
                    res[evenIndex] = c;
                    chars[i]--;
                    evenIndex+=2;
                }
            }
            return new String(res);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}