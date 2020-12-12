//请实现一个函数，把字符串 s 中的每个空格替换成"%20"。 
//
// 
//
// 示例 1： 
//
// 输入：s = "We are happy."
//输出："We%20are%20happy." 
//
// 
//
// 限制： 
//
// 0 <= s 的长度 <= 10000 
// 👍 54 👎 0


    package com.hudaqian.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TiHuanKongGeLcof {
        public static void main(String[] args) {
            Solution solution = new TiHuanKongGeLcof().new Solution();
            String s= "Hello world! ";
            System.out.print(solution.replaceSpace(s));
        }
       //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String replaceSpace(String s) {
//        List<String> list = Arrays.asList(s.split(""));
//        for (int i = 0;i<list.size();i++) {
//            String c = list.get(i);
//            if (c.equals(" ")) list.set(i,"%20");
//        }
//        return String.join("",list);
        /**
         * sb
         */
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c == ' ') {
                sb.append("%20");
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

    }