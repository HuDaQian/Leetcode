//三枚石子放置在数轴上，位置分别为 a，b，c。 
//
// 每一回合，我们假设这三枚石子当前分别位于位置 x, y, z 且 x < y < z。从位置 x 或者是位置 z 拿起一枚石子，并将该石子移动到某一整数位
//置 k 处，其中 x < k < z 且 k != y。 
//
// 当你无法进行任何移动时，即，这些石子的位置连续时，游戏结束。 
//
// 要使游戏结束，你可以执行的最小和最大移动次数分别是多少？ 以长度为 2 的数组形式返回答案：answer = [minimum_moves, maximu
//m_moves] 
//
// 
//
// 示例 1： 
//
// 输入：a = 1, b = 2, c = 5
//输出：[1, 2]
//解释：将石子从 5 移动到 4 再移动到 3，或者我们可以直接将石子移动到 3。
// 
//
// 示例 2： 
//
// 输入：a = 4, b = 3, c = 2
//输出：[0, 0]
//解释：我们无法进行任何移动。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= a <= 100 
// 1 <= b <= 100 
// 1 <= c <= 100 
// a != b, b != c, c != a 
// 
// Related Topics 脑筋急转弯 
// 👍 27 👎 0


package com.hudaqian.leetcode.editor.cn;

import java.util.Arrays;

public class MovingStonesUntilConsecutive {
    public static void main(String[] args) {
        Solution solution = new MovingStonesUntilConsecutive().new Solution();
        int a = 3, b = 5, c = 1;
        System.out.print(Arrays.toString(solution.numMovesStones(a, b, c)));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] numMovesStones(int a, int b, int c) {
//            int[] position = new int[3];
//            position[0] = a;
//            position[1] = b;
//            position[2] = c;
//            Arrays.sort(position);
//            a = position[0];
//            b = position[1];
//            c = position[2];
            //  简单的冒泡
            if (a > b) {
                a = a ^ b;
                b = a ^ b;
                a = a ^ b;
            }
            if (a > c) {
                a = a ^ c;
                c = a ^ c;
                a = a ^ c;
            }
            if (b > c) {
                b = b ^ c;
                c = b ^ c;
                b = b ^ c;
            }

            int max = c - a - 2;
            int min = 0;
            if (b - a == 1 && c - b == 1) {
                min = 0;
            } else if (b - a == 1 || c - b == 1 || b - a == 2 || c - b == 2) {
                min = 1;
            } else {
                min = 2;
            }
            int[] res = new int[2];
            res[0] = min;
            res[1] = max;
            return res;
        }

        private void swap(int a, int b) {
            a = a ^ b;
            a = a ^ b;
            b = a ^ b;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}