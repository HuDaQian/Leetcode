//两个整数之间的汉明距离指的是这两个数字对应二进制位不同的位置的数目。 
//
// 给出两个整数 x 和 y，计算它们之间的汉明距离。 
//
// 注意： 
//0 ≤ x, y < 231. 
//
// 示例: 
//
// 
//输入: x = 1, y = 4
//
//输出: 2
//
//解释:
//1   (0 0 0 1)
//4   (0 1 0 0)
//       ↑   ↑
//
//上面的箭头指出了对应二进制位不同的位置。
// 
// Related Topics 位运算 
// 👍 364 👎 0


package com.hudaqian.leetcode.editor.cn;

public class HammingDistance {
    public static void main(String[] args) {
        Solution solution = new HammingDistance().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int hammingDistance(int x, int y) {
//            return Integer.bitCount( x ^ y);
            /**
             * 计数
             */
//            int xor = x ^ y;
//            int count = 0;
//            while (xor != 0) {
//                if (xor % 2 == 1) {
//                    count++;
//                }
//                xor = xor >> 1;
//            }
//            return count;
            /**
             * 另一种计数方式
             */
            int xor = x ^ y;
            int count = 0;
            while (xor != 0) {
                count++;
                xor = xor & (xor - 1);
            }
            return count;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}