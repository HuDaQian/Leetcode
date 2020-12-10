//给定 S 和 T 两个字符串，当它们分别被输入到空白的文本编辑器后，判断二者是否相等，并返回结果。 # 代表退格字符。 
//
// 注意：如果对空文本输入退格字符，文本继续为空。 
//
// 
//
// 示例 1： 
//
// 输入：S = "ab#c", T = "ad#c"
//输出：true
//解释：S 和 T 都会变成 “ac”。
// 
//
// 示例 2： 
//
// 输入：S = "ab##", T = "c#d#"
//输出：true
//解释：S 和 T 都会变成 “”。
// 
//
// 示例 3： 
//
// 输入：S = "a##c", T = "#a#c"
//输出：true
//解释：S 和 T 都会变成 “c”。
// 
//
// 示例 4： 
//
// 输入：S = "a#c", T = "b"
//输出：false
//解释：S 会变成 “c”，但 T 仍然是 “b”。 
//
// 
//
// 提示： 
//
// 
// 1 <= S.length <= 200 
// 1 <= T.length <= 200 
// S 和 T 只含有小写字母以及字符 '#'。 
// 
//
// 
//
// 进阶： 
//
// 
// 你可以用 O(N) 的时间复杂度和 O(1) 的空间复杂度解决该问题吗？ 
// 
//
// 
// Related Topics 栈 双指针 
// 👍 244 👎 0


package com.hudaqian.leetcode.editor.cn;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class BackspaceStringCompare {
    public static void main(String[] args) {
        Solution solution = new BackspaceStringCompare().new Solution();
        String S = "a##c";
        String T = "#a#c";
        System.out.print(solution.backspaceCompare(S, T));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean backspaceCompare(String S, String T) {
            /**
             * 重制字符串解法
             */
//            return Arrays.equals(getRealString(S.toCharArray()), getRealString(T.toCharArray()));
            /**
             * 双指针解法 从后往前找
             */
            char[] sChars = S.toCharArray(), tChars = T.toCharArray();
            int p = S.length() - 1, q = T.length() - 1;
            while (p >= 0 || q >= 0) {
                int nextP = getRealChar(sChars, p);
                int nextQ = getRealChar(tChars, q);
                if (nextP < 0 && nextQ < 0) return true;
                if (nextP < 0 || nextQ < 0) return false;
                if (sChars[nextP] != tChars[nextQ]) {
                    return false;
                } else {
                    p = nextP - 1;
                    q = nextQ - 1;
                }
            }
            return true;
        }

        private int getRealChar(char[] chars, int index) {
            int count = 0;
            while (index >= 0) {
                if (chars[index] != '#') {
                    if (count == 0) {
                        return index;
                    } else {
                        count--;
                    }
                } else {
                    count++;
                }
                index--;
            }
            if (count != 0) return -1;
            return index;
        }

        private char[] getRealString(char[] chars) {
            int slow = 0, fast = 0, len = chars.length;
            char[] res = new char[len];
            while (fast < len) {
                char c = chars[fast];
                res[slow] = chars[fast];
                if (c != '#') {
                    slow++;
                } else {
                    slow--;
                    slow = Math.max(slow, 0);
                }
                fast++;
            }
            char[] newRes = new char[slow];
            System.arraycopy(res, 0, newRes, 0, slow);
            return newRes;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}